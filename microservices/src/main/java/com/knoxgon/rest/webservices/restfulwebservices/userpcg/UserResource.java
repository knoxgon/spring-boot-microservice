package com.knoxgon.rest.webservices.restfulwebservices.userpcg;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//Rest controller - Resource
@RestController
public class UserResource {
	
	//What spring does is to create an instance of userService and wire it for use
	@Autowired
	private UserDaoService userService = new UserDaoService();
	
	//GET /users
	//Retrieve all users
	@GetMapping("/users")
	public List<User> retrieveUsers(){
		return userService.allUsers();
	}
	
	//GET /users/{id}
	//Retrieve one user, id as input
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable String id) {
		return userService.getOneUser(id);
	}
	
	//POST/users
	//Store user
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User saveUser = this.userService.saveUser(user);
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(saveUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
