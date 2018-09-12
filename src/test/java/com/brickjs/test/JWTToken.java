/**
 * 
 */
package com.brickjs.test;

import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @author yuhongliang
 *
 */
public class JWTToken {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try {
			Algorithm algorithm = Algorithm.HMAC256("secret");
			String token = JWT.create()
					.withIssuer("auth0")
					.withClaim("name", 123)
					.withArrayClaim("array", new Integer[]{1, 2, 3})
					.sign(algorithm);
			System.out.println(token);
		} catch (JWTCreationException e) {
			// TODO: handle exception
			System.out.println("JWTCreationException");
		}
		
		String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhcnJheSI6WzEsMiwzXSwiaXNzIjoiYXV0aDAiLCJuYW1lIjoxMjN9.2tiN4FnxWnkEVp3WcZsWMfwSCMFUAy_pZDLkTjW1rMk";
		try {
			DecodedJWT jwt = JWT.decode(token);
			
			Map<String, Claim> claims = jwt.getClaims();
			Claim claim = claims.get("array");
			System.out.println(claim.asList(Integer.class));
//			System.out.println(claim.asInt());
			
		} catch (JWTDecodeException e) {
			// TODO: handle exception
		}
		
		try {
			Algorithm algorithm = Algorithm.HMAC256("secret");
			JWTVerifier verifier = JWT.require(algorithm)
					.withClaim("name", 123)
					.build();
			DecodedJWT jwt = verifier.verify(token);
		} catch (JWTVerificationException e) {
			// TODO: handle exception
			System.out.println("JWTVerificationException");
		}

	}

}
