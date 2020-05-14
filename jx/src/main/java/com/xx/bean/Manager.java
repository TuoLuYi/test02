package com.xx.bean; 
  
import java.io.Serializable;  
  
public class Manager implements Serializable {
  
  
	private Integer glid; 
	private String glmz; 
	private String glmm; 
  
	public Manager(){ 
	    
	} 
	public Manager(Integer glid,String glmz,String glmm){ 
		 this.glid=glid;   
		 this.glmz=glmz;   
		 this.glmm=glmm;   
	} 
  
	public void setGlid(Integer glid){  
		 this.glid=glid; 
	} 
	public Integer getGlid(){ 
			return glid; 
	} 
  
	public void setGlmz(String glmz){  
		 this.glmz=glmz; 
	} 
	public String getGlmz(){ 
			return glmz; 
	} 
  
	public void setGlmm(String glmm){  
		 this.glmm=glmm; 
	} 
	public String getGlmm(){ 
			return glmm; 
	} 
  
}  
   
   
   
