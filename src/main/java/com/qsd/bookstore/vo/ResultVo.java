package com.qsd.bookstore.vo;

/**
 * @Description 加强回复
 * @Author Esion
 * @Data 2020年6月14日
 */

public class ResultVo<T> {
	
	private int code;
	private String message;
	private T data;
	public ResultVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultVo(int code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
