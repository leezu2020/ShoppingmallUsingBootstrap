package com.leezu.web.user.controller;

import java.security.Principal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.user.entity.SecurityUser;
import com.leezu.web.user.entity.User;
import com.leezu.web.user.service.IUserService;

@Controller
@RequestMapping("/customer/user/")
public class CustomerUserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping("userInfo")
	public String userInfo(Principal user, Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		SecurityUser userDetails = (SecurityUser) principal;
		
		User userInfo = new User();
		
		userInfo.setUserID(userDetails.getUserName());
		userInfo.setUserEmail(userDetails.getEmail());
		userInfo.setUserName(user.getName());
		
		model.addAttribute("user", userInfo);
		return "customer.user.info.userInfo";
	}
	
	@GetMapping("modUser")
	public String modUser(Principal user, Model model) {
		String userID = user.getName();
		
		User userInfo = userService.selectByID(userID);
		
		model.addAttribute("userInfo", userInfo);		
		
		System.out.println("modUser GetMapping");
		return "customer.user.info.modUser";
	}
	
	@PostMapping("modUser")
	public String modUser(Principal user, String userName, String userEmail) throws Exception{
		String userID = user.getName();
		
		User modUser = new User();
		modUser.setUserID(userID);
		modUser.setUserName(userName);
		modUser.setUserEmail(userEmail);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("modUser", modUser);
		
		userService.modUser(map);
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		SecurityUser userDetails = (SecurityUser) principal;
		
		userDetails.setUserName(userName);
		
		System.out.println("modUser 실행");
		return "redirect:userInfo";
	}
}
