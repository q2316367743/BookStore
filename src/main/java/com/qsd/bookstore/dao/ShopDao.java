package com.qsd.bookstore.dao;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月3日
 */

public interface ShopDao {
	
	void createShopTable(String shopName);
	Integer deleteShopTable(String shopName);

}
