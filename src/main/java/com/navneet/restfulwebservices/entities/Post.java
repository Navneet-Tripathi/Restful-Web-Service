package com.navneet.restfulwebservices.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	@JsonProperty(value = "id")
	private Long postId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@JsonProperty(value = "user_id")
	@JsonIgnore
	private User user;
	
	@Column(name = "post_heading")
	@JsonProperty(value = "post_heading")
	private String postHeading;
	
	@Column(name = "post_content")
	@JsonProperty(value = "post_content")
	private String postContent;
	
	//Default Constructor
	public Post() {
		
	}

	//Parameterized Constructor
	public Post(Long postId, User user, String postHeading, String postContent) {
		this.postId = postId;
		this.user = user;
		this.postHeading = postHeading;
		this.postContent = postContent;
	}

	//Getters & Setters
	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUserId(User user) {
		this.user = user;
	}

	public String getPostHeading() {
		return postHeading;
	}

	public void setPostHeading(String postHeading) {
		this.postHeading = postHeading;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
}
