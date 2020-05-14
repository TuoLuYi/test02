package com.xx.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xx.bean.Student;
import com.xx.dao.StudentDao;

@Controller
@RequestMapping("student")
public class StudentControl {

	@Resource
	StudentDao sd;
	
	@RequestMapping("getListDynamic")
	@ResponseBody
	public Map<String, Object> getListDynamic(Integer page, Integer rows, Student stu){
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(page, rows);
		List<Student> list = sd.getListDynamic(stu);
		PageInfo<Student> pa = new PageInfo<Student>(list);
		map.put("rows", list); //此处必须写"rows",因为前台模板默认为rows
		map.put("total", pa.getTotal());
		return map;
	}
	
	@RequestMapping("add")
	@ResponseBody
	public Map<String, Object> add(Student stu){
		Map<String, Object> map = new HashMap<String, Object>();
		int n = sd.add(stu);
		map.put("code", n);
		return map;
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Map<String, Object> delete(Integer stid){
		Map<String, Object> map = new HashMap<String, Object>();
		int n = sd.delete(stid);
		map.put("code", n);
		return map;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Map<String, Object> update(Student stu){
		Map<String, Object> map = new HashMap<String, Object>();
		int n = sd.update(stu);
		map.put("code", n);
		return map;
	}
	
	
}
