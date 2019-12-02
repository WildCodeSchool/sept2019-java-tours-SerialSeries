package fr.wildcodeschool.serialSeries.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *  This class is used as database model of a Season
 */
public class Season {
    private int id;
    private int number;
    private int serieId;
    private ArrayList<Episode> episodeList;
    public ArrayList<Episode> getEpisodeList() {
		return episodeList;
	}

	public void setEpisodeList(ArrayList<Episode> episodeList) {
		this.episodeList = episodeList;
	}

	public int getSerieId() {
		return serieId;
	}

	public void setSerieId(int serieId) {
		this.serieId = serieId;
	}

	public Season(ResultSet resultSet) throws SQLException {
		this.episodeList = new ArrayList<>();
		this.id = resultSet.getInt("id");
        this.number = resultSet.getInt("number");
        this.serieId = resultSet.getInt("serie_id");
    }

    public Season() {
		this.episodeList = new ArrayList<>();

		// TODO Auto-generated constructor stub
	}


	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
	public void addEpisode(Episode episode) {
		this.episodeList.add(episode);
	}
}

