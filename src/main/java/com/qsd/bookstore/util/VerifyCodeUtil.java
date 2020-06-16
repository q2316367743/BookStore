package com.qsd.bookstore.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import cn.hutool.core.util.IdUtil;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月16日
 */

public class VerifyCodeUtil {
	
	/**
	 * 设置文件过期时间5分钟
	 * */
	private static final long CODE_EXPIRE_TIME = 5 * 60 * 1000;
	/**
	 * tocken私钥
	 * */
	private static final String TOKEN_SECRET = IdUtil.simpleUUID();

	/**
	 * 生成验证码签名，1分钟后过期
	 * 
	 * @param code 验证码答案
	 * @return 加密的token
	 * */
	public static String sign(String code) {
		try {
			Date date = new Date(System.currentTimeMillis() + CODE_EXPIRE_TIME);
			Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
			Map<String, Object> map = new HashMap<>();
			map.put("typ", "JWT");
			map.put("alg", "HS256");
			return JWT.create().withHeader(map)
							   .withClaim("code", code)
							   .withExpiresAt(date)
							   .sign(algorithm);
		} catch (Exception e) {
			return "";
		}
	}
	
	/**
	 * 检验token是否正确
	 * 
	 * @param token token字符串
	 * @return 过期
	 * */
	public static boolean verify(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
			JWTVerifier verifier = JWT.require(algorithm).build();
			verifier.verify(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 获取token中的验证码答案
	 * 
	 * @param token token字符串
	 * @return 验证码答案
	 * */
	public static boolean verify(String token, String code) {
		boolean real = verify(token);
		if (real) {
			try {
				DecodedJWT decode = JWT.decode(token);
				String result = decode.getClaim("code").asString();
				if (code.equals(result)) {
					return true;
				}
			} catch (Exception e) {
			}
		}
		return false;
	}

}
