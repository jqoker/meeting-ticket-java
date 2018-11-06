/**
 * 
 */
package com.hailooo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hailooo.dao.ThemeDao;
import com.hailooo.entity.Theme;
import com.hailooo.service.ThemeService;

/**
 * @author yuhongliang
 *
 */
@Service
public class ThemeServiceImpl extends BaseServiceImpl<Theme> implements ThemeService {
	
	@Autowired
	private ThemeDao themeDaoService;

	// 会议下的主题
	public List<Theme> getThemesByMeetId(int meetId) {
		try {
			return themeDaoService.findThemeByMeetId(meetId);
		} catch(Exception e) {
			return null;
		}
	}
	
	// 所有未被占用的主题
	// 会议id=0
	public List<Theme> listAllAvailableTheme() {
		return themeDaoService.findAllAvailableList();
	}

	// 更新主题所属会议
	public int updateThemeMeetId(List<Map<String, Integer>> ids) {
		return themeDaoService.updateThemeMeetIdByIds(ids);
	}

	// 保存
	@Override
	public int save(List<Theme> themes) {
		try {
			return themeDaoService.insert(themes);
		} catch (Exception e) {
			return 0;
		}
	}

	// 查询全部
	@Override
	public List<Theme> listAll() {
		return themeDaoService.findAllList();
	}

	// 删除
	@Override
	public int remove(int id) {
		return themeDaoService.delete(new Theme(id));
	}
	
	// 更新
	@Override
	public int update(Theme theme) {
		return themeDaoService.update(theme);
	}

}
