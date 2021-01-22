package com.leezu.web.user.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.leezu.web.user.DAO.UserDAOImpl;
import com.leezu.web.user.DTO.UserRegReq;

@Service
public class UserServiceImpl implements IUserService{

	@Inject
	private UserDAOImpl userDAO;
	
	@Override
	public void UserReg(UserRegReq userRegReq) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("회원가입 서비스 시작");
		userDAO.userReg(userRegReq);
		System.out.println("회원가입 서비스 끝");
	}

}
