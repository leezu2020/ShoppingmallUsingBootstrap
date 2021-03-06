package com.leezu.web.user.entity;

// 회원정보 세션 유지 기능
public class AuthInfo {
	private String userID;
	private String userName;
	private String authority;
	
	public AuthInfo(String userID, String userName, String authority) {
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
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}
