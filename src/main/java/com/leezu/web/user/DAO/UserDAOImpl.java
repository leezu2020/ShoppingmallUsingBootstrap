package com.leezu.web.user.DAO;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.leezu.web.user.DTO.UserRegReq;

@Repository
public class UserDAOImpl implements IUserDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.leezu.mapper.userMapper";
	
	@Override
	public void userReg(UserRegReq userRegReq){
		// TODO Auto-generated method stub
		System.out.println("회원가입 dao 시작");
		sqlSession.insert(namespace + ".userReg", userRegReq);
		System.out.println("회원가입 dao 끝");
	}
	
	
}
