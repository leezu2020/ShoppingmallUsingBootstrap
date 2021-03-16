package com.leezu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.product.service.IProductService;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private IProductService productService;
	
	@GetMapping("")
	public String index(Model model) throws Exception {
		System.out.println("home Controller 실행");
		model.addAttribute("productHomeList", productService.getList("", "all", 1, 2147483647));
		return "root.index";
	}
}
