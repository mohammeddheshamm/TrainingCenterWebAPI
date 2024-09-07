package com.example.TrainingCenter.Exception;

public class NoEntitiesYetException extends RuntimeException  {

	private String message;

	public NoEntitiesYetException(String message) {
		super();
		this.message = message;
	}

	public NoEntitiesYetException() {
		super();
	}
	
	
	
}
