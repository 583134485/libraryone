package shedulerTest;


import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.context.support.ClassPathXmlApplicationContext;



//内存中的定时 任务
public class RAMXML {
	private static  Logger logger=Logger.getLogger(Class.class);
	
	public static void main(String [] args) throws SchedulerException{
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("test-spring-quartz.xml");
		Scheduler scheduler=(Scheduler) applicationContext.getBean("scheduler");
	       JobListenerTest jobListener=new JobListenerTest();
           TriggerListenerTest triggerListenerTest=new TriggerListenerTest();
           SchedulerListenerTest schedulerListener=new SchedulerListenerTest();
           //scheduler.getListenerManager().addJobListener(jobListener);
           //scheduler.getListenerManager().addTriggerListener(triggerListenerTest);
           logger.info("5");
           scheduler.getListenerManager().addSchedulerListener(schedulerListener);
          logger.info("6");
           
	}
	
    
}
