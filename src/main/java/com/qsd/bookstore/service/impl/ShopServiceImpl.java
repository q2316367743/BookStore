package com.qsd.bookstore.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsd.bookstore.dao.ShopDao;
import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.Shop;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.ShopService;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月4日
 */
@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDao shopDao;

	@Override
	public int addShop(String shopName, int commodity_id) {
		// TODO Auto-generated method stub
		return shopDao.addShop(shopName, commodity_id);
	}

	@Override
	public List<Commodity> getAll(User user) {
		String shopName = user.getShopName();
		List<Commodity> commodities = shopDao.queryAll(shopName);
		return commodities;
	}

	@Override
	public boolean removeCommodity(User user, int commodityId) {
		String shopName = user.getShopName();
		int result = shopDao.removeCommodityById(shopName, commodityId);
		return result > 0;
	}
	
}
