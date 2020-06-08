package com.qsd.bookstore.service.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsd.bookstore.dao.CommodityDao;
import com.qsd.bookstore.dao.RecordDao;
import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.RecordService;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;

/**
 * @Description
 * @Author Esion
 * @Data 2020年6月5日
 */
@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordDao recordDao;

	@Override
	public List<Commodity> getAllRecord(User user) {
		// TODO Auto-generated method stub
		String recordName = user.getRecordName();
		return recordDao.queryAllRecord(recordName);
	}

}
