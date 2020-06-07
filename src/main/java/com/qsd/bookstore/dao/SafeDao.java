package com.qsd.bookstore.dao;

import com.qsd.bookstore.po.Safe;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月6日
 */

public interface SafeDao {

	/**
	 * 向密保表中新增记录
	 * @param safe 密保信息
	 * */
	int addSafe(Safe safe);
	/**
	 * 修改密保信息
	 * @param safe 密保信息
	 * */
	int updateSafe(Safe safe);
	/**
	 * 查询密保信息
	 * @param username 用户名
	 * */
	Safe querySafeByUsername(String username);
	/**
	 * 删除密保信息
	 * @param username 用户名
	 * */
	int deleteSafeByUsername(String username);
	
}
