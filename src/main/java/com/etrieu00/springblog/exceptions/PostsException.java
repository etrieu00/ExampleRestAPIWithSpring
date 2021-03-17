package com.etrieu00.springblog.exceptions;

public class PostsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PostsException(String message) {
		super(message);
	}
}
