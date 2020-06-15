package com.qsd.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.service.SearchService;
import com.qsd.bookstore.vo.DataVo;
import com.qsd.bookstore.vo.PageVo;

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
	public DataVo baseSearch(String commodityName, int page, int limit) {
		PageVo<Commodity> baseSearch = searchService.baseSearch(commodityName, page, limit);
		if (baseSearch != null) {
			return new DataVo(200, "搜索" + commodityName + "成功", baseSearch.getCount(), baseSearch.getData());
		}else {
			return new DataVo(400, "搜索" + commodityName + "错误");
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("price")
	public DataVo priceSearch(String commodityName, int max, int min, int page, int limit) {
		PageVo<Commodity> priceSearch = searchService.priceSearch(commodityName, max, min, page, limit);
		if (priceSearch != null) {
			return new DataVo(200, "搜索>商品：" + commodityName + ",max:" + max + ",min" + min +  "<成功", priceSearch.getCount()	, priceSearch.getData());
		}else {
			return new DataVo(400, "搜索" + commodityName + "错误");
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("category")
	public DataVo category(String category, int page, int limit) {
		PageVo<Commodity> searchByCategory = searchService.searchByCategory(category, page, limit);
		if (searchByCategory != null) {
			return new DataVo(200, "搜索" + category + "成功", searchByCategory.getCount(), searchByCategory.getData());
		}else {
			return new DataVo(400, "搜索" + category + "错误");
		}
	}
	
}
