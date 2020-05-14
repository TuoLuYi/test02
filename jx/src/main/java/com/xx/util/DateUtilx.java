package com.xx.util;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.stereotype.Component;
@Component
public class DateUtilx {
	
	 
	public String getPreMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(cal.MONTH, 1);
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM");
        String preMonth = dft.format(cal.getTime());
       
        return preMonth;
    }
	public List<String> getMonthFullDay(int year , int month){
	    SimpleDateFormat dateFormatYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
	    List<String> fullDayList = new ArrayList(32);//创建集合的时候就是32
	    // 获得当前日期对象
	    Calendar cal = Calendar.getInstance();
	    cal.clear();// 清除信息
	    cal.set(Calendar.YEAR, year);
	    // 1月从0开始
	    cal.set(Calendar.MONTH, month-1 );
	    // 当月1号
	    cal.set(Calendar.DAY_OF_MONTH,1);
	    int count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	    for (int j = 1; j <= count ; j++) {
	        fullDayList.add(dateFormatYYYYMMDD.format(cal.getTime()));
	        cal.add(Calendar.DAY_OF_MONTH,1);
	    }
	    return fullDayList;
	}
	/***
	 * 获取下个月 所有天的日期
	 * @return
	 */
	public List<String> getNextMonthDates(){
		String riqi = getPreMonth();
		
		String[] ny = riqi.split("-");
		int year = Integer.valueOf(ny[0]);
		int month = Integer.valueOf(ny[1]);
		List li = getMonthFullDay( year ,  month);
		return li;
	}
	
	 public   String dayForWeek(String pTime)  {  

	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  

	        Date tmpDate=null;
			try {
				tmpDate = format.parse(pTime);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  

	        Calendar cal = Calendar.getInstance(); 

	        String[] weekDays = { "7", "1", "2", "3", "4", "5", "6" };

	        try {

	            cal.setTime(tmpDate);

	        } catch (Exception e) {

	            e.printStackTrace();

	        }

	        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。

	        if (w < 0)

	            w = 0;

	        return weekDays[w];

	    }  

	@Test
	public void testName() throws Exception {
		
		String a=null;
		try {
			a = dayForWeek("2019-08-20");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(a);
		
	}
	
}
