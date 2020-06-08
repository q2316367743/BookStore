package com.qsd.bookstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.qsd.bookstore.dao.AdminDao;
import com.qsd.bookstore.dao.CategoryDao;
import com.qsd.bookstore.dao.CommodityDao;
import com.qsd.bookstore.dao.UserDao;
import com.qsd.bookstore.po.Admin;
import com.qsd.bookstore.po.Category;
import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.User;
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
	@Autowired
	private CategoryDao categoryDao;

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
		List<Commodity> commodities = commodityDao.queryAllCommodity();
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
	public Integer setSellStatus(int id, boolean status) {
		Integer exist = commodityDao.commodityExist(id);
		if (exist != null) {
			Integer integer = commodityDao.updateStatus(id, status);
			return integer;
		}
		return -1;
	}

	@Override
	public List<User> getAllUserInfo() {
		// TODO Auto-generated method stub
		return userDao.queryAllUser();
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryDao.queryAllCategory();
	}

}
