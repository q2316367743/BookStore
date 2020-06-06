package com.qsd.bookstore.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */
@Component
@Scope("singleton")
public class Global {
	
	//网站的公告栏
	private String Notice = "尊敬的用户，您好<br />&nbsp;&nbsp;&nbsp;&nbsp;从6月15日起，本书店盛大开业，欢迎您的光临。";
	//网站访问量
	private int view = 0;
	public String getNotice() {
		return Notice;
	}
	public void setNotice(String notice) {
		Notice = notice;
	}
	public int getView() {
		return view;
	}
	public void addView() {
		this.view += 1;
	}

}
