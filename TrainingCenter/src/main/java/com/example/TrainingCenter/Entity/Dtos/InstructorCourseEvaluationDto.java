package com.example.TrainingCenter.Entity.Dtos;

import com.example.TrainingCenter.Entity.Course;
import com.example.TrainingCenter.Entity.Instructor;

public class InstructorCourseEvaluationDto {

	private Instructor instructor;
	private Course course;
	private String evaluation;
	
	public InstructorCourseEvaluationDto() {
		
	}
	public InstructorCourseEvaluationDto(Instructor instructor, Course course, String evaluation) {
		this.instructor = instructor;
		this.course = course;
		this.evaluation = evaluation;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	
	
	
}
