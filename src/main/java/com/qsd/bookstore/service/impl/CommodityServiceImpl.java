package com.qsd.bookstore.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsd.bookstore.dao.CommodityDao;
import com.qsd.bookstore.dao.ShopDao;
import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.service.CommodityService;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */
@Service
public class CommodityServiceImpl implements CommodityService {
	
	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	private ShopDao shopDao;

	@Override
	public Map<String, Object> queryAllByNum(int page, int limit) {
		Map<String, Object> map = new HashMap<>();
		List<Commodity> commodities = commodityDao.queryAllByNum();
		int count = commodities.size();
		int fromIndex = (page - 1) * limit;
		int toIndex = fromIndex;
		if (count - fromIndex > limit) {
			toIndex = fromIndex + limit;
		}else {
			toIndex = count;
		}
		List<Commodity> subList = commodities.subList(fromIndex, toIndex);
		map.put("count", count);
		map.put("commoditys", subList);
		return map;
	}

	@Override
	public Commodity queryCommodityById(Integer id) {
		// TODO Auto-generated method stub
		return commodityDao.queryCommodityById(id);
	}

}
