package com.example.TrainingCenter.Entity;

import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "stud_id")
	private Long id ;
	
	@Column(name = "stud_fname")
	private String firstName;
	
	@Column(name = "stud_lname")
	private String lastName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "birth_date")
	private Date birthDate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    private User user;


	public Set<StudentCourse> getGrades() {
		return grades;
	}

	public void setGrades(Set<StudentCourse> grades) {
		this.grades = grades;
	}

	@OneToMany(mappedBy = "student")
    Set<StudentCourse> grades;
	
	
	public Student() {
		
	}

	public Student(Long id, String firstName, String lastName, int age, String address, Date birthDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.birthDate = birthDate;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", address=" + address + ", birthDate=" + birthDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age, birthDate, firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(birthDate, other.birthDate)
				&& Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName);
	} 
	
	
	
}
