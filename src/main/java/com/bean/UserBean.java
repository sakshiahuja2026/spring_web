package com.bean;

import javax.validation.constraints.NotBlank;

public class UserBean {
	Integer userId;
	@NotBlank(message = "Please Enter FirstName")
	String firstName;
	@NotBlank(message = "Please Enter lastName")
	String lastName;
	@NotBlank(message = "Please Enter Email")
	String email;
	@NotBlank(message = "Please Select Gender")
	String gender;
	@NotBlank(message = "Please Enter Password")
	String password;
	String userType;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
