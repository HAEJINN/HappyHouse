package com.ssafy.happyhouse.interceptor;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssafy.happyhouse.error.UnauthorizedException;
import com.ssafy.happyhouse.service.JwtService;

public class ConfirmInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	JwtService jwtservice;
	
	private static final String HEADER_AUTH = "auth-token";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final String token = request.getHeader(HEADER_AUTH);
		
		if (token != null && jwtservice.isUsable(token)) {
			return true;
		}
		throw new UnauthorizedException();
	}

}
