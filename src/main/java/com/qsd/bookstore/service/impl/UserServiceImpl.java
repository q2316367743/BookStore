package com.qsd.bookstore.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qsd.bookstore.dao.RecordDao;
import com.qsd.bookstore.dao.SafeDao;
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
	@Autowired
	private SafeDao safeDao;

	@Override
	public User login(UserByLogin user) {
		return userDao.login(user);
	}

	@SuppressWarnings("deprecation")
	@Transactional
	@Override
	public Integer register(User user) {
		String shopName = "s" + markName();
		String recordName = "r" + markName();
		shopDao.createShopTable(shopName);
		recordDao.createRecordTable(recordName);
		user.setShopName(shopName);
		user.setRecordName(recordName);
		return userDao.register(user);
	}

	@Override
	@Transactional
	public User update(User oldUser, User newUser) {
		//1. 获取用户名
		String username = oldUser.getUsername();
		//2. 修改数据库
		newUser.setUsername(username);
		userDao.update(newUser);
		//3. 查询新信息
		return userDao.queryUser(username);
	}

	@Override
	@Transactional
	public Integer logout(User user) {
		String username = user.getUsername();
		String shopName = user.getShopName();
		String recordName = user.getRecordName();
		Boolean isSafe = user.getIsSafe();
		//删除购物车表
		shopDao.deleteShopTable(shopName);
		//删除记录表
		recordDao.deleteRecordTable(recordName);
		//删除用户表
		userDao.delete(username);
		if (isSafe) {
			//删除密保记录
			safeDao.deleteSafeByUsername(username);
		}
		return 1;
	}

	@Override
	public Integer alterpwd(UserByPwd user) {
		// TODO Auto-generated method stub
		return userDao.alterpwd(user);
	}
	
	public static String markName(){
		LocalDateTime now = LocalDateTime.now();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int minute = now.getMinute();
		int second = now.getSecond();
		int hour = now.getHour();
		String m = "";
		String d = "";
		String mi = "";
		String s = "";
		String h = "";
		if (month<10) {
			m = "0" + month;
		}else {
			m = month + "";
		}
		if (day < 10) {
			d = "0" + day;
		}else {
			d = day + "";
		}
		if (minute < 10) {
			mi = "0" + minute;
		}else {
			mi = "" + minute;
		}
		if (second < 10) {
			s = "0" + second;
		}else {
			s = "" + second;
		}
		if (hour < 10) {
			h = "0" + hour;
		}else {
			h = "" + hour;
		}
		Integer random = (int) (Math.random() * 90 + 10);
		return now.getYear()+m+d+h+mi+s+random.toString();
	}

}
