package com.navneet.restfulwebservices.servicesimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.navneet.restfulwebservices.entities.User;
import com.navneet.restfulwebservices.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	private static List<User> userList;
	private static long userCount = 0;
	
	static {
		userList  = new ArrayList<>();
		userList.add(new User(++userCount, "Adam", LocalDate.now().minusYears(30)));
		userList.add(new User(++userCount, "Eve", LocalDate.now().minusYears(25)));
		userList.add(new User(++userCount, "Jim", LocalDate.now().minusYears(35)));
	}

	//Method that will fetch the list of all users
	@Override
	public List<User> getAllUsers() {
		return userList;
	}

	//Method that will get the details of a specific user based on its id
	@Override
	public User getUser(Long userId) {
		for(User u : userList) {
			if(u.getUserId() == userId) {
				return u;
			}
		}
		return null;
	}

	//Method that will add a user
	@Override
	public User addAUser(User user) {
		user.setUserId(++userCount);
		userList.add(user);
		return user;
	}

	//Method to delete a user based on input user id
	@Override
	public User deleteAUser(Long userId) {
		for(User user : userList) {
			if(user.getUserId() == userId) {
				User deletedUser = user;
				userList.remove(user);
				return deletedUser;
			}
		}
		return null;
	}
}
