package com.qsd.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsd.bookstore.dao.CommodityDao;
import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.service.SearchService;
import com.qsd.bookstore.util.JdbcUtil;
import com.qsd.bookstore.vo.PageVo;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */
@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private CommodityDao commodityDao;

	@SuppressWarnings("unchecked")
	@Override
	public PageVo<Commodity> baseSearch(String commodityName, int page, int limit) {
		List<Commodity> commodities = commodityDao.queryCommodityByName(commodityName);
		return JdbcUtil.PageUtil(page, limit, commodities);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageVo<Commodity> searchByCategory(String category, int page, int limit) {
		List<Commodity> commodities = commodityDao.queryCommodityByCategory(category);
		return JdbcUtil.PageUtil(page, limit, commodities);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageVo<Commodity> priceSearch(String commodityName, int max, int min, int page, int limit) {
		List<Commodity> commodities = commodityDao.queryCommoditiesByNameAndPrice(commodityName, max, min);
		return JdbcUtil.PageUtil(page, limit, commodities);
	}

}
