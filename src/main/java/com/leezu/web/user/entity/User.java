package com.leezu.web.user.entity;

import java.util.Date;

public class User {
	
	private String userID;
	private String userPassword;
	private String userName;
	private String userEmail;
	private String authority;
	private Date regDate;
	

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public User(String userID, String userPassword, String userName, String userEmail, String authority,
			Date regDate) {
		super();
		this.userID = userID;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userEmail = userEmail;
		this.authority = authority;
		this.regDate = regDate;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public boolean matchPassword(String pw) {
		return this.userPassword.equals(pw);
	}
	
}
