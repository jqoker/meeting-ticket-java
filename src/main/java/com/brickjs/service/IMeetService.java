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
public interface IMeetService {
	
	/**
	 * 所有会议
	 * @return
	 */
	List<Meet> getAllMeets();

	/**
	 * 类别下会议
	 * @param categoryId
	 * @return
	 */
	List<Meet> getMeetsByCategoryId(int categoryId);
	
	/**
	 * 查询指定会议
	 * @param meetId
	 * @return
	 */
	Meet getMeetById(int meetId);
	 
	 /**
	  * 删除会议
	  * @param meetId
	  */
	 void deleteMeetById(int meetId);
	 
	 /**
	  * 更新会议
	  * @param meet
	  * @return
	  */
	 int updateMeet(Meet meet);
}
