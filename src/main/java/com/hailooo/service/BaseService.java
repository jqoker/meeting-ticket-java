/**
 * 
 */
package com.hailooo.service;

import java.util.List;

/**
 * @author yuhongliang
 *
 */
public interface BaseService<T> {
	
	 /**
	  * 查询所有
	  * @return
	  */
	 List<T> listAll();
	 
	 /**
	  * 指定id下的全部结果
	  * @param id
	  * @return
	  */
	 List<T> listAll(int id);
	
	 /**
	  * 保存
	  * @param t
	  * @return
	  */
	 int save(T t);
	 
	 /**
	  * 批量保存
	  * @param list
	  * @return
	  */
	 int save(List<T> list);
	 
	 /**
	  * 删除
	  * @param id
	  */
	 int remove(int id);
	 
	 /**
	  * 更新
	  * @param meet
	  * @return
	  */
	 int update(T t);
	 
	 /**
	  * 详情
	  * @param id
	  * @return
	  */
	 T detail(int id);
}
