package com.xx.bean; 
  
import java.io.Serializable;  
  
public class News implements Serializable {
  
  
	private Integer neid; 
	private String nebt; 
	private String nenr; 
	private String nesj; 
  
	public News(){ 
	    
	} 
	public News(Integer neid,String nebt,String nenr,String nesj){ 
		 this.neid=neid;   
		 this.nebt=nebt;   
		 this.nenr=nenr;   
		 this.nesj=nesj;   
	} 
  
	public void setNeid(Integer neid){  
		 this.neid=neid; 
	} 
	public Integer getNeid(){ 
			return neid; 
	} 
  
	public void setNebt(String nebt){  
		 this.nebt=nebt; 
	} 
	public String getNebt(){ 
			return nebt; 
	} 
  
	public void setNenr(String nenr){  
		 this.nenr=nenr; 
	} 
	public String getNenr(){ 
			return nenr; 
	} 
  
	public void setNesj(String nesj){  
		 this.nesj=nesj; 
	} 
	public String getNesj(){ 
			return nesj; 
	} 
  
}  
   
   
   
