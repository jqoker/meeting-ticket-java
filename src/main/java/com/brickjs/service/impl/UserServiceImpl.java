package com.brickjs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brickjs.dao.UserDao;
import com.brickjs.entity.User;
import com.brickjs.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;

	
	/**
	 * 根据邮箱获取用户
	 */
	public User getUserByEmail(String email) {
		return userDao.findUserByEmail(email);
	}
	
	
}
