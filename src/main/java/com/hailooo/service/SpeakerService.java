/**
 * 
 */
package com.hailooo.service;

import java.util.List;

import com.hailooo.entity.Speaker;

/**
 * @author yuhongliang
 *
 */
public interface SpeakerService extends BaseService<Speaker> {
	
	/**
	 * 名称查询用户
	 * @param name
	 */
	public List<Speaker> getAuthorByName(String name);
}
