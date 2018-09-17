/**
 * 
 */
package com.brickjs.dao.common;

import java.util.List;

/**
 * @author yuhongliang
 * dao泛型接口，定义通用处理
 */
public interface CrudDao<T> extends BaseDao {
	
	/**
	 * 查询单个记录
	 * @param id
	 * @return
	 */
	public T get(int id);
	
	/**
	 * 查询单个记录
	 * @param entity
	 * @return
	 */
	public T get(T entity);
	
	/**
	 * 记录集合
	 * @return
	 */
	public List<T> findAllList();
	
	/**
	 * 指定id下记录集合
	 * @return
	 */
	public List<T> findAllList(int id);
	
	/**
	 * 插入记录
	 * @param entity
	 * @return
	 */
	public int insert(T entity);
	
	/**
	 * 批量插入数据集
	 * @param list
	 * @return
	 */
	public int insert(List<T> list);
	
	/**
	 * 更新记录
	 * @param entity
	 * @return
	 */
	public int update(T entity);
	
	/**
	 * 删除记录
	 * @param entity
	 * @return
	 */
	public int delete(T entity);
	
	/**
	 * 删除记录
	 * @param id
	 * @return
	 */
	@Deprecated
	public int delete(int id);
}
