package com.qsd.bookstore.vo;

/**
 * @Description 返回token的结果集
 * @Author Esion
 * @Data 2020年6月1日
 */

public class TokenVo<T> extends ResultVo<T> {
	
	private String token;
	
	public TokenVo() {
	}
	public TokenVo(Integer code, String message) {
		super(code, message);
	}
	public TokenVo(Integer code, String message, T data) {
		super(code, message, data);
	}
	public TokenVo(Integer code, String message, String token, T data) {
		super(code, message, data);
		this.token = token;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
