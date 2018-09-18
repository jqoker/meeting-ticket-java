/**
 * 
 */
package com.brickjs.service;

import java.util.List;

import com.brickjs.entity.Meet;

/**
 * @author yuhongliang
 *
 */
public interface MeetService extends BaseService<Meet> {

	/**
	 * 类别下会议
	 * @param categoryId
	 * @return
	 */
	List<Meet> getAllMeetsByCategoryId(int categoryId);
}
