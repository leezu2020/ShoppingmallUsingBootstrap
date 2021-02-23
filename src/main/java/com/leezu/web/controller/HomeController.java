package com.leezu.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.notice.service.INoticeService;
import com.leezu.web.product.service.IProductService;

@Controller
@RequestMapping("/")
public class HomeController{

	@Autowired
	private IProductService productService;
	@Autowired
	private INoticeService noticeService;
	
	@GetMapping("")
	public String index(Model model, HttpSession session) throws Exception {
		System.out.println("index 매핑");
		model.addAttribute("productList", productService.getList("","all",1,2147483647));
		session.setAttribute("noticeNum", noticeService.getNoticeNum("",""));
		session.setAttribute("eventNum", 3);
		session.setAttribute("productNum", productService.getProductNum());
		return "root.index";
	}
}
