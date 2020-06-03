package com.qsd.bookstore.dto;

import com.qsd.bookstore.po.User;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月1日
 */

public class UserByLogin {
	
	private String username;
	private String password;
	public UserByLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserByLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public UserByLogin(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
