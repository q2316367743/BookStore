package com.qsd.bookstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qsd.bookstore.po.Commodity;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月3日
 */

public interface ShopDao {
	
	void createShopTable(String shopName);
	Integer deleteShopTable(String shopName);
	Integer addShop(@Param("shopName") String shopName, @Param("commodityId") int commodityId);
	List<Commodity> queryAll(String shopName);
	int removeCommodityById(@Param("shopName") String shopName, @Param("commodityId") int commodityId);

}
