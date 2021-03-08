package com.leezu.web.order.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.order.entity.Order;
import com.leezu.web.repository.OrderDAO;

@Controller
@RequestMapping("/admin/")
public class AdminOrderController {
	
	@Autowired
	private OrderDAO orderService;
	
	@GetMapping("orderList")
	public String orderList(Model model) {
		
		List<Order> orderList = orderService.getOrderAllList();
		
		model.addAttribute("orderList", orderList);
		return "admin.order.orderList";
	}
	
	@PostMapping("modOrder")
	public String modOrder(String[] orderID,
			String[] state) {
		
		for(int i=0; i<orderID.length; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("orderID", orderID[i]);
			map.put("state", state[i]);
			orderService.modOrder(map);
		}
		
		return "redirect:orderList";
	}
}
