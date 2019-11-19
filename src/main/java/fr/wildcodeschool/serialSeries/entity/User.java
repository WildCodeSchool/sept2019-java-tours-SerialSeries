package fr.wildcodeschool.serialSeries.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class User {
	private int id;

	private String userName;

	private String pictures;

	 	
	
	public User(int id, String userName, String picture) {
		this.id = id;
		this.userName = userName;
		this.pictures = picture;
	}
	
	public User(ResultSet result) throws SQLException {
		this.id = result.getInt("id");
		this.userName = result.getString("name");
		this.pictures = result.getString("pictures");
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return this.id;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getPictures() {
		return this.pictures;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

}
