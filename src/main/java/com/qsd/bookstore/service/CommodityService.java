package com.qsd.bookstore.service;

import java.util.List;

import com.qsd.bookstore.po.Commodity;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */

public interface CommodityService {

	List<Commodity> queryAllByNum(int page, int limit);
	
}
