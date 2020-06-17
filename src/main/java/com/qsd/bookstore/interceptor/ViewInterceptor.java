package com.qsd.bookstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.qsd.bookstore.po.Global;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月6日
 */
@Component
public class ViewInterceptor implements HandlerInterceptor {
	
	@Autowired
	private Global global;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//第一次登录
		global.addView();
	}
	
	

}
