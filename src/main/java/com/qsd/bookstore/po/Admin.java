package com.qsd.bookstore.po;

import com.qsd.bookstore.dto.UserByLogin;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月6日
 */

public class Admin {
	
	private String username;
	private String password;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(UserByLogin user) {
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
