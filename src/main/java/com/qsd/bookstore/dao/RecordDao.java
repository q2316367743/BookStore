package com.qsd.bookstore.dao;

import java.util.List;

import com.qsd.bookstore.po.Commodity;
import com.qsd.bookstore.po.Record;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月3日
 */

public interface RecordDao {

	void createRecordTable(String recordName);
	Integer deleteRecordTable(String recordName);
	Integer addRecord(Record record);
	List<Commodity> queryAllRecord(String recordName);
	
}
