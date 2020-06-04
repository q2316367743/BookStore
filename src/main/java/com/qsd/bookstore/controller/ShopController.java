package com.qsd.bookstore.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.User;
import com.qsd.bookstore.service.ShopService;
import com.qsd.bookstore.vo.CommodityVo;

/**
 * @Description 处理购物车获取，购买，移除
 * @Author Esion
 * @Data 2020年6月4日
 */
@RestController
@RequestMapping("shop")
public class ShopController {
	
	@Autowired
	private ShopService shopService;

	/**
	 * 加入购物车
	 * @param commodityId 商品id
	 * @return 添加结果
	 * */
	@GetMapping("addShop")
	public CommodityVo<String> addShop(Integer commodityId, HttpServletRequest request){
		//获取购物车表名
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			String shopName = user.getShopName();
			//增加记录
			int addShop = shopService.addShop(shopName, commodityId);
			if (addShop > 0) {
				return new CommodityVo<String>(200, "加入购物车成功");
			}else {
				return new CommodityVo<String>(400, "未加入购物车");
			}
		}else {
			return new CommodityVo<String>(404, "用户信息不存在");
		}
		
	}
	
	//查询购物车全部记录
	@GetMapping("all")
	public CommodityVo<List<Commodity>> all(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			List<Commodity> commodities = shopService.getAll(user);
			return new CommodityVo<List<Commodity>>(200, "全部商品", -1, commodities);
		}else {
			return new CommodityVo<List<Commodity>>(404, "用户信息不存在，请重新登陆");
		}
	}
	
	@GetMapping("remove")
	public CommodityVo<Boolean> removeCommodity(int commodityId, HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			boolean b = shopService.removeCommodity(user, commodityId);
			return new CommodityVo<Boolean>(200, "成功移除商品" + commodityId, -1, b);
		}else {
			return new CommodityVo<Boolean>(404, "用户信息不存在，请重新登陆");
		}
	}
	
}
