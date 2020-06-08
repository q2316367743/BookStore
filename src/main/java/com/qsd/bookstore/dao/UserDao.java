package com.qsd.bookstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qsd.bookstore.dto.UserByLogin;
import com.qsd.bookstore.dto.UserByPwd;
import com.qsd.bookstore.po.User;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月1日
 */

public interface UserDao {
	
	/**
	 * 登录
	 * */
	User login(UserByLogin user);
	/**
	 * 注册
	 * */
	Integer register(User user);
	/**
	 * 修改年龄，昵称，性别
	 * */
	Integer update(User user);
	/**
	 * 删除
	 * */
	Integer delete(String username);
	/**
	 * 修改密码
	 * */
	Integer alterpwd(UserByPwd user);
	/**
	 * 根据用户名查询用户信息
	 * */
	User queryUser(String username);
	/**
	 * 更新账户余额
	 * */
	Integer updateBalance(@Param("username")String username, @Param("balance")Double balance);
	/**
	 * 更新密保状态
	 * */
	Integer updateSafe(String username);
	/**
	 * 设置密码
	 * */
	Integer setPassword(UserByLogin user);
	/**
	 * 获取注册用户数量
	 * */
	Integer getUserNum();
	/**
	 * 查询全部的用户信息
	 * */
	List<User> queryAllUser();

}
