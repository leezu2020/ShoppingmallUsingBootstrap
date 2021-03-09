package com.leezu.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

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
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		if(modelAndView != null) {
			modelAndView.addObject("noticeNum", noticeService.getNoticeNum("", ""));
			modelAndView.addObject("eventNum", 3);
			modelAndView.addObject("productNum", productService.getProductNum());
			
			//관리자용
			modelAndView.addObject("userNum", userService.getUserNum(null, null));
			modelAndView.addObject("allOrderNum", orderService.getOrderAllList().size());
		}
		super.postHandle(request, response, handler, modelAndView);
	}
}