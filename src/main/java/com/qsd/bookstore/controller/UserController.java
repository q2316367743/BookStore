package com.qsd.bookstore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.qsd.bookstore.dto.UserByLogin;
import com.qsd.bookstore.dto.UserByPwd;
import com.qsd.bookstore.po.Admin;
import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.AdminService;
import com.qsd.bookstore.service.RecordService;
import com.qsd.bookstore.service.ShopService;
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
	@Autowired
	private ShopService shopService;
	@Autowired
	private RecordService recordService;
	@Autowired
	private AdminService adminService;

	@GetMapping("login")
	public UserVo login(UserByLogin user, HttpServletRequest request) {
		User login = userService.login(user);
		HttpSession session = request.getSession();
		if (login != null) {
			session.setAttribute("user", login);
			return new UserVo(200, "登录成功");
		}else {
			//管理员验证
			Admin admin = new Admin(user);
			boolean result = adminService.login(admin);
			if (result) {
				session.setAttribute("admin", admin);
				return new UserVo(101, "管理员登录成功");
			}
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
		try {
			response.sendRedirect("/index.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PostMapping("update")
	public UserVo update(User user,HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			//获取账户名
			User oldUser = (User) session.getAttribute("user");
			//修改数据库
			User newUser = userService.update(oldUser, user);
			session.setAttribute("user", newUser);
			return new UserVo(200, "成功");
		} catch (Exception e) {
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
	
	@GetMapping("alterpwd")
	public UserVo alterpwd(String oldpwd, String newpwd, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			Integer alterpwd = userService.alterpwd(new UserByPwd(user.getUsername(), oldpwd, newpwd));
			if (alterpwd > 0) {
				session.removeAttribute("user");
				return new UserVo(200, "修改成功，请登录");
			}else {
				return new UserVo(400, "旧密码错误");
			}
		}else {
			return new UserVo(400, "请先登录");
		}
	}
	
	@GetMapping("self")
	public ModelAndView self(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("self");
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			try {
				response.sendRedirect("../login.html");
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//个人信息
		modelAndView.addObject("user", user);
		//购物车信息
		List<Commodity> commodities = shopService.getAll(user);
		modelAndView.addObject("commodities", commodities);
		//购买记录
		List<Commodity> records = recordService.getAllRecord(user);
		modelAndView.addObject("records", records);
		return modelAndView;
	}
	
}
