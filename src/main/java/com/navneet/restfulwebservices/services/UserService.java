package com.navneet.restfulwebservices.services;

import java.util.List;

import com.navneet.restfulwebservices.entities.User;

public interface UserService {
	//Method that will return a list of users
	public List<User> getAllUsers();
	
	//Method that will return a specific user based on its id
	public User getUser(Long userId);
	
	//Method that will add a user
	public User addAUser(User user);
	
	//Method to delete a user based on the input user id
	public User deleteAUser(Long userId);
}
