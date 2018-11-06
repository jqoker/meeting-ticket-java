package com.hailooo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hailooo.dao.UserDao;
import com.hailooo.entity.User;
import com.hailooo.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Autowired
	private UserDao userDao;

	
	/**
	 * 根据邮箱获取用户
	 */
	public User getUserByEmail(String email) {
		return userDao.findUserByEmail(email);
	}

}
