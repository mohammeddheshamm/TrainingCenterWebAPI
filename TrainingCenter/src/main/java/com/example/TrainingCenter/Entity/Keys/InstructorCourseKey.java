package com.example.TrainingCenter.Entity.Keys;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class InstructorCourseKey implements Serializable {

	
	@Column(name = "ins_course")
	private Long InstructorId;

	
	@Column(name = "course_id")
    private Long courseId;


	public InstructorCourseKey() {
		
	}


	public InstructorCourseKey(Long instructorId, Long courseId) {
		InstructorId = instructorId;
		this.courseId = courseId;
	}


	public Long getInstructorId() {
		return InstructorId;
	}


	public void setInstructorId(Long instructorId) {
		InstructorId = instructorId;
	}


	public Long getCourseId() {
		return courseId;
	}


	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}


	@Override
	public String toString() {
		return "InstructorCourseKey [InstructorId=" + InstructorId + ", courseId=" + courseId + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(InstructorId, courseId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstructorCourseKey other = (InstructorCourseKey) obj;
		return Objects.equals(InstructorId, other.InstructorId) && Objects.equals(courseId, other.courseId);
	}
	
	
	
}
