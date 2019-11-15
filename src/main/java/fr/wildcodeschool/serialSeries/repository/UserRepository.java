package fr.wildcodeschool.serialSeries.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.wildcodeschool.serialSeries.entity.User;

public class UserRepository {



	public List<User> getUsers() {
		try {
	        Connection connection = Database.getInstance().getConnection();
	        
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM user;"
            );
            
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                users.add(new User(resultSet));
            }
            return users;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
		return null;

	}

	public User createUser(String name, String pictures) {
		try {
	        Connection connection = Database.getInstance().getConnection();
	        
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO user(name,pictures) VALUES (?,?)"
            );
            
            statement.setString(1,name);
            statement.setString(2,pictures);
            statement.executeUpdate();
            
            //User user = new User(resultSet);
            
            return null;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
		return null;
	}



}
