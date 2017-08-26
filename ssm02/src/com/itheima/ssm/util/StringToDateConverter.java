package com.itheima.ssm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/** 
* @author lijin E-mail: lijin1@itcast.cn 
* @date   2017年8月18日 下午6:29:29 
* 类说明 
* S : Source 源   要被转类型
* T: target 目标 要转成的类型
*/
public class StringToDateConverter implements Converter<String, Date> {

	public Date convert(String source) {
		
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
