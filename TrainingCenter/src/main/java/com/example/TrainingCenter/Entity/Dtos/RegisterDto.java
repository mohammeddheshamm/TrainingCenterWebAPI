package com.example.TrainingCenter.Entity.Dtos;

public class RegisterDto {

	private String username;
	
	private String password;
	
	private String email;
	
	private String phoneNumber;
	
	private String role;

	public String getRole() {
		return role;
	}

	private void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public RegisterDto() {
	
	}

	public RegisterDto(String username, String password, String email, String phoneNumber) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

}

