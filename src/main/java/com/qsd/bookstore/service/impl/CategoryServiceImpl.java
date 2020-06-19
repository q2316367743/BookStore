package com.qsd.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.qsd.bookstore.dao.CategoryDao;
import com.qsd.bookstore.po.Category;
import com.qsd.bookstore.service.CategoryService;
import com.qsd.bookstore.util.Cache;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月18日
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	@Cacheable(value = Cache.NAME, key = Cache.CATEGORY)
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryDao.queryAllCategory();
	}
	
	@Override
	@CacheEvict(value = Cache.NAME, key = Cache.CATEGORY)
	public int addCategory(Category category) {
		return categoryDao.newCategory(category);
	}
	
	@Override
	@CacheEvict(value = Cache.NAME, key = Cache.CATEGORY)
	public int deleteCategory(String name) {
		return categoryDao.deleteCategoryByName(name);
	}

}
