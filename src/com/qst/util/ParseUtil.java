package com.qst.util;
/**
 * 类型转换工具类
 * @author qst
 *
 */
public class ParseUtil {
	/**
	 * 将字符串转成Integer
	 * @param source
	 * @return
	 */
	public static Integer parseToInteger(String source) {
		Integer result=null;
		try {
			if(source!=null&&!"".equals(source))
				result=Integer.parseInt(source);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return result;
	}
}
