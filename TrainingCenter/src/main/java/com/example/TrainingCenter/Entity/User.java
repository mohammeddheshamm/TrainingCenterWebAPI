package com.example.TrainingCenter.Entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usr_id") 
	private Long Id;
	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@OneToOne(mappedBy = "user")
	private Student student;
	
	@OneToOne(mappedBy = "user")
	private Instructor instructor;
	
	@ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles" ,
				joinColumns = @JoinColumn(name = "user_id" , referencedColumnName = "usr_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id" ,referencedColumnName = "id"))
	private List<Role> roles = new ArrayList<>();
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public User() {
		
	}
	
	public User(Long userId, String userName, String email, String password, String phoneNumber) {
		
		this.Id = userId;
		this.username = userName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public Long getUserId() {
		return Id;
	}

	public void setUserId(Long userId) {
		this.Id = userId;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getEmail() {
		return email;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [userId=" + Id + ", userName=" + username + ", email=" + email + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, password, phoneNumber, Id, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(Id, other.Id)
				&& Objects.equals(username, other.username);
	}
	
	
	
}
