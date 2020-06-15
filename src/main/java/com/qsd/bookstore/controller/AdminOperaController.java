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
import com.qsd.bookstore.vo.BaseVo;

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
	public BaseVo setNotice(String notice) {
		global.setNotice(notice);
		return new BaseVo(200, "设置公告成功");
	}
	
	@RequestMapping("setIndexImage")
	public BaseVo setIndexImage(@RequestParam("images") MultipartFile images) {
		String filename = images.getOriginalFilename();
		System.err.println(filename);
		return new BaseVo(200, "成功");
	}
	
	@GetMapping("enableSell")
	public BaseVo enableSell(int commodityId, boolean status) {
		Integer result = adminService.setSellStatus(commodityId, status);
		if (result == -1) {
			return new BaseVo(404, "商品不存在");
		}else if (result == 0) {
			return new BaseVo(400, "操作失败");
		}
		return new BaseVo(200, "操作成功");
	}
	
	@PostMapping("newCommodityWithfeild")
	public BaseVo newCommodityWithfeild(Commodity commodity) {
		commodity.setStatus(true);
		int result = commodityService.newCommodity(commodity);
		if (result > 0) {
			return new BaseVo(200, "success");
		}else {
			return new BaseVo(400, "error");
		}
	}
	
	@RequestMapping("newCommodityWithImage")
	public BaseVo newCommodityWithImage(@RequestParam("image") MultipartFile image) {
		int result = -1;
		result = resourceService.uploadCommodityImage(image);
		if (result > 0) {
			return new BaseVo(200, "success");
		}else {
			return new BaseVo(400, "error");
		}
	}
	
	@RequestMapping("newCommodityWithFile")
	public BaseVo newCommodityWithFile(@RequestParam("file") MultipartFile file) {
		int result = -1;
		result = resourceService.uploadCommodityFile(file);
		if (result > 0) {
			return new BaseVo(200, "success");
		}else {
			return new BaseVo(400, "error");
		}
	}
	
	@GetMapping("newCategory")
	public BaseVo newCategory(Category category) {
		adminService.addCategory(category);
		return new BaseVo(200, "success");
	}
	
	@GetMapping("deleteCategory")
	public BaseVo deleteCategory(String name) {
		adminService.deleteCategory(name);
		return new BaseVo(200, "success");
	}

}
