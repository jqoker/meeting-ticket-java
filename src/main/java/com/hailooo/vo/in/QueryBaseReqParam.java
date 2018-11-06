/**
 * 
 */
package com.hailooo.vo.in;

/**
 * @author hongliang.yu
 * 请求参数基类
 */
public class QueryBaseReqParam {
	private int page;
	private int pageSize;
	
	public QueryBaseReqParam() {
		
	}
	public QueryBaseReqParam(int page, int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
