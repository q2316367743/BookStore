package com.qsd.bookstore.po;

import java.io.Serializable;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月1日
 */

public class User implements Serializable {
	
	private static final long serialVersionUID = 5983933459162029811L;
	private String username;
	private String password;
	private String nickname;
	private Boolean gender;
	private Integer age;
	private String shopName;
	private String recordName;
	private Double balance;
	private Boolean isSafe;
	private String code;
	private String token;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getRecordName() {
		return recordName;
	}
	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Boolean getIsSafe() {
		return isSafe;
	}
	public void setIsSafe(Boolean isSafe) {
		this.isSafe = isSafe;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", nickname=" + nickname + ", gender=" + gender
				+ ", age=" + age + ", shopName=" + shopName + ", recordName=" + recordName + ", balance=" + balance
				+ ", isSafe=" + isSafe + ", code=" + code + ", token=" + token + "]";
	}

}
