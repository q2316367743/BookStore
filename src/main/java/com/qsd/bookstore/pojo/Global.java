package com.qsd.bookstore.pojo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.qsd.bookstore.dao.CommodityDao;
import com.qsd.bookstore.dao.UserDao;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */
@Component
@Scope("singleton")
public class Global {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private CommodityDao commodityDao;
	
	//网站的公告栏
	private String notice = "尊敬的用户，您好<br />&nbsp;&nbsp;&nbsp;&nbsp;从6月15日起，本书店盛大开业，欢迎您的光临。";
	//网站访问量
	private int view = 0;
	//网站在线人数
	private int online = 0;
	//商品卖出量
	private int commoditySellNum = 0;
	//营业额
	private int turnover = 0;
	//注册用户数量
	private int userNum;
	//上架图书数量
	private int commodityNum;
	@PostConstruct
	public void init() {
		this.commodityNum = commodityDao.getCOmmodityNum();
		this.userNum = userDao.getUserNum();
	}
	public String getNotice() {
		return this.notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public int getView() {
		return view;
	}
	public void addView() {
		this.view += 1;
	}
	public int getOnline() {
		return online;
	}
	public void addOnline() {
		this.online += 1;
	}
	public void reduceOnline() {
		this.online -= 1;
	}
	public int getCommoditySellNum() {
		return commoditySellNum;
	}
	public void addCommoditySellNum() {
		this.commoditySellNum += 1;
	}
	public int getTurnover() {
		return turnover;
	}
	public void addTurnover(int money) {
		this.turnover += money;
	}
	public void updateUserNum() {
		userNum += 1;
	}
	public int getUserNum() {
		return userNum;
	}
	public void updateCommodityNum() {
		commodityNum += 1;
	}
	public int getCommodityNum() {
		return commodityNum;
	}

}
