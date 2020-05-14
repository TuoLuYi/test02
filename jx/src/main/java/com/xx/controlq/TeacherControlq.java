package com.xx.controlq;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xx.bean.Teacher;
import com.xx.dao.TeacherDao;

@Controller
@RequestMapping("teacherq")
public class TeacherControlq {
	@Resource
	TeacherDao tdao;
	
	@RequestMapping("getTeacher")
	@ResponseBody
	public Map getTeacher(Integer teid){
		Map ma = new HashMap();
		Teacher te = tdao.getTeacherById(teid);
		ma.put("te", te);
		return ma; 
	}
	
	
}
