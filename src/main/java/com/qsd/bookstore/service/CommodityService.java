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
	 * @param page 页数，从1开始
	 * @param limit 每页数量
	 * @return 分页后的数据
	 * */
	PageVo<Commodity> queryAllByNum(int page, int limit);
	/**
	 * 查询全部的商品信息根据购买量
	 * @param page 页数，从1开始
	 * @param limit 每页数量
	 * @return 分页后的数据
	 * */
	PageVo<Commodity> queryAllByView(int page, int limit);
	/**
	 * 查询商品信息根据商品ID
	 * @param id 商品的ID
	 * @return 商品全部信息
	 * */
	Commodity queryCommodityById(Integer id);
	/**
	 * 上架商品
	 * @param commodity 商品信息
	 * @return 新增的数量
	 * */
	int newCommodity(Commodity commodity);
	/**
	 * 设置商品是否上架状态
	 * @param id 商品ID
	 * @param status 商品状态
	 * @return 更新的数量
	 * */
	Integer setSellStatus(int id, boolean status);
	
}
