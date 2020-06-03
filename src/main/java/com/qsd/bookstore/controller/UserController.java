package com.qsd.bookstore.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsd.bookstore.dto.UserByLogin;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.UserService;
import com.qsd.bookstore.vo.UserInfoVo;
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
	public UserVo register(User user, HttpServletRequest request) {
		Integer register = userService.register(user);
		if (register > 0) {
			User login = userService.login(new UserByLogin(user));
			HttpSession session = request.getSession();
			session.setAttribute("user", login);
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
	
	@GetMapping("getInfo")
	public UserInfoVo getInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			return new UserInfoVo(200, "登录成功", user);
		}else {
			return new UserInfoVo(400, "帐户或密码错误", null);
		}
	}
	
	@PostMapping("update")
	public UserVo update(User user,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//获取账户名
		User oldUser = (User) session.getAttribute("user");
		user.setUsername(oldUser.getUsername());
		//修改数据库
		Integer update = userService.update(user);
		if (update > 0) {
			//修改成功
			//设置
			user.setPassword(oldUser.getPassword());
			user.setShopName(oldUser.getShopName());
			user.setRecordName(oldUser.getRecordName());
			//重新加入session
			session.setAttribute("user", user);
			return new UserVo(200, "成功");
		}else {
			//修改失败
			return new UserVo(400, "失败");
		}
	}
	
	@GetMapping("logout")
	public UserVo logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer logout = userService.logout(user);
		System.out.println(logout);
		if (logout > 0) {
			session.removeAttribute("user");
			return new UserVo(200, "注销成功");
		}else {
			return new UserVo(400, "注销失败");
		}
	}
	
}
