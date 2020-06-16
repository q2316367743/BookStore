package com.qsd.bookstore.service;

import com.qsd.bookstore.dto.SafeByAnswer;
import com.qsd.bookstore.po.Safe;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月6日
 */

public interface SafeService {

	/**
	 * 设置密保信息
	 * @param safe 密保信息
	 * */
	int setSafe(Safe safe);
	/**
	 * 判断用户是否存在
	 * @param username 用户名
	 * @return 用户不存在0，设置过密保2，未设置-1
	 * */
	int exist(String username);
	/**
	 * 获取全部的密保问题
	 * @param username 用户名
	 * */
	Safe getQuestion(String username);
	/**
	 * 设置新的密码根据密保问题
	 * @param safe 密保信息
	 * @param answer 密保问题和新密码
	 * */
	int setNewPwd(Safe safe, SafeByAnswer answer);
	
}
