package com.qsd.bookstore.service;

import java.util.Map;

import com.qsd.bookstore.po.Commodity;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */

public interface CommodityService {

	/**
	 * 查询全部的商品信息根据销售量
	 * */
	Map<String, Object> queryAllByNum(int page, int limit);
	/**
	 * 查询全部的商品信息根据购买量
	 * */
	Map<String, Object> queryAllByView(int page, int limit);
	/**
	 * 查询商品信息根据商品ID
	 * */
	Commodity queryCommodityById(Integer id);
	
}
