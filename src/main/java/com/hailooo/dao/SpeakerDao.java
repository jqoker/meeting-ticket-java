package com.hailooo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hailooo.dao.common.CrudDao;
import com.hailooo.entity.Speaker;

@Repository
public interface SpeakerDao extends CrudDao<Speaker> {

	/**
	 * 根据用户名查询用户
	 * @param name
	 * @return
	 */
	List<Speaker> get(String name);
}
