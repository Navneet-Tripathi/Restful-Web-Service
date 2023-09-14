package com.navneet.restfulwebservices.entities;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	private Long userId;
	@Size(min = 2, message = "Username can't be empty!")
	private String userName;
	@Past(message = "User birth date should be in the past!")
	private LocalDate userBirthDate;
	
	//Parameterized Constructor
	public User(Long userId, String userName, LocalDate userBirthDate) {
		this.userId = userId;
		this.userName = userName;
		this.userBirthDate = userBirthDate;
	}
	
	//Getters And Setters
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDate getUserBirthDate() {
		return userBirthDate;
	}
	public void setUserBirthDate(LocalDate userBirthDate) {
		this.userBirthDate = userBirthDate;
	}
}
