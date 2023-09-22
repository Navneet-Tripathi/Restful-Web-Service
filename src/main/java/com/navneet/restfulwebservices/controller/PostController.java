package com.navneet.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navneet.restfulwebservices.entities.Post;
import com.navneet.restfulwebservices.services.UserPostService;

@RestController
@RequestMapping(path = "/api")
public class PostController {
	@Autowired
	private UserPostService postService;
	
	@GetMapping(path = "/users/{userId}/posts")
	public List<Post> retrieveAllPosts(@PathVariable Long userId){
		List<Post> allUserPost = this.postService.getAllUserPost(userId);
		return allUserPost;
	}
}
