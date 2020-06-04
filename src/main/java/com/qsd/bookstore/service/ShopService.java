package com.qsd.bookstore.service;

import java.util.List;
import java.util.Map;

import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.User;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月4日
 */

public interface ShopService {

	/**
	 * @param shopName 购物车表的表明
	 * @param commodity_id 商品的id
	 * @return 增加记录的数目
	 * */
	int addShop(String shopName, int commodity_id);
	/**
	 * @param user 查询购物车的用户信息
	 * @param page 页数
	 * @param limit 每页记录数
	 * @return commoditys 全部的商品
	 * */
	List<Commodity> getAll(User user);
	/**
	 * 移除购物车中的商品
	 * @param user 用户
	 * @param commodityId 商品ID
	 * @return 结果
	 * */
	boolean removeCommodity(User user, int commodityId);
	
}
