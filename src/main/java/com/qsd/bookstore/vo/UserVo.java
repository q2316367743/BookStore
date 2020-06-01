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
	private UserInfo userInfo;
	
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
		this.userInfo = new UserInfo();
		this.userInfo.setNickname(user.getNickname());
		this.userInfo.setUsername(user.getUsername());
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
	
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	class UserInfo{
		private String nickname;
		private String username;
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
	}

}
