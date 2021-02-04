package com.leezu.web.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.product.service.IProductService;

@Controller
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@RequestMapping("productlist")
	public String noticelist(Model model) throws Exception{
		model.addAttribute("productList", productService.getList());
		return "customer.productList";
	}	
}
