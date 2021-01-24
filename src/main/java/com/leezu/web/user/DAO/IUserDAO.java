package com.leezu.web.user.DAO;

import java.util.List;

import com.leezu.web.user.DTO.UserDTO;
import com.leezu.web.user.DTO.UserRegReq;

public interface IUserDAO {
	
	//회원가입
	public void userReg(UserRegReq userRegReq) throws Exception;
	
	//로그인
	public UserDTO userLogin(UserDTO dto) throws Exception;
	
	//회원조회
	public List<UserDTO> userList() throws Exception;
}
