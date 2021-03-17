package com.etrieu00.springblog.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Posts {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long postId;
	private String title;
	private String body;
	@ManyToOne
	@JoinColumn(name="userId", nullable=false)
	private Users user;
	@OneToMany(mappedBy="commentId")
	private List<Comments> comments;
	
	public Posts() { }
	
	public Posts(String title, String body, Users user) {
		this.title = title;
		this.body = body;
		this.user = user;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
}
