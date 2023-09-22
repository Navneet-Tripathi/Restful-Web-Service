package com.navneet.restfulwebservices.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user_details")
public class User {
	
	@JsonProperty("user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long userId;
	
	@JsonProperty("user_name")
	@Size(min = 2, message = "Username can't be empty!")
	@Column(name = "user_name", nullable = false)
	private String userName;
	
	@JsonProperty("birth_date")
	@Past(message = "User birth date should be in the past!")
	@Column(name = "birth_date", nullable = false)
	private LocalDate userBirthDate;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;
	
	//Default Constructor
	public User() {
	}

	//Parameterized Constructor
	public User(Long userId, String userName, LocalDate userBirthDate, List<Post> posts) {
		this.userId = userId;
		this.userName = userName;
		this.userBirthDate = userBirthDate;
		this.posts = posts;
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
	
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	//To string method to print details of a user using its reference variable
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userBirthDate=" + userBirthDate + ", posts="
				+ posts + "]";
	}
	
}
