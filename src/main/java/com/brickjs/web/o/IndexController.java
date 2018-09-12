/**
 * 
 */
package com.brickjs.web.o;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brickjs.constant.HttpStatusCode;
import com.brickjs.entity.Meet;
import com.brickjs.service.impl.MeetServiceImpl;
import com.brickjs.vo.out.AjaxCommonResponse;

/**
 * @author yuhongliang
 */

@RestController
@RequestMapping("/meeting/o/ajax/")
public class IndexController {
	
	@Autowired
	private MeetServiceImpl meetingService;

	/**
	 * 所有会议
	 * @return
	 */
	@RequestMapping("/meet_list")
	public AjaxCommonResponse<Map<String, Object>> meets(ServletRequest request, ServletResponse response) {
		AjaxCommonResponse<Map<String, Object>> ajaxCommonResponse;
		try {
			// 查询meeting
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("meets", meetingService.getAllMeets());
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, map);
		} catch (Exception e) {
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxCommonResponse;
	}

	/**
	 * 查询指定会议
	 * @param id
	 * @return
	 */
	@RequestMapping("/meet")
	public AjaxCommonResponse<Map<String, Object>> Meet(@RequestParam(required = true) int id) {
		AjaxCommonResponse<Map<String, Object>> ajaxCommonResponse;
		try {
			Meet meet = meetingService.getMeetById(id);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("meet", meet);
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, map);
		} catch (Exception e) {
			System.out.println(e);
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxCommonResponse;
	}
}
