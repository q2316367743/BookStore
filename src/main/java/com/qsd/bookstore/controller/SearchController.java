package com.qsd.bookstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.service.SearchService;
import com.qsd.bookstore.vo.CommodityVo;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */
@RestController
@RequestMapping("search")
public class SearchController {
	
	@Autowired
	private SearchService searchService;

	@GetMapping("base")
	public CommodityVo baseSearch(String commodityName, int page, int limit) {
		Map<String, Object> baseSearch = searchService.baseSearch(commodityName, page, limit);
		if (baseSearch != null) {
			int count = (int) baseSearch.get("count");
			List<Commodity> commodities = (List<Commodity>) baseSearch.get("commoditys");
			return new CommodityVo(200, "搜索" + commodityName + "成功", count, commodities);
		}else {
			return new CommodityVo(400, "搜索" + commodityName + "错误");
		}
	}
	
	@GetMapping("category")
	public CommodityVo category(String category, int page, int limit) {
		Map<String, Object> baseSearch = searchService.searchByCategory(category, page, limit);
		if (baseSearch != null) {
			int count = (int) baseSearch.get("count");
			List<Commodity> commodities = (List<Commodity>) baseSearch.get("commoditys");
			return new CommodityVo(200, "搜索" + category + "成功", count, commodities);
		}else {
			return new CommodityVo(400, "搜索" + category + "错误");
		}
	}
	
}
