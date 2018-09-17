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
			// 查询所有会议
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, new HashMap<String, Object>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = -4620119999025546267L;
				{
					put("meet", meetingService.listAll());
				}
			});
		} catch (Exception e) {
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxCommonResponse;
	}

	/**
	 * 会议详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/meet_detail")
	public AjaxCommonResponse<Map<String, Object>> Meet(@RequestParam(required = true) final int id) {
		AjaxCommonResponse<Map<String, Object>> ajaxCommonResponse;
		try {
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, new HashMap<String, Object>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = -4222836130430154666L;
				{
					put("meet", meetingService.detail(id));
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxCommonResponse;
	}
}
