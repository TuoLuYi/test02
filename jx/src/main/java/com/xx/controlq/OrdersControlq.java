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
		
		// �ȸ��� ����id ����һ�� ʣ������
		Worktime wt = new Worktime();
		wt.setTeid(or.getTeid());
		wt.setWtsj(or.getOrsj());
		//��ѯ����������
		Worktime wtchade = wtdao.getSyrs(wt);
		int a =0;
		if (wtchade.getWtrs()>0) {
			a = odao.add(or);//���ԤԼ��Ϣ�����ݿ�
			int dqrs = wtchade.getWtrs()-1;
			wtchade.setWtrs(dqrs);
			wtdao.update(wtchade);//����ԤԼ��¼�е����ݣ���ԤԼ����-1
			
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
