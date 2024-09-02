package com.example.TrainingCenter.Exception;

public class NoStudentsRegisteredThisCourse extends RuntimeException {

	private String message;

	public NoStudentsRegisteredThisCourse() {
		
	}

	public NoStudentsRegisteredThisCourse(String message) {
		
		this.message = message;
	}
	
	
}
