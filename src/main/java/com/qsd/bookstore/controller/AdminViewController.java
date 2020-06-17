package com.qsd.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qsd.bookstore.po.Admin;
import com.qsd.bookstore.po.Category;
import com.qsd.bookstore.po.User;
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
	
	@GetMapping("index")
	public String index(HttpServletRequest request, Model model) {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		adminService.getWebInfo(model);
		model.addAttribute("admin", admin);
		return "admin/index";
	}
	
	@GetMapping("dashboard")
	public String dashboard(HttpServletRequest request, Model model) {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		adminService.getWebInfo(model);
		model.addAttribute("admin", admin);
		return "admin/dashboard";
	}
	
	@GetMapping("commodity")
	public String commodity(HttpServletRequest request, Model model) {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		model.addAttribute("admin", admin);
		adminService.getAllCommodity(model);
		return "admin/commodity";
	}
	
	@GetMapping("new")
	public String operation(HttpServletRequest request, Model model) {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		model.addAttribute("admin", admin);
		List<Category> categories = adminService.getAllCategories();
		model.addAttribute("categories", categories);
		return "admin/new";
	}
	
	@GetMapping("setting")
	public String setting(HttpServletRequest request, Model model) {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		model.addAttribute("admin", admin);
		return "admin/setting";
	}
	
	@GetMapping("statistics")
	public String statistics(HttpServletRequest request, Model model) {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		model.addAttribute("admin", admin);
		return "admin/statistics";
	}
	
	@GetMapping("exit")
	public String exit(HttpServletRequest request) {
		request.getSession().removeAttribute("admin");
		return "redirect:/index.html";
	}
	
	@GetMapping("message")
	public String message(HttpServletRequest request, Model model) {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		model.addAttribute("admin", admin);
		return "admin/message";
	}
	
	@GetMapping("user")
	public String user(HttpServletRequest request, Model model) {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		model.addAttribute("admin", admin);
		List<User> users = adminService.getAllUserInfo();
		model.addAttribute("users", users);
		return "admin/user";
	}
	
	@GetMapping("about")
	public String about() {
		return "admin/about";
	}
	
}
