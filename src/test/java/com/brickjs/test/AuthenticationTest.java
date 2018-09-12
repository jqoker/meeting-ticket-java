package com.brickjs.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class AuthenticationTest {
	
	CustomRealm customRealm = new CustomRealm();

	@Test
	public void testAuthentication() {
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(customRealm);
		
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("yuhongliang", "000000");
		
		subject.login(token);
		
		System.out.println("isAuthentication -> " + subject.isAuthenticated());
		
		subject.checkRole("admin");
		subject.checkPermission("user:delete");
	}
}
