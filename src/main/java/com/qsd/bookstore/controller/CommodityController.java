package com.qsd.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.service.CommodityService;
import com.qsd.bookstore.vo.DataVo;
import com.qsd.bookstore.vo.PageVo;

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
	
	@GetMapping("orderByNumber")
	public DataVo<List<Commodity>> orderByNumber(int page, int limit) {
		PageVo<Commodity> result = commodityService.queryAllByNum(page, limit);
		if (result != null) {
			return new DataVo<List<Commodity>>(0, "成功", result.getCount(), result.getData());
		}else {
			return new DataVo<List<Commodity>>(1, "结果为空");
		}
	}
	
	@GetMapping("orderByView")
	public DataVo<List<Commodity>> orderByView(int page, int limit) {
		PageVo<Commodity> result = commodityService.queryAllByView(page, limit);
		if (result != null) {
			return new DataVo<List<Commodity>>(0, "成功", result.getCount(), result.getData());
		}else {
			return new DataVo<List<Commodity>>(1, "结果为空");
		}
	}
	
	@GetMapping("info")
	public DataVo<Commodity> info(int commodityId){
		Commodity commodity = commodityService.queryCommodityById(commodityId);
		if (commodity != null) {
			return new DataVo<Commodity>(200, "success", -1, commodity);
		}else {
			return new DataVo<>(404, "商品不存在");
		}
	}
	
}
