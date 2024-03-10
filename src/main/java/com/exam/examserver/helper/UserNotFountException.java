package com.exam.examserver.helper;

public class UserNotFountException extends Exception {
	public UserNotFountException() {
		super("User with this username is already there in DB!! try with different username" );
	}
	public UserNotFountException(String msg) {
		super(msg);
	}

}
