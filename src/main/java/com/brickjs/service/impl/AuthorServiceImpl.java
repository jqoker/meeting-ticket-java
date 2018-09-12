/**
 * 
 */
package com.brickjs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brickjs.dao.AuthorDao;
import com.brickjs.entity.Author;
import com.brickjs.service.IAuthorService;

/**
 * @author yuhongliang
 *
 */
@Service
public class AuthorServiceImpl implements IAuthorService {
	
	@Autowired
	private AuthorDao authorDaoService;
	
	/**
	 * 保存嘉宾
	 * @param authors
	 * @return
	 */
	public int save(List<Author> authors) {
		return authorDaoService.insert(authors);
	}


	public List<Author> getAllAuthorList() {
		return authorDaoService.findAllList();
	}


	public List<Author> getAuthorByName(String name) {
		// TODO Auto-generated method stub
		return authorDaoService.get(name);
	}


	public int deleteAuthor(int id) {
		return authorDaoService.delete(new Author(id));
	}

}
