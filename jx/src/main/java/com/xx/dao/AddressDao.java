package com.xx.dao; 
import java.util.List;  
import com.xx.bean.*;  
  
public interface AddressDao {
  
	public List getListByStid(Integer stid);
	public Integer deleteByid(Integer id); 
	public Integer insert(Address ob); 
	public Address getByid(Integer id); 
	public Integer update(Address ob); 
	public Integer updateDynamic(Address ob); 
	public List getList(); 
	public List getListDynamic(Address ob); 
  
}  
