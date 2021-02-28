package com.leezu.web.controller.customer;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.basket.service.IBasketService;
import com.leezu.web.user.entity.AuthInfo;
import com.leezu.web.user.entity.User;
import com.leezu.web.user.service.IUserService;

@Controller
@RequestMapping("/customer/user/")
public class UserController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IBasketService basketService;
	
	@RequestMapping("userInfo")
	public String userInfo(HttpSession session, Model model) {
		AuthInfo user = (AuthInfo) session.getAttribute("authInfo");
		
		User userInfo = userService.selectByID(user.getUserID());
		
		model.addAttribute("user", userInfo);
		return "customer.user.info.userInfo";
	}
	
	@GetMapping("modUser")
	public String modUser(HttpSession session, Model model) {
		AuthInfo user = (AuthInfo) session.getAttribute("authInfo");
		
		User userInfo = userService.selectByID(user.getUserID());
		
		model.addAttribute("userInfo", userInfo);		
		
		System.out.println("modUser GetMapping");
		return "customer.user.info.modUser";
	}
	
	@PostMapping("modUser")
	public String modUser(HttpSession session, String userName, String userEmail) throws Exception{
		AuthInfo user = (AuthInfo) session.getAttribute("authInfo");
		String ID = user.getUserID();
		
		User modUser = new User();
		modUser.setUserID(ID);
		modUser.setUserName(userName);
		modUser.setUserEmail(userEmail);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("modUser", modUser);
		
		
		userService.modUser(map);
		System.out.println("modUser 실행");
		return "redirect:userInfo";
	}
}
