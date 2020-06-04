package com.qsd.bookstore.po;

import java.sql.Timestamp;

/**
 * @Description 购买记录
 * @Author Esion
 * @Data 2020年6月3日
 */

public class Record {
	
	private String RecordName;
	private Integer id;
	private Integer commodityId;
	private Timestamp shopTime;
	public Record(String recordName, Integer commodityId, Timestamp shopTime) {
		super();
		RecordName = recordName;
		this.commodityId = commodityId;
		this.shopTime = shopTime;
	}
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRecordName() {
		return RecordName;
	}
	public void setRecordName(String recordName) {
		RecordName = recordName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}
	public Timestamp getShopTime() {
		return shopTime;
	}
	public void setShopTime(Timestamp shopTime) {
		this.shopTime = shopTime;
	}

}
