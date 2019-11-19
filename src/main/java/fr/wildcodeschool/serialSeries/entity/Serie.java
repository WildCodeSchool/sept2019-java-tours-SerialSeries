package fr.wildcodeschool.serialSeries.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Serie {
	private String titre;
	private int season;
	private int episode;
	
	
	public Serie(String titre, int season, int episode) {
		this.titre = titre;
		this.season = season;
		this.episode = episode;
	}

	public Serie(ResultSet resultSet) throws SQLException{
		this.titre = resultSet.getString("titre");
		this.season = resultSet.getInt("nb_season");
		this.episode = resultSet.getInt("episode");
	}

	public String getTitre() {
		return this.titre;
	}


	public int getSeason() {
		return this.season;
	}


	public int getEpisode() {
		return this.episode;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public void setSeason(int season) {
		this.season = season;
	}


	public void setEpisode(int episode) {
		this.episode = episode;
	}
	
	


}
