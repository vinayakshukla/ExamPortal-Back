package com.exam.examserver.helper;

public class UserAlreadyPresentException  extends Exception{
	public UserAlreadyPresentException() {
		super("User with this username is already there in DB!! try with different username" );
	}
	public UserAlreadyPresentException(String msg) {
		super(msg);
	}

}
