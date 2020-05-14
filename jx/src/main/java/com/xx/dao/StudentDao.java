package com.xx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xx.bean.Student;

public interface StudentDao {
	
	
	@Insert("insert into student (stmz,stmm,stdh,stsf) values(#{stmz},#{stmm},#{stdh},#{stsf})")
	public int add(Student stu);
	
	@Delete("delete from student where stid=#{stid}")
	public int delete(Integer stid);
	
	@Update("update student set stmz=#{stmz},stmm=#{stmm},stdh=#{stdh},stsf=#{stsf} where stid=#{stid}")
	public int update(Student stu);
	
	public List<Student> getListDynamic(Student stu);
	@Select("select * from student where stmz=#{stmz} and stmm = #{stmm}")
	public Student  login(Student stu);
	
}
