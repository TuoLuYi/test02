package com.xx.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class InBoxMap {
	
	public Map<String,Object> inBox(HttpServletRequest request){
		Map<String,Object> ma = new HashMap<String, Object>();
		Enumeration<String> em = request.getParameterNames();//��ȡ���д��ݹ���������nameֵ
		while (em.hasMoreElements()) {
			String name = em.nextElement();
			String value = request.getParameter(name);
			ma.put(name, value);
		}
		return ma;
	}
	
}
