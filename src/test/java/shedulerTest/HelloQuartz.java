package shedulerTest;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
//多个trigger可疑调用一个job  但 一个trigger不可已调用多个job
public class HelloQuartz implements Job {
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