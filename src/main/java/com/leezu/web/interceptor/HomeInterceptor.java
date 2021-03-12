package com.leezu.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.leezu.web.basket.service.IBasketService;
import com.leezu.web.notice.service.INoticeService;
import com.leezu.web.order.service.IOrderService;
import com.leezu.web.product.service.IProductService;
import com.leezu.web.user.service.IUserService;

public class HomeInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	private IProductService productService;
	@Autowired
	private INoticeService noticeService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IBasketService basketService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if(modelAndView != null) {
			modelAndView.addObject("noticeNum", noticeService.getNoticeNum("", ""));
			modelAndView.addObject("eventNum", 3);
			modelAndView.addObject("productNum", productService.getProductNum());
			
			//관리자용
			if(request.isUserInRole("ROLE_ADMIN")) {
				modelAndView.addObject("userNum", userService.getUserNum(null, null));
				modelAndView.addObject("allOrderNum", orderService.getOrderAllList().size());
			}
			
			//유저용
			else if(request.isUserInRole("ROLE_USER")) {
				modelAndView.addObject("orderNum", orderService.getOrderNum(request.getRemoteUser()));
				modelAndView.addObject("basketNum", basketService.getBasketNum(request.getRemoteUser()));
			}
		}
		super.postHandle(request, response, handler, modelAndView);
	}
}