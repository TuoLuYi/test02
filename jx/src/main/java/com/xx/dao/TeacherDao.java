package com.xx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.xx.bean.Teacher;

public interface TeacherDao {
	
	
	@Insert("insert into teacher (temz,texb,tejl,tejs,tedh,tezp,tefy,tezb,temm) values(#{temz},#{texb},#{tejl},#{tejs},#{tedh},#{tezp},#{tefy},#{tezb},#{temm})")
	public int add(Teacher t);
	
	@Delete("delete from teacher where teid=#{teid}")
	public int delete(Integer teid);
	
	public int update(Teacher t);
	
	public List<Teacher> getList(Teacher t);
	@Select("select * from teacher where teid=#{teid}")
	public Teacher getTeacherById(Integer teid);
}
