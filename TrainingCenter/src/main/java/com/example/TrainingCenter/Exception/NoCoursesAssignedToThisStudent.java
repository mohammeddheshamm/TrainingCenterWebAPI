package com.example.TrainingCenter.Exception;

public class NoCoursesAssignedToThisStudent extends RuntimeException {

	private String message;

	public NoCoursesAssignedToThisStudent(String message) {
		super();
		this.message = message;
	}

	public NoCoursesAssignedToThisStudent() {
		super();
	}
	
	
}
