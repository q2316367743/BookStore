package com.qsd.bookstore.po;

import java.io.Serializable;

/**
 * @Description 商品分类表
 * @Author Esion
 * @Data 2020年6月8日
 */

public class Category implements Serializable {
	
	private static final long serialVersionUID = -8707900096166055244L;
	private String name;
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
