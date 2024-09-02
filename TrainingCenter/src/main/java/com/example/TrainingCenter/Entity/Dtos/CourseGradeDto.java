package com.example.TrainingCenter.Entity.Dtos;

import com.example.TrainingCenter.Entity.Course;

public class CourseGradeDto {
	
	private Course course;
	private float grade;
	
	public CourseGradeDto() {
		super();
	}

	public CourseGradeDto(Course course, float grade) {
		super();
		this.course = course;
		this.grade = grade;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}
	
	
	
}
