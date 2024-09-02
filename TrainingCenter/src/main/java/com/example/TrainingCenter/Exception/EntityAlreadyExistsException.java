package com.example.TrainingCenter.Exception;

public class EntityAlreadyExistsException extends RuntimeException {

	private String message;

	public EntityAlreadyExistsException() {
		
	}

	public EntityAlreadyExistsException(String message) {
		this.message = message;
	}
	
	
	
}
