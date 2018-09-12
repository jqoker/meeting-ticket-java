/**
 * 
 */
package com.brickjs.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.brickjs.dao.common.CrudDao;
import com.brickjs.entity.Meet;

/**
 * @author yuhongliang
 *
 */
@Repository
public interface MeetDao extends CrudDao<Meet> {
	
	/**
	 * 查询某一类别下的会议
	 * @param categoryId
	 * @return
	 */
	List<Meet> findMeetByCid(int cid);
}
