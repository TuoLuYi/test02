package com.xx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xx.bean.Teacher;
import com.xx.bean.Worktime;

public interface WorkTimeService {
	
	public Map<String, Object> makeworks();
	
	public Map<String, Object> getList(Integer page,Integer rows,HttpServletRequest request);
	
	
	
	public Map<String, Object> update(Worktime wt);
	
}
