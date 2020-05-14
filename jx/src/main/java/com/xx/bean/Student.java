package com.xx.bean; 
  
import java.io.Serializable;  
  
public class Student implements Serializable {
  
  
	private Integer stid; 
	private String stmz; 
	private String stmm; 
	private String stdh; 
	private String stsf; 
  
	public Student(){ 
	    
	} 
	public Student(Integer stid,String stmz,String stmm,String stdh,String stsf){ 
		 this.stid=stid;   
		 this.stmz=stmz;   
		 this.stmm=stmm;   
		 this.stdh=stdh;   
		 this.stsf=stsf;   
	} 
  
	public void setStid(Integer stid){  
		 this.stid=stid; 
	} 
	public Integer getStid(){ 
			return stid; 
	} 
  
	public void setStmz(String stmz){  
		 this.stmz=stmz; 
	} 
	public String getStmz(){ 
			return stmz; 
	} 
  
	public void setStmm(String stmm){  
		 this.stmm=stmm; 
	} 
	public String getStmm(){ 
			return stmm; 
	} 
  
	public void setStdh(String stdh){  
		 this.stdh=stdh; 
	} 
	public String getStdh(){ 
			return stdh; 
	} 
  
	public void setStsf(String stsf){  
		 this.stsf=stsf; 
	} 
	public String getStsf(){ 
			return stsf; 
	} 
  
}  
   
   
   
