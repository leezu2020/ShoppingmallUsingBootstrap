package com.leezu.web.user.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.leezu.web.paging.DAO.PagingDAO;
import com.leezu.web.user.entity.User;
import com.leezu.web.user.entity.UserRegReq;

@Repository
public class UserDAOImp implements IUserDAO{

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
	public User userLogin(User dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".userLogin", dto);
	}
	
	// 아이디로 확인
	public User selectByID(String id) {
		return sqlSession.selectOne(namespace + ".selectByID", id);
	}

	// 회원 조회
	@Override
	public List<User> userList(PagingDAO paging) throws Exception {
		return sqlSession.selectList(namespace + ".userList", paging);
	}

	@Override
	public int getUserNum() {
		return sqlSession.selectOne(namespace + ".getUserNum");
	}
	
}

