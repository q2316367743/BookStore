package com.qsd.bookstore.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.CommodityService;
import com.qsd.bookstore.service.ShopService;
import com.qsd.bookstore.util.JwtUtil;
import com.qsd.bookstore.vo.DataVo;
import com.qsd.bookstore.vo.ResultVo;
import com.qsd.bookstore.vo.BaseVo;

/**
 * @Description 处理购物车获取，购买，移除；需要认证
 * @Author Esion
 * @Data 2020年6月4日
 */
@RestController
@RequestMapping("shop")
public class ShopController {

	@Autowired
	private ShopService shopService;
	@Autowired
	private CommodityService commodityService;
	
	/**
	 * 加入购物车
	 * 
	 * @param commodityId 商品id
	 * @return 添加结果
	 */
	@GetMapping("add")
	public DataVo<String> add(String token, Integer commodityId){
		String username = JwtUtil.getUsername(token);
		int addShop = shopService.addShop(username, commodityId);
		if (addShop > 0) {
			return new DataVo<String>(200, "加入购物车成功");
		} else if (addShop == 0) {
			return new DataVo<String>(400, "未加入购物车");
		} else if (addShop == -1) {
			return new DataVo<String>(500, "已经加入购物车，请勿重复添加");
		} else if (addShop == -2) {
			return new DataVo<String>(401, "商品已下架，无法加入购物车");
		} else {
			return new DataVo<String>(402, "商品不存在，无法加入购物车");
		}
	}

	/**
	 * 从购物车中删除商品
	 * */
	@GetMapping("remove")
	public DataVo<Boolean> removeCommodity(String token, int commodityId, HttpServletRequest request) {
		boolean b = shopService.removeCommodity(token, commodityId);
		return new DataVo<Boolean>(200, "成功移除商品" + commodityId, -1, b);
	}

	@GetMapping("buy")
	public DataVo<Integer> buy(int commodityId, String token) {
		int result = shopService.buyCommodity(token, commodityId);
		if (result == 1) {
				return new DataVo<Integer>(200, "成功购买商品" + commodityId);
		} else if (result == 0) {
			return new DataVo<Integer>(400, "账户余额不足");
		} else if (result == -1) {
			return new DataVo<Integer>(404, "用户信息不存在，请重新登陆");
		} else if (result == 2) {
			return new DataVo<Integer>(500, "您以购买过商品，请勿重复购买");
		} else if (result == -2) {
			return new DataVo<Integer>(402, "商品不存在");
		} else {
			return new DataVo<Integer>(401, "商品以下架");
		}
	}

	/**
	 * 跳转到支付页面
	 * */
	@GetMapping("pay")
	public ModelAndView pay(int commodityId, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("pay");
		// 1. 查询个人信息
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			// 2. 查询商品全部信息
			Commodity commodity = commodityService.queryCommodityById(commodityId);
			if (commodity != null) {
				if (commodity.getStatus()) {
					// 3. 赋值、跳转页面
					modelAndView.addObject("commodity", commodity);
					modelAndView.addObject("user", user);
					return modelAndView;
				}else {
					modelAndView.setViewName("read");
					modelAndView.addObject("result", new BaseVo(0, "商品已下架，无法购买"));
					return modelAndView;
				}
			}else {
				modelAndView.setViewName("read");
				modelAndView.addObject("result", new BaseVo(0, "商品不存在"));
				return modelAndView;
			}
		} else {
			// 如果没有登录，则重定向到登陆页面
			try {
				response.sendRedirect("../login.html?commodityId=" + commodityId);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
	
	@GetMapping("getDownloadPath")
	public ResultVo<String> getDownloadPath(String token, int commodityId) {
		String username = JwtUtil.getUsername(token);
		String message = JwtUtil.sign(username, commodityId);
		return new ResultVo<String>(200, "success", message);
	}

}
