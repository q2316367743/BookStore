package com.qsd.bookstore.service;

import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.vo.PageVo;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */

public interface CommodityService {

	/**
	 * 查询全部的商品信息根据销售量
	 * */
	PageVo<Commodity> queryAllByNum(int page, int limit);
	/**
	 * 查询全部的商品信息根据购买量
	 * */
	PageVo<Commodity> queryAllByView(int page, int limit);
	/**
	 * 查询商品信息根据商品ID
	 * */
	Commodity queryCommodityById(Integer id);
	/**
	 * 上架商品
	 * */
	int newCommodity(Commodity commodity);
	/**
	 * 设置商品是否上架状态
	 * */
	Integer setSellStatus(int id, boolean status);
	
}
