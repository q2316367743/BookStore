package com.qsd.bookstore.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qsd.bookstore.dao.CommodityDao;
import com.qsd.bookstore.dao.RecordDao;
import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.ResourceService;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileWriter;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月8日
 */
@Service
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private RecordDao recordDao;
	@Autowired
	private CommodityDao commodityDao;

	@Override
	public int getCommodityFile(HttpServletRequest request, HttpServletResponse response, int commodityId) {
		// 资源目录
		//linux
		String path = "/home/pi/Documents/book";
		//window
		//String path = "E:/Documents/book";
		File file = new File(path);
		// 1. 获取记录表名
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			// 2. 获取全部记录
			String recordName = user.getRecordName();
			Integer result = recordDao.queryRecordByCommodityId(recordName, commodityId);
				if (result != null) {
					// 如果存在记录，则获取商品信息
					Commodity commodity = commodityDao.queryCommodityById(commodityId);
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
			// 没有购买图书
			return 0;
		} else {
			// 未登录
			return -1;
		}
	}

	private void uploadFileWithPath(InputStream inputStream, File path) {
		FileWriter fileWriter = new FileWriter(path);
		BufferedOutputStream outputStream = fileWriter.getOutputStream();
		IoUtil.copy(inputStream, outputStream);
	}

	@Override
	public int uploadCommodityImage(MultipartFile image) {
		//linux
		String tempPath = "/dev/path";
		String path = "/var/www/html/bookstore/commodity";
		//whidow
		//String tempPath = "D:\\temp";
		//String path = "D:\\nginx-1.14.2\\html\\bookstore\\commodity";
		String fileName = image.getOriginalFilename();
		File tempFile = new File(tempPath, fileName);
		File file = new File(path, fileName);
		try {
			InputStream inputStream = image.getInputStream();
			uploadFileWithPath(inputStream, tempFile);
			//对图片进行裁剪
			ImgUtil.scale(tempFile, file, 150, 150, null);
			return 1;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int uploadCommodityFile(MultipartFile file) {
		//linux
		String path = "/home/pi/Documents/book";
		//window
		//String path = "E:\\Documents\\book";
		String fileName = file.getOriginalFilename();
		File f = new File(path, fileName);
		try {
			InputStream inputStream = file.getInputStream();
			uploadFileWithPath(inputStream, f);
			return 1;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
}
