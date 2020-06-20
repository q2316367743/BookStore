package com.qsd.bookstore.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.qsd.bookstore.dao.GlobalDao;
import com.qsd.bookstore.po.Global;

/**
 * @Description 网站信息实例化任务
 * @Author Esion
 * @Data 2020年6月8日
 */
@Component
public class GlobalJob {
	
	@Autowired
	private Global global;
	@Autowired
	private GlobalDao globalDao;
	
	@Scheduled(cron = "59 59 23 * * *")
	public void saveGlobal() {
		//网站数据实例化
		globalDao.saveGlobal(global);
		//数据更新
		global.update();
	}
	
}
