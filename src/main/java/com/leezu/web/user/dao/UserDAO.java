package com.leezu.web.user.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leezu.web.paging.DAO.PagingDAO;
import com.leezu.web.user.entity.User;
import com.leezu.web.user.entity.UserRegReq;

@Repository
public class UserDAO{

	// SqlSession 객체를 스프링에서 생성해서 주입시켜준다.IoC
	// try catch문, finally문, 객체를 close할 필요가 사라짐
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.leezu.mapper.userMapper";
	
	
	// 회원가입
	public void userReg(UserRegReq userRegReq){
		// TODO Auto-generated method stub
		System.out.println("회원가입 dao 시작");
		sqlSession.insert(namespace + ".userReg", userRegReq);
		System.out.println("회원가입 dao 끝");
	}
	
	// 로그인
	public User userLogin(User dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".userLogin", dto);
	}
	
	// 아이디로 확인
	public User selectByID(String id) {
		return sqlSession.selectOne(namespace + ".selectByID", id);
	}

	// 회원 조회
	public List<User> userList(PagingDAO paging) throws Exception {
		return sqlSession.selectList(namespace + ".userList", paging);
	}

	public int getUserNum(String condition, String keyword) {
		HashMap<String, String> key = new HashMap<String, String>();
		key.put("condition", condition);
		key.put("keyword", keyword);
		return sqlSession.selectOne(namespace + ".getUserNum", key);
	}

	// 회원 정보 수정
	public void modUser(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".modUser", map);
	}
	
	
}

