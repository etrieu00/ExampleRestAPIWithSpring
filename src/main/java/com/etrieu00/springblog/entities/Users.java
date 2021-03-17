package com.etrieu00.springblog.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userId;
	private String firstName;
	private String lastName;
	@OneToMany(mappedBy= "postId")
	private List<Posts> posts;
	@OneToMany(mappedBy= "commentId")
	private List<Comments> comments;
	
	public Users() {
	}
	
	public Users(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public List<Posts> getPosts() {
		return posts;
	}
	
	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}
	
	public List<Comments> getComments() {
		return comments;
	}
	
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}	
}
