package com.qsd.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsd.bookstore.dao.GlobalDao;
import com.qsd.bookstore.po.Global;
import com.qsd.bookstore.vo.DataVo;
import com.qsd.bookstore.vo.GlobalVo;
import com.qsd.bookstore.vo.ResultVo;

/**
 * @Description 数据可视化
 * @Author Esion
 * @Data 2020年6月17日
 */
@RestController
@RequestMapping("admin/global")
public class AdminGlobalController {
	
	@Autowired
	private GlobalDao globalDao;
	
	/**
	 * 查询全部用于表格
	 * */
	@GetMapping("all")
	public ResultVo<List<Global>> all(){
		List<Global> all = globalDao.queryAll(5);
		return new ResultVo<List<Global>>(200, "success", all);
	}
	
	/**
	 * 查询全部用于图表
	 * */
	@GetMapping("show")
	public GlobalVo show(){
		List<Integer> view = globalDao.queryView(5);
		List<Integer> online = globalDao.queryOnline(5);
		List<Integer> commoditySellNum = globalDao.queryCommoditySellNum(5);
		List<Integer> turnover = globalDao.queryTurnover(5);
		List<Integer> userNum = globalDao.queryUserNum(5);
		List<Integer> commodityNum = globalDao.queryCommodityNum(5);
		return new GlobalVo(200, "success", 5, view, online, commoditySellNum, turnover, userNum, commodityNum);
	}
	
	/**
	 * 获取网站近五日的访问量
	 * */
	@GetMapping("view")
	public DataVo<List<Integer>> view(){
		List<Integer> data = globalDao.queryView(5);
		return new DataVo<List<Integer>>(200, "success", data.size(), data);
	}
	
	/**
	 * 获取网站近五日的在线人数
	 * */
	@GetMapping("online")
	public DataVo<List<Integer>> online(){
		List<Integer> data = globalDao.queryOnline(5);
		return new DataVo<List<Integer>>(200, "success", data.size(), data);
	}
	
	/**
	 * 获取网站近五日的商品售出数量
	 * */
	@GetMapping("commoditySellNum")
	public DataVo<List<Integer>> commoditySellNum(){
		List<Integer> data = globalDao.queryCommoditySellNum(5);
		return new DataVo<List<Integer>>(200, "success", data.size(), data);
	}
	
	/**
	 * 获取网站近五日的营业额
	 * */
	@GetMapping("turnover")
	public DataVo<List<Integer>> turnover(){
		List<Integer> data = globalDao.queryTurnover(5);
		return new DataVo<List<Integer>>(200, "success", data.size(), data);
	}
	
	/**
	 * 获取网站近五日的用户数量
	 * */
	@GetMapping("userNum")
	public DataVo<List<Integer>> userNum(){
		List<Integer> data = globalDao.queryUserNum(5);
		return new DataVo<List<Integer>>(200, "success", data.size(), data);
	}
	
	/**
	 * 获取网站近五日的商品数量
	 * */
	@GetMapping("commodityNum")
	public DataVo<List<Integer>> commodityNum(){
		List<Integer> data = globalDao.queryCommodityNum(5);
		return new DataVo<List<Integer>>(200, "success", data.size(), data);
	}

}
