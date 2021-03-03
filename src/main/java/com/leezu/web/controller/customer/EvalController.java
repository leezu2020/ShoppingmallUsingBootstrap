package com.leezu.web.controller.customer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.eval.entity.Eval;
import com.leezu.web.eval.service.IEvalService;
import com.leezu.web.order.entity.Order;
import com.leezu.web.order.service.IOrderService;
import com.leezu.web.user.entity.AuthInfo;

@Controller
@RequestMapping("/customer/user/")
public class EvalController {
	
	@Autowired
	private IEvalService evalService;
	
	@Autowired
	private IOrderService orderService;
	
	@PostMapping("addEval")
	public String addEval(Model model, HttpSession session, Eval eval) {
		AuthInfo user = (AuthInfo) session.getAttribute("authInfo");
		eval.setUserID(user.getUserID());
		
		// 평가 등록
		evalService.addEval(eval);
		// 주문 DB에 eval 값 변경
		orderService.doEval((String)eval.getOrderID());
		
		return "redirect:orderList";
	}
	
	@GetMapping("addEval")
	public String addEval(Model model, Order order) {
		
		model.addAttribute("order", order);
		return "customer.user.eval.addEval";
	}
}
