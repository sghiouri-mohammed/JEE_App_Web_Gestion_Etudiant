package com.tp1.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	
	private String fname;
	private String lname;
	private String login;
	private String password;
	private String dob;
	private String mobile ;
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDob() {
	
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
}

