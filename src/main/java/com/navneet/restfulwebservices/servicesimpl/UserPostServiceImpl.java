package com.navneet.restfulwebservices.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navneet.restfulwebservices.entities.Post;
import com.navneet.restfulwebservices.entities.User;
import com.navneet.restfulwebservices.exceptionhandling.UserNotFoundException;
import com.navneet.restfulwebservices.repository.UserPostDao;
import com.navneet.restfulwebservices.services.UserPostService;
import com.navneet.restfulwebservices.services.UserService;

@Service
public class UserPostServiceImpl implements UserPostService{
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserPostDao postDao;

	//Method to retrieve all the posts of a user corresponding to user-id
	@Override
	public List<Post> getAllUserPost(Long userId) {
		User user = this.userService.getUser(userId);
		if(user == null) throw new UserNotFoundException("User doesn't exists for id : "+ userId);
		
		List<Post> userPostList = this.postDao.findByUser(user);
		return userPostList;
	}

}
