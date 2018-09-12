/**
 * 
 */
package com.brickjs.service;

import java.util.List;

import com.brickjs.entity.Author;

/**
 * @author yuhongliang
 *
 */
public interface IAuthorService {
	
	/**
	 * 获取全部嘉宾
	 * @return
	 */
	public List<Author> getAllAuthorList();

	/**
	 * 保存嘉宾
	 * @param author
	 */
	public int save(List<Author> authors);
	
	/**
	 * 名称查询用户
	 * @param name
	 */
	public List<Author> getAuthorByName(String name);
	
	/**
	 * 删除嘉宾
	 * @param id
	 * @return
	 */
	int deleteAuthor(int id);
}
