package com.leezu.web.validator;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;



@Entity
public class UserLoginValidator {

	//null 검증만 하면되므로 hibernate 사용
	
	@NotBlank(message="아이디를 입력해주세요.")
	private String userID;
	
	@NotEmpty(message="비밀번호를 입력해주세요.")
	private String userPassword;
	private boolean rememberID;
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
	public boolean isRememberID() {
		return rememberID;
	}
	public void setRememberID(boolean rememberID) {
		this.rememberID = rememberID;
	}
	
}
