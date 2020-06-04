package com.qsd.bookstore.service;

import java.util.Map;

import com.qsd.bookstore.po.Commodity;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */

public interface CommodityService {

	Map<String, Object> queryAllByNum(int page, int limit);
	Commodity queryCommodityById(Integer id);
	
}
