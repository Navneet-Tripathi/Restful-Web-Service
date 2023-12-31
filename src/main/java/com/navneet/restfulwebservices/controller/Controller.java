package com.navneet.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.navneet.restfulwebservices.entities.User;
import com.navneet.restfulwebservices.exceptionhandling.UserNotFoundException;
import com.navneet.restfulwebservices.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api")
public class Controller {
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers(){
		return this.userService.getAllUsers();
	}
	
	@GetMapping(path = "/users/{userId}")
	public EntityModel<User> retrieveAUser(@PathVariable Long userId) {
		User user= this.userService.getUser(userId);
		if(user == null) throw new UserNotFoundException("User doesn't exists! User id : "+ userId);
		//Creating an entity model
		EntityModel<User> userEntityModel = EntityModel.of(user);
		//Creating a WebMvcLinkBuilder object to bind links with data
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers()); //Fetching the url associated with retrieveAllUsers() method instead of hard-coding it
		//Attaching generated link with created entity model
		userEntityModel.add(link.withRel("all-users"));
		return userEntityModel;
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<User> addAUser(@Valid @RequestBody User user) {
		User savedUser = this.userService.addAUser(user); //Adding the user in the user list
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()  //Building the uri so that the user can be fetched 
						.path("/{id}")
						.buildAndExpand(savedUser.getUserId())
						.toUri();

		return ResponseEntity.created(location).body(savedUser);  //Building and returning a response entity with location header and response body containing the saved user
	}
	
	@DeleteMapping(path = "/users/{userId}")
	public User deleteAUser(@PathVariable Long userId){
		User deleteUser = this.userService.deleteAUser(userId);
		if(deleteUser == null) throw new UserNotFoundException("User doesn't exists!User id : "+ userId);
		
		return deleteUser;
	}
	
}
