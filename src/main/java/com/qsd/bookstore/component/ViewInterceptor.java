package com.qsd.bookstore.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

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
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object attribute = session.getAttribute("view");
		if (attribute == null) {
			//第一次登录
			global.addView();
			session.setAttribute("view", new Object());
		}
		return true;
	}

}
