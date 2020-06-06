package com.qsd.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsd.bookstore.pojo.Global;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */
@RestController
@RequestMapping("global")
public class IndexController {
	
	@Autowired
	private Global global;
	
	@GetMapping("notice")
	public String notice() {
		return global.getNotice();
	}
	
	@GetMapping("list")
	public Global list() {
		return global;
	}
	
}
