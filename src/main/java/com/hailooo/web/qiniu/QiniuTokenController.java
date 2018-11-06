/**
 * 
 */
package com.hailooo.web.qiniu;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hailooo.constant.HttpStatusCode;
import com.hailooo.vo.out.AjaxCommonResponse;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * @author hongliang.yu
 */
@RestController
@RequestMapping("/meeting/e/ajax/")
public class QiniuTokenController {
	
	// 定义常量
	private static final String ACCESS_KEY = "6O9gotqetF3I-NZw1MhgnuIq4z1OaIUZX3Gx7n56";
	private static final String SECRET_KEY = "Qcb4Vy_1WyTfA42UY5aV6ExVND51Id9qay7BT9ZI";
	private static final String BUCKET = "hailoooo";
	private static final long EXPIRE_SECONDS = 3600;
	private static final String RETURN_BODY = "{\"code\":\"0\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize),\"key\":$(key)}";

	// 下发七牛云 upload token
	// TODO 需要加入缓存
	@RequestMapping("/qiniu/upload/token")
	public AjaxCommonResponse<Map<String, Object>> generateQiniuToken() {
		StringMap putPolicy = new StringMap();
		putPolicy.put("returnBody", RETURN_BODY);
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		final String token = auth.uploadToken(BUCKET, null, EXPIRE_SECONDS, putPolicy);
		
		return new AjaxCommonResponse<Map<String,Object>>(HttpStatusCode.HTTP_CODE_OK, new HashMap<String, Object>() {
			private static final long serialVersionUID = -2349850924054069657L;
			{
				put("code", 0);
				put("token", token);
			}
		});
	}
}
