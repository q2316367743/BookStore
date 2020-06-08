package com.qsd.bookstore.dao;

import java.util.List;

import com.qsd.bookstore.po.Category;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月8日
 */

public interface CategoryDao {
	
	List<Category> queryAllCategory();
	int newCategory(Category category);
	int deleteCategoryByName(String name);

}
