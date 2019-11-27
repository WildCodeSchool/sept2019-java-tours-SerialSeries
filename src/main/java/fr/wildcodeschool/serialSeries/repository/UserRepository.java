package fr.wildcodeschool.serialSeries.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.wildcodeschool.serialSeries.entity.User;

/**
 * All request used with the database on User TABLE
 */
public class UserRepository {
	
    private static UserRepository instance;

    public static UserRepository getInstance() {
        return instance == null ? new UserRepository(): instance;
    }

    /**
     * This method get all users from database
     * @return List of users
     */
    public List<User> getUsers() {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM User;"
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
    
    /**
     * This method create a User in the database
     */
    public void createUser(String name, String pictures) {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO User(name,pictures) VALUES (?,?)"
            );

            statement.setString(1,name);
            statement.setString(2,pictures);
            statement.executeUpdate();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    //Request on database to get user by specific ID
    public User getUsersById(int id) {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM User WHERE id=?"
            );

            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return new User(resultSet);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}