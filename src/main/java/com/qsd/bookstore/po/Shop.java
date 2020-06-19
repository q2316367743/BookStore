package com.qsd.bookstore.po;

import java.io.Serializable;

/**
 * @Description 购物车
 * @Author Esion
 * @Data 2020年6月3日
 */

public class Shop implements Serializable {

	private static final long serialVersionUID = -3199125340184718661L;
	private Integer id;
	private Integer commodityId;
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
	
	
}
