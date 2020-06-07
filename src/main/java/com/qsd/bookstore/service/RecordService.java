package com.qsd.bookstore.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	/**
	 * 获取商品文件
	 * @param response 
	 * @param request 
	 * @param commodityId 商品ID
	 * @return 结果
	 * */
	int getCommodityFile(HttpServletRequest request, HttpServletResponse response, int commodityId);
	
}
