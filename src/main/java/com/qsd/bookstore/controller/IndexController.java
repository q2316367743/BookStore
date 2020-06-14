package com.qsd.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsd.bookstore.dao.CategoryDao;
import com.qsd.bookstore.po.Category;
import com.qsd.bookstore.po.Global;
import com.qsd.bookstore.vo.CategoryVo;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */
@RestController
@RequestMapping("global")
public class IndexController {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private Global global;
	
	@GetMapping("notice")
	public String notice() {
		String notice = global.getNotice();
		notice = notice.replace("\n", "<br>");
		notice = notice.replace(" ", "&nbsp;");
		return notice;
	}
	
	@GetMapping("category")
	public CategoryVo category() {
		List<Category> categories = categoryDao.queryAllCategory();
		return new CategoryVo(200, "success", categories);
	}
	
}
