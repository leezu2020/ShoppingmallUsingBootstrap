package com.leezu.web.user.DAO;

import com.leezu.web.user.DTO.UserRegReq;

public interface IUserDAO {
	public void userReg(UserRegReq userRegReq) throws Exception;
}
