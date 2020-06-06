package com.qsd.bookstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsd.bookstore.dto.SafeByAnswer;
import com.qsd.bookstore.po.Safe;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.SafeService;
import com.qsd.bookstore.vo.SafeVo;
import com.qsd.bookstore.vo.ShopVo;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月6日
 */
@RestController
@RequestMapping("safe")
public class SafeController {
	
	@Autowired
	private SafeService safeService;
	
	/**
	 * 判断是否存在用户
	 * */
	@GetMapping("userExist")
	public ShopVo userExist(String username, HttpServletRequest request) {
		int exist = safeService.exist(username);
		if (exist == 0) {
			return new ShopVo(404, "用户不存在");
		}else if (exist == 2) {
			return new ShopVo(200, "用户存在且设置密保");
		}else {
			return new ShopVo(400, "用户未设置密保，请仔细回想密码");
		}
	}
	
	/**
	 * 设置密保
	 * */
	@PostMapping("setSafe")
	public ShopVo setSafe(Safe safe, HttpServletRequest request) {
		//1. 获取用户信息
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		//2. 设置密保
		int result = safeService.setSafe(user, safe);
		if (result == 1) {
			user.setIsSafe(true);
			session.setAttribute("user", user);
			return new ShopVo(200, "设置修改成功");
		}else if(result == -1) {
			return new ShopVo(404, "用户未登录");
		}else {
			return new ShopVo(400, "设置失败，请重试");
		}
	}
	
	/**
	 * 获取密保的问题
	 * */
	@GetMapping("getQuestion")
	public SafeVo getQuestion(String username, HttpServletRequest request) {
		Safe safe = safeService.getQuestion(username);
		if (safe != null) {
			request.getSession().setAttribute("safe", safe);
			return new SafeVo(200, username+"成功", safe);
		}
		return new SafeVo(404, username+"没有设置密保");
	}
	
	/**
	 * 从新设置密码
	 * @return
	 * 200:成功
	 * 400：密保答案错误
	 * 404：未设置密保
	 * */
	@GetMapping("setNewPwd")
	public ShopVo setNewPwd(SafeByAnswer answer, HttpServletRequest request) {
		Safe safe = (Safe) request.getSession().getAttribute("safe");
		if (safe == null) {
			return new ShopVo(404, "未设置密保");
		}
		int setNewPwd = safeService.setNewPwd(safe, answer);
		if (setNewPwd ==  1) {
			return new ShopVo(200, "成功");
		}else {
			return new ShopVo(400, "密保答案错误");
		}
		
	}
	
}
