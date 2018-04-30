package shedulerTest;

import org.quartz.SchedulerListener;
import org.apache.log4j.Logger;
import org.quartz.JobDetail;  
import org.quartz.JobKey;  
import org.quartz.SchedulerException;    
import org.quartz.Trigger;  
import org.quartz.TriggerKey;





public class SchedulerListenerTest  implements SchedulerListener{
	Logger logger=Logger.getLogger(Class.class);
	
	
	
    @Override  
    public void jobAdded(JobDetail arg0) {  
    	logger.info("666");
    System.out.println("SchedulerListener监听器：jobAdded()");    
    }  
  
    @Override  
    public void jobDeleted(JobKey arg0) {  
        System.out.println("SchedulerListener监听器：jobDeleted()");      
    }  
  
    @Override  
    public void jobPaused(JobKey arg0) {  
        System.out.println("SchedulerListener监听器：jobPaused()");   
    }  
  
    @Override  
    public void jobResumed(JobKey arg0) {  
        System.out.println("SchedulerListener监听器：jobResumed()");      
    }  
  
    @Override  
    public void jobScheduled(Trigger arg0) {  
        System.out.println("SchedulerListener监听器：jobScheduled()");    
    }  
  
    @Override  
    public void jobUnscheduled(TriggerKey arg0) {  
        System.out.println("SchedulerListener监听器：jobUnscheduled()");      
    }  
  
    @Override  
    public void jobsPaused(String arg0) {  
        System.out.println("SchedulerListener监听器：jobsPaused()");      
    }  
  
    @Override  
    public void jobsResumed(String arg0) {  
        System.out.println("SchedulerListener监听器：jobsResumed()");     
    }  
  
    @Override  
    public void schedulerError(String arg0, SchedulerException arg1) {  
        System.out.println("SchedulerListener监听器：schedulerError()");      
    }  
  
    @Override  
    public void schedulerInStandbyMode() {  
        System.out.println("SchedulerListener监听器：schedulerInStandbyMode()");      
    }  
  
    @Override  
    public void schedulerShutdown() {  
        System.out.println("SchedulerListener监听器：schedulerShutdown()");   
    }  
  
    @Override  
    public void schedulerShuttingdown() {  
        System.out.println("SchedulerListener监听器：schedulerShuttingdown()");   
    }  
  
    @Override  
    public void schedulerStarted() { 
      	logger.info("start");
        System.out.println("SchedulerListener监听器：schedulerStarted()");    
    }  
  
    @Override  
    public void schedulerStarting() {  
      	logger.info("startting");
        System.out.println("SchedulerListener监听器：schedulerStarting()");   
    }  
  
    @Override  
    public void schedulingDataCleared() {  
        System.out.println("SchedulerListener监听器：schedulingDataCleared()");   
    }  
  
    @Override  
    public void triggerFinalized(Trigger arg0) {  
        System.out.println("SchedulerListener监听器：triggerFinalized()");    
    }  
  
    @Override  
    public void triggerPaused(TriggerKey arg0) {  
        System.out.println("SchedulerListener监听器：triggerPaused()");   
    }  
  
  
  
    @Override  
    public void triggersPaused(String arg0) {  
        System.out.println("SchedulerListener监听器：triggersPaused()");      
    }  
  
    @Override  
    public void triggersResumed(String arg0) {  
        System.out.println("SchedulerListener监听器：triggersResumed()");     
    }  
  
    @Override  
    public void triggerResumed(TriggerKey arg0) {  
        System.out.println("SchedulerListener监听器：triggerResumed()");      
          
    }  
	
}
