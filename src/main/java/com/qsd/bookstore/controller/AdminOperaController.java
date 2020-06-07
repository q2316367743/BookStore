package com.qsd.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.qsd.bookstore.pojo.Global;
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
	
	@GetMapping("setNotice")
	public ShopVo setNotice(String notice) {
		notice = notice.replace("\n", "<br>");
		notice = notice.replace(" ", "&nbsp;");
		global.setNotice(notice);
		return new ShopVo(200, "设置公告成功");
	}
	
	@RequestMapping("setIndexImage")
	public void setIndexImage(@RequestParam("images") MultipartFile[] images) {
		
	}

}
