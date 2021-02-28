package com.leezu.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.order.dao.IOrderDAO;
import com.leezu.web.order.entity.Order;

@Controller("adminOrderController")
@RequestMapping("/admin/")
public class OrderController {
	
	@Autowired
	private IOrderDAO orderService;
	
	@GetMapping("orderList")
	public String orderList(Model model) {
		
		List<Order> orderList = orderService.getOrderAllList();
		
		model.addAttribute("orderList", orderList);
		return "admin.order.orderList";
	}
	
	@PostMapping("modOrder")
	public String modOrder(Model model) {
		
		return "redirect:orderList";
	}
}
