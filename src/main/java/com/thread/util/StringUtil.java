package com.thread.util;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	/**
	 * 私有构造方法，防止类的实例化，因为工具类不需要实例化。
	 */
	private StringUtil() {
	}
	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str) || "null".equals(str)) {
			return true;
		} else{
			return false;
		} 
	}
	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(Object str) {
		if (str == null || "".equals(str) || "null".equals(str)) {
			return true;
		} else{
			return false;
		} 
	}
	/**
	 * 判断字符串不是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (str == null || "".equals(str)) {
			return false;
		} else{
			return true;
		} 
	}
	/**
	 * 判断字符串不是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(Object str) {
		if (str == null || "".equals(str)) {
			return false;
		} else{
			return true;
		} 
	}
	
	/**
	 * 判断字符串为数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){ 
		return str.matches("^(-?\\d+)(\\.\\d+)?$");
	 } 
	
	/**
	 * 将字符串为null时，转换为空白
	 * 
	 * @param str
	 * @return
	 */
	public static String convNull2Blank(String str) {
		if (StringUtil.isEmpty(str) || "null".equals(str.toLowerCase())) {
			return "";
		} else {
			return str;
		}
	}
	
	/**
	 * 将字符串为null时，转换为空白
	 * 
	 * @param str
	 * @return
	 */
	public static String convNull2Blank(Object obj) {
		if (obj == null) {
			return "";
		} else {
			return obj.toString();
		}
	}
	
	/**
	 * 将字符串为null时，转换为零
	 * 
	 * @param obj
	 * @return
	 */
	public static String convNull2Zero(Object obj) {
		if (obj == null) {
			return "0";
		} else {
			return obj.toString();
		}
	}
	
	/**
	 * 将字符串为Long
	 * @param obj
	 * @return
	 */
	public static Long convStr2Long(String str) {
		if (str == null || "".equals(str)) {
			return 0L;
		} else {
			return Long.parseLong(str);
		}
	}
	
	/**
	 * 将字符串为Int
	 * @param obj
	 * @return
	 */
	public static Integer convStr2Int(String str) {
		if (str == null || "".equals(str)) {
			return 0;
		} else {
			return Integer.parseInt(str);
		}
	}
	
	/**
	 * 将字符串为Int
	 * @param obj
	 * @return
	 */
	public static Integer convStr2Int(Object obj) {
		if (obj == null) {
			return 0;
		} else {
			return Integer.parseInt((String)obj);
		}
	}
	
	/**
	 * 将字符串转码
	 * @param obj
	 * @return
	 * @throws Exception 
	 */
	public static String changeStrCode(String str,String fromcode,String tocode) throws Exception {
		if(fromcode == null || "".equals(fromcode)){
			fromcode = "iso8859-1";
		}
		if(tocode == null || "".equals(tocode)){
			tocode = "gb2312";
		}
		
		return new String(str.getBytes(fromcode), tocode); 
	}
	
	/**
	 * 将字符串为null时，转换为空白,并且添加单引号
	 * 
	 * @param str
	 * @return
	 */
	public static String convNull2BlankApp(Object obj) {
//		if (obj == null) {
//			return "\"'\"'";
//		} else {
//			return "\"" + obj.toString() + "\"";
//		}
		if (obj == null) {
			return "";
		} else {
			return obj.toString();
		}
	}
	
	/**
	 * 判断有几个中文字符
	 * 
	 * @param str
	 * @return
	 */
	public static int getChineseCount(String str) {
		String temp = null;
		Pattern p = Pattern.compile("[\u4E00-\u9FA5]+");
		Matcher m = p.matcher(str);
		int count = 0;
		while (m.find()) {
			temp = m.group(0);
			count += temp.length();
			System.out.println(temp + ":" + temp.length());
		}
		return count;
	}

	/**
	 * 设置填充字符
	 * 
	 * @param str
	 *            原字符
	 * @param fill
	 *            填充字符
	 * @param digit
	 *            填充后总位数
	 * @param startOrend
	 *            填充在原字符首尾(1,-1)
	 * @return
	 * @throws Exception
	 */
	public static String fChar(String str, String fill, int digit,int startOrend) throws Exception {
		if (!(str.length() > digit)) {
			// 处理中文问题
			// int slength=new String(str.getBytes(),"ISO-8859-1").length();
			int slength = str.length();
			int i = digit - slength;
			StringBuffer fillStr = new StringBuffer();
			for (int x = 0; x < i; x++)
				fillStr.append(fill);
			if (startOrend >= 0)
				return fillStr + str;
			else
				return str + fillStr;
		} else {
			throw new Exception("填充字符过程中出现异常");
		}
	}

	/**
	 * 得到字符串的字节长度
	 * 
	 * @param source
	 *            字符串
	 * @return 字符串的字节长度
	 */
	public static int getByteLength(String source) {
		int len = 0;
		for (int i = 0; i < source.length(); i++) {
			char c = source.charAt(i);
			int highByte = c >>> 8;
			len += highByte == 0 ? 1 : 2;
		}
		return len;
	}

	/**
	 * 去除右边多余的空格。
	 * 
	 * @param value
	 *            待去右边空格的字符串
	 * @return 去右边空格的字符串
	 */
	public static String trimRight(String value) {
		String result = value;
		if (result == null)
			return result;
		char ch[] = result.toCharArray();
		int endIndex = -1;
		for (int i = ch.length - 1; i > -1; i--) {
			if (Character.isWhitespace(ch[i])) {
				endIndex = i;
			} else {
				break;
			}
		}
		if (endIndex != -1) {
			result = result.substring(0, endIndex);
		}
		return result;
	}

	/**
	 * 去除左边多余的空格。
	 * 
	 * @param value
	 *            待去左边空格的字符串
	 * @return 去掉左边空格后的字符串
	 */
	public static String trimLeft(String value) {
		String result = value;
		if (result == null)
			return result;
		char ch[] = result.toCharArray();
		int index = -1;
		for (int i = 0; i < ch.length; i++) {
			if (Character.isWhitespace(ch[i])) {
				index = i;
			} else {
				break;
			}
		}
		if (index != -1) {
			result = result.substring(index + 1);
		}
		return result;
	}

	/**
	 * 将字符串数组使用指定的分隔符合并成一个字符串。
	 * 
	 * @param array
	 *            字符串数组
	 * @param delim
	 *            分隔符，为null的时候使用""作为分隔符（即没有分隔符）
	 * @return 合并后的字符串
	 */
	public static String combineStringArray(String[] array, String delim) {
		int length = array.length - 1;
		if (delim == null) {
			delim = "";
		}
		StringBuffer result = new StringBuffer(length * 8);
		for (int i = 0; i < length; i++) {
			result.append(array[i]);
			result.append(delim);
		}
		result.append(array[length]);
		return result.toString();
	}

	/**
	 * 字符串数组中是否包含指定的字符串。
	 * 
	 * @param strings
	 *            字符串数组
	 * @param string
	 *            字符串
	 * @param caseSensitive
	 *            是否大小写敏感
	 * @return 包含时返回true，否则返回false
	 */
	public static boolean contains(String[] strings, String string,
			boolean caseSensitive) {
		for (int i = 0; i < strings.length; i++) {
			if (caseSensitive == true) {
				if (strings[i].equals(string)) {
					return true;
				}
			} else {
				if (strings[i].equalsIgnoreCase(string)) {
					return true;
				}
			}
		}
		return false;
	}

	public static InputStream parseInputStream(String str) {
		InputStream is = new ByteArrayInputStream(str.getBytes());
		return is;
	}

	/**
	 * 得到一个属性的get方法名
	 * @param str bean的一个属性
	 * @return
	 */
	public static String getMethodByStr(String str){
		String methodName=null;
		String firstLetter = str.substring(0, 1).toUpperCase();
		methodName = "get" + firstLetter + str.substring(1);
		return methodName;
	}
	/**
	 * 得到一个属性的set方法名
	 * @param str bean的一个属性
	 * @return
	 */
	public static String setMethodByStr(String str){
		String methodName=null;
		String firstLetter = str.substring(0, 1).toUpperCase();
		methodName = "set" + firstLetter + str.substring(1);
		return methodName;
	}
	/**
	 * 检验一个字符串是否是纯英文的字符串
	 * @param str
	 * @return
	 */
	public static boolean isWord(String str){
		return str.matches("[[a-z]|[A-Z]]*");
	}
	public static String getRandomNum(int len){
		StringBuffer sb=new StringBuffer();
		Random rd = new Random();
		for(int i=0;i<len;i++){
			sb.append(rd.nextInt(10));
		}
		return sb.toString();
	}

	/**
	 * 在字答串左边添加字符到指定长度
	 * @param src  指定字符串
	 * @param intLength 字符串目标长度
	 * @param character 添加字符
	 * @return
	 */
	public static String appendLeft(String src,int intLength,String character){
			if (StringUtil.isEmpty(src) || src.length() > intLength) {
				return src;
			}
			StringBuffer sb = new StringBuffer();
			int intAppendLength =intLength - src.length();
			for (int i = 0; i < intAppendLength; i++) {
				sb.append(character);
			}
			sb.append(src);
			src = sb.toString();
		
		return src;
	}
	
	
	/**
	 * 在字答串右边添加字符到指定长度
	 * @param src  指定字符串
	 * @param intLength 字符串目标长度
	 * @param character 添加字符
	 * @return
	 */
	public static String appendRight(String src,int intLength,String character){
			if (StringUtil.isEmpty(src) || src.length() > intLength) {
				return src;
			}
			StringBuffer sb = new StringBuffer();
			sb.append(src);
			int intAppendLength =intLength - src.length();
			for (int i = 0; i < intAppendLength; i++) {
				sb.append(character);
			}
			src = sb.toString();
		
		return src;
	}
}
