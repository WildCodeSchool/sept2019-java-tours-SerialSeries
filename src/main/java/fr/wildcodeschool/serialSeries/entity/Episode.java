package fr.wildcodeschool.serialSeries.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  This class is used as database model of an Episode
 */
public class Episode {
    private int id;
    
    private String title;
    private boolean seen;
    private int number;
    private int seasonId;

    public Episode(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.title = resultSet.getString("title");
        this.seen = resultSet.getBoolean("seen");
        this.number = resultSet.getInt("episode_numb");
        this.seasonId = resultSet.getInt("season_id");
    }

    public Episode() {
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

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }
}

