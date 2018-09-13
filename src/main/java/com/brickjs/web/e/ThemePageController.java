/**
 * 
 */
package com.brickjs.web.e;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brickjs.constant.HttpStatusCode;
import com.brickjs.entity.Theme;
import com.brickjs.service.impl.ThemeServiceImpl;
import com.brickjs.vo.out.AjaxCommonResponse;

/**
 * @author yuhongliang
 *
 */

@RestController
@RequestMapping("/meeting/e/ajax/")
public class ThemePageController {
	
	@Autowired
	private ThemeServiceImpl themeService;
	
	/**
	 * 所有主题
	 * @return
	 */
	@RequestMapping("/theme/list")
	public AjaxCommonResponse<Map<String, Object>> themeList() {
		AjaxCommonResponse<Map<String, Object>> ajaxJson;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Theme> themes = themeService.getAllTheme();
			map.put("themes", themes);
			ajaxJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, map);
		} catch(Exception e) {
			System.out.println(e);
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
			// TODO: handle exception
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
	public AjaxCommonResponse<Map<String, Object>> themeDelete(@RequestParam(required = true) int id) {
		AjaxCommonResponse<Map<String, Object>> ajaxJson;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			themeService.deleteTheme(id);
			map.put("id", id);
			ajaxJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, map);
		} catch (Exception e) {
			// TODO: handle exception
			ajaxJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxJson;
	}
}
