package com.xx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import com.xx.bean.News;

public interface NewsDao {
	
	
	@Insert("insert into news (nebt,nenr,nesj) values(#{nebt},#{nenr},#{nesj})")
	public int add(News n);
	
	@Delete("delete from news where neid=#{neid}")
	public int delete(Integer neid);
	
	@Update("update news set nebt=#{nebt},nenr=#{nenr},nesj=#{nesj} where neid=#{neid}")
	public int update(News n);
	
	public List<News> getList(News n);
	
}




