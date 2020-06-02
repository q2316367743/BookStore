package com.qsd.bookstore.dao;

import java.util.List;
import java.util.Map;

import com.qsd.bookstore.po.Commodity;

/**
 * @Description 商品相关
 * @Author Esion
 * @Data 2020年6月2日
 */

public interface CommodityDao {

	/**
	 * 查询全部商品根据销售量排序
	 * */
	List<Commodity> queryAllByNum(Map<String, Object> condition);
	
}
