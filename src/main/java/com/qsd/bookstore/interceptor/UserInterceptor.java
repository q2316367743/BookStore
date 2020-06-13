package com.qsd.bookstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.qsd.bookstore.util.JwtUtil;
import com.qsd.bookstore.vo.ShopVo;

/**
 * @Description 用户状态拦截，拦截特定url
 * @Author Esion
 * @Data 2020年6月12日
 */
@Component
public class UserInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getParameter("token");
		ShopVo result = null;
		if (token != null) {
			boolean verify = JwtUtil.verify(token);
			if (verify) {
				return true;
			}
			new ShopVo(400, "token信息错误");
		}
		result = new ShopVo(404, "没有token");
		response.getWriter().print(result.toJSONString());
		return false;
	}
	
}
