package shedulerTest;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.junit.Test;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.DateBuilder.newDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.GregorianCalendar;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;
import org.quartz.impl.triggers.SimpleTriggerImpl;

//job相关的builder
import static org.quartz.JobBuilder.*;

//trigger相关的builder
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.DailyTimeIntervalScheduleBuilder.*;
import static org.quartz.CalendarIntervalScheduleBuilder.*;


public class sheduledemotest {

	static Logger logger=Logger.getLogger(Class.class);
	
	public static void main(String[] args) throws Exception{
		//Quartz的API的风格在2.x以后，采用的是DSL风格（通常意味着fluent interface风格）\
		//，就是示例中newTrigger()那一段东西。它是通过Builder实现的，就是以下几个。
		//（** 下面大部分代码都要引用这些Builder ** )
		  try {
			  
			  
			  
	            //创建scheduler
	            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

	            //定义一个Trigger
	            Trigger trigger = newTrigger().withIdentity("trigger1", "group1") //定义name/group
	                .startNow()//一旦加入scheduler，立即生效
	                .withSchedule(simpleSchedule() //使用SimpleTrigger
	                    .withIntervalInSeconds(1) //每隔一秒执行一次
	                    .repeatForever()) //一直执行，奔腾到老不停歇
	                .build();
	            //2.x 
	            SimpleTriggerImpl triggerImpl=new SimpleTriggerImpl("trigger1","group1");
	            triggerImpl.setStartTime(DateTime.now().toDate());
	            triggerImpl.setRepeatCount(-1);//表示次数，-1无线次
	            triggerImpl.setRepeatInterval(3000);//多久执行一次 ，ms毫秒

	            //定义一个JobDetail
	            JobDetail job = newJob(HelloQuartz.class) //定义Job类为HelloQuartz类，这是真正的执行逻辑所在
	                .withIdentity("job1", "group1") //定义name/group
	                .usingJobData("name", "scheduleTest") //定义属性
	                .build();
               //2.x 风格
	            JobDetail jobDetail=new JobDetailImpl("jobDetail","group1",HelloQuartz.class);
	            jobDetail.getJobDataMap().put("name", "scheduleTest");
	            
	            //加入这个调度
	            //scheduler.scheduleJob(job, trigger);
	            
	            scheduler.scheduleJob(jobDetail,triggerImpl);

	            //启动之
	            scheduler.start();

	            //运行一段时间后关闭
	           Thread.sleep(3000);
	            scheduler.shutdown(true);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	
	

