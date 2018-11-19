package com.knoxgon.rest.webservices.restfulwebservices.userpcg;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

//Following service must be managed by spring, @Component is therefore required
@Component
public class UserDaoService {
	private List<UserBean> users = new ArrayList<>();

	// Method to save the user to DB
	public UserBean saveUser(UserBean user) {
		user.setId(UUID.randomUUID().toString());
		this.users.add(user);
		return user;
	}

	// Method to find and retrieve all users
	public List<UserBean> allUsers() {
		return this.users;
	}

	// Method to find a user
	public UserBean getOneUser(String id) {
		for(UserBean user: this.users) {
			if(user.getId().equals(id))
				return user;
		}
		return null;
	}
	
	//Method to delete a user
	public UserBean deleteUserByID(String id) {
		this.users.forEach(action);
	}
}
