/**
 * 
 */
package com.hailooo.web.e;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hailooo.constant.HttpStatusCode;
import com.hailooo.entity.Meet;
import com.hailooo.service.impl.MeetServiceImpl;
import com.hailooo.vo.out.AjaxCommonResponse;

/**
 * @author hongliang.yu
 * 会议控制器
 */
@RestController
@RequestMapping("/meeting/e/ajax/")
public class MeetPageController {
	// 每一页大小
	private static final int PAGE_SIZE = 20;
	
	@Autowired
	private MeetServiceImpl meetingService;
	
	/**
	 * 所有会议
	 * 支持分页
	 * @return
	 */
	@RequestMapping("/meet/list")
	public AjaxCommonResponse<Map<String, Object>> listAllMeet(@RequestParam(required = false) Integer page) {
		AjaxCommonResponse<Map<String, Object>> ajaxCommonResponse;
		try {
			PageHelper.startPage(page == null ? 0 : page, PAGE_SIZE);
			final List<Meet> meets = meetingService.listAll();
			final PageInfo<Meet> pageInfo = new PageInfo<Meet>(meets, PAGE_SIZE);
			ajaxCommonResponse = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, new HashMap<String, Object>() {
				private static final long serialVersionUID = 284168023697104717L;
				{
					put("meets", meets);
					put("hasNextPage", pageInfo.isHasNextPage());
				}
			});
		} catch (Exception e) {
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
