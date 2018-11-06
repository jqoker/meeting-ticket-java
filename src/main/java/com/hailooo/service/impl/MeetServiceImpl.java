/**
 * 
 */
package com.hailooo.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hailooo.dao.MeetDao;
import com.hailooo.dao.ThemeDao;
import com.hailooo.entity.Meet;
import com.hailooo.entity.Theme;
import com.hailooo.service.MeetService;

/**
 * @author yuhongliang
 *
 */
@Service
public class MeetServiceImpl extends BaseServiceImpl<Meet> implements MeetService {
	@Autowired
	private MeetDao meetingDaoService;
	@Autowired
	private ThemeDao themeDaoService;

	/**
	 * 类别下会议
	 */
	public List<Meet> getAllMeetsByCategoryId(int categoryId) {
		return meetingDaoService.findMeetByCid(categoryId);
	}
	
	/**
	 * 获取会议列表
	 * 避开限制
	 * https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/Important.md
	 * 此处采用遍历取数。而不是联合查询
	 */
	@Override
	public List<Meet> listAll() {
		List<Meet> queryAllMeets = meetingDaoService.findAllList();
		// TODO 此处遍历性能问题优化
		// 比如接入redis服务
		for (Meet currentMeet : queryAllMeets) {
			List<Theme> accordingThemes = themeDaoService.findThemeByMeetId(currentMeet.getId());
			currentMeet.setThemes(accordingThemes);
		}
		return queryAllMeets;
	}

	/**
	 * 创建会议
	 */
	@Override
	@Transactional
	public int save(Meet meet) {
		List<Map<String, Integer>> ids = meet.getIds();
		// 插入会议, 返回影响行数
		int count = meetingDaoService.insert(meet);
		// 更新主题所属会议id
		Integer lastInsertMeetId = meet.getId();
		for (Iterator<Map<String, Integer>> iterator = ids.iterator(); iterator.hasNext();) {
			Map<String, Integer> map = (Map<String, Integer>) iterator.next();
			map.replace("meetId", lastInsertMeetId);
		}
		themeDaoService.updateThemeMeetIdByIds(ids);
		return count;
	}

	/**
	 * 删除会议
	 */
	@Override
	public int remove(int id) {
		return meetingDaoService.delete(new Meet(id));
	}

	 /**
	  * 更新会议
	  * @param meet
	  * @return
	  */
	@Override
	@Transactional
	public int update(Meet meet) {
		List<Map<String, Integer>> ids = meet.getIds();
		// 更新主题所属会议ID
		themeDaoService.updateThemeMeetIdByIds(ids);
		return meetingDaoService.update(meet);
	}

	/**
	 * 会议详情
	 */
	@Override
	public Meet detail(int id) {
		return meetingDaoService.get(id);
	}

}
