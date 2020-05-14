package com.xx.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xx.bean.Teacher;
import com.xx.bean.Worktime;
import com.xx.dao.TeacherDao;
import com.xx.dao.WorktimeDao;
import com.xx.service.WorkTimeService;
import com.xx.util.DateUtilx;
import com.xx.util.InBoxMap;

@Service
public class WorkTimeServiceImpl implements WorkTimeService{
	
	@Resource
	DateUtilx dux;
	@Resource
	WorktimeDao wtd;
	@Resource
	TeacherDao td;
	@Resource
	InBoxMap ibm;
	
	
	
	@Transactional 
	public Map<String, Object> makeworks(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<String> rqs = dux.getNextMonthDates();
		Worktime wt = new Worktime();
		List<Teacher> art = td.getList(null);
		for (Teacher te : art) {
			for (String rq : rqs) {
				String zhouji = dux.dayForWeek(rq);
				wt.setTeid(te.getTeid());
				wt.setWtsj(rq);
				
				if (zhouji.equals("1")) {
					wt.setWtsx("nowork");
				}else{
					wt.setWtsx("work");
				}
				wt.setWtrs(4);
				wtd.add(wt);
			}
		}
		
		
		map.put("code", 1);
		return map;
	}
	
	public Map<String, Object> getList(Integer page,Integer rows,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> ma  = ibm.inBox(request);//自动把表单中的数据封装到map中
		
		if ( !ma.get("wtsj").equals("")) {
			String rq = (String)ma.get("wtsj");
			rq = rq.substring(0,10);
			ma.put("wtsj", rq);
		}
		
		PageHelper.startPage(page, rows);
		List li = wtd.getListByTeWo(ma);
		PageInfo pf = new PageInfo(li);
		
		map.put("rows",li);
		map.put("total", pf.getTotal());
		return map;
	}
	
	
	
	public Map<String, Object> update(Worktime wt){
		Map<String, Object> map = new HashMap<String, Object>();
		 
		int n = wtd.update(wt);
		map.put("code", n);
		return map;
	}
	
}
