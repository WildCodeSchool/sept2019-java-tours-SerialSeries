package fr.wildcodeschool.serialSeries.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *  This class is used as database model of a Serie
 */
public class Serie {
	private int id;
	private int userId;
	private String title;
	private String pictureURL;
	private Map<Integer, Season> seasonList;
	public Serie(ResultSet resultSet) throws SQLException{
		this.seasonList = new HashMap<>();
		this.id = resultSet.getInt("id");
		this.userId = resultSet.getInt("user_id");
		this.title = resultSet.getString("title");
		this.pictureURL = resultSet.getString("serie_picture");

	}

	public Serie() {
		this.seasonList = new HashMap<>();

		// TODO Auto-generated constructor stub
	}

	public Map<Integer, Season> getSeasonList() {
		return seasonList;
	}

	public void setSeasonList(Map<Integer, Season> seasonList) {
		this.seasonList = seasonList;
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

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	public void addSeason(Season season) {
		this.seasonList.put(season.getId(), season);
	}
}