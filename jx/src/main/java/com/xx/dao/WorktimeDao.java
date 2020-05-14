package com.xx.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.xx.bean.Teacher;
import com.xx.bean.Worktime;

public interface WorktimeDao { 
	
	@Select("select * from worktime where teid=#{teid} and wtsj=#{wtsj}")
	public Worktime getSyrs(Worktime wt);
	
	
	
	public int add(Worktime wo);
	public int delete(Integer id);
	public int update(Worktime wo);
	public List<Worktime> getList(Worktime wo);
	public Worktime getById(Integer id);

	public List<Map<String, Object>> getListByTeWo(Map<String, Object> ma);
	/***
	 * 
	 * @param wtsj  ¸ñÊ½Îª 2019-09-01
	 * @return
	 */
	public List<Teacher> getFreeTeacher(String wtsj);
	
	
}