package com.qsd.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.qsd.bookstore.dao.AdminDao;
import com.qsd.bookstore.dao.CommodityDao;
import com.qsd.bookstore.dao.UserDao;
import com.qsd.bookstore.po.Admin;
import com.qsd.bookstore.pojo.Global;
import com.qsd.bookstore.service.AdminService;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月7日
 */
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private Global global;
	@Autowired
	private UserDao userDao;
	@Autowired
	private CommodityDao commodityDao;

	@Override
	public boolean login(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.login(admin) != null;
	}

	@Override
	public void getWebInfo(Model model) {
		//网站访问量,当前在线人数, 书籍卖出量, 营业额
		model.addAttribute("global", global);
	}

}
