package com.leezu.web.user.service;

import java.util.HashMap;
import java.util.List;

import com.leezu.web.controller.login.UserLoginValidator;
import com.leezu.web.paging.DAO.PagingDAO;
import com.leezu.web.user.entity.AuthInfo;
import com.leezu.web.user.entity.User;
import com.leezu.web.user.entity.UserRegReq;

public interface IUserService {
	
	// 회원가입
	public void UserReg(UserRegReq userRegReq) throws Exception;
	
	// 로그인
	public AuthInfo UserLogin(UserLoginValidator loginVal) throws Exception;
	
	// 회원 리스트 조회
	public List<User> userList(PagingDAO paging) throws Exception;

	// 회원 수 조회
	public int getUserNum();
	
	public User selectByID(String id);

	// 회원 정보 수정
	public void modUser(HashMap<String, Object> map);
}
