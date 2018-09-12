/**
 * 
 */
package com.brickjs.vo.out;

import com.brickjs.constant.HttpStatusCode;

/**
 * @author yuhongliang
 *
 */
public class AjaxCommonResponse<T> {
	// 定义常量
	private final static String HTTP_SUCCESS_INFO = "success";
	private final static String HTTP_FAIL_INFO = "fail";
	// 状态码
	protected int code;
	// 说明信息
	protected String message;
	// 响应数据
	protected T data;
	
	public AjaxCommonResponse() {
		
	}
	
	public AjaxCommonResponse(int code, T data) {
		this.code = code;
		this.message = (code == HttpStatusCode.HTTP_CODE_OK ? HTTP_SUCCESS_INFO : HTTP_FAIL_INFO);
		this.data = data;
	}
	
	public AjaxCommonResponse(int code) {
		this(code, null);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
