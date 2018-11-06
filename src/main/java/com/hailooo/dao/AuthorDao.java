package com.hailooo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hailooo.dao.common.CrudDao;
import com.hailooo.entity.Author;

@Repository
public interface AuthorDao extends CrudDao<Author> {

	/**
	 * 根据用户名查询用户
	 * @param name
	 * @return
	 */
	List<Author> get(String name);
}
