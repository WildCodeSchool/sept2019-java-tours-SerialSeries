package fr.wildcodeschool.serialSeries.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *  This class is used as database model of a Season
 */
public class Season {
    private int id;
    private int number;
    private int serieId;
    private Map<Integer, Episode> episodeList;
    public Map<Integer, Episode> getEpisodeList() {
		return episodeList;
	}

	public void setEpisodeList(Map<Integer, Episode>  episodeList) {
		this.episodeList = episodeList;
	}

	public int getSerieId() {
		return serieId;
	}

	public void setSerieId(int serieId) {
		this.serieId = serieId;
	}

	public Season(ResultSet resultSet) throws SQLException {
		this.episodeList = new HashMap<>();
		this.id = resultSet.getInt("id");
        this.number = resultSet.getInt("number");
        this.serieId = resultSet.getInt("serie_id");
    }

    public Season() {
		this.episodeList = new HashMap<>();
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
		this.episodeList.put(episode.getId(), episode);
	}
}

