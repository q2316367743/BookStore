package com.qsd.bookstore.vo;

import java.util.List;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月15日
 */

public class PageVo<T> {
	
	private Integer count;
	private List<T> data;
	public PageVo() {
	}
	public PageVo(Integer count, List<T> data) {
		this.count = count;
		this.data = data;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}

}
