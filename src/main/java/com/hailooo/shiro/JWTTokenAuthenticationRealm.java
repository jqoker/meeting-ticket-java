/**
 * 
 */
package com.hailooo.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hailooo.entity.User;
import com.hailooo.service.UserService;
import com.hailooo.utils.JWTTokenUtil;

/**
 * @author hongliang.yu
 * 自定义realm
 */
public class JWTTokenAuthenticationRealm extends AuthorizingRealm {
	
	private static final String REALM_NAME = "jwtLoginVerfiyRealm";
	
	@Autowired
	private UserService loginAccountService;
	
	/**
	 * 设定realm支持该类型token
	 */
	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof AuthenticationToken;
	}

	/**
	 * 授权过程
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 授权过程
		return null;
	}

	/**
	 * 认证过程
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 认证过程
		String authToken = (String) token.getPrincipal();
		// token中析出用户名
		String account = JWTTokenUtil.getPrincipal(authToken);
		// 登录用户、需处理异常情况
		try {
			User sysUserInfo = loginAccountService.getUserByEmail(account);
			// 密码
			String sysUserPasswordInfo = sysUserInfo.getPassword();
			
			// 验证不通过
			if (!JWTTokenUtil.verify(authToken, account, sysUserPasswordInfo)) {
				return null;
			}
		} catch(Exception e) {
			return null;
		}
		return new SimpleAuthenticationInfo(authToken, authToken, REALM_NAME);
	}

}
