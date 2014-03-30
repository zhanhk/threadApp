package com.thread.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

/**
 *  获取properties文件内容的工具类
 * @author zhanhk
 */
public class PropertiesUtil {
	//存放配置文件的所有的key-value
	private static Map<String,String> allParam = new HashMap<String, String>();
	
	//根据文件名称-key，返回相应key的�?
    public static String getPropertiesByKey(String key){
		try {
			 if(allParam.containsKey(key)){
				return allParam.get(key);
			 }else{
				 allParam.clear();
		   		 InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties");
		       	 Properties p = new Properties();
		       	 p.load(in);
		       	 Set<Entry<Object, Object>> allKey = p.entrySet();
		       	 for (Entry<Object, Object> entry : allKey) {
					allParam.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
				 }
		       	 in.close();
		       	 return allParam.get(key);
			 }
	   	} catch (Exception e) {
	   		e.printStackTrace();
	    }
		return null;
    }
    
	//初始化config配置文件
	public static void initProperties() {
		try {
			InputStream in = PropertiesUtil.class.getClassLoader()
					.getResourceAsStream("config.properties");
			Properties p = new Properties();
			p.load(in);
			Set<Entry<Object, Object>> allKey = p.entrySet();
			for (Entry<Object, Object> entry : allKey) {
				allParam.put(String.valueOf(entry.getKey()),
						String.valueOf(entry.getValue()));
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
