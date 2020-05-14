package com.xx.bean; 
  
import java.io.Serializable;  
  
public class Orders implements Serializable {
  
  
	private Integer orid; 
	private Integer stid; 
	private Integer teid; 
	private String orkm; 
	private Integer orfs; 
	private Integer orfy; 
	private String orpj; 
	private String orsj; 
	private Integer adid;
  
	public Orders(){ 
	    
	}

	public Orders(Integer orid, Integer stid, Integer teid, String orkm,
			Integer orfs, Integer orfy, String orpj, String orsj, Integer adid) {
		super();
		this.orid = orid;
		this.stid = stid;
		this.teid = teid;
		this.orkm = orkm;
		this.orfs = orfs;
		this.orfy = orfy;
		this.orpj = orpj;
		this.orsj = orsj;
		this.adid = adid;
	}

	public Integer getOrid() {
		return orid;
	}

	public void setOrid(Integer orid) {
		this.orid = orid;
	}

	public Integer getStid() {
		return stid;
	}

	public void setStid(Integer stid) {
		this.stid = stid;
	}

	public Integer getTeid() {
		return teid;
	}

	public void setTeid(Integer teid) {
		this.teid = teid;
	}

	public String getOrkm() {
		return orkm;
	}

	public void setOrkm(String orkm) {
		this.orkm = orkm;
	}

	public Integer getOrfs() {
		return orfs;
	}

	public void setOrfs(Integer orfs) {
		this.orfs = orfs;
	}

	public Integer getOrfy() {
		return orfy;
	}

	public void setOrfy(Integer orfy) {
		this.orfy = orfy;
	}

	public String getOrpj() {
		return orpj;
	}

	public void setOrpj(String orpj) {
		this.orpj = orpj;
	}

	public String getOrsj() {
		return orsj;
	}

	public void setOrsj(String orsj) {
		this.orsj = orsj;
	}

	public Integer getAdid() {
		return adid;
	}

	public void setAdid(Integer adid) {
		this.adid = adid;
	} 
	 
}  
   
   
   
