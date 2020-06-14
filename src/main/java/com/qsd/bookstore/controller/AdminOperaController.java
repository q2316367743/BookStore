package com.qsd.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.qsd.bookstore.po.Category;
import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.Global;
import com.qsd.bookstore.service.AdminService;
import com.qsd.bookstore.service.CommodityService;
import com.qsd.bookstore.service.ResourceService;
import com.qsd.bookstore.vo.ShopVo;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月7日
 */
@RestController
@RequestMapping("admin/opera")
public class AdminOperaController {
	
	@Autowired
	private Global global;
	@Autowired
	private AdminService adminService;
	@Autowired
	private CommodityService commodityService;
	@Autowired
	private ResourceService resourceService;
	
	@GetMapping("setNotice")
	public ShopVo setNotice(String notice) {
		global.setNotice(notice);
		return new ShopVo(200, "设置公告成功");
	}
	
	@RequestMapping("setIndexImage")
	public ShopVo setIndexImage(@RequestParam("images") MultipartFile images) {
		String filename = images.getOriginalFilename();
		System.err.println(filename);
		return new ShopVo(200, "成功");
	}
	
	@GetMapping("enableSell")
	public ShopVo enableSell(int commodityId, boolean status) {
		Integer result = adminService.setSellStatus(commodityId, status);
		if (result == -1) {
			return new ShopVo(404, "商品不存在");
		}else if (result == 0) {
			return new ShopVo(400, "操作失败");
		}
		return new ShopVo(200, "操作成功");
	}
	
	@PostMapping("newCommodityWithfeild")
	public ShopVo newCommodityWithfeild(Commodity commodity) {
		commodity.setStatus(true);
		int result = commodityService.newCommodity(commodity);
		if (result > 0) {
			return new ShopVo(200, "success");
		}else {
			return new ShopVo(400, "error");
		}
	}
	
	@RequestMapping("newCommodityWithImage")
	public ShopVo newCommodityWithImage(@RequestParam("image") MultipartFile image) {
		int result = -1;
		result = resourceService.uploadCommodityImage(image);
		if (result > 0) {
			return new ShopVo(200, "success");
		}else {
			return new ShopVo(400, "error");
		}
	}
	
	@RequestMapping("newCommodityWithFile")
	public ShopVo newCommodityWithFile(@RequestParam("file") MultipartFile file) {
		int result = -1;
		result = resourceService.uploadCommodityFile(file);
		if (result > 0) {
			return new ShopVo(200, "success");
		}else {
			return new ShopVo(400, "error");
		}
	}
	
	@GetMapping("newCategory")
	public ShopVo newCategory(Category category) {
		adminService.addCategory(category);
		return new ShopVo(200, "success");
	}
	
	@GetMapping("deleteCategory")
	public ShopVo deleteCategory(String name) {
		adminService.deleteCategory(name);
		return new ShopVo(200, "success");
	}

}
