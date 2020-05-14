package com.xx.time;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xx.serviceImpl.WorkTimeServiceImpl;

@Component
public class Every15Number {
	@Resource
	WorkTimeServiceImpl wts;
 
	@Scheduled(cron = "0 0 0 15 * ?")
	public void MemberService() {
		 
		wts.makeworks();
	}

}
