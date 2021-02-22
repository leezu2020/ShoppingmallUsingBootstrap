package com.leezu.web.user.DAO;

import java.util.HashMap;
import java.util.List;

import com.leezu.web.paging.DAO.PagingDAO;
import com.leezu.web.user.entity.User;
import com.leezu.web.user.entity.UserRegReq;

public interface IUserDAO {
	
	//회원가입
	public void userReg(UserRegReq userRegReq) throws Exception;
	
	//로그인
	public User userLogin(User dto) throws Exception;
	
	//회원 리스트 조회
	List<User> userList(PagingDAO paging) throws Exception;
	
	//회원 수 조회
	public int getUserNum(String condition, String keyword);
	
	public User selectByID(String id);

	// 회원 정보 수정
	public void modUser(HashMap<String, Object> map);

}
