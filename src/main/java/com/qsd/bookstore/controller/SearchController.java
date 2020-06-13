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
 * @Description 根据条件筛选产品，不需要认证
 * @Author Esion
 * @Data 2020年6月2日
 */
@RestController
@RequestMapping("search")
public class SearchController {
	
	@Autowired
	private SearchService searchService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("price")
	public CommodityVo priceSearch(String commodityName, int max, int min, int page, int limit) {
		Map<String, Object> baseSearch = searchService.priceSearch(commodityName, max, min, page, limit);
		if (baseSearch != null) {
			int count = (int) baseSearch.get("count");
			List<Commodity> commodities = (List<Commodity>) baseSearch.get("commoditys");
			return new CommodityVo(200, "搜索>商品：" + commodityName + ",max:" + max + ",min" + min +  "<成功", count, commodities);
		}else {
			return new CommodityVo(400, "搜索" + commodityName + "错误");
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
