package com.qsd.bookstore.po;

import java.sql.Timestamp;

/**
 * @Description 购买记录
 * @Author Esion
 * @Data 2020年6月3日
 */

public class Record {
	
	private Integer commodityId;
	private Integer count;
	private Timestamp shopTime;
	public Integer getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Timestamp getShopTime() {
		return shopTime;
	}
	public void setShopTime(Timestamp shopTime) {
		this.shopTime = shopTime;
	}

}
