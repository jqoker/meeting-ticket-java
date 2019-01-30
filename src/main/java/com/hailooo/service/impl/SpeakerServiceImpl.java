/**
 * 
 */
package com.hailooo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hailooo.dao.SpeakerDao;
import com.hailooo.entity.Speaker;
import com.hailooo.service.SpeakerService;

/**
 * @author yuhongliang
 *
 */
@Service
public class SpeakerServiceImpl extends BaseServiceImpl<Speaker> implements SpeakerService {
	
	@Autowired
	private SpeakerDao authorDaoService;
	
	/// 更加用户名查询
	public List<Speaker> getAuthorByName(String name) {
		return authorDaoService.get(name);
	}
	
	/**
	 * 保存嘉宾
	 * @param authors
	 * @return
	 */
	@Override
	public int save(List<Speaker> authors) {
		return authorDaoService.insert(authors);
	}

	// 查询全部
	@Override
	public List<Speaker> listAll() {
		return authorDaoService.findAllList();
	}

	// 删除
	@Override
	public int remove(int id) {
		return authorDaoService.delete(new Speaker(id));
	}
	
	// 更新
	@Override
	public int update(Speaker author) {
		return authorDaoService.update(author);
	}

}
