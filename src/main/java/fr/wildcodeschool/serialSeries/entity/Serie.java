package fr.wildcodeschool.serialSeries.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Serie {
	private String title;
	private int season;
	private int episode;
	
	
	public Serie(String title, int season, int episode) {
		this.title = title;
		this.season = season;
		this.episode = episode;
	}

	public Serie(ResultSet resultSet) throws SQLException{
		this.title = resultSet.getString("title");
		this.season = resultSet.getInt("season");
		this.episode = resultSet.getInt("episode");
	}

	public String getTitle() {
		return this.title;
	}


	public int getSeason() {
		return this.season;
	}


	public int getEpisode() {
		return this.episode;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setSeason(int season) {
		this.season = season;
	}


	public void setEpisode(int episode) {
		this.episode = episode;
	}
	
	


}
