package com.leezu.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.leezu.web.basket.service.IBasketService;
import com.leezu.web.order.service.IOrderService;
import com.leezu.web.security.SecurityUser;

public class UserInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IBasketService basketService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		SecurityUser user = (SecurityUser) principal;
		
		if(modelAndView != null) {
			modelAndView.addObject("orderNum", orderService.getOrderNum(user.getUsername()));
			modelAndView.addObject("basketNum", basketService.getBasketNum(user.getUsername()));
		}
		super.postHandle(request, response, handler, modelAndView);
	}
}
