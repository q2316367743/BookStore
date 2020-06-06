package com.qsd.bookstore.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsd.bookstore.dao.CommodityDao;
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

	@Override
	public Map<String, Object> queryAllByNum(int page, int limit) {
		Map<String, Object> map = new HashMap<>();
		List<Commodity> commodities = commodityDao.queryAllByNum();
		int size = commodities.size();
		int count = size / limit + 1;
		int fromIndex = (page - 1) * limit;
		int toIndex = fromIndex;
		if (size - fromIndex > limit) {
			toIndex = fromIndex + limit;
		}else {
			toIndex = size;
		}
		List<Commodity> subList = commodities.subList(fromIndex, toIndex);
		map.put("count", count);
		map.put("commoditys", subList);
		return map;
	}
	
	@Override
	public Map<String, Object> queryAllByView(int page, int limit) {
		Map<String, Object> map = new HashMap<>();
		List<Commodity> commodities = commodityDao.queryAllByView();
		int size = commodities.size();
		int count = size / limit + 1;
		int fromIndex = (page - 1) * limit;
		int toIndex = fromIndex;
		if (size - fromIndex > limit) {
			toIndex = fromIndex + limit;
		}else {
			toIndex = size;
		}
		List<Commodity> subList = commodities.subList(fromIndex, toIndex);
		map.put("count", count);
		map.put("commoditys", subList);
		return map;
	}

	@Override
	public Commodity queryCommodityById(Integer id) {
		//1. 查询商品信息
		Commodity commodity = commodityDao.queryCommodityById(id);
		//2. 浏览量加一
		commodityDao.addView(id);
		return commodity;
	}

}
