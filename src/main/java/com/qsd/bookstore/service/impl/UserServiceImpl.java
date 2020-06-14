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
import com.qsd.bookstore.util.JwtUtil;

import cn.hutool.crypto.digest.DigestUtil;

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
		//密码加密
		String password = user.getPassword();
		password = DigestUtil.md5Hex(password);
		user.setPassword(password);
		return userDao.login(user);
	}

	@Transactional
	@Override
	public Integer register(User user) {
		//创建购物车和记录表
		String shopName = "s" + markName();
		String recordName = "r" + markName();
		shopDao.createShopTable(shopName);
		recordDao.createRecordTable(recordName);
		user.setShopName(shopName);
		user.setRecordName(recordName);
		//密码加密
		String password = user.getPassword();
		password = DigestUtil.md5Hex(password);
		user.setPassword(password);
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
	public Integer logout(String token) {
		String username = JwtUtil.getUsername(token);
		User user = userDao.queryUser(username);
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
		String token = user.getUsername();
		String username = JwtUtil.getUsername(token);
		String oldpwd = user.getOldpwd();
		String newpwd = user.getNewpwd();
		oldpwd = DigestUtil.md5Hex(oldpwd);
		newpwd = DigestUtil.md5Hex(newpwd);
		user.setUsername(username);
		user.setOldpwd(oldpwd);
		user.setNewpwd(newpwd);
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

	@Override
	public User info(String token) {
		boolean verify = JwtUtil.verify(token);
		if (verify) {
			String username = JwtUtil.getUsername(token);
			return userDao.queryUser(username);
		}
		return null;
	}

	@Override
	public Double balance(String token) {
		String username = JwtUtil.getUsername(token);
		User user = userDao.queryUser(username);
		return user.getBalance();
	}

}
