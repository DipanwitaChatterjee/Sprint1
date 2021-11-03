package com.surveybuilder.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;


public class Login {

	private String userName;
	
	private String password;
	
	private String userType;

	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

}
