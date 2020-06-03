package com.qsd.bookstore.po;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月1日
 */

public class User {
	
	private String username;
	private String password;
	private String nickname;
	private Boolean gender;
	private Integer age;
	private String shopName;
	private String recordName;
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
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", nickname=" + nickname + ", gender=" + gender
				+ ", age=" + age + ", shopName=" + shopName + ", recordName=" + recordName + "]";
	}
	

}
