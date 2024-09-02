package com.example.TrainingCenter.Entity;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ins_id")
	private Long id;
	
	@Column(name = "ins_name")
	private String name;
	
	
	private String address;
	
	@Column(name = "hire_date")
	private Date hireDate;
	
	private float salary;
	
	private float bouns;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<InstructorCourse> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(Set<InstructorCourse> evaluations) {
		this.evaluations = evaluations;
	}

	@OneToMany(mappedBy = "instructor")
	Set<InstructorCourse> evaluations;

	public Instructor() {
		super();
	}

	public Instructor(Long id, String name, String address, Date hireDate, float salary, float bouns) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.hireDate = hireDate;
		this.salary = salary;
		this.bouns = bouns;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", address=" + address + ", hireDate=" + hireDate
				+ ", salary=" + salary + ", bouns=" + bouns + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, bouns, hireDate, id, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instructor other = (Instructor) obj;
		return Objects.equals(address, other.address)
				&& Float.floatToIntBits(bouns) == Float.floatToIntBits(other.bouns)
				&& Objects.equals(hireDate, other.hireDate) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name)
				&& Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public float getBouns() {
		return bouns;
	}

	public void setBouns(float bouns) {
		this.bouns = bouns;
	}
	
	
	
}
