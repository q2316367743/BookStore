package com.qsd.bookstore.dao;

import com.qsd.bookstore.po.Safe;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月6日
 */

public interface SafeDao {

	int addSafe(Safe safe);
	int updateSafe(Safe safe);
	Safe querySafeByUsername(String username);
	
}
