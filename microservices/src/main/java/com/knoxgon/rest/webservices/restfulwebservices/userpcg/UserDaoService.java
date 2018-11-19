package com.knoxgon.rest.webservices.restfulwebservices.userpcg;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

//Following service must be managed by spring, @Component is therefore required
@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();

	// Method to save the user to DB
	public User saveUser(User user) {
		user.setId(UUID.randomUUID().toString());
		users.add(user);
		return user;
	}

	// Method to find and retrieve all users
	public List<User> allUsers() {
		return users;
	}

	// Method to find one user
	public User getOneUser(String id) {
		for(User user: users) {
			if(user.getId().equals(id))
				return user;
		}
		return null;
	}
	
}
