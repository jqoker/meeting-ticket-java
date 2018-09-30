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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * @author hongliang.yu
 */
@RestController
@RequestMapping("/meeting/e/ajax/")
public class AuthorPageController {
	// 默认页大小
	private static final int PAGE_SIZE = 20; 
	
	@Autowired
	private AuthorServiceImpl authorService;
	
	/**
	 * 嘉宾列表
	 * @return
	 */
	@RequestMapping("/author/list")
	public AjaxCommonResponse<Map<String, Object>> getAuthorList(@RequestParam(required = false) Integer page) {
		AjaxCommonResponse<Map<String, Object>> ajaxAuthorJson;
		try {
			PageHelper.startPage(page == null ? 0 : page, PAGE_SIZE);
			final List<Author> authors = authorService.listAll();
			final PageInfo<Author> pageInfo = new PageInfo<Author>(authors, PAGE_SIZE);
			ajaxAuthorJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, new HashMap<String, Object>(){
				private static final long serialVersionUID = 9063660679922745268L;
				{
					put("authors", authors);
					put("hasNextPage", pageInfo.isHasNextPage());
				}
			});
		} catch (Exception e) {
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
			authorService.save(authors);
			ajaxAuthorJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK);
		} catch (Exception e) {
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
	public AjaxCommonResponse<Map<String, Object>> suggestAuthor(@RequestParam(required = true) final String name) {
		AjaxCommonResponse<Map<String, Object>> ajaxSuggestAuthorJson;
		try {
			ajaxSuggestAuthorJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, new HashMap<String, Object>() {
				private static final long serialVersionUID = 1097872131398147535L;
				{
					put("list", authorService.getAuthorByName(name));
				}
			});
		} catch (Exception e) {
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
	public AjaxCommonResponse<Map<String, Object>> themeDelete(@RequestParam(required = true) final int id) {
		AjaxCommonResponse<Map<String, Object>> ajaxJson;
		try {
			authorService.remove(id);
			ajaxJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, new HashMap<String, Object>() {
				private static final long serialVersionUID = -9050854118023500777L;
				{
					put("id", id);
				}
			});
		} catch (Exception e) {
			ajaxJson = new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxJson;
	}
	
	/**
	 * 创建嘉宾
	 * @param author
	 * @return
	 */
	@RequestMapping("/author/update")
	public AjaxCommonResponse<Map<String, Object>> updateAuthor(@RequestBody Author author) {
		AjaxCommonResponse<Map<String, Object>> ajaxAuthorJson;
		if (author == null) {
			return new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		try {
			authorService.update(author);
			ajaxAuthorJson = new AjaxCommonResponse<Map<String, Object>>(HttpStatusCode.HTTP_CODE_OK);
		} catch (Exception e) {
			ajaxAuthorJson = new AjaxCommonResponse<Map<String, Object>>(HttpStatusCode.HTTP_CODE_ERR);
		}
		return ajaxAuthorJson;
	}
}
