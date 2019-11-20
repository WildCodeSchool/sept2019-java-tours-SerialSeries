package fr.wildcodeschool.serialSeries.repository;

import fr.wildcodeschool.serialSeries.entity.Episode;
import fr.wildcodeschool.serialSeries.entity.Serie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SerieRepository {

    public List<Serie> getEpisodeByUserId(int id) {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM serie WHERE user_id=?"
            );

            statement.setInt(1, id);
            List<Serie>  series = new ArrayList<Serie>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                series.add(new Serie(resultSet));
            }
            return series;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
