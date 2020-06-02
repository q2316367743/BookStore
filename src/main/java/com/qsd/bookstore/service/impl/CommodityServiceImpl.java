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
	public List<Commodity> queryAllByNum(int page, int limit) {
		Map<String, Object> condition = new HashMap<>();
		condition.put("currIndex", ((page - 1) * limit));
		condition.put("pageSize", limit);
		List<Commodity> commoditys = commodityDao.queryAllByNum(condition);
		return commoditys;
	}

}
