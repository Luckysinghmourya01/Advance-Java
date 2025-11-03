package com.rays.preparedstatement;

import java.util.Date;

public class UserBean {

	private int id;
	private String Firstname;
	private String Lastname;
	private String login;
	private String password;
	private Date dob;
	
	public int getid(){
		return id;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String Firstname) {
		this.Firstname = Firstname;
	}
	
	public String getLastname() {
		return Lastname;
	}
	
	public void setLastname(String Lastname) {
		this.Lastname = Lastname;
	}
	
	public String getlogin() {
		return login;
	}
	public void setlogin(String login) {
		this.login=login;
	}
	public String getpassword() {
		return password;
	}
	
	public void setpassword(String password) {
		this.password = password;
	}
	
	public Date getdob() {
		return dob;
	}
	
	public void setdob(Date dob) {
		this.dob = dob;
	}
}
