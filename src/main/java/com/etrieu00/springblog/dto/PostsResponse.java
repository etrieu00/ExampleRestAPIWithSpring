package com.etrieu00.springblog.dto;

public class PostsResponse {
	private Long id;
	private String title;
	private String body;
	private Long author;
	
	public PostsResponse() { }
	
	public PostsResponse(String title, String body, Long author) {
		this.title = title;
		this.body = body;
		this.author = author;
	}
	
	public PostsResponse(Long id, String title, String body, Long author) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.author = author;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public Long getAuthor() {
		return author;
	}
	
	public void setAuthor(Long author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "PostsResponse [id=" + id + ", title=" + title + ", body=" + body + ", author=" + author + "]";
	}
}
