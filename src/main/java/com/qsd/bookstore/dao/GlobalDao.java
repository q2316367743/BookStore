package com.qsd.bookstore.dao;

import java.util.List;

import com.qsd.bookstore.po.Global;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月8日
 */

public interface GlobalDao {
	
	int saveGlobal(Global global);
	List<Global> queryAll(int num);
	List<Integer> queryView(int num);
	List<Integer> queryOnline(int num);
	List<Integer> queryCommoditySellNum(int num);
	List<Integer> queryTurnover(int num);
	List<Integer> queryUserNum(int num);
	List<Integer> queryCommodityNum(int num);

}
