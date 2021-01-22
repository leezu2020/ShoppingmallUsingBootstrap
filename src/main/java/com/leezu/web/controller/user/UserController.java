package com.leezu.web.controller.user;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leezu.web.user.DTO.UserRegReq;
import com.leezu.web.user.service.IUserService;

@Controller
@RequestMapping("/login/")
public class UserController {

	@Inject
	private IUserService userService;

	@GetMapping("userReg")
	public String userReg(UserRegReq userRegReq){
		System.out.println("회원가입신호");
		return "/login/userReg";
	}
	
	@PostMapping("userReg")
	public String userReg(UserRegReq userRegReq, Errors errors) throws Exception {
		new UserRegValidator().validate(userRegReq, errors);
		System.out.println("에러 체크 UserController");
		if(errors.hasErrors()) {
			System.out.println("에러 UserController");
			return "/login/userReg";
		}
		System.out.println("회원가입 성공");
		userService.UserReg(userRegReq);
		return "redirect:/login/join";
	}
	
	@RequestMapping("join")
	@ResponseBody
	public String join() {
		return "회원가입성공";
	}
	
	@RequestMapping("userLogin")
	public String userlogin() {
		return "/login/userLogin";
	}
}
