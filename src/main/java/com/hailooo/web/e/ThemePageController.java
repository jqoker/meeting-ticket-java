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
import com.hailooo.entity.Theme;
import com.hailooo.service.impl.ThemeServiceImpl;
import com.hailooo.vo.out.AjaxCommonResponse;

/**
 * @author hongliang.yu
 */
@RestController
@RequestMapping("/meeting/e/ajax/")
public class ThemePageController {
	
	// 默认页大小
	private static final int PAGE_SIZE = 20; 
	
	@Autowired
	private ThemeServiceImpl themeService;
	
	/**
	 * 所有主题(不论是否被会议占用)
	 * @return
	 */
	@RequestMapping("/theme/list")
	public AjaxCommonResponse<Map<String, Object>> themeList(@RequestParam(required = false) Integer page) {
		AjaxCommonResponse<Map<String, Object>> ajaxJson;
		try {
			PageHelper.startPage(page == null ? 0 : page, PAGE_SIZE);
			final List<Theme> themes = themeService.listAll();
			final PageInfo<Theme> pageInfo = new PageInfo<Theme>(themes, PAGE_SIZE);
			ajaxJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, new HashMap<String, Object>() {
				private static final long serialVersionUID = 139523328282057761L;
				{
					put("themes", themes);
//					put("page", pageInfo.getPageNum());
//					put("pageSize", pageInfo.getPageSize());
					put("hasNextPage", pageInfo.isHasNextPage());
				}
			});
		} catch(Exception e) {
			ajaxJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxJson;
	}
	
	/**
	 * 所有未被会议占用的主题
	 * 会议id=0标识该主题未被占用，可以供其他会议选择
	 * @return
	 */
	@RequestMapping("/theme/list_available")
	public AjaxCommonResponse<Map<String, Object>> getAllAvailableThemes() {
		AjaxCommonResponse<Map<String, Object>> ajaxJson;
		try {
			ajaxJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, new HashMap<String, Object>() {
				private static final long serialVersionUID = 139523328282057761L;
				{
					put("themes", themeService.listAllAvailableTheme());
				}
			});
		} catch(Exception e) {
			ajaxJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxJson;
	}
	
	/**
	 * 创建主题
	 * @param themes
	 * @return
	 */
	@RequestMapping("/theme/create")
	public AjaxCommonResponse<Map<String, Object>> themeCreate(@RequestBody List<Theme> themes) {
		AjaxCommonResponse<Map<String, Object>>	ajaxJson;
		try {
			themeService.save(themes);
			ajaxJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK);
		} catch (Exception e) {
			ajaxJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxJson;
	}
	
	/**
	 * 删除主题
	 * @param id
	 * @return
	 */
	@RequestMapping("/theme/delete")
	public AjaxCommonResponse<Map<String, Integer>> themeDelete(@RequestParam(required = true) final int id) {
		AjaxCommonResponse<Map<String, Integer>> ajaxJson;
		try {
			themeService.remove(id);
			ajaxJson = new AjaxCommonResponse<Map<String,Integer>>(HttpStatusCode.HTTP_CODE_OK, new HashMap<String, Integer>() {
				private static final long serialVersionUID = -5807287987886511317L;
				{
					put("id", id);
				}
			});
		} catch (Exception e) {
			ajaxJson = new AjaxCommonResponse<Map<String,Integer>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxJson;
	}
	
	/**
	 * 更新主题
	 * @param theme
	 * @return
	 */
	@RequestMapping("/theme/update")
	public AjaxCommonResponse<Map<String, Object>> themeUpdate(@RequestBody Theme theme) {
		AjaxCommonResponse<Map<String, Object>> ajaxJson;
		try {
			themeService.update(theme);
			ajaxJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK);
		} catch (Exception e) {
			ajaxJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxJson;
	}
}
