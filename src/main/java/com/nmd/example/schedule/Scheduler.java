package com.nmd.example.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// Scheduling is a pricess of executing the tasks for the specific time period. Spring Boot provides a good support to write a scheduler on the Spring applications
// Java Cron expressions are used to configure the instances of CronTrigger, a subclass of org.quartz.Trigger.
@Component
public class Scheduler {

	// Print in 14PM - 15PM, every minute 
	//@Scheduled(cron = "0 * 14 * * ?")
	public void cronJobSch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date date = new Date();
		String strDate = sdf.format(date);
		System.out.println("Cron Expression scheduler:: " + strDate);
	}
	
	//Fixed Rate scheduler is used to execute the tasks at the specific time. It does not wait for the completion of previous task. The values should be in milliseconds.
	//@Scheduled(fixedRate = 1000)
	public void fixedRateSch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date date = new Date();
		String strDate = sdf.format(date);
		System.out.println("Fixed Rate scheduler:: " + strDate);
	}
	
	//Fixed Delay scheduler is used to execute the tasks at a specific time. It should wait for the previous task completion. The values should be in milliseconds.
	@Scheduled(fixedDelay = 1000, initialDelay = 3000)
	public void fixedDelaySch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("Fixed Delay scheduler:: " + strDate);
	}
}
