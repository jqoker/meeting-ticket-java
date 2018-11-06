/**
 * 
 */
package com.hailooo.dao;

import java.util.List;
import java.util.Map;

import com.hailooo.dao.common.CrudDao;
import com.hailooo.entity.Theme;

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
	 * 根据ids更新主题所属会议id
	 * 入参类型
	 *  "ids": [
	 *  	{
	 *  		"id": ...,	主题id
	 *  		"meetId: ... 会议id
	 *  	}
	 *  	...
	 *  ]
	 * @param list
	 * @return
	 */
	int updateThemeMeetIdByIds(List<Map<String, Integer>> ids);
	
	/**
	 * 查询所有未被占用的主题
	 * 会议id=0
	 * @return
	 */
	List<Theme> findAllAvailableList();
}
