/**
 * 
 */
package com.hailooo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hailooo.dao.AuthorDao;
import com.hailooo.entity.Author;
import com.hailooo.service.AuthorService;

/**
 * @author yuhongliang
 *
 */
@Service
public class AuthorServiceImpl extends BaseServiceImpl<Author> implements AuthorService {
	
	@Autowired
	private AuthorDao authorDaoService;
	
	/// 更加用户名查询
	public List<Author> getAuthorByName(String name) {
		return authorDaoService.get(name);
	}
	
	/**
	 * 保存嘉宾
	 * @param authors
	 * @return
	 */
	@Override
	public int save(List<Author> authors) {
		return authorDaoService.insert(authors);
	}

	// 查询全部
	@Override
	public List<Author> listAll() {
		return authorDaoService.findAllList();
	}

	// 删除
	@Override
	public int remove(int id) {
		return authorDaoService.delete(new Author(id));
	}
	
	// 更新
	@Override
	public int update(Author author) {
		return authorDaoService.update(author);
	}

}
