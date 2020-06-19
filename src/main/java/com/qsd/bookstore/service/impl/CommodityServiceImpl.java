package com.qsd.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.qsd.bookstore.dao.CommodityDao;
import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.Global;
import com.qsd.bookstore.service.CommodityService;
import com.qsd.bookstore.util.Cache;
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
	
	/**
	 * 根据销售量查询商品
	 * */
	@Cacheable(value = Cache.NAME, key = Cache.COMMODITY_NUM)
	private List<Commodity> queryAllByNum(){
		return commodityDao.queryAllByNum();
	}

	/**
	 * 根据销售量查询商品，分页
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public PageVo<Commodity> queryAllByNum(int page, int limit) {
		List<Commodity> commodities = queryAllByNum();
		return JdbcUtil.PageUtil(page, limit, commodities);
	}
	
	/**
	 * 根据浏览量查询商品
	 * */
	@Cacheable(value = Cache.NAME, key = Cache.COMMODITY_VIEW)
	private List<Commodity> queryAllByView(){
		return commodityDao.queryAllByView();
	}
	
	/**
	 * 根据浏览量查询商品，分页
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public PageVo<Commodity> queryAllByView(int page, int limit) {
		List<Commodity> commodities = queryAllByView();
		return JdbcUtil.PageUtil(page, limit, commodities);
	}

	/**
	 * 查询商品信息根据ID
	 * */
	@Override
	@Cacheable(value = Cache.NAME, key = Cache.COMMODITY_INFO)
	public Commodity queryCommodityById(Integer id) {
		//1. 查询商品信息
		Commodity commodity = commodityDao.queryCommodityById(id);
		//2. 浏览量加一
		commodityDao.addView(id);
		// 店铺浏览量加一
		global.addView();
		return commodity;
	}

	/**
	 * 根据商品信息新增商品
	 * */
	@Override
	@Caching(evict = {
			@CacheEvict(value = Cache.NAME, key = Cache.COMMODITY_LIST),
			@CacheEvict(value = Cache.NAME, key = Cache.COMMODITY_NUM),
			@CacheEvict(value = Cache.NAME, key = Cache.COMMODITY_VIEW)
	})
	public int newCommodity(Commodity commodity) {
		return commodityDao.newCommodity(commodity);
	}
	
	/**
	 * 修改商品上下架状态
	 * */
	@Override
	@Caching(evict = {
			@CacheEvict(value = Cache.NAME, key = Cache.COMMODITY_LIST),
			@CacheEvict(value = Cache.NAME, key = Cache.COMMODITY_NUM),
			@CacheEvict(value = Cache.NAME, key = Cache.COMMODITY_VIEW),
			@CacheEvict(value = Cache.NAME, key = Cache.COMMODITY_INFO)
	})
	public Integer setSellStatus(int id, boolean status) {
		Integer exist = commodityDao.commodityExist(id);
		if (exist != null) {
			Integer integer = commodityDao.updateStatus(id, status);
			return integer;
		}
		return -1;
	}

}
