/**
 * 
 */
package com.brickjs.service;

import com.brickjs.entity.User;

/**
 * @author yuhongliang
 *
 */
public interface UserService extends BaseService<User> {
	
	/**
	 * 根据邮箱获取用户
	 * @param email
	 * @return
	 */
	User getUserByEmail(String email);
}
