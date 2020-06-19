package com.qsd.bookstore.service;

import java.util.List;

import com.qsd.bookstore.po.Category;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月18日
 */

public interface CategoryService {
	
	/**
	 * 获取全部分类
	 * */
	List<Category> getAllCategories();
	/**
	 * 增加类别
	 * */
	int addCategory(Category category);
	/**
	 * 删除类别
	 * */
	int deleteCategory(String name);

}
