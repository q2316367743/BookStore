package com.qsd.bookstore.vo;

import com.qsd.bookstore.po.User;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月1日
 */

public class UserVo {
	
	private Integer code;
	private String message;
	private String token;
	private User user;
	
	public UserVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserVo(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public UserVo(Integer code, String message, User user) {
		super();
		this.code = code;
		this.message = message;
		this.user = user;
	}
	public UserVo(Integer code, String message, String token, User user) {
		super();
		this.code = code;
		this.message = message;
		this.token = token;
		this.user = user;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
