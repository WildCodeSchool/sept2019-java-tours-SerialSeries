package fr.wildcodeschool.serialSeries.repository;


import fr.wildcodeschool.serialSeries.entity.Season;
import fr.wildcodeschool.serialSeries.entity.Serie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * All request used with the database on Season TABLE
 */
public class SeasonRepository {
    private static SeasonRepository instance;

    public static SeasonRepository getInstance() {
        return instance == null ? new SeasonRepository(): instance;
    }

    /**
     * This method get all Season of a User by serie_id from database
     * @return List of serie of a user
     */
    public List<Season> getSeasonBySerieId(int serie_id) {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Season WHERE serie_id=? ORDER BY number"
            );

            statement.setInt(1, serie_id);
            List<Season>  seasons = new ArrayList<Season>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                seasons.add(new Season(resultSet));
            }
            return seasons;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createSeason(int number, int serieId) {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Season(serie_id,number) VALUES (?,?)"
            );

            statement.setInt(1,serieId);
            statement.setInt(2,number);

            statement.executeUpdate();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public Season getSeasonBySeasonId(int seasonId) {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Season WHERE id=? ORDER BY number"
            );

            statement.setInt(1, seasonId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                return new Season(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}