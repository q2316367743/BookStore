package com.qsd.bookstore.util;

import java.util.UUID;

/**
 * @Description 工具类
 * @Author Esion
 * @Data 2020年6月3日
 */

public class SimpleUtil {

	public static String generateUUID() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		return uuid;
	}
	
}
