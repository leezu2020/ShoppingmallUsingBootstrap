package com.leezu.web.user.service;

import com.leezu.web.controller.user.UserLoginValidator;
import com.leezu.web.user.DTO.AuthInfo;
import com.leezu.web.user.DTO.UserRegReq;

public interface IUserService {
	
	// 회원가입
	public void UserReg(UserRegReq userRegReq) throws Exception;
	
	// 로그인
	AuthInfo UserLogin(UserLoginValidator loginVal) throws Exception;
}
