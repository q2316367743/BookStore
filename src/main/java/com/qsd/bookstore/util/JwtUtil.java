package com.qsd.bookstore.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.qsd.bookstore.dto.UserByLogin;

import cn.hutool.core.util.IdUtil;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月12日
 */

public class JwtUtil {
	
	/**
	 * 设置过期时间15分钟
	 * */
	private static final long EXPIRE_TIME = 15 * 60 * 1000;
	/**
	 * tocken私钥
	 * */
	private static final String TOKEN_SECRET = IdUtil.simpleUUID();;
	
	/**
	 * 生成签名，15分钟后过期
	 * 
	 * @param user 用户信息
	 * @return 加密的token
	 * */
	public static String sign(UserByLogin user) {
		try {
			Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
			Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
			Map<String, Object> map = new HashMap<>();
			map.put("typ", "JWT");
			map.put("alg", "HS256");
			return JWT.create().withHeader(map)
							   .withClaim("username", user.getUsername())
							   .withClaim("password", user.getPassword())
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
			DecodedJWT verify = verifier.verify(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 获取token中的用户名
	 * 
	 * @param token token字符串
	 * @return 用户名
	 * */
	public static String getUsername(String token) {
		try {
			DecodedJWT decode = JWT.decode(token);
			return decode.getClaim("username").asString();
		} catch (Exception e) {
			return null;
		}
	}

}
