package com.qsd.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/index.html");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//网站访问量拦截器
		registry.addInterceptor(viewInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/layui/**", "/read/**");
	}
	
}
