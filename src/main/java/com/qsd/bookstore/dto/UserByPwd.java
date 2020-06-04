package com.qsd.bookstore.dto;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月4日
 */

public class UserByPwd {
	
	private String username;
	private String oldpwd;
	private String newpwd;
	public UserByPwd() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserByPwd(String username, String oldpwd, String newpwd) {
		super();
		this.username = username;
		this.oldpwd = oldpwd;
		this.newpwd = newpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

}
