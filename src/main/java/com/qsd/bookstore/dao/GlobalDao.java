package com.qsd.bookstore.dao;

import java.util.List;

import com.qsd.bookstore.po.Global;

/**
 * @Description 网站信息
 * @Author Esion
 * @Data 2020年6月8日
 */

public interface GlobalDao {
	
	/**
	 * 网站信息实例化
	 * @param global 网站信息
	 * */
	int saveGlobal(Global global);
	/**
	 * 查询全部网站信息
	 * @param num 查询日期跨度
	 * */
	List<Global> queryAll(int num);
	/**
	 * 查询网站浏览量
	 * @param num 查询日期跨度
	 * */
	List<Integer> queryView(int num);
	/**
	 * 查新网站在线人数
	 * @param num 查询日期跨度
	 * */
	List<Integer> queryOnline(int num);
	/**
	 * 查询网站售出量
	 * @param num 查询日期跨度
	 * */
	List<Integer> queryCommoditySellNum(int num);
	/**
	 * 查询网站营业额
	 * @param num 查询日期跨度
	 * */
	List<Integer> queryTurnover(int num);
	/**
	 * 查询注册用户数量
	 * @param num 查询日期跨度
	 * */
	List<Integer> queryUserNum(int num);
	/**
	 * 查询网站商品数量
	 * @param num 查询日期跨度
	 * */
	List<Integer> queryCommodityNum(int num);

}
