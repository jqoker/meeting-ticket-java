/**
 * 
 */
package com.brickjs.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.util.ResourceUtils;

import com.qiniu.util.Auth;

/**
 * @author yuhongliang
 *
 */
public class QiniuToken {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String AK = "6O9gotqetF3I-NZw1MhgnuIq4z1OaIUZX3Gx7n56";
//		String SK = "Qcb4Vy_1WyTfA42UY5aV6ExVND51Id9qay7BT9ZI";
//		String bucket = "hailoooo";
//		
//		Auth auth = Auth.create(AK, SK);
//		String token = auth.uploadToken(bucket);
//		
//		System.out.println(token);
		
		try {
			Properties properties = new Properties();
			File file = ResourceUtils.getFile("classpath:qiniu.properties");
			InputStream in = new BufferedInputStream(new FileInputStream(file));
			properties.load(in);
			String ak = properties.getProperty("AccessKey");
			String sk = properties.getProperty("SecretKey");
			String bucket = properties.getProperty("Bucket");
			System.out.println(ak + "-" + sk + "-" + bucket);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
