package com.guo.ssm.quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloTest implements Job {
	static int i=0;
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	//System.out.println("show i"+i);
    	//int i=0;
        JobDetail detail = context.getJobDetail();
        String name = detail.getJobDataMap().getString("name");
        i++;
        System.out.println("++");
        System.out.println("say hello to " + name + " at "+ i);
    }
}
