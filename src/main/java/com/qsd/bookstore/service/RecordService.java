package com.qsd.bookstore.service;

import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.vo.PageVo;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月5日
 */

public interface RecordService {

	/**
	 * 查询全部记录根据用户名
	 * @param username 用户名
	 * @param page 页数
	 * @param limit 每页的页数
	 * @return 分页后的记录
	 * */
	PageVo<Commodity> getAllByUsername(String username, int page, int limit);
	
	
}
