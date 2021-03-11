package com.leezu.web.user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.validator.UserLoginValidator;

@Controller
@RequestMapping("/")
public class LoginController {

	// 로그인
	@GetMapping("login")
	public String userlogin(UserLoginValidator loginVal, @CookieValue(value="REMEMBER", required=false) Cookie rememberCookie) throws Exception {
		
		// 쿠키가 있으면
		if(rememberCookie != null) {
			loginVal.setUserID(rememberCookie.getValue());
			loginVal.setRememberID(true);
		}
		
		return "login.userLogin";
	}

	
	// 로그아웃
	@GetMapping("logout")
	public String userlogout(HttpSession session) throws Exception{
		
		session.invalidate();
		return "login.successLogout";
	}
}
