package fr.wildcodeschool.serialSeries.repository;

import fr.wildcodeschool.serialSeries.entity.Season;
import fr.wildcodeschool.serialSeries.entity.Serie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeasonRepository {
    public List<Season> getEpisodeByUserId(int id) {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM serie WHERE user_id=?"
            );

            statement.setInt(1, id);
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
}
