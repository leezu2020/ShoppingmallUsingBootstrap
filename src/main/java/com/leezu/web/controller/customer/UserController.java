package com.leezu.web.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/user/")
public class UserController {

	@RequestMapping("userInfo")
	public String userInfo() {
		
		return "customer.user.userInfo";
	}
}
