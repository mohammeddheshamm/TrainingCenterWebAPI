package com.example.TrainingCenter.Entity;

import java.util.Objects;

import com.example.TrainingCenter.Entity.Keys.InstructorCourseKey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "insructor_course")
public class InstructorCourse {

	@EmbeddedId
	private InstructorCourseKey id;
	
	@ManyToOne
    @MapsId("InstructorId")
    @JoinColumn(name = "ins_id")
    private Instructor instructor;
	
	@ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;
	
	private String evaluation;

	public InstructorCourse() {
		
	}

	public InstructorCourse(InstructorCourseKey id, Instructor instructor, Course course, String evaluation) {
		this.id = id;
		this.instructor = instructor;
		this.course = course;
		this.evaluation = evaluation;
	}

	public InstructorCourseKey getId() {
		return id;
	}

	public void setId(InstructorCourseKey id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "InstructorCourse [id=" + id + ", instructor=" + instructor + ", course=" + course + ", evaluation="
				+ evaluation + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, evaluation, id, instructor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstructorCourse other = (InstructorCourse) obj;
		return Objects.equals(course, other.course) && Objects.equals(evaluation, other.evaluation)
				&& Objects.equals(id, other.id) && Objects.equals(instructor, other.instructor);
	}
	
	
	
	
}
