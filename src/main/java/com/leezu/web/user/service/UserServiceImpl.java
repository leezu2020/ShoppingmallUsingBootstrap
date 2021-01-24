package com.leezu.web.user.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.leezu.web.controller.user.UserLoginValidator;
import com.leezu.web.exception.IDPasswordNotMatchingException;
import com.leezu.web.user.DAO.UserDAOImpl;
import com.leezu.web.user.DTO.AuthInfo;
import com.leezu.web.user.DTO.UserDTO;
import com.leezu.web.user.DTO.UserRegReq;

@Service
public class UserServiceImpl implements IUserService{

	@Inject
	private UserDAOImpl userDAO;
	
	// 회원가입
	@Override
	public void UserReg(UserRegReq userRegReq) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("회원가입 서비스 시작");
		userDAO.userReg(userRegReq);
		System.out.println("회원가입 서비스 끝");
	}

	// 로그인
	@Override
	public AuthInfo UserLogin(UserLoginValidator loginVal) throws Exception {
		UserDTO user = userDAO.selectByID(loginVal.getUserID());
		if(user == null) {
			throw new IDPasswordNotMatchingException();
		}
		if(!user.matchPassword(loginVal.getUserPassword())){
			throw new IDPasswordNotMatchingException();
		}
		return new AuthInfo(user.getUserID(), user.getUserName(), user.getAutohrity());
	}

	// 회원 조회
	@Override
	public List<UserDTO> userList() throws Exception {

		return userDAO.userList();
	}

}
