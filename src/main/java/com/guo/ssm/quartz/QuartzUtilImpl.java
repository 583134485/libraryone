package com.guo.ssm.quartz;

import java.text.ParseException;


import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdScheduler;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public class QuartzUtilImpl  implements QuartzUtil{
Logger logger=Logger.getLogger(Class.class);
	
	
	@Override
	public void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, Class jobClass,
			String cronExpression) throws SchedulerException, ParseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyJobTime(String jobName, String jobGroupName, String triggerName, String triggerGroupName,
			String cronExpression) throws SchedulerException, ParseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName)
			throws SchedulerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startAllJobs() throws SchedulerException {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("test-spring-quartz.xml");
		Scheduler scheduler=(Scheduler)applicationContext.getBean("scheduler");
		ClassPathXmlApplicationContext applicationContext2=new ClassPathXmlApplicationContext("test-spring-jdbcquartz.xml");
		Scheduler schedulerjdbc=(StdScheduler)applicationContext2.getBean("scheduler");
		
		if(!scheduler.isStarted()){
			logger.info("开启定时");
			scheduler.start();
			schedulerjdbc.start();
		}
	}

	@Override
	public void shutdownAllJobs() throws SchedulerException {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("test-spring-quartz.xml");
		Scheduler scheduler=(Scheduler) applicationContext.getBean("scheduler");
		ClassPathXmlApplicationContext applicationContext2=new ClassPathXmlApplicationContext("test-spring-jdbcquartz.xml");
		Scheduler schedulerjdbc=(StdScheduler)applicationContext2.getBean("scheduler");
		if(!scheduler.isShutdown()){
			logger.info("关闭定时");
			scheduler.shutdown();
			schedulerjdbc.shutdown();
		}
		
	}

	@Override
	public void pauseJob(String jobName, String jobGroupName) throws SchedulerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resumeJob(String jobName, String jobGroupName) throws SchedulerException {
		// TODO Auto-generated method stub
		
	}

}
