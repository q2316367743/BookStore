package com.qsd.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsd.bookstore.dao.RecordDao;
import com.qsd.bookstore.dao.UserDao;
import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.RecordService;

/**
 * @Description
 * @Author Esion
 * @Data 2020年6月5日
 */
@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordDao recordDao;
	@Autowired
	private UserDao userDao;

	@Override
	public List<Commodity> getAllRecord(User user) {
		String recordName = user.getRecordName();
		return recordDao.queryAllRecord(recordName);
	}

	@Override
	public List<Commodity> getAllByUsername(String username) {
		User user = userDao.queryUser(username);
		String recordName = user.getRecordName();
		return recordDao.queryAllRecord(recordName);
	}

}
