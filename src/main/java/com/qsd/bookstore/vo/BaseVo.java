package com.qsd.bookstore.vo;

import cn.hutool.json.JSONUtil;

/**
 * @Description 基础回复
 * @Author Esion
 * @Data 2020年6月5日
 */

public class BaseVo {
	
	private Integer code;
	private String message;
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
	public BaseVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BaseVo(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public String toJSONString() {
		return JSONUtil.toJsonStr(this);
	}

}
