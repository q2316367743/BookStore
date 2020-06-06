package com.qsd.bookstore.service;

import com.qsd.bookstore.dto.SafeByAnswer;
import com.qsd.bookstore.po.Safe;
import com.qsd.bookstore.po.User;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月6日
 */

public interface SafeService {

	int setSafe(User user, Safe safe);
	/**
	 * 判断用户是否存在
	 * @param username 用户名
	 * @return 用户不存在0，设置过密保2，未设置-1
	 * */
	int exist(String username);
	Safe getQuestion(String username);
	int setNewPwd(Safe safe, SafeByAnswer answer);
	
}
