/**
 * 
 */
package com.brickjs.utils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yuhongliang
 * 实用工具类
 */
public class WebUtil {
	
	/**
	 * 转换http request|response
	 * @param request
	 * @return
	 */
	public static HttpServletRequest toHttpRequest(ServletRequest request) {
		return (HttpServletRequest)request;
	}
	public static HttpServletResponse toHttpResponse(ServletResponse response) {
		return (HttpServletResponse)response;
	}

}
