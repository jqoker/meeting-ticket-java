/**
 * 
 */
package com.hailooo.service;

import java.util.List;

import com.hailooo.entity.Author;

/**
 * @author yuhongliang
 *
 */
public interface AuthorService extends BaseService<Author> {
	
	/**
	 * 名称查询用户
	 * @param name
	 */
	public List<Author> getAuthorByName(String name);
}
