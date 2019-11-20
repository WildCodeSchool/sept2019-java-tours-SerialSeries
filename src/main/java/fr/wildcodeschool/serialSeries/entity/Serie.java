package fr.wildcodeschool.serialSeries.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Serie {
	private int id;
	private int userId;
	private String title;
	private int nbSeason;

	public Serie(ResultSet resultSet) throws SQLException{
		this.id = resultSet.getInt("id");
		this.userId = resultSet.getInt("user_id");
		this.title = resultSet.getString("titre");
		this.nbSeason = resultSet.getInt("nb_season");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNbSeason() {
		return nbSeason;
	}

	public void setNbSeason(int nbSeason) {
		this.nbSeason = nbSeason;
	}

}
