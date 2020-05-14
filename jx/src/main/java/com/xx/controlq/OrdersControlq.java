package com.xx.controlq;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xx.bean.Orders;
import com.xx.bean.Student;
import com.xx.bean.Worktime;
import com.xx.dao.OrdersDao;
import com.xx.dao.WorktimeDao;

@Controller
@RequestMapping("ordersq")
public class OrdersControlq {
	
	@Resource
	OrdersDao odao;
	
	@Resource
	WorktimeDao wtdao;
	
	@RequestMapping("add")
	@ResponseBody
	public Map add(Orders or,HttpSession se){
		Map ma = new HashMap();
		Student st = (Student)se.getAttribute("stt");
		int stid = st.getStid();
		or.setStid(stid);
		
		// 先根据 教练id 查那一天 剩余人数
		Worktime wt = new Worktime();
		wt.setTeid(or.getTeid());
		wt.setWtsj(or.getOrsj());
		//查询出整个对象
		Worktime wtchade = wtdao.getSyrs(wt);
		int a =0;
		if (wtchade.getWtrs()>0) {
			a = odao.add(or);//添加预约信息到数据库
			int dqrs = wtchade.getWtrs()-1;
			wtchade.setWtrs(dqrs);
			wtdao.update(wtchade);//更新预约记录中的数据，可预约数量-1
			
		} 
		
		 
		ma.put("code", a);
		 
		
		return ma;
	}
	
	@RequestMapping("getOrdersBystid")
	@ResponseBody
	public Map getOrdersBystid(HttpSession se){
		Map ma = new HashMap();
		Student st = (Student)se.getAttribute("stt");
		int stid = st.getStid();
		
		List<Map> li = odao.getOrders(stid);
		ma.put("ar", li);
		return ma;
		
	}
	
}
