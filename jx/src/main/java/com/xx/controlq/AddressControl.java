package com.xx.controlq;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 

import com.xx.bean.Address;
import com.xx.bean.Student;
import com.xx.dao.AddressDao;

@Controller
@RequestMapping("address")
public class AddressControl {
	@Resource
	AddressDao adao;
	
	@RequestMapping("getAddressByStid")
	@ResponseBody
	public Map getAddressByStid(HttpSession se){
		Map ma = new HashMap();
		Student st = (Student)se.getAttribute("stt"); //从session中拿到用户登陆的id
		List<Address> ar = adao.getListByStid(st.getStid());
		ma.put("ar", ar);
		ma.put("code", 1);
		return ma;
	}
	
	
	@RequestMapping("getAddressByadid")
	@ResponseBody
	public Map getAddressByadid(Integer adid){
		Map ma = new HashMap();
		Address ad = adao.getByid(adid);
		ma.put("ad", ad);
		return ma;
	}
	
	@RequestMapping("add")
	@ResponseBody
	public Map add(Address ad,HttpSession se){
		Map ma = new HashMap();
		Student st = (Student)se.getAttribute("stt"); //从session中拿到用户登陆的id
		ad.setStid(st.getStid());
		int a = adao.insert(ad);
	 
		ma.put("code", a);
		return ma;
	}
	
	
}
