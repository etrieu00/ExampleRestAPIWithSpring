package com.etrieu00.springblog.dto;

public class CommentsResponse {
	private Long id;
	private Long author;
	private Long postId;
	private String message;

	public CommentsResponse() { }
	
	public CommentsResponse(Long author, Long postId, String message) {
		this.author = author;
		this.postId = postId;
		this.message = message;
	}
	
	public CommentsResponse(Long id, Long author, Long postId, String message) {
		this.id = id;
		this.author = author;
		this.postId = postId;
		this.message = message;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getAuthor() {
		return author;
	}
	
	public void setAuthor(Long author) {
		this.author = author;
	}
	
	public Long getPostId() {
		return postId;
	}
	
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CommentsResponse [id=" + id + ", author=" + author + ", postId=" + postId + ", message=" + message + "]";
	}
}
