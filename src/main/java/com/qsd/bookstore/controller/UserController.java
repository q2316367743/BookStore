package com.qsd.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsd.bookstore.dto.UserByLogin;
import com.qsd.bookstore.dto.UserByPwd;
import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.Global;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.RecordService;
import com.qsd.bookstore.service.ShopService;
import com.qsd.bookstore.service.UserService;
import com.qsd.bookstore.util.JwtUtil;
import com.qsd.bookstore.util.VerifyCodeUtil;
import com.qsd.bookstore.vo.DataVo;
import com.qsd.bookstore.vo.PageVo;
import com.qsd.bookstore.vo.ResultVo;
import com.qsd.bookstore.vo.TokenVo;

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
	private RecordService recordService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private Global global;

	@GetMapping("login")
	public TokenVo<User> login(UserByLogin user, HttpServletRequest request) {
		User login = userService.login(user);
		String token = JwtUtil.sign(user.getUsername());
		if (login != null) {
			global.addOnline();
			return new TokenVo<>(200, "登录成功", token, login);
		}else {
			return new TokenVo<>(400, "帐户或密码错误");
		}
	}
	
	@PostMapping("register")
	public TokenVo<User> register(User user, HttpServletRequest request) {
		String code = user.getCode();
		String token = user.getToken();
		if (code != null && token != null) {
			boolean verify = VerifyCodeUtil.verify(token, code);
			if (verify) {
				Integer register = userService.register(user);
				if (register > 0) {
					String tmp = JwtUtil.sign(user.getUsername());
					global.updateUserNum();
					return new TokenVo<>(200, "注册成功", tmp, user);
				}else {
					return new TokenVo<>(400, "账户重复");
				}
			}else {
				return new TokenVo<>(400, "验证码错误");
			}
		}else {
			return new TokenVo<>(400, "缺少验证码");
		}
	}
	
	/**
	 * 根据token获取用户信息
	 * */
	@GetMapping("info")
	public TokenVo<User> info(String token, HttpServletRequest request) {
		if (token != null) {
			User user = userService.info(token);
			if (user != null) {
				return new TokenVo<>(200, "success", user);
			}else {
				return new TokenVo<>(400, "token信息错误");
			}
		}
		return new TokenVo<>(404, "缺少token");
	}
	
	@PostMapping("update")
	public TokenVo<Boolean> update(String token, User user,HttpServletRequest request) {
		try {
			//获取账户名
			User oldUser = userService.info(token);
			//修改数据库
			userService.update(oldUser, user);
			return new TokenVo<>(200, "成功");
		} catch (Exception e) {
			return new TokenVo<>(400, "失败");
		}
		
	}
	
	@GetMapping("logout")
	public TokenVo<Boolean> logout(String token, HttpServletRequest request) {
		Integer logout = userService.logout(token);
		if (logout > 0) {
			return new TokenVo<>(200, "注销成功");
		}else {
			return new TokenVo<>(400, "注销失败");
		}
	}
	
	@GetMapping("alterpwd")
	public TokenVo<Boolean> alterpwd(String token, String oldpwd, String newpwd, HttpServletRequest request) {
		Integer alterpwd = userService.alterpwd(new UserByPwd(token, oldpwd, newpwd));
		if (alterpwd > 0) {
			return new TokenVo<>(200, "修改成功，请登录");
		}else {
			return new TokenVo<>(400, "旧密码错误");
		}
	}
	
	// 查询购物车全部记录
	@GetMapping("shop")
	public DataVo<List<Commodity>> shop(String token, int page, int limit) {
		//获取用户信息
		String username = JwtUtil.getUsername(token);
		//购物车信息
		PageVo<Commodity> allByUsername = shopService.getAllByUsername(username, page, limit);
		return new DataVo<List<Commodity>>(200, "success", allByUsername.getCount(), allByUsername.getData());
	}
	
	@GetMapping("record")
	public DataVo<List<Commodity>> record(String token, int page, int limit) {
		//获取用户信息
		String username = JwtUtil.getUsername(token);
		//购物车信息
		PageVo<Commodity> data = recordService.getAllByUsername(username, page, limit);
		return new DataVo<List<Commodity>>(200, "success", data.getCount(), data.getData());
	}
	
	/**
	 * 获取用户余额
	 * */
	@GetMapping("balance")
	public ResultVo<Double> balance(String token){
		Double balance = userService.balance(token);
		return new ResultVo<Double>(200, "success", balance);
	}
	
}
