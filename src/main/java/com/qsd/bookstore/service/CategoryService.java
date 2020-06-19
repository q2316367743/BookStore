package com.qsd.bookstore.service;

import java.util.List;

import com.qsd.bookstore.po.Category;

/**
 * @Description 分类业务
 * @Author Esion
 * @Data 2020年6月18日
 */

public interface CategoryService {
	
	/**
	 * 获取全部分类
	 * @return 全部分类
	 * */
	List<Category> getAllCategories();
	/**
	 * 增加类别
	 * @return 增加的数量
	 * */
	int addCategory(Category category);
	/**
	 * 删除类别
	 * @return 删除类别的数量
	 * */
	int deleteCategory(String name);

}
