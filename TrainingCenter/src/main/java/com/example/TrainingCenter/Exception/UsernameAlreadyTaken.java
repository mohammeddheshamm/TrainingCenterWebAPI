package com.example.TrainingCenter.Exception;

public class UsernameAlreadyTaken extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UsernameAlreadyTaken(String message) {
		
		this.message = message;
	}

	public UsernameAlreadyTaken() {
		
	}
	
	
	
}
