package fr.wildcodeschool.serialSeries.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Serie {
	private String titre;
	private int nb_season;
	private int episode;
	
	
	public Serie(String titre, int nb_season, int episode) {
		this.titre = titre;
		this.nb_season = nb_season;
		this.episode = episode;
	}

	public Serie(ResultSet resultSet) throws SQLException{
		this.titre = resultSet.getString("titre");
		this.nb_season = resultSet.getInt("nb_season");
		
	}

	public Serie() {
		// TODO Auto-generated constructor stub
	}

	public String getTitre() {
		return this.titre;
	}

	public int getNb_season() {
		return nb_season;
	}

	public void setNb_season(int nb_season) {
		this.nb_season = nb_season;
	}

	public int getEpisode() {
		return this.episode;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}




	public void setEpisode(int episode) {
		this.episode = episode;
	}
	
	


}
