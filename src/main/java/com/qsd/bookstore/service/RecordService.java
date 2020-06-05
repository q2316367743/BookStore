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

	List<Commodity> getAllRecord(User user);
	
}
