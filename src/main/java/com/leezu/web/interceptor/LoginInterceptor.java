package com.leezu.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.leezu.web.user.DTO.AuthInfo;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	protected Log log = LogFactory.getLog(LoginInterceptor.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		AuthInfo user = (AuthInfo)session.getAttribute("authInfo");
		
		
		if(user == null || user.getAuthority() != '1') {
			response.sendRedirect("/");
			return false;
		}
		
		return true;
	}

}
