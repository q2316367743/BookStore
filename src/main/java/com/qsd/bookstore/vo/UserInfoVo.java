package com.qsd.bookstore.vo;

import com.qsd.bookstore.po.User;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月3日
 */

public class UserInfoVo {

	private Integer code;
	private String message;
	private User userInfo;
	public UserInfoVo(Integer code, String message, User userInfo) {
		super();
		this.code = code;
		this.message = message;
		this.userInfo = userInfo;
	}
	public UserInfoVo() {
		super();
		// TODO Auto-generated constructor stub
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
	public User getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(User userInfo) {
		this.userInfo = userInfo;
	}
	
}
