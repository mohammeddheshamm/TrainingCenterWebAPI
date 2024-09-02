package com.example.TrainingCenter.Exception;

public class NoCoursesTeachedByInstructor extends RuntimeException {

	private String message;

	public NoCoursesTeachedByInstructor(String message) {
		super();
		this.message = message;
	}

	public NoCoursesTeachedByInstructor() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
