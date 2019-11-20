package fr.wildcodeschool.serialSeries.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.wildcodeschool.serialSeries.entity.Serie;

public class SerieRepository {

	public List<Serie> getSeriesByUserId(int id) {
		try {
	        Connection connection = Database.getInstance().getConnection();
	        
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM serie WHERE user_id= ?;"
            );
            
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            List<Serie> series = new ArrayList<>();

            while (resultSet.next()) {
                series.add(new Serie(resultSet));
            }
            return series;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
		return null;

	}
	
	public void createSerie(String titre, int nb_season, int userId) {
		try {
	        Connection connection = Database.getInstance().getConnection();
	        
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO serie(titre,nb_season, user_id) VALUES (?,?,?)"
            );
            
            statement.setString(1,titre);
            statement.setInt(2,nb_season);
            statement.setInt(3,userId);

            statement.executeUpdate();
            
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
	}
}
