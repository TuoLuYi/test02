package com.xx.bean; 
  
import java.io.Serializable;  
  
public class Worktime implements Serializable {
  
  
	private Integer wtid; 
	private Integer teid; 
	private String wtsj; 
	private String wtsx; 
	private Integer wtrs;
  
	public Worktime(){ 
	    
	}

	public Worktime(Integer wtid, Integer teid, String wtsj, String wtsx,
			Integer wtrs) {
		super();
		this.wtid = wtid;
		this.teid = teid;
		this.wtsj = wtsj;
		this.wtsx = wtsx;
		this.wtrs = wtrs;
	}

	public Integer getWtid() {
		return wtid;
	}

	public void setWtid(Integer wtid) {
		this.wtid = wtid;
	}

	public Integer getTeid() {
		return teid;
	}

	public void setTeid(Integer teid) {
		this.teid = teid;
	}

	public String getWtsj() {
		return wtsj;
	}

	public void setWtsj(String wtsj) {
		this.wtsj = wtsj;
	}

	public String getWtsx() {
		return wtsx;
	}

	public void setWtsx(String wtsx) {
		this.wtsx = wtsx;
	}

	public Integer getWtrs() {
		return wtrs;
	}

	public void setWtrs(Integer wtrs) {
		this.wtrs = wtrs;
	} 
	
  
}  
   
   
   
