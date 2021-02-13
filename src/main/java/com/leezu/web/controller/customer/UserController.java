package com.leezu.web.controller.customer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.user.entity.AuthInfo;
import com.leezu.web.user.entity.User;
import com.leezu.web.user.service.IUserService;

@Controller
@RequestMapping("/customer/user/")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping("userInfo")
	public String userInfo(HttpSession session, Model model) {
		AuthInfo user = (AuthInfo) session.getAttribute("authInfo");
		
		User userInfo = userService.selectByID(user.getUserID());

		System.out.println(userInfo.getUserID());
		
		model.addAttribute("user", userInfo);
		return "customer.user.userInfo";
	}
}
