/**
 * 
 */
package com.hailooo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hailooo.dao.common.CrudDao;
import com.hailooo.entity.Meet;

/**
 * @author hongliang.yu
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
