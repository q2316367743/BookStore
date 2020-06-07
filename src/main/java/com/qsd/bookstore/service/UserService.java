package com.qsd.bookstore.service;

import com.qsd.bookstore.dto.UserByLogin;
import com.qsd.bookstore.dto.UserByPwd;
import com.qsd.bookstore.po.User;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月1日
 */

public interface UserService {
	
	/**
	 * 登陆
	 * @param user 用户名密码
	 * @return 用户信息
	 * */
	User login(UserByLogin user);
	/**
	 * 注册
	 * @param user 用户信息
	 * */
	Integer register(User user);
	/**
	 * 修改用户信息：性别，年龄，昵称
	 * @param oldUser 旧的用户信息
	 * @param newUser 新的用户信息
	 * @return 更新后的用户信息
	 * */
	User update(User oldUser, User newUser);
	/**
	 * 注销用户
	 * @param user 用户信息
	 * */
	Integer logout(User user);
	/**
	 * 修改密码
	 * @param user 用户名，旧密码，新密码
	 * */
	Integer alterpwd(UserByPwd user);

}
