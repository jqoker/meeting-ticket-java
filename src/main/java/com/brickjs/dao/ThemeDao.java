/**
 * 
 */
package com.brickjs.dao;

import java.util.List;
import java.util.Map;

import com.brickjs.dao.common.CrudDao;
import com.brickjs.entity.Theme;

/**
 * @author yuhongliang
 *
 */
public interface ThemeDao extends CrudDao<Theme> {
	/**
	 * 查询会议下的主题
	 * @return
	 */
	List<Theme> findThemeByMeetId(int meetId);
	
	/**
	 * 根据ids查询主题
	 * @param ids
	 * @return
	 */
	List<Theme> findThemeByIds(List<Integer> ids);
	
	/**
	 * 根据ids更新主题所属会议id
	 * 入参类型
	 * {
	 * 		"meetId": ...,
	 * 		"ids": [....]
	 * }
	 * @param map
	 * @return
	 */
	int updateThemeMeetIdByIds(List<Map<String, Integer>> ids);
}
