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
public class Notice {

	String message;
	
	public Notice() {
		this.message = "尊敬的用户，您好<br />" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;从6月15日起，本书店盛大开业，欢迎您的光临。";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
