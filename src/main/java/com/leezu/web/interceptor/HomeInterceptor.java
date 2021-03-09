package com.leezu.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.leezu.web.notice.service.INoticeService;
import com.leezu.web.product.service.IProductService;

public class HomeInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	private IProductService productService;
	@Autowired
	private INoticeService noticeService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		if(modelAndView != null) {
			modelAndView.addObject("noticeNum", noticeService.getNoticeNum("", ""));
			modelAndView.addObject("eventNum", 3);
			modelAndView.addObject("productNum", productService.getProductNum());
			modelAndView.addObject("productList", productService.getList("", "all", 1, 2147483647));
		}
		super.postHandle(request, response, handler, modelAndView);
	}
}