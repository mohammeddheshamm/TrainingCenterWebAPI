package com.example.TrainingCenter.Entity.Keys;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class StudentCourseKey implements Serializable{

	@Column(name = "student_id")
    private Long studentId;

    @Column(name = "course_id")
    private Long courseId;
    

	public StudentCourseKey() {
	}

	public StudentCourseKey(Long studentId, Long courseId) {
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "StudentCourseGrade [studentId=" + studentId + ", courseId=" + courseId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseId, studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentCourseKey other = (StudentCourseKey) obj;
		return Objects.equals(courseId, other.courseId) && Objects.equals(studentId, other.studentId);
	}	
    
    
	
}
