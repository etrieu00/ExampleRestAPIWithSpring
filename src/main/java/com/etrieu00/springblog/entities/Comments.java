package com.etrieu00.springblog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comments {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long commentId;
	@ManyToOne
	@JoinColumn(name="userId", nullable=false)
	private Users user;
	@ManyToOne
	@JoinColumn(name="postId", nullable=false)
	private Posts post;
	private String message;
	
	public Comments() {
	}

	public Comments(Users user, 
					Posts post, 
					String message) {
		this.user = user;
		this.post = post;
		this.message = message;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Posts getPost() {
		return post;
	}

	public void setPost(Posts post) {
		this.post = post;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
