package com.xx.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.xx.bean.Orders;

public interface OrdersDao { 
	@Insert("INSERT INTO Orders (stid,teid,orkm,orfs,orfy,orpj,orsj,adid)  values (#{stid},#{teid},#{orkm},#{orfs},#{orfy},#{orpj},#{orsj},#{adid})")
	public int add(Orders or);
	public int delete(Integer id);
	public int update(Orders or);
	public List<Orders> getList(Orders or);
	public Orders getById(Integer id);

	@Select("select orid,temz,orkm,orfy,orsj,admz,addh,addz "
			+ "from orders o,teacher t,address a where"
			+ " o.teid = t.teid and o.adid = a.adid and o.stid=#{stid}")
	public List<Map> getOrders(Integer stid);
}