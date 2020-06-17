package com.qsd.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsd.bookstore.dao.CommodityDao;
import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.Global;
import com.qsd.bookstore.service.CommodityService;
import com.qsd.bookstore.util.JdbcUtil;
import com.qsd.bookstore.vo.PageVo;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */
@Service
public class CommodityServiceImpl implements CommodityService {
	
	@Autowired
	private Global global;
	@Autowired
	private CommodityDao commodityDao;

	@SuppressWarnings("unchecked")
	@Override
	public PageVo<Commodity> queryAllByNum(int page, int limit) {
		List<Commodity> commodities = commodityDao.queryAllByNum();
		return JdbcUtil.PageUtil(page, limit, commodities);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public PageVo<Commodity> queryAllByView(int page, int limit) {
		List<Commodity> commodities = commodityDao.queryAllByView();
		return JdbcUtil.PageUtil(page, limit, commodities);
	}

	@Override
	public Commodity queryCommodityById(Integer id) {
		//1. 查询商品信息
		Commodity commodity = commodityDao.queryCommodityById(id);
		//2. 浏览量加一
		commodityDao.addView(id);
		// 店铺浏览量加一
		global.addView();
		return commodity;
	}

	@Override
	public int newCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		return commodityDao.newCommodity(commodity);
	}

}
