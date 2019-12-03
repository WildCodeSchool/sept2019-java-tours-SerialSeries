package fr.wildcodeschool.serialSeries.repository;


import fr.wildcodeschool.serialSeries.entity.Episode;
import fr.wildcodeschool.serialSeries.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * All request used with the database on Episode TABLE
 */
public class EpisodeRepository {
	
    private static EpisodeRepository instance;
    

    public static EpisodeRepository getInstance() {
        return instance == null ? new EpisodeRepository(): instance;
    }
    
    /**
     * This method get all Episode of a Season by season_id from database
     * @return List of serie of a user
     */
    public List<Episode> getEpisodeBySeasonId(int id) {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Episode WHERE season_id=? ORDER BY episode_numb"
            );
            statement.setInt(1, id);
            List<Episode>  episodes = new ArrayList<Episode>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                episodes.add(new Episode(resultSet));
            }
            return episodes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean getState(int id) {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT vue FROM Episode WHERE Episode.id=?"
            );
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            	return resultSet.getBoolean("vue");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //Change state seen/not seen from episode Id
    public void swapState(int id, boolean state) {
    	try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Episode set vue=? WHERE Episode.id=?"
            );

            statement.setBoolean(1,state);
            statement.setInt(2,id);


            statement.executeUpdate();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Create Episode in Database
    public void createEpisode(String title, int userId, int number, boolean vue, int seasonId, int serieId) {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Episode(titre, user_id,episode_numb, vue, season_id,serie_id) VALUES (?,?,?,?,?, ?)"
            );

            statement.setString(1,title);
            statement.setInt(2,userId);
            statement.setInt(3,number);
            statement.setBoolean(4,vue);
            statement.setInt(5,seasonId);
            statement.setInt(6,serieId);

            statement.executeUpdate();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

}