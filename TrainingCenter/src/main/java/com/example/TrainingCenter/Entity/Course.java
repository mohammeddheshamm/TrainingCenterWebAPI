package com.example.TrainingCenter.Entity;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name= "course_id")
	private Long id;
	
	@Column(name = "course_name" )
	private String name;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "description")
	private String desc;
	
	@Column(name = "duration_in_months")
	private int durationInMonths;
	
	@Column(name = "cost")
	private float cost;
	
	@OneToMany(mappedBy = "course")
    Set<StudentCourse> grades;
	
	@OneToMany(mappedBy = "course")
	Set<InstructorCourse> evaluations;

	public Course() {
		
	}

	public Course(Long id, String name, Date startDate, Date endDate, String desc, int durationInMonths) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.desc = desc;
		this.durationInMonths = durationInMonths;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getDurationInMonths() {
		return durationInMonths;
	}

	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}
	


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", desc="
				+ desc + ", durationInMonths=" + durationInMonths + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(desc, durationInMonths, endDate, id, name, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(desc, other.desc) && durationInMonths == other.durationInMonths
				&& Objects.equals(endDate, other.endDate) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(startDate, other.startDate);
	}
	
	
	
}
