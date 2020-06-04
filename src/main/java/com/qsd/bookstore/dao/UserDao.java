package com.qsd.bookstore.dao;

import com.qsd.bookstore.dto.UserByLogin;
import com.qsd.bookstore.dto.UserByPwd;
import com.qsd.bookstore.po.User;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月1日
 */

public interface UserDao {
	
	User login(UserByLogin user);
	Integer register(User user);
	Integer update(User user);
	Integer delete(String username);
	Integer alterpwd(UserByPwd user);

}
