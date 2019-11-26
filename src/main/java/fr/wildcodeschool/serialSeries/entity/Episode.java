package fr.wildcodeschool.serialSeries.entity;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  This class is used as database model of an Episode
 */
public class Episode {
    private int id;
    private String title;
    private boolean vue;
    private int userId;
    private int number;
    private int serieId;
    private int seasonId;

    public Episode(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.title = resultSet.getString("titre");
        this.vue = resultSet.getBoolean("vue");
        this.userId = resultSet.getInt("user_id");
        this.number = resultSet.getInt("episode_numb");
        this.seasonId = resultSet.getInt("season_id");
        this.serieId = resultSet.getInt("serie_id");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVue() {
        return vue;
    }

    public void setVue(boolean vue) {
        this.vue = vue;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSerieId() {
        return serieId;
    }

    public void setSerieId(int serieId) {
        this.serieId = serieId;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }
}