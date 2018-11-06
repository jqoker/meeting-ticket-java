package com.hailooo.dao;

import org.springframework.stereotype.Repository;

import com.hailooo.dao.common.CrudDao;
import com.hailooo.entity.User;


@Repository
public interface UserDao extends CrudDao<User> {
	
	/**
	 * 根据邮箱获取用户
	 * @param email
	 * @return
	 */
	User findUserByEmail(String email);
}
