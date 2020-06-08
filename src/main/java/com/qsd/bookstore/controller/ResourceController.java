package com.qsd.bookstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qsd.bookstore.service.RecordService;
import com.qsd.bookstore.service.ResourceService;
import com.qsd.bookstore.vo.ShopVo;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月5日
 */
@Controller
@RequestMapping("resource")
public class ResourceController {
	
	@Autowired
	private RecordService recordService;
	@Autowired
	private ResourceService resourceService;
	
	@GetMapping("read/{commodityId}")
	@ResponseBody
	public ModelAndView read(@PathVariable("commodityId") int commodityId, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("read");
		int result = resourceService.getCommodityFile(request, response, commodityId);
		System.err.println(result);
		switch (result) {
		case -1:
			//未登录
			modelAndView.addObject("result", new ShopVo(-1, "您没有登录，请重新登陆"));
			break;
		case 0:
			// 没有购买图书
			modelAndView.addObject("result", new ShopVo(0, "您没有购买图书，请购买后查看"));
			break;
		case 2:
			// 下载异常
			modelAndView.addObject("result", new ShopVo(2, "下载异常"));
			break;
		case 1:
			// 成功
			return null;
		}
		return modelAndView;
	}

}
