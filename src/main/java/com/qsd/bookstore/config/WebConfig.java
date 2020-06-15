package com.qsd.bookstore.config;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.qsd.bookstore.interceptor.AdminInterceptor;
import com.qsd.bookstore.interceptor.UserInterceptor;
import com.qsd.bookstore.interceptor.ViewInterceptor;


/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月1日
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private ViewInterceptor viewInterceptor;
	@Autowired
	private AdminInterceptor adminInterceptor;
	@Autowired
	private UserInterceptor userInterceptor;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("admin", "admin/dashboard");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//网站访问量拦截器
		registry.addInterceptor(viewInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/layui/**", "/read/**");
		//管理员登录
		registry.addInterceptor(adminInterceptor)
				.addPathPatterns("/admin/**");
		//token拦截
		List<String> need = new ArrayList<>();
		need.add("/shop/**");
		need.add("/user/**");
		need.add("/resource/**");
		List<String> dis = new ArrayList<>();
		dis.add("/user/login");
		dis.add("/user/register");
		registry.addInterceptor(userInterceptor)
				.addPathPatterns(need)
				.excludePathPatterns(dis);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("*");
	}
	
	
	
}
