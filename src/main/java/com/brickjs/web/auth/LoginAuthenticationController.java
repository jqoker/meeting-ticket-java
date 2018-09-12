/**
 * 
 */
package com.brickjs.web.auth;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brickjs.constant.HttpStatusCode;
import com.brickjs.entity.User;
import com.brickjs.shiro.JWTAuthenticationToken;
import com.brickjs.utils.JWTTokenUtil;
import com.brickjs.vo.out.AjaxCommonResponse;

/**
 * @author yuhongliang
 * 登录控制
 */
@RestController
@RequestMapping("/meeting/e/ajax/u/")
public class LoginAuthenticationController {
	
	/**
	 * 登录
	 * @param loginUser(登录用户)
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public AjaxCommonResponse<Map<String, String>> login(@RequestBody User loginUser) {
		// 取出登录名、密码
		final String loginEmail = loginUser.getEmail();
		final String loginPassword = loginUser.getPassword();
		
		/// 执行登录操作
		try {
			/// 创建登录token
			final String token = JWTTokenUtil.sign(loginEmail, loginPassword);
			JWTAuthenticationToken jwtToken = new JWTAuthenticationToken(token);
			Subject subject = SecurityUtils.getSubject();
			subject.login(jwtToken);

			Map<String, String> map = new HashMap<String, String>(){/**
				 * 
				 */
				private static final long serialVersionUID = -4560909169641165624L;
			{
				put("u", loginEmail);
			}};
			return new AjaxCommonResponse<Map<String, String>>(HttpStatusCode.HTTP_CODE_OK, map); 
		} catch (Exception e) {
			System.out.println(e);
			return new AjaxCommonResponse<Map<String, String>>(HttpStatusCode.HTTP_NO_AUTHENTICATION_CODE);
		}
	}
	
	/**
	 * 登出
	 * @return
	 */
	@RequestMapping("/logout")
	public AjaxCommonResponse<Map<String, String>> logout() {
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.logout();
			return new AjaxCommonResponse<Map<String,String>>(HttpStatusCode.HTTP_CODE_OK);
		} catch (Exception e) {
			return new AjaxCommonResponse<Map<String,String>>(HttpStatusCode.HTTP_CODE_ERR);
		}
	}
}
