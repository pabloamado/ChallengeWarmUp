package com.alkemy.challenge.Exception.msg;

public class ErrorMsg {

	private static final String CATEGORY="Category ";
	
	private static final String POST="Post ";
	
	private static final String WITH_ID="with id ";
	
	private static final String DOESNT_EXISTS=" does not exists.";
	
	private static final String DTO_NOT_VALID="The body of the DTO has errors.";
	
	private static final String BAD_CREDENTIALS="Wrong username or password.";
	
	private static final String USER_EXISTS="The user already exists.";
	
	private static final String USER_NOT_FOUND="The user has not been found.";
	
	public static String categoryNotFoundMsg(Long id) {
		
		return CATEGORY + WITH_ID + id + DOESNT_EXISTS;
	}
	
	public static String postNotFoundMsg(Long id) {
		
		return POST + WITH_ID + id + DOESNT_EXISTS;
	}
	
	public static String dtoBodyNotValidMsg() {
		
		return DTO_NOT_VALID;
	}
	
	public static String badCredentialsMsg() {
		
		return BAD_CREDENTIALS;
	}
	
	public static String UserExistsMsg() {
		
		return USER_EXISTS;
	}
	
	public static String userNotFoundMsg() {
		
		return USER_NOT_FOUND;
	}
}
