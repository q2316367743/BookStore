package com.qsd.bookstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.qsd.bookstore.dao.AdminDao;
import com.qsd.bookstore.dao.CommodityDao;
import com.qsd.bookstore.dao.UserDao;
import com.qsd.bookstore.po.Admin;
import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.Global;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.AdminService;
import com.qsd.bookstore.util.Cache;

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

	/**
	 * 查询全部商品信息
	 * */
	@Cacheable(value = Cache.NAME, key = Cache.COMMODITY_LIST)
	private List<Commodity> getAllCommodity(){
		return commodityDao.queryAllCommodity();
	}
	
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

	@Override
	public void getAllCommodity(Model model) {
		List<Commodity> commodities = getAllCommodity();
		List<Commodity> trueCommodities = new ArrayList<>();
		List<Commodity> falseCommodities = new ArrayList<>();
		for (Commodity commodity : commodities) {
			if (commodity.getStatus()) {
				trueCommodities.add(commodity);
			}else {
				falseCommodities.add(commodity);
			}
		}
		model.addAttribute("trueCommodities", trueCommodities);
		model.addAttribute("falseCommodities", falseCommodities);
	}

	@Override
	public List<User> getAllUserInfo() {
		// TODO Auto-generated method stub
		return userDao.queryAllUser();
	}

}
