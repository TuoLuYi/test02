package com.xx.controlq;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xx.bean.Teacher;
import com.xx.dao.WorktimeDao;

@Controller
@RequestMapping("worktimeq")
public class WorkTimeControlq {
	
	@Resource
	WorktimeDao wdao;
	
	@RequestMapping("getFree")
	@ResponseBody
	public Map getFree(String wtsj){
		Map ma  = new HashMap();
		List<Teacher> ar = wdao.getFreeTeacher(wtsj);
		ma.put("ar", ar);
		return ma;
	}
	
	
}
