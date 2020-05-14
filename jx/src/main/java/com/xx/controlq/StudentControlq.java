package com.xx.controlq;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xx.bean.Student;
import com.xx.dao.StudentDao;

@Controller
@RequestMapping("studentq")
public class StudentControlq {
	@Resource
	StudentDao sdao;
	
	
	@RequestMapping("register")
	@ResponseBody
	public Map register(Student st){
		Map<String,Object> ma = new HashMap<String, Object>();
		int a = sdao.add(st);
		ma.put("code", a);
		return ma;
	}
	
	@RequestMapping("loginst")
	@ResponseBody
	public Map loginst(Student st,HttpSession se){
		Map<String,Object> ma = new HashMap<String, Object>();
		Student stt = sdao.login(st);
		if (stt!=null) {
			se.setAttribute("stt", stt);
			ma.put("code", 1);
		}else{
			ma.put("code", 0);
		}
		
		return ma;
	}
	
	
	@RequestMapping("checkLogin")
	@ResponseBody
	public Map checkLogin(HttpSession se){
		Map<String,Object> ma = new HashMap<String, Object>();
		Student stt =  (Student)se.getAttribute("stt");
		ma.put("code", stt==null?0:1 );
		
		return ma;
	}
	
}
