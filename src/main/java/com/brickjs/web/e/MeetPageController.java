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
 * 会议控制器
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
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, new HashMap<String, Object>() {
				private static final long serialVersionUID = 284168023697104717L;
				{
					put("meets", meetingService.listAll());
				}
			});
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
	public AjaxCommonResponse<Map<String, Object>> meetInSpecialCategory(@RequestParam(required = true) final int id) {
		AjaxCommonResponse<Map<String, Object>> ajaxCommonResponse;
		try {
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, new HashMap<String, Object>() {
				private static final long serialVersionUID = 3719753392451436526L;
				{
					put("meets", meetingService.getAllMeetsByCategoryId(id));
				}
			});
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
			meetingService.update(meet);
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
	public AjaxCommonResponse<Map<String, Integer>> deleteMeet(@RequestParam(required = true) final int id) {
		AjaxCommonResponse<Map<String, Integer>> ajaxCommonResponse;
		try {
			meetingService.remove(id);
			ajaxCommonResponse = new AjaxCommonResponse<Map<String, Integer>>(HttpStatusCode.HTTP_CODE_OK, new HashMap<String, Integer>() {
				private static final long serialVersionUID = 4524908329136049057L;
				{
					put("id", id);
				}
			});
		} catch(Exception e) {
			ajaxCommonResponse = new AjaxCommonResponse<Map<String, Integer>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxCommonResponse;
	}
}
