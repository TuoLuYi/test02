package com.xx.bean; 
  
import java.io.Serializable;  
  
public class Teacher implements Serializable {
  
  
	private Integer teid; 
	private String temz; 
	private String texb; 
	private Integer tejl; 
	private String tejs; 
	private String tedh; 
	private String tezp; 
	private Integer tefy; 
	private String tezb; 
	private String temm; 
  
	public Teacher(){ 
	    
	} 
	public Teacher(Integer teid,String temz,String texb,Integer tejl,String tejs,String tedh,String tezp,Integer tefy,String tezb,String temm){ 
		 this.teid=teid;   
		 this.temz=temz;   
		 this.texb=texb;   
		 this.tejl=tejl;   
		 this.tejs=tejs;   
		 this.tedh=tedh;   
		 this.tezp=tezp;   
		 this.tefy=tefy;   
		 this.tezb=tezb;   
		 this.temm=temm;   
	} 
  
	public void setTeid(Integer teid){  
		 this.teid=teid; 
	} 
	public Integer getTeid(){ 
			return teid; 
	} 
  
	public void setTemz(String temz){  
		 this.temz=temz; 
	} 
	public String getTemz(){ 
			return temz; 
	} 
  
	public void setTexb(String texb){  
		 this.texb=texb; 
	} 
	public String getTexb(){ 
			return texb; 
	} 
  
	public void setTejl(Integer tejl){  
		 this.tejl=tejl; 
	} 
	public Integer getTejl(){ 
			return tejl; 
	} 
  
	public void setTejs(String tejs){  
		 this.tejs=tejs; 
	} 
	public String getTejs(){ 
			return tejs; 
	} 
  
	public void setTedh(String tedh){  
		 this.tedh=tedh; 
	} 
	public String getTedh(){ 
			return tedh; 
	} 
  
	public void setTezp(String tezp){  
		 this.tezp=tezp; 
	} 
	public String getTezp(){ 
			return tezp; 
	} 
  
	public void setTefy(Integer tefy){  
		 this.tefy=tefy; 
	} 
	public Integer getTefy(){ 
			return tefy; 
	} 
  
	public void setTezb(String tezb){  
		 this.tezb=tezb; 
	} 
	public String getTezb(){ 
			return tezb; 
	} 
  
	public void setTemm(String temm){  
		 this.temm=temm; 
	} 
	public String getTemm(){ 
			return temm; 
	} 
  
}  
   
   
   
