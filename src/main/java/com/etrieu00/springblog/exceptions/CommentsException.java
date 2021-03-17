package com.etrieu00.springblog.exceptions;

public class CommentsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CommentsException(String message) {
		super(message);
	}
}
