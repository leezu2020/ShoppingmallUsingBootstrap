package com.leezu.web.controller.admin;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leezu.web.paging.DAO.PagingDAO;
import com.leezu.web.user.service.IUserService;

@Controller("adminUserController")
@RequestMapping("/admin/")
public class UserController {
	
	@Inject
	private IUserService userService;
	

	@GetMapping("userList")
	public String userList(Model model, PagingDAO paging,
			
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String condition,
			
			@RequestParam(defaultValue = "1")int nowPage,
			@RequestParam(defaultValue = "5")int cntPerPage) throws Exception {
		
		/*
		 * // 키워드에 한글이 포함될 가능성이 있기 때문에 미리 인코딩 String encodedKeyword = null; try {
		 * encodedKeyword = URLEncoder.encode(keyword, "utf-8");
		 * System.out.println("encodedKeyword는" + encodedKeyword); }
		 * catch(UnsupportedEncodingException e) { e.printStackTrace(); }
		 */
		
		
		
		int userNum = userService.getUserNum(condition, keyword);		
		System.out.println("검색된 유저 수 : " + userNum);
		
		paging = new PagingDAO(userNum, nowPage, cntPerPage, condition, keyword);
		
		model.addAttribute("userList", userService.userList(paging));
		model.addAttribute("page", paging);
		System.out.println("userList 조회");
		return "admin.user.userList";
	}

	
	@GetMapping("eventList")
	public String eventList() throws Exception {
		return "admin.event.eventList";
	}
}
