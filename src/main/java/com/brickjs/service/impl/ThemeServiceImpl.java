/**
 * 
 */
package com.brickjs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brickjs.dao.ThemeDao;
import com.brickjs.entity.Theme;
import com.brickjs.service.IThemeService;

/**
 * @author yuhongliang
 *
 */
@Service
public class ThemeServiceImpl implements IThemeService {
	
	@Autowired
	private ThemeDao themeDaoService;


	public Boolean save(List<Theme> themes) {
		try {
			themeDaoService.insert(themes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Theme> getThemesByMeetId(int meetId) {
		try {
			return themeDaoService.findThemeByMeetId(meetId);
		} catch(Exception e) {
			return null;
		}
	}

	public List<Theme> getAllTheme() {
		return themeDaoService.findAllList();
	}

	public List<Theme> getThemeByIds(List<Integer> ids) {
		return themeDaoService.findThemeByIds(ids);
	}

	public int updateThemeMeetId(List<Map<String, Integer>> ids) {
		return themeDaoService.updateThemeMeetIdByIds(ids);
	}

	public int deleteTheme(int id) {
		return themeDaoService.delete(new Theme(id));
	}

}
