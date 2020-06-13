package com.qsd.bookstore.service;

import java.util.List;

import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.User;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月5日
 */

public interface RecordService {

	/**
	 * 获取全部的购买记录
	 * @param user 用户信息
	 * @return 全部商品列表
	 * */
	List<Commodity> getAllRecord(User user);
	List<Commodity> getAllByUsername(String username);
	
	
}
