package com.qsd.bookstore.service;


import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.vo.PageVo;

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
	int addShop(String username, int commodity_id);
	/**
	 * 移除购物车中的商品
	 * @param token 用户信息
	 * @param commodityId 商品ID
	 * @return 结果
	 * */
	boolean removeCommodity(String token, int commodityId);
	/**
	 * 购买商品
	 * @param token token信息
	 * @param commodityId 商品ID
	 * @return 结果
	 * */
	int buyCommodity(String token, int commodityId);
	/**
	 * 根据用户名查询购物车信息
	 * @param user 查询购物车的用户信息
	 * @param page 页数
	 * @param limit 每页记录数
	 * @return 全部的商品
	 * */
	PageVo<Commodity> getAllByUsername(String username, int page, int limit);
	
}
