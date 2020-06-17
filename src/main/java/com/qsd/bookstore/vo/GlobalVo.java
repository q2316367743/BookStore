package com.qsd.bookstore.vo;

import java.util.List;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月17日
 */

public class GlobalVo {
	
	private Integer code;
	private String message;
	private Integer count;
	private List<Integer> view;
	private List<Integer> online;
	private List<Integer> commoditySellNum;
	private List<Integer> turnover;
	private List<Integer> userNum;
	private List<Integer> commodityNum;
	public GlobalVo() {
	}
	public GlobalVo(Integer code, String message, Integer count, List<Integer> view, List<Integer> online,
			List<Integer> commoditySellNum, List<Integer> turnover, List<Integer> userNum, List<Integer> commodityNum) {
		super();
		this.code = code;
		this.message = message;
		this.count = count;
		this.view = view;
		this.online = online;
		this.commoditySellNum = commoditySellNum;
		this.turnover = turnover;
		this.userNum = userNum;
		this.commodityNum = commodityNum;
	}
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<Integer> getView() {
		return view;
	}
	public void setView(List<Integer> view) {
		this.view = view;
	}
	public List<Integer> getOnline() {
		return online;
	}
	public void setOnline(List<Integer> online) {
		this.online = online;
	}
	public List<Integer> getCommoditySellNum() {
		return commoditySellNum;
	}
	public void setCommoditySellNum(List<Integer> commoditySellNum) {
		this.commoditySellNum = commoditySellNum;
	}
	public List<Integer> getTurnover() {
		return turnover;
	}
	public void setTurnover(List<Integer> turnover) {
		this.turnover = turnover;
	}
	public List<Integer> getUserNum() {
		return userNum;
	}
	public void setUserNum(List<Integer> userNum) {
		this.userNum = userNum;
	}
	public List<Integer> getCommodityNum() {
		return commodityNum;
	}
	public void setCommodityNum(List<Integer> commodityNum) {
		this.commodityNum = commodityNum;
	}
	
}
