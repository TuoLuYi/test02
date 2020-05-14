package com.xx.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xx.bean.Teacher;
import com.xx.bean.Worktime;
import com.xx.dao.TeacherDao;
import com.xx.dao.WorktimeDao;
import com.xx.service.WorkTimeService;
import com.xx.serviceImpl.WorkTimeServiceImpl;
import com.xx.util.DateUtilx;
import com.xx.util.InBoxMap;

@Controller
@RequestMapping("workTime")
public class WorktimeControl { 
	@Resource
	WorkTimeService wts;

	
	@RequestMapping("makeworks")
	@ResponseBody
	public Map<String, Object> makeworks(){
		 Map ma = wts.makeworks();
		 
		return ma;
	}
	 
	@RequestMapping("getList")
	@ResponseBody
	public Map<String, Object> getList(Integer page,Integer rows,HttpServletRequest request){
		 Map ma = wts.getList(page, rows, request);
		return ma;
	}
	
	
	@RequestMapping("update")
	@ResponseBody
	public Map<String, Object> update(Worktime wt){
		 Map ma = wts.update(wt);
		return ma;
	}
	
}