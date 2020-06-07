package com.qsd.bookstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qsd.bookstore.po.Admin;
import com.qsd.bookstore.pojo.Global;
import com.qsd.bookstore.service.AdminService;

/**
 * @Description 管理员页面映射
 * @Author Esion
 * @Data 2020年6月6日
 */
@Controller
@RequestMapping("admin")
public class AdminViewController {

	@Autowired
	private AdminService adminService;

	@GetMapping("")
	public String index(HttpServletRequest request) {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin != null) {
			return "redirect:dashboard";
		}else {
			return "redirect:../login.html";
		}
	}
	
	@GetMapping("dashboard")
	public String dashboard(HttpServletRequest request, Model model) {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin != null) {
			adminService.getWebInfo(model);
			model.addAttribute("admin", admin);
			return "admin/dashboard";
		}else {
			return "redirect:../login.html";
		}
		
	}
	
	@GetMapping("commodity")
	public String commodity() {
		return "admin/commodity";
	}
	
	@GetMapping("operation")
	public String operation() {
		return "admin/operation";
	}
	
	@GetMapping("setting")
	public String setting() {
		return "admin/setting";
	}
	
}
