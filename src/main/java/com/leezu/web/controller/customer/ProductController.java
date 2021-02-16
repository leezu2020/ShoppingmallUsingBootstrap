package com.leezu.web.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.product.service.IProductService;

@Controller
@RequestMapping("/customer/")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@RequestMapping("productList")
	public String productlist(Model model) throws Exception{
		model.addAttribute("productList", productService.getList());
		return "customer.product.productList";
	}
	
	@RequestMapping("productDetail")
	public String productDetail(Model model, String id) {
		int ID = Integer.parseInt(id);
		System.out.println("product ID : " + ID);
		model.addAttribute("product", productService.get(ID));
		return "customer.product.productDetail";
	}
}
