package com.qsd.bookstore.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qsd.bookstore.dto.UserByLogin;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.UserService;
import com.qsd.bookstore.vo.UserVo;

/**
 * @Description 处理关于用户相关
 * @Author Esion
 * @Data 2020年6月1日
 */
@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("login")
	public UserVo login(UserByLogin user, HttpServletRequest request) {
		User login = userService.login(user);
		HttpSession session = request.getSession();
		if (login != null) {
			session.setAttribute("user", login);
			return new UserVo(200, "登录成功");
		}else {
			return new UserVo(400, "帐户或密码错误");
		}
	}
	
	@PostMapping("register")
	public UserVo register(User user) {
		Integer register = userService.register(user);
		if (register > 1) {
			return new UserVo(200, "注册成功");
		}else {
			return new UserVo(400, "账户重复");
		}
	}
	
	@GetMapping("isLogin")
	public UserVo isLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			return new UserVo(200, "登录成功", user);
		}else {
			return new UserVo(400, "帐户或密码错误");
		}
	}
	
	@GetMapping("exit")
	public void exit(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		Object result = session.getAttribute("user");
		try {
			response.sendRedirect("/index.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
