package com.xx.bean; 
  
import java.io.Serializable;  
  
public class Address implements Serializable {
  
  
	private Integer adid; 
	private String admz; 
	private String addh; 
	private String addz; 
	private Integer stid; 
  
	public Address(){ 
	    
	} 
	public Address(Integer adid,String admz,String addh,String addz,Integer stid){ 
		 this.adid=adid;   
		 this.admz=admz;   
		 this.addh=addh;   
		 this.addz=addz;   
		 this.stid=stid;   
	} 
  
	public void setAdid(Integer adid){  
		 this.adid=adid; 
	} 
	public Integer getAdid(){ 
			return adid; 
	} 
  
	public void setAdmz(String admz){  
		 this.admz=admz; 
	} 
	public String getAdmz(){ 
			return admz; 
	} 
  
	public void setAddh(String addh){  
		 this.addh=addh; 
	} 
	public String getAddh(){ 
			return addh; 
	} 
  
	public void setAddz(String addz){  
		 this.addz=addz; 
	} 
	public String getAddz(){ 
			return addz; 
	} 
  
	public void setStid(Integer stid){  
		 this.stid=stid; 
	} 
	public Integer getStid(){ 
			return stid; 
	} 
  
}  
   
   
   
