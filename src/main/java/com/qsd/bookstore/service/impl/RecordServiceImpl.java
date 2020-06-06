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

	@Override
	public int getCommodityFile(HttpServletRequest request, HttpServletResponse response, int commodityId) {
		// 资源目录
		String path = "E:/Documents/book";
		File file = new File(path);
		// 1. 获取记录表名
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			// 2. 获取全部记录
			String recordName = user.getRecordName();
			List<Commodity> commodities = recordDao.queryAllRecord(recordName);
			for (Commodity commodity : commodities) {
				if (commodity.getId() == commodityId) {
					String fileName = commodity.getFileName() + ".pdf";
					
					// 配置文件下载
	                response.setHeader("content-type", "application/octet-stream");
	                response.setContentType("application/octet-stream");
	                // 下载文件能正常显示中文
	                try {
						response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
					} catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
						response.setHeader("Content-Disposition", "attachment;filename=unknown.pdf");
					}

					BufferedInputStream in = FileUtil.getInputStream(new File(file, fileName));
					ServletOutputStream outputStream = null;
					try {
						outputStream = response.getOutputStream();
						IoUtil.copy(in, outputStream, IoUtil.DEFAULT_BUFFER_SIZE);
						return 1;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return 2;
					} finally {
						try {
							if (in != null) {
								in.close();
							}
							if (outputStream != null) {
								outputStream.close();
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			// 没有购买图书
			return 0;
		} else {
			// 未登录
			return -1;
		}
	}

}
