package com.leezu.web.user.DTO;

import oracle.sql.TIMESTAMP;

public class UserDTO {
	
	private String userID;
	private String userPassword;
	private String userName;
	private String userEmail;
	private char autohrity;
	private char emailChecked;
	private TIMESTAMP regDate;
	
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
	public char getAutohrity() {
		return autohrity;
	}
	public void setAutohrity(char autohrity) {
		this.autohrity = autohrity;
	}
	public char getEmailChecked() {
		return emailChecked;
	}
	public void setEmailChecked(char emailChecked) {
		this.emailChecked = emailChecked;
	}
	
	public boolean matchPassword(String pw) {
		return this.userPassword.equals(pw);
	}
	
	public TIMESTAMP getRegDate() {
		return regDate;
	}
	
	public UserDTO(String userID, String userPassword, String userName, String userEmail, char autohrity,
			char emailChecked, TIMESTAMP regDate) {
		super();
		this.userID = userID;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userEmail = userEmail;
		this.autohrity = autohrity;
		this.emailChecked = emailChecked;
		this.regDate = regDate;
	}


	
}
