package com.leezu.web.user.controller;

import java.security.Principal;
import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.leezu.web.security.SecurityUser;
import com.leezu.web.user.entity.User;
import com.leezu.web.user.entity.UserRegReq;
import com.leezu.web.user.service.IUserService;
import com.leezu.web.validator.UserRegValidator;

@Controller
@RequestMapping("/customer/user")
public class CustomerUserController {

	@Autowired
	private IUserService userService;

	
	@GetMapping("")
	public String userReg(UserRegReq userRegReq) {
		System.out.println("회원가입신호");
		return "login.userReg";
	}
	 
	
	// 회원가입
	@PostMapping("")
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
	
	// 유저 정보 조회
	@GetMapping("/{userID}")
	public String userInfo(@PathVariable String userID, Model model) {

		User userInfo = userService.selectByID(userID);
		
		model.addAttribute("user", userInfo);
		return "customer.user.info.userInfo";
	}
	
	// 정보 수정 페이지
	@GetMapping("mod-user")
	public String modUser(Principal user, Model model) {
		String userID = user.getName();

		User userInfo = userService.selectByID(userID);

		model.addAttribute("userInfo", userInfo);

		System.out.println("modUser GetMapping");
		return "customer.user.info.modUser";
	}
	
	// 유저 정보 수정
	@PutMapping("/{userID}")
	public ModelAndView modUser(@PathVariable("userID") String userID, String userName, ModelAndView mv) throws Exception{
		
		User modUser = new User();
		modUser.setUserID(userID);
		modUser.setUserName(userName);

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("modUser", modUser);

		userService.modUser(map);

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		SecurityUser userDetails = (SecurityUser) principal;

		userDetails.setUserName(userName);
		
		// redirect 시 parameter(interceptor에서 오는 aside의 number) 숨기기
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/customer/user/"+userID);
		redirectView.setExposeModelAttributes(false);
		
		mv.setView(redirectView);
		
		System.out.println("modUser 실행");
		return mv;
	}
}
