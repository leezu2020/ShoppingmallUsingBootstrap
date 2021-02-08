package com.leezu.web.controller;

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
	public String index(Model model) throws Exception {
		System.out.println("index 매핑");
		model.addAttribute("productList", productService.getList());
		model.addAttribute("noticeNum", noticeService.getNoticeNum());
		return "root.index";
	}
}
