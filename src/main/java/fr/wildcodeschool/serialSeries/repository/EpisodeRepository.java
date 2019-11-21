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
}
