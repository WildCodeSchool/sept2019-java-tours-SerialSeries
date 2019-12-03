package fr.wildcodeschool.serialSeries.repository;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

/**
 * This class is a singleton to manage database connection
 */
public class Database {

	private final static String DB_URL = "jdbc:mysql://localhost:3306/serialSeries?serverTimezone=GMT";
	private final static String DB_USER = "serialSeries";
	private final static String DB_PASSWORD = "wild4ever";
	
	private Connection connection;
	private static Database instance;
	
	private Database() throws SQLException {
		this.connection = DriverManager.getConnection(
	            DB_URL, DB_USER, DB_PASSWORD
	    );
	}
	
	public static Database getInstance() throws SQLException {
		return instance == null ? new Database(): instance; 
	}
	
	public Connection getConnection() {
		return this.connection;
	}
}
