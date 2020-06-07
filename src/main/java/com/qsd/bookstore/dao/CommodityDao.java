package com.qsd.bookstore.dao;

import java.util.List;

import com.qsd.bookstore.po.Commodity;

/**
 * @Description 商品相关
 * @Author Esion
 * @Data 2020年6月2日
 */

public interface CommodityDao {

	/**
	 * 查询全部商品根据销售量排序
	 * @return 全部商品
	 * */
	List<Commodity> queryAllByNum();
	/**
	 * 查询全部商品根据查看量排序
	 * @return 全部商品
	 * */
	List<Commodity> queryAllByView();
	/**
	 * 根据书名查询图书
	 * */
	List<Commodity> queryCommodityByName(String name);
	/**
	 * 根据类别搜索
	 * @param category 类别
	 * @return 所有图书
	 * */
	List<Commodity> queryCommodityByCategory(String category);
	/**
	 * 根据ID搜索商品
	 * @param id 商品id
	 * @return 商品信息
	 * */
	Commodity queryCommodityById(int id);
	/**
	 * 查询商品价格根据商品ID
	 * @param id 商品ID
	 * @return 商品价格
	 * */
	Double queryPriceById(int id);
	/**
	 * 销售量+1
	 * */
	Integer addNumber(int id);
	/**
	 * 浏览量+1
	 * */
	Integer addView(int id);
	
}
