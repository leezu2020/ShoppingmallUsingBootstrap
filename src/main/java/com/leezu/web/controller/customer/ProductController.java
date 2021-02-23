package com.leezu.web.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leezu.web.product.service.IProductService;

@Controller
@RequestMapping("/customer/")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	
	@GetMapping("productList")
	public String productlist(Model model,
			@RequestParam(defaultValue = "all") String size,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "1") int minprice,
			@RequestParam(defaultValue = "2147483647") int maxprice) throws Exception{
		
		model.addAttribute("productList", productService.getList(keyword, size, minprice, maxprice));
		System.out.println("keyword : " + keyword +
				" size : " + size + 
				" minprice : " + minprice + 
				" maxprice : " + maxprice + 
				" 상품 리스트 검색 갯수" + productService.getList(keyword, size, minprice, maxprice).size());

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
