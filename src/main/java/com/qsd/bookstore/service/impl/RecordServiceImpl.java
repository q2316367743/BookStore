package com.qsd.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsd.bookstore.dao.RecordDao;
import com.qsd.bookstore.dao.UserDao;
import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.RecordService;
import com.qsd.bookstore.util.JdbcUtil;
import com.qsd.bookstore.vo.PageVo;

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

	@SuppressWarnings("unchecked")
	@Override
	public PageVo<Commodity> getAllByUsername(String username, int page, int limit) {
		User user = userDao.queryUser(username);
		String recordName = user.getRecordName();
		List<Commodity> records = recordDao.queryAllRecord(recordName);
		return JdbcUtil.PageUtil(page, limit, records);
	}

}
