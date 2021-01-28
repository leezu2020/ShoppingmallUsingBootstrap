package com.leezu.web.controller.admin;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.user.service.IUserService;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Inject
	private IUserService userService;

	@GetMapping("userList")
	public String userList(Model model) throws Exception {
		model.addAttribute("userList", userService.userList());
		System.out.println("userList 조회");
		return "admin.userList";
	}
	
	@GetMapping("productList")
	public String productList() throws Exception {
		return "admin.productList";
	}
	
	@GetMapping("eventList")
	public String eventList() throws Exception {
		return "admin.eventList";
	}
	
	@GetMapping("noticeList")
	public String noticeList() throws Exception {
		return "admin.noticeList";
	}
}
