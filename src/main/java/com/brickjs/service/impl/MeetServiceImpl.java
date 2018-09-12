/**
 * 
 */
package com.brickjs.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brickjs.dao.MeetDao;
import com.brickjs.dao.ThemeDao;
import com.brickjs.entity.Meet;
import com.brickjs.service.IMeetService;

/**
 * @author yuhongliang
 *
 */
@Service
public class MeetServiceImpl implements IMeetService {
	
	@Autowired
	private MeetDao meetingDaoService;
	@Autowired
	private ThemeDao themeDaoService;

	/**
	 * 获取会议列表
	 */
	public List<Meet> getAllMeets() {
		return meetingDaoService.findAllList();
	}

	/**
	 * 类别下会议
	 */
	public List<Meet> getMeetsByCategoryId(int categoryId) {
		return meetingDaoService.findMeetByCid(categoryId);
	}

	/**
	 * 创建会议
	 */
	@Transactional
	public void save(Meet meet) {
		// 插入会议
		meetingDaoService.insert(meet);
		List<Integer> ids = meet.getIds();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("meetId", meet.getId());
		map.put("ids", ids);
		
		// 更新主题所属会议ID
		themeDaoService.updateThemeMeetIdByIds(map);
	}

	/**
	 * 查询指定会议
	 */
	public Meet getMeetById(int meetId) {
		return meetingDaoService.get(meetId);
	}

	/**
	 * 删除会议
	 */
	public void deleteMeetById(int id) {
		meetingDaoService.delete(new Meet(id));
	}

	 /**
	  * 更新会议
	  * @param meet
	  * @return
	  */
	@Transactional
	public int updateMeet(Meet meet) {
		List<Integer> ids = meet.getIds();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("meetId", meet.getId());
		map.put("ids", ids);
		// 更新主题所属会议ID
		themeDaoService.updateThemeMeetIdByIds(map);
		return meetingDaoService.update(meet);
	}

}
