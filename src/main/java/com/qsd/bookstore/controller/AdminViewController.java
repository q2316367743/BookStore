package com.qsd.bookstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qsd.bookstore.po.Admin;

/**
 * @Description 管理员页面映射
 * @Author Esion
 * @Data 2020年6月6日
 */
@Controller
@RequestMapping("admin")
public class AdminViewController {

	@GetMapping("")
	public String index(HttpServletRequest request) {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin != null) {
			return "redirect:dashboard";
		}else {
			return "redirect:admin/login.html";
		}
	}
	
	@GetMapping("dashboard")
	public String dashboard() {
		return "admin/dashboard";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
}
