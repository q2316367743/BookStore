package com.qsd.bookstore.job;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.qsd.bookstore.dao.GlobalDao;
import com.qsd.bookstore.po.Global;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月8日
 */
@Component
public class GlobalJob {
	
	private Logger logger = LoggerFactory.getLogger(GlobalJob.class);
	@Autowired
	private Global global;
	@Autowired
	private GlobalDao globalDao;
	
	@Scheduled(cron = "59 59 23 * * *")
	public void saveGlobal() {
		globalDao.saveGlobal(global);
		LocalDate now = LocalDate.now();
		logger.info("时间：{}，网站数据实例化", now.toString());
	}
	
}
