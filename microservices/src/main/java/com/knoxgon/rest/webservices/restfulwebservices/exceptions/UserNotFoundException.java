package com.knoxgon.rest.webservices.restfulwebservices.exceptions;

public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 6622473984205510970L;

	public UserNotFoundException(String message) {
		super(String.format("[message=%s]", message));
	}
	
}
