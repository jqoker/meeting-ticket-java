/**
 *
 */
package com.hailooo.service.impl;

import java.util.List;

import com.hailooo.service.BaseService;
import com.hailooo.vo.in.QueryMeetReqParam;

/**
 * @author yuhongliang
 * 定义实现泛型接口的基类
 * 以保证继承类不因为接口变化而修改代码，只需要覆写需要实现的方法即可
 */
public class BaseServiceImpl<T> implements BaseService<T> {

	// 保存
	public int save(T t) {
		return 0;
	}

	// 批量保存
	public int save(List<T> list) {
		return 0;
	}

	// 删除
	public int remove(int id) {
		return 0;
	}

	// 更新
	public int update(T t) {
		return 0;
	}

	// 详情
	public T detail(int id) {
		return null;
	}

	// 查询所有
	public List<T> listAll(QueryMeetReqParam param) {
		return null;
	}

	// 指定id下的全部
	public List<T> listAll(int id) {
		return null;
	}

	public List<T> listAll() {
		return null;
	}
}
