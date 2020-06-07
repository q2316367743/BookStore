package com.qsd.bookstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.Record;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月3日
 */

public interface RecordDao {

	/**
	 * 根据记录表名创建记录表
	 * @param recordName 记录表名
	 * */
	void createRecordTable(String recordName);
	/**
	 * 根据记录表名删除记录表
	 * @param recordName 记录表名
	 * */
	Integer deleteRecordTable(String recordName);
	/**
	 * 向记录表中新增一条数据
	 * @param record 记录
	 * */
	Integer addRecord(Record record);
	/**
	 * 根据记录表名查询全部记录
	 * @param recordName 记录表名
	 * @return 全部商品数据
	 * */
	List<Commodity> queryAllRecord(String recordName);
	/**
	 * 根据记录表名，商品ID查询数据库中是否存在记录
	 * @param recordName 记录表名
	 * @param commodityId 商品ID
	 * @return 是否存在
	 * */
	Integer queryRecordByCommodityId(@Param("recordName") String recordName, @Param("commodityId") int commodityId);
	
}
