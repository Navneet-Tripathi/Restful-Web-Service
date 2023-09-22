package com.navneet.restfulwebservices.servicesimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navneet.restfulwebservices.entities.User;
import com.navneet.restfulwebservices.repository.UserDao;
import com.navneet.restfulwebservices.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	//Method that will fetch the list of all users
	@Override
	public List<User> getAllUsers() {
		return this.userDao.findAll();
	}

	//Method that will get the details of a specific user based on its id
	@Override
	public User getUser(Long userId) {
		User user = this.userDao.findById(userId).orElse(null);
		return user;
	}

	//Method that will add a user
	@Override
	public User addAUser(User user) {
		User savedUser = this.userDao.save(user);
		return savedUser;
	}

	//Method to delete a user based on input user id
	@Override
	public User deleteAUser(Long userId) {
		User user = this.userDao.findById(userId).orElse(null);
		if(user != null) {
			this.userDao.delete(user);
		}
		
		return user;
	}
}
