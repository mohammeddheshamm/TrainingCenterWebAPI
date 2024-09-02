package com.example.TrainingCenter.Exception;

public class NoInstructorTeachCourseException extends RuntimeException {

	private String message;

	public NoInstructorTeachCourseException() {
	
	}

	public NoInstructorTeachCourseException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
