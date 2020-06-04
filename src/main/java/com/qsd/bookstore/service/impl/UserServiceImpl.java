package com.qsd.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qsd.bookstore.dao.RecordDao;
import com.qsd.bookstore.dao.ShopDao;
import com.qsd.bookstore.dao.UserDao;
import com.qsd.bookstore.dto.UserByLogin;
import com.qsd.bookstore.dto.UserByPwd;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.UserService;

import cn.hutool.crypto.SecureUtil;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月1日
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private RecordDao recordDao;
	@Autowired
	private ShopDao shopDao;

	@Override
	public User login(UserByLogin user) {
		return userDao.login(user);
	}

	@Transactional
	@Override
	public Integer register(User user) {
		String shopName = SecureUtil.simpleUUID();
		String recordName = SecureUtil.simpleUUID();
		shopDao.createShopTable(shopName);
		recordDao.createRecordTable(recordName);
		user.setShopName(shopName);
		user.setRecordName(recordName);
		return userDao.register(user);
	}

	@Override
	@Transactional
	public User update(User oldUserm, User newUser) {
		//1. 获取用户名
		String username = oldUserm.getUsername();
		//2. 修改数据库
		newUser.setUsername(username);
		userDao.update(newUser);
		//3. 查询新信息
		return userDao.queryUser(username);
	}

	@Override
	@Transactional
	public Integer logout(User user) {
		String shopName = user.getShopName();
		String recordName = user.getRecordName();
		//删除购物车表
		int shop = shopDao.deleteShopTable(shopName);
		//删除记录表
		int record = recordDao.deleteRecordTable(recordName);
		//删除用户表
		int delete = userDao.delete(user.getUsername());
		return shop + record + delete;
	}

	@Override
	public Integer alterpwd(UserByPwd user) {
		// TODO Auto-generated method stub
		return userDao.alterpwd(user);
	}

}
