package com.leezu.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.order.dao.IOrderDAO;

@Controller("adminOrderController")
@RequestMapping("/admin/")
public class OrderController {
	
	@Autowired
	private IOrderDAO orderService;
	
	@GetMapping("orderList")
	public String orderList(Model model) {
		
		model.addAttribute("orderList", orderService.getOrderAllList());
		return "admin.order.orderList";
	}
}
