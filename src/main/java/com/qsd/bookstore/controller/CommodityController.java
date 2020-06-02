package com.qsd.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.service.CommodityService;
import com.qsd.bookstore.vo.CommodityVo;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */
@RestController
@RequestMapping("commodity")
public class CommodityController {

	@Autowired
	private CommodityService commodityService;
	
	@GetMapping("order")
	public CommodityVo order(int page, int limit) {
		List<Commodity> commodities = commodityService.queryAllByNum(page, limit);
		if (commodities != null) {
			return new CommodityVo(0, "成功", 1, commodities);
		}else {
			return new CommodityVo(1, "结果为空");
		}
	}
	
}
