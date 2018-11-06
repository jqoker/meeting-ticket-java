/**
 * 
 */
package com.hailooo.service;

import java.util.List;
import java.util.Map;

import com.hailooo.entity.Theme;

/**
 * @author yuhongliang
 *
 */
public interface ThemeService extends BaseService<Theme> {
	
	/**
	 * 获取会议下的主题
	 * @param meetId
	 * @return
	 */
	List<Theme> getThemesByMeetId(int meetId);
	
	/**
	 * 更新主题会议id
	 * @param map
	 * @return
	 */
	int updateThemeMeetId(List<Map<String, Integer>> ids);

	/**
	 * 所有未被占用的主题
	 * 会议id=0
	 * @return
	 */
	public List<Theme> listAllAvailableTheme();
}
