package com.qsd.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsd.bookstore.dao.CategoryDao;
import com.qsd.bookstore.po.Category;
import com.qsd.bookstore.po.Global;
import com.qsd.bookstore.util.VerifyCodeUtil;
import com.qsd.bookstore.vo.ResultVo;
import com.qsd.bookstore.vo.TokenVo;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月2日
 */
@RestController
@RequestMapping("global")
public class IndexController {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private Global global;
	
	/**
	 * 公告
	 * */
	@GetMapping("notice")
	public String notice() {
		String notice = global.getNotice();
		notice = notice.replace("\n", "<br>");
		notice = notice.replace(" ", "&nbsp;");
		return notice;
	}
	
	/**
	 * 种类
	 * */
	@GetMapping("category")
	public ResultVo<List<Category>> category() {
		List<Category> categories = categoryDao.queryAllCategory();
		return new ResultVo<>(200, "success", categories);
	}
	
	@GetMapping("getVerifyCode")
	public TokenVo<String> getVerifyCode(){
		//生成验证码
		ShearCaptcha cerifyCode = CaptchaUtil.createShearCaptcha(100, 38, 4, 4);
		String image = cerifyCode.getImageBase64();
		String code = cerifyCode.getCode();
		//生成答案token
		String token = VerifyCodeUtil.sign(code);
		//返回前端
		return new TokenVo<String>(200, "成功", token, image);
	}
	
}
