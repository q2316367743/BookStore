package com.qsd.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qsd.bookstore.dao.CommodityDao;
import com.qsd.bookstore.dao.RecordDao;
import com.qsd.bookstore.dao.UserDao;
import com.qsd.bookstore.po.Record;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	private RecordDao recordDao;
	@Autowired
	private UserDao userDao;

	@Test
	void contextLoads() {
		//Double temp = commodityDao.queryPriceById(1);
		//Integer temp = recordDao.queryRecordByCommodityId("95989ee2c731410a9759e515b8b47d37", 2);
		Integer temp = userDao.getUserNum();
		System.err.println("temp:"+temp);
	}

}
