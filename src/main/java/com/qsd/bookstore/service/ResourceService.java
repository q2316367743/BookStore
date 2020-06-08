package com.qsd.bookstore.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月8日
 */

public interface ResourceService {

	/**
	 * 获取商品文件
	 * @param response 
	 * @param request 
	 * @param commodityId 商品ID
	 * @return 结果
	 * */
	int getCommodityFile(HttpServletRequest request, HttpServletResponse response, int commodityId);
	/**
	 * 上传商品图片
	 * @param image 商品图片
	 * */
	int uploadCommodityImage(MultipartFile image);
	/**
	 * 上传商品文件
	 * @param file 商品文件
	 * */
	int uploadCommodityFile(MultipartFile file);
	
}
