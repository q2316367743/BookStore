package com.qsd.bookstore.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.service.CommodityService;
import com.qsd.bookstore.vo.CommodityVo;
import com.qsd.bookstore.vo.ShopVo;

/**
 * @Description 关于商品的信息，不需要认证
 * @Author Esion
 * @Data 2020年6月2日
 */
@RestController
@RequestMapping("commodity")
public class CommodityController {

	@Autowired
	private CommodityService commodityService;
	
	@SuppressWarnings("unchecked")
	@GetMapping("orderByNumber")
	public CommodityVo<List<Commodity>> orderByNumber(int page, int limit) {
		Map<String, Object> commodities = commodityService.queryAllByNum(page, limit);
		if (commodities != null) {
			return new CommodityVo<List<Commodity>>(0, "成功", (int)commodities.get("count"), (List<Commodity>)commodities.get("commoditys"));
		}else {
			return new CommodityVo<List<Commodity>>(1, "结果为空");
		}
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("orderByView")
	public CommodityVo<List<Commodity>> orderByView(int page, int limit) {
		Map<String, Object> commodities = commodityService.queryAllByView(page, limit);
		if (commodities != null) {
			return new CommodityVo<List<Commodity>>(0, "成功", (int)commodities.get("count"), (List<Commodity>)commodities.get("commoditys"));
		}else {
			return new CommodityVo<List<Commodity>>(1, "结果为空");
		}
	}
	
	@GetMapping("info")
	public CommodityVo<Commodity> info(int commodityId){
		Commodity commodity = commodityService.queryCommodityById(commodityId);
		if (commodity != null) {
			return new CommodityVo<Commodity>(200, "success", -1, commodity);
		}else {
			return new CommodityVo<>(404, "商品不存在");
		}
	}
	
}
