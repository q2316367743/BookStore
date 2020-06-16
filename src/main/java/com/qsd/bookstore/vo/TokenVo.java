package com.qsd.bookstore.vo;

/**
 * @Description 返回token的结果集
 * @Author Esion
 * @Data 2020年6月1日
 */

public class TokenVo<T> {
	
	private Integer code;
	private String message;
	private String token;
	private T data;
	
	public TokenVo() {
	}
	public TokenVo(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public TokenVo(Integer code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	public TokenVo(Integer code, String message, String token, T data) {
		super();
		this.code = code;
		this.message = message;
		this.token = token;
		this.data = data;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
