package com.etrieu00.springblog.exceptions;

public class UsersException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UsersException(String message) {
		super(message);
	}
}
