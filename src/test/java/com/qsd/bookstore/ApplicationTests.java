package com.qsd.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qsd.bookstore.dao.CommodityDao;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	private CommodityDao commodityDao;

	@Test
	void contextLoads() {
		Double price = commodityDao.queryPriceById(1);
		System.out.println(price);
	}

}
