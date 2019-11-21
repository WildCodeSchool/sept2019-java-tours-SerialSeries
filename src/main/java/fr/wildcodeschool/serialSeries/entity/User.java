package fr.wildcodeschool.serialSeries.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 *  This class is used as database model of a User
 */
public class User {
	private int id;
	private String userName;
	private String pictureUrl;

	public User(ResultSet result) throws SQLException {
		this.id = result.getInt("id");
		this.userName = result.getString("name");
		this.pictureUrl = result.getString("pictures");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

}
