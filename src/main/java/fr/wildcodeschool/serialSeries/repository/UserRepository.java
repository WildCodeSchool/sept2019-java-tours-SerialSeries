package fr.wildcodeschool.serialSeries.repository;

import java.util.Arrays;
import java.util.List;

import fr.wildcodeschool.serialSeries.entity.User;

public class UserRepository {

	public User createUser() {
		return new User();
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return new User();

	}

	public List<User> getUsersByName(String userName) {
		// TODO Auto-generated method stub
		return Arrays.asList(new User(), new User());

	}

	public User getFirstUserByName(String userName) {
		// TODO Auto-generated method stub
		return new User();
	}

}
