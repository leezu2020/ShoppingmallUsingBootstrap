package com.leezu.web.user.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.leezu.web.user.DTO.UserDTO;
import com.leezu.web.user.DTO.UserRegReq;

@Repository
public class UserDAOImpl implements IUserDAO{

	// SqlSession 객체를 스프링에서 생성해서 주입시켜준다.IoC
	// try catch문, finally문, 객체를 close할 필요가 사라짐
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.leezu.mapper.userMapper";
	
	
	// 회원가입
	@Override
	public void userReg(UserRegReq userRegReq){
		// TODO Auto-generated method stub
		System.out.println("회원가입 dao 시작");
		sqlSession.insert(namespace + ".userReg", userRegReq);
		System.out.println("회원가입 dao 끝");
	}
	
	// 로그인
	@Override
	public UserDTO userLogin(UserDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".userLogin", dto);
	}
	
	// 아이디로 확인
	public UserDTO selectByID(String id) {
		return sqlSession.selectOne(namespace + ".selectByID", id);
	}

	// 회원 조회
	@Override
	public List<UserDTO> userList() throws Exception {
		return sqlSession.selectList(namespace + ".userList");
	}
	
}

