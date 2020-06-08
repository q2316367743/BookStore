package com.qsd.bookstore.vo;

import java.util.List;

import com.qsd.bookstore.po.Category;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月8日
 */

public class CategoryVo {
	
	private Integer code;
	private String message;
	private List<Category> categories;
	public CategoryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryVo(Integer code, String message, List<Category> categories) {
		super();
		this.code = code;
		this.message = message;
		this.categories = categories;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
