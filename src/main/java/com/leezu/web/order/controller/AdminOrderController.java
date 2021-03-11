package com.leezu.web.order.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.leezu.web.order.dao.OrderDAO;
import com.leezu.web.order.entity.Order;

@Controller
@RequestMapping("/admin/")
public class AdminOrderController {
	
	@Autowired
	private OrderDAO orderService;
	
	@GetMapping("orders")
	public String orderList(Model model) {
		
		List<Order> orderList = orderService.getOrderAllList();
		
		model.addAttribute("orderList", orderList);
		return "admin.order.orderList";
	}
	
	@PutMapping("order")
	public ModelAndView modOrder(String[] orderID,
			String[] state, ModelAndView mv) {
		
		for(int i=0; i<orderID.length; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("orderID", orderID[i]);
			map.put("state", state[i]);
			orderService.modOrder(map);
		}
		// redirect 시 parameter(interceptor에서 오는 aside의 number) 숨기기
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("redirect:orders");
		redirectView.setExposeModelAttributes(false);
		
		mv.setView(redirectView);
		
		return mv;
	}
}
