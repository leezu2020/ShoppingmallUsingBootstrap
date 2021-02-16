package com.leezu.web.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/")
public class orderController {
	
	@RequestMapping("orderList")
	public String orderList() {
		return "customer.user.order.orderList";
	}
}
