package com.hailooo.utils;

import java.util.Date;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @author hongliang.yu
 */
public class JWTTokenUtil {
	
	// 过期时间
	private static final long EXPIRE_TIME = 60 * 60 * 1000;
	
	// 定义用户标识
	private static final String PRINCIPAL = "_u";
	
	// 校验
	@SuppressWarnings("unused")
	public static boolean verify(String token, String principal, String secret) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			JWTVerifier verifier = JWT.require(algorithm)
					.withClaim(PRINCIPAL, principal)
					.build();
			DecodedJWT jwt = verifier.verify(token);
			return true;
		} catch (JWTVerificationException e) {
			return false;
		}
	}
	
	// 获取凭证
	public static String getPrincipal(String token) {
		try {
			DecodedJWT jwt = JWT.decode(token);
			return jwt.getClaim(PRINCIPAL).asString();
		} catch (JWTDecodeException e) {
			return null;
		}
	}
	
	// 签名
	public static String sign(String username, String secret) {
		Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create()
					.withClaim(PRINCIPAL, username)
					.withExpiresAt(date)
					.sign(algorithm);
			return token;
		} catch (JWTCreationException e) {
			return null;
		}
	}
}
