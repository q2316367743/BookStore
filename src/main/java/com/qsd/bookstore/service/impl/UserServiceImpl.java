package com.qsd.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qsd.bookstore.dao.RecordDao;
import com.qsd.bookstore.dao.ShopDao;
import com.qsd.bookstore.dao.UserDao;
import com.qsd.bookstore.dto.UserByLogin;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.UserService;
import com.qsd.bookstore.util.SimpleUtil;

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
		String shopName = SimpleUtil.generateUUID();
		String recordName = SimpleUtil.generateUUID();
		shopDao.createShopTable(shopName);
		recordDao.createRecordTable(recordName);
		user.setShopName(shopName);
		user.setRecordName(recordName);
		return userDao.register(user);
	}

	@Override
	public Integer update(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
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

}
