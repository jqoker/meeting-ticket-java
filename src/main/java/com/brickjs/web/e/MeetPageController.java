/**
 * 
 */
package com.brickjs.web.e;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brickjs.constant.HttpStatusCode;
import com.brickjs.entity.Meet;
import com.brickjs.service.impl.MeetServiceImpl;
import com.brickjs.vo.out.AjaxCommonResponse;

/**
 * @author yuhongliang
 *
 */

@RestController
@RequestMapping("/meeting/e/ajax/")
public class MeetPageController {
	
	@Autowired
	private MeetServiceImpl meetingService;
	
	/**
	 * 所有会议
	 * @return
	 */
	@RequestMapping("/meet/list")
	public AjaxCommonResponse<Map<String, Object>> meets(ServletRequest request, ServletResponse response) {
		AjaxCommonResponse<Map<String, Object>> ajaxCommonResponse;
		try {
			// map
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("meets", meetingService.getAllMeets());
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, map);
		} catch (Exception e) {
			System.out.println(e);
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxCommonResponse;
	}
	
	/**
	 * 类别下所有会议
	 * @param cid
	 * @return
	 */
	@RequestMapping("/meet/category")
	public AjaxCommonResponse<Map<String, Object>> meets_in_category(@RequestParam(required = true) int id) {
		AjaxCommonResponse<Map<String, Object>> ajaxCommonResponse;
		try {
			// map
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("meets", meetingService.getMeetsByCategoryId(id));
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, map);
		} catch (Exception e) {
			System.out.println(e);
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxCommonResponse;
	}
	
	/**
	 * 创建会议
	 * @param vo
	 * @return
	 */
	@RequestMapping("/meet/create")
	public AjaxCommonResponse<Map<String, Object>> createMeet(@RequestBody Meet meet) {
		AjaxCommonResponse<Map<String, Object>> ajaxCommonResponse;
		try {
			meetingService.save(meet);
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK);
		} catch (Exception e) {
			System.out.println(e);
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxCommonResponse;
	}
	
	/**
	 * 更新会议
	 * @param vo
	 * @return
	 */
	@RequestMapping("/meet/update")
	public AjaxCommonResponse<Map<String, Object>> updateMeet(@RequestBody Meet meet) {
		AjaxCommonResponse<Map<String, Object>> ajaxCommonResponse;
		try {
			meetingService.updateMeet(meet);
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK);
		} catch (Exception e) {
			System.out.println(e);
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxCommonResponse;
	}
	
	/**
	 * 删除会议
	 * @param id
	 * @return
	 */
	@RequestMapping("/meet/delete")
	public AjaxCommonResponse<Map<String, Object>> deleteMeet(@RequestParam(required = true) int id) {
		AjaxCommonResponse<Map<String, Object>> ajaxCommonResponse;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			meetingService.deleteMeetById(id);
			map.put("id", id);
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, map);
		} catch(Exception e) {
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxCommonResponse;
	}
}
