package com.qsd.bookstore.service;

import java.util.List;

import org.springframework.ui.Model;

import com.qsd.bookstore.po.Admin;
import com.qsd.bookstore.po.User;

/**
 * @Description 管理员业务
 * @Author Esion
 * @Data 2020年6月7日
 */

public interface AdminService {
	
	/**
	 * 登录
	 * @param admin 账户，密码
	 * @return 是否存在账户
	 * */
	boolean login(Admin admin);
	/**
	 * 获取网站全部信息
	 * @param model 存放信息
	 * */
	void getWebInfo(Model model);
	/**
	 * 获取全部的商品
	 * */
	void getAllCommodity(Model model);
	/**
	 * 获取全部的用户信息
	 * */
	List<User> getAllUserInfo();

}
