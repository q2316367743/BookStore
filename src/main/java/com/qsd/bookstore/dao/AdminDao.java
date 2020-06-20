package com.qsd.bookstore.dao;

import com.qsd.bookstore.po.Admin;

/**
 * @Description 管理员
 * @Author Esion
 * @Data 2020年6月7日
 */

public interface AdminDao {

	/**
	 * 管理员登录
	 * */
	Integer login(Admin admin);
	
}
