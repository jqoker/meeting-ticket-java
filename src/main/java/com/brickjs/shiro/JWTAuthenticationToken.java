/**
 * 
 */
package com.brickjs.shiro;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author hongliang.yu
 * 自定义认证token
 */
public class JWTAuthenticationToken implements AuthenticationToken  {

	private static final long serialVersionUID = -5626308284976909513L;
	
	private String token;
	
	public JWTAuthenticationToken(String token) {
		this.token = token;
	}

	public Object getPrincipal() {
		return token;
	}

	public Object getCredentials() {
		return token;
	}

}
