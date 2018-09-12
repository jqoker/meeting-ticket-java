/**
 * 
 */
package com.brickjs.service;

import java.util.List;
import java.util.Map;

import com.brickjs.entity.Theme;

/**
 * @author yuhongliang
 *
 */
public interface IThemeService {
	
	/**
	 * 获取所有主题
	 * @return
	 */
	List<Theme> getAllTheme();
	
	/**
	 * 获取会议下的主题
	 * @param meetId
	 * @return
	 */
	List<Theme> getThemesByMeetId(int meetId);
	
	/**
	 * 返回指定ids主题
	 * @param ids
	 * @return
	 */
	List<Theme> getThemeByIds(List<Integer> ids);
	
	
	/**
	 * 更新主题会议id
	 * @param map
	 * @return
	 */
	int updateThemeMeetId(Map<String, Object> map);

	/**
	 * 创建主题
	 * @param theme
	 * @return
	 */
	Boolean save(List<Theme> themes);
	
	/**
	 * 删除主题
	 * @param id
	 * @return
	 */
	int deleteTheme(int id);
	
	/**
	 * 释放主题
	 * @param theme
	 * @return
	 */
	int deliveryTheme(int id);
}
