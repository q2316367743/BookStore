package com.qsd.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qsd.bookstore.dao.SafeDao;
import com.qsd.bookstore.dao.UserDao;
import com.qsd.bookstore.dto.SafeByAnswer;
import com.qsd.bookstore.dto.UserByLogin;
import com.qsd.bookstore.po.Safe;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.SafeService;
import com.qsd.bookstore.util.JwtUtil;

import cn.hutool.crypto.digest.DigestUtil;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月6日
 */
@Service
public class SafeServiceImpl implements SafeService {
	
	@Autowired
	private SafeDao safeDao;
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public int setSafe(Safe safe) {
		int result = -1;
		String username = JwtUtil.getUsername(safe.getToken());
		User user = userDao.queryUser(username);
		if (user != null) {
			Boolean isSafe = user.getIsSafe();
			//没有设置密保，进行设置
			if (!isSafe) {
				//将密保加入表
				safe.setToken(username);
				result = safeDao.addSafe(safe);
				//将用户信息中密保设为true
				userDao.updateSafe(username);
			}else {
				//设置了密保，进行更新
				result = safeDao.updateSafe(safe);
			}
			
		}
		return result;
	}

	@Override
	public int exist(String username) {
		User user = userDao.queryUser(username);
		if (user != null) {
			if (user.getIsSafe()) {
				return 2;
			}else {
				return -1;
			}
		}else {
			return 0;
		}
	}

	@Override
	public Safe getQuestion(String username) {
		// TODO Auto-generated method stub
		return safeDao.querySafeByUsername(username);
	}

	@Override
	public int setNewPwd(Safe safe, SafeByAnswer answer) {
		if (safe.getAnswer1().equals(answer.getAnswer1())) {
			if (safe.getAnswer2().equals(answer.getAnswer2())) {
				if (safe.getAnswer3().equals(answer.getAnswer3())) {
					String token = safe.getToken();
					String username = JwtUtil.getUsername(token);
					String password = answer.getPassword();
					//密码加密
					password = DigestUtil.md5Hex(password);
					UserByLogin user = new UserByLogin(username, password);
					userDao.setPassword(user);
					return 1;
				}
			}
		}
		return 0;
	}

}
