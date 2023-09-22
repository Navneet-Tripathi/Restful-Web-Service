package com.navneet.restfulwebservices.services;

import java.util.List;

import com.navneet.restfulwebservices.entities.Post;

public interface UserPostService {
	//Method to retrieve all the posts of a user based on the user-id
	public List<Post> getAllUserPost(Long userId);
}
