package com.qsd.bookstore.service;

import java.util.Map;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */

public interface SearchService {

	Map<String, Object> baseSearch(String commodityName, int page, int limit);
	
}
