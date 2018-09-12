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
import com.brickjs.entity.Author;
import com.brickjs.service.impl.AuthorServiceImpl;
import com.brickjs.vo.out.AjaxCommonResponse;

/**
 * @author yuhongliang
 *
 */
@RestController
@RequestMapping("/meeting/e/ajax/")
public class AuthorPageController {
	
	@Autowired
	private AuthorServiceImpl authorService;
	
	/**
	 * 嘉宾列表
	 * @return
	 */
	@RequestMapping("/author/list")
	public AjaxCommonResponse<Map<String, Object>> getAuthorList() {
		AjaxCommonResponse<Map<String, Object>> ajaxAuthorJson;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Author> list = authorService.getAllAuthorList();
			map.put("authors", list);
			ajaxAuthorJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, map);
		} catch (Exception e) {
			// TODO: handle exception
			ajaxAuthorJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxAuthorJson;
	}

	/**
	 * 创建嘉宾
	 * @param author
	 * @return
	 */
	@RequestMapping("/author/create")
	public AjaxCommonResponse<Map<String, Object>> createAuthor(@RequestBody List<Author> authors) {
		AjaxCommonResponse<Map<String, Object>> ajaxAuthorJson;
		if (authors == null) {
			return new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			authorService.save(authors);
//			map.put("id", authors());
			ajaxAuthorJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, map);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			ajaxAuthorJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxAuthorJson;
	}
	
	/**
	 * 搜索嘉宾
	 * @param name
	 * @return
	 */
	@RequestMapping("/author/suggest")
	public AjaxCommonResponse<Map<String, Object>> suggestAuthor(@RequestParam(required = true) String name) {
		AjaxCommonResponse<Map<String, Object>> ajaxSuggestAuthorJson;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Author> list = authorService.getAuthorByName(name);
			map.put("list", list);
			ajaxSuggestAuthorJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, map);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			ajaxSuggestAuthorJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxSuggestAuthorJson;
	}
	
	/**
	 * 删除嘉宾
	 * @param id
	 * @return
	 */
	@RequestMapping("/author/delete")
	public AjaxCommonResponse<Map<String, Object>> themeDelete(@RequestParam(required = true) int id) {
		AjaxCommonResponse<Map<String, Object>> ajaxJson;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			authorService.deleteAuthor(id);
			map.put("id", id);
			ajaxJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, map);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			ajaxJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxJson;
	}
}
