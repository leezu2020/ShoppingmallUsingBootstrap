package com.leezu.web.user.entity;

import java.util.Date;

public class User {
	
	private String userID;
	private String userPassword;
	private String userName;
	private String userEmail;
	private int authority;
	private boolean emailChecked;
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
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public boolean isEmailChecked() {
		return emailChecked;
	}

	public void setEmailChecked(boolean emailChecked) {
		this.emailChecked = emailChecked;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public User(String userID, String userPassword, String userName, String userEmail, int authority,
			boolean emailChecked, Date regDate) {
		super();
		this.userID = userID;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userEmail = userEmail;
		this.authority = authority;
		this.emailChecked = emailChecked;
		this.regDate = regDate;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public boolean matchPassword(String pw) {
		return this.userPassword.equals(pw);
	}
	
}
