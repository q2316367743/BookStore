package com.qsd.bookstore.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.qsd.bookstore.po.Admin;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月7日
 */
@Component
public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin != null) {
			return true;
		}else {
			response.sendRedirect("/login.html");
			return false;
		}
	}

}
