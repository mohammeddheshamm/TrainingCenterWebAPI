package com.example.TrainingCenter.Exception;

public class NoSuchEntityException extends RuntimeException{

	private String message;

	public NoSuchEntityException() {
		
	}

	public NoSuchEntityException(String message) {
		this.message = message;
	}
	
	
	
}
