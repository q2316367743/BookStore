package com.qsd.bookstore.po;

import java.io.Serializable;

import com.qsd.bookstore.dto.UserByLogin;

/**
 * @Description 管理员账户
 * @Author Esion
 * @Data 2020年6月6日
 */

public class Admin implements Serializable {

	private static final long serialVersionUID = 7515704976911030823L;
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
