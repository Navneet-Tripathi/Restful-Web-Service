package com.navneet.restfulwebservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navneet.restfulwebservices.entities.Post;
import com.navneet.restfulwebservices.entities.User;

public interface UserPostDao extends JpaRepository<Post, Long>{

	//Method to fetch all the post corresponding to a user
	public List<Post> findByUser(User user);
}
