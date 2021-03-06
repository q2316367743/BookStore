package com.qsd.bookstore.service;

import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.vo.PageVo;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */

public interface SearchService {

	/**
	 * 根据名字搜索
	 * @param commodityName 商品名字
	 * @param page 页码（0，1，2，...，n）
	 * @param limit 每页的条数
	 * @return 包含count总数， commoditys分页后的列表
	 * */
	PageVo<Commodity> baseSearch(String commodityName, int page, int limit);
	
	/**
	 * 根据名字和价格搜索
	 * @param commodityName 商品名字
	 * @param max 价格最大值
	 * @param min 价格最小值
	 * @param page 页码（0，1，2，...，n）
	 * @param limit 每页的条数
	 * @return 包含count总数， commoditys分页后的列表
	 * */
	PageVo<Commodity> priceSearch(String commodityName, int max, int min, int page, int limit);
	
	/**
	 * 根据类型搜索
	 * @param category 类型
	 * @param page 页码（0，1，2，...，n）
	 * @param limit 每页的条数
	 * */
	PageVo<Commodity> searchByCategory(String category, int page, int limit);
	
}
