package fr.wildcodeschool.serialSeries.repository;


import fr.wildcodeschool.serialSeries.entity.Serie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * All request used with the database on Serie TABLE
 */
public class SerieRepository {
    private static SerieRepository instance;

    public static SerieRepository getInstance() {
        return instance == null ? new SerieRepository(): instance;
    }
    
    /**
     * This method get all serie of a user by user_id from database
     * @return List of serie of a user
     */
    public List<Serie> getSerieByUserId(int id) {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Serie WHERE user_id=? ORDER BY title"
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

    //Request on database to create serie
    public void createSerie(String title, int userId, String pictureURL) {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Serie(title, user_id,serie_picture) VALUES (?,?,?)"
            );

            statement.setString(1,title);
            statement.setInt(2,userId);
            statement.setString(3,pictureURL);

            statement.executeUpdate();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }


}

