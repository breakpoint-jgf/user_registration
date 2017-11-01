package com.project.senpai.dto;

import java.io.Serializable;

public class RegistrationDto implements Serializable{

	private static final long serialVersionUID = -1080387644884835076L;

	private String userName = "";
	
	private int age;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

}
