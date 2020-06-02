package com.qsd.bookstore.vo;

import java.util.List;

import com.qsd.bookstore.po.Commodity;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */

public class CommodityVo {

	private Integer code;
	private String msg;
	private Integer count;
	private List<Commodity> data;
	public CommodityVo() {
	}
	public CommodityVo(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public CommodityVo(Integer code, String msg, Integer count, List<Commodity> data) {
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<Commodity> getData() {
		return data;
	}
	public void setData(List<Commodity> data) {
		this.data = data;
	}
	
}
