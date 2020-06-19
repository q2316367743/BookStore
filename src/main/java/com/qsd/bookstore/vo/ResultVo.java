package com.qsd.bookstore.vo;

/**
 * @Description 加强回复
 * @Author Esion
 * @Data 2020年6月14日
 */

public class ResultVo<T> extends BaseVo {
	
	private T data;
	public ResultVo() {
	}
	public ResultVo(int code, String message) {
		super(code, message);
	}
	public ResultVo(int code, String message, T data) {
		super(code, message);
		this.data = data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
