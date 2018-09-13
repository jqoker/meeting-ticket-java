/**
 * 
 */
package com.brickjs.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * @author yuhongliang
 *
 */
public class JavaUtilTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Map<String, Integer>> list = new ArrayList<Map<String,Integer>>();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("meetId", 10);
		map.put("id", 2);
		
		final Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("meetId", 11);
		map2.put("id", 2);
		
		list.add(map);
		list.add(map2);
		
		System.out.println(list);
		
		for (Iterator<Map<String, Integer>> iterator = list.iterator(); iterator.hasNext();) {
			Map<String, Integer> mapp = (Map<String, Integer>) iterator.next();
			mapp.replace("meetId", 0);
		}
		
		System.out.println(list);
	}

}
