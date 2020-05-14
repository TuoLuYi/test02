package com.xx.dao;

import java.util.List;
import com.xx.bean.Manager;

public interface ManagerDao { 

	public int add(Manager ma);
	public int delete(Integer id);
	public int update(Manager ma);
	public List<Manager> getList(Manager ma);
	public Manager getById(Integer id);

}