package com.qsd.bookstore.vo;

/**
 * @Description 数据分页回复
 * @Author Esion
 * @Data 2020年6月2日
 */

public class DataVo<T> {

	private Integer code;
	private String msg;
	private Integer count;
	private T data;
	public DataVo() {
	}
	public DataVo(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	public DataVo(Integer code, String msg, Integer count, T data) {
		super();
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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
