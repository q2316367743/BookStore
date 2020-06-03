package com.qsd.bookstore.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsd.bookstore.dao.CommodityDao;
import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.service.SearchService;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */
@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private CommodityDao commodityDao;

	@Override
	public Map<String, Object> baseSearch(String commodityName, int page, int limit) {
		Map<String, Object> map = new HashMap<>();
		List<Commodity> commodities = commodityDao.queryCommodityByName(commodityName);
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
	public Map<String, Object> searchByCategory(String category, int page, int limit) {
		Map<String, Object> map = new HashMap<>();
		List<Commodity> commodities = commodityDao.queryCommodityByCategory(category);
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

}
