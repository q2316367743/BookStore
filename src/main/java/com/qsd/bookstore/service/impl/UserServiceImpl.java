package com.qsd.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsd.bookstore.dao.UserDao;
import com.qsd.bookstore.dto.UserByLogin;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.UserService;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月1日
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User login(UserByLogin user) {
		return userDao.login(user);
	}

	@Override
	public Integer register(User user) {
		return userDao.register(user);
	}

}
