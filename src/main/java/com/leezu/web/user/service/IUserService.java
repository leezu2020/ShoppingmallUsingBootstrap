package com.leezu.web.user.service;

import java.util.List;

import com.leezu.web.controller.login.UserLoginValidator;
import com.leezu.web.user.DTO.AuthInfo;
import com.leezu.web.user.DTO.UserDTO;
import com.leezu.web.user.DTO.UserRegReq;

public interface IUserService {
	
	// 회원가입
	public void UserReg(UserRegReq userRegReq) throws Exception;
	
	// 로그인
	public AuthInfo UserLogin(UserLoginValidator loginVal) throws Exception;
	
	// 회원 리스트 조회
	public List<UserDTO> userList() throws Exception;

}
