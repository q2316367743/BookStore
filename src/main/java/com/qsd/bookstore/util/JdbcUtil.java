package com.qsd.bookstore.util;

import java.util.List;

import com.qsd.bookstore.vo.PageVo;

/**
 * @Description 数据库工具类
 * @Author Esion
 * @Data 2020年6月15日
 */

public class JdbcUtil {

	//分页插件实现
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static PageVo PageUtil(int page, int limit, List data){
		//结果集的容量
		int size = data.size();
		//总共的页数
		int count = size / limit + 1;
		if(page <= count) {
			int fromIndex = (page - 1) * limit;
			int toIndex = fromIndex;
			if (size - fromIndex > limit) {
				toIndex = fromIndex + limit;
			}else {
				toIndex = size;
			}
			List result = data.subList(fromIndex, toIndex);
			return new PageVo(count, result);
		}else {
			return new PageVo(count, null);
		}
		
	}
	
}
