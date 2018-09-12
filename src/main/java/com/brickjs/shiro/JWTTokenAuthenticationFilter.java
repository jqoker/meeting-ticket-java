/**
 * 
 */
package com.brickjs.shiro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brickjs.utils.WebUtil;

/**
 * @author yuhongliang
 * shiro自定义过滤器
 */
public class JWTTokenAuthenticationFilter extends BasicHttpAuthenticationFilter {
	
	/**
	 * 定义常量
	 */
//	private final static int TOKEN_COOKIE_MAX_AGE = 3 * 60 * 60;
	private final static String TOKEN_COOKIE_NAME = "_u_token";
	
	/**
	 * 是否需要验证
	 */
	@Override
	protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
		return true;
//		HttpServletRequest httpRequest = WebUtil.toHttp(request);
//		String jwtToken = null;
//		Cookie[] cookies = httpRequest.getCookies();
//		for (Cookie cookie : cookies) {
//			if (cookie.getName().equals(TOKEN_COOKIE_NAME)) {
//				jwtToken = cookie.getValue();
//				break;
//			}
//		}
//		return jwtToken != null;
	}
	
	/**
	 * 尝试执行登录
	 */
	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpRequest = WebUtil.toHttpRequest(request);
		
		String jwtToken = null;
		Cookie[] cookies = httpRequest.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(TOKEN_COOKIE_NAME)) {
				jwtToken = cookie.getValue();
				break;
			}
		}
		// 从cookie中取出token
		JWTAuthenticationToken token = new JWTAuthenticationToken(jwtToken);
		
		// 执行登录
		try {
			Subject subject = getSubject(request, response);
			subject.login(token);
			return onLoginSuccess(token, subject, httpRequest, response);
		} catch (AuthenticationException e) {
			return onLoginFailure(token, e, httpRequest, response);
		}
	}
	
	/**
	 * 成功
	 */
	@Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject,
            ServletRequest request, ServletResponse response) throws Exception {
        /// 将登录token添加至cookie
//        String jwtToken = (String)token.getPrincipal();
//        SimpleCookie cookie = new SimpleCookie(TOKEN_COOKIE_NAME);
//        cookie.setHttpOnly(true);
//        cookie.setMaxAge(TOKEN_COOKIE_MAX_AGE);
//        cookie.setValue(jwtToken);
//        cookie.saveTo(WebUtil.toHttp(request), WebUtil.toHttp(response));
		return true;
	}
	
	/**
	 * 失败
	 */
	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e,
	            ServletRequest request, ServletResponse response) {
		return false;
	}
	
	
	/**
	 * 是否允许访问
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		// 是否允许被访问
		return getSubject(request, response).isAuthenticated();
	}
	
	/**
	 * 请求未验证被拦截
	 * 只有isAccessAllowed返回false，onAccessDenied才会执行
	 * 只有isAccessAllowed或onAccessDenied返回true时，才允许执行doFilter()
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		boolean loggedIn = false;
		if (isLoginAttempt(request, response)) {
			loggedIn = executeLogin(request, response);
		}
		if (!loggedIn) {
			sendLoginChallenge(request, response);
		}
		return loggedIn;
	}
	
	/**
	 * 登录失败
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	protected boolean sendLoginChallenge(ServletRequest request, ServletResponse response) throws IOException {
		response.setContentType("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			out.write("{\"code\":403,\"message\":\"no authenticate,forbidden\"}");
		} finally {
			out.close();
		}
		return false;
	}
	
	/**
	 * 预处理
	 */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
    	// 跨域处理
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        
        // options请求，不处理
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

}
