package com.leezu.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.leezu.web.user.entity.AuthInfo;

public class UserInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		AuthInfo user = (AuthInfo)session.getAttribute("authInfo");
		
		
		if(user == null || user.getAuthority() != 0) {
			response.sendRedirect("/");
			return false;
		}
		
		return true;
	}

}
