package com.leezu.web.controller.customer;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.basket.entity.Basket;
import com.leezu.web.basket.service.IBasketService;
import com.leezu.web.user.entity.AuthInfo;

@Controller
@RequestMapping("/customer/")
public class basketController {

	@Autowired
	private IBasketService basketService;
	
	@RequestMapping("basketList")
	public String basketList() {
		return "customer.user.basket.basketList";
	}
	
	@PostMapping("addBasket")
	public String addBasket(HttpSession session, String cnt, String productID) {
		System.out.println("cnt : " + cnt + " productID : " + productID);
		
		Basket prebasket = new Basket();
		int productid = Integer.parseInt(productID);
		prebasket.setProductID(productid);
		
		AuthInfo user = (AuthInfo) session.getAttribute("authInfo");
		prebasket.setUserID(user.getUserID());
		
		int ea = Integer.parseInt(cnt);
		prebasket.setCount(ea);
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("basket", prebasket);
		
		basketService.addBasket(map);
		
		return "customer.user.basket.basketList";
	}
}
