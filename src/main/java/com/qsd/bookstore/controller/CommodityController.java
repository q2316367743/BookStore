package com.qsd.bookstore.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.User;
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
	public CommodityVo<List<Commodity>> order(int page, int limit) {
		Map<String, Object> commodities = commodityService.queryAllByNum(page, limit);
		if (commodities != null) {
			return new CommodityVo<List<Commodity>>(0, "成功", (int)commodities.get("count"), (List<Commodity>)commodities.get("commoditys"));
		}else {
			return new CommodityVo<List<Commodity>>(1, "结果为空");
		}
	}
	
	@GetMapping("info")
	public ModelAndView info(Integer commodityId, HttpServletRequest request) {
		Commodity commodity = commodityService.queryCommodityById(commodityId);
		ModelAndView modelAndView = new ModelAndView("commodity");
		Object user = request.getSession().getAttribute("user");
		modelAndView.addObject("commodity", commodity);
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	
	
}
