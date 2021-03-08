package com.leezu.web.user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.exception.IDNoExist;
import com.leezu.web.exception.IDPasswordNotMatchingException;
import com.leezu.web.user.entity.AuthInfo;
import com.leezu.web.user.entity.UserRegReq;
import com.leezu.web.user.service.IUserService;
import com.leezu.web.validator.UserLoginValidator;
import com.leezu.web.validator.UserRegValidator;

@Controller
@RequestMapping("/login/")
public class LoginController {

	@Autowired
	private IUserService userService;

	@GetMapping("userReg")
	public String userReg(UserRegReq userRegReq){
		System.out.println("회원가입신호");
		return "login.userReg";
	}
	// 회원가입
	@PostMapping("userReg")
	public String userReg(@ModelAttribute @Valid UserRegReq userRegReq, Errors errors) throws Exception {
		System.out.println("modelAttribute 확인" + userRegReq.getUserID());
		new UserRegValidator().validate(userRegReq, errors);
		System.out.println("에러 체크 UserController");
		if(errors.hasErrors()) {
			System.out.println("에러 UserController");
			return "login.userReg";
		}
		userService.UserReg(userRegReq);
		System.out.println("회원가입 성공");
		return "login.successReg";
	}
	
	// 로그인
	@GetMapping("userLogin")
	public String userlogin(UserLoginValidator loginVal, @CookieValue(value="REMEMBER", required=false) Cookie rememberCookie) throws Exception {
		
		// 쿠키가 있으면
		if(rememberCookie != null) {
			loginVal.setUserID(rememberCookie.getValue());
			loginVal.setRememberID(true);
		}
		
		return "login.userLogin";
	}

	
	// 로그아웃
	@GetMapping("userLogout")
	public String userlogout(HttpSession session) throws Exception{
		
		session.invalidate();
		return "login.successLogout";
	}
}
