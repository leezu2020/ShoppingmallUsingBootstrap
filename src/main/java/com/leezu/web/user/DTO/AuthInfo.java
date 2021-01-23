package com.leezu.web.user.DTO;

// 회원정보 세션 유지 기능
public class AuthInfo {
	private String userID;
	private String userName;
	private char authority;
	
	public AuthInfo(String userID, String userName, char authority) {
		this.userID = userID;
		this.userName = userName;
		this.authority = authority;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public char getAuthority() {
		return authority;
	}
	public void setAuthority(char authority) {
		this.authority = authority;
	}
	
	
}
