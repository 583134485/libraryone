package com.guo.ssm.quartz;

import java.text.ParseException;  

import org.quartz.SchedulerException; 

/** 
 * 定时任务工具类，用于管理定时任务； 
 *  
 * 
 * 
 */  
public interface QuartzUtil {

	/** 
     * 添加一个定时任务，使用传入的任务名、任务群组名、触发器名、触发器群组名； 
     *  
     * @param jobName 任务名； 
     * @param jobGroupName 任务的群组名； 
     * @param triggerName 触发器名； 
     * @param triggerGroupName 触发器群组名； 
     * @param jobClass 任务类； 
     * @param cronExpression cron表达式，用于指定任务的执行时间，参考 Quartz 说明文档； 
     * @throws SchedulerException  
     * @throws ParseException  
     */  
    public void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, Class jobClass, String cronExpression) throws SchedulerException, ParseException;  
      
    /** 
     * 修改任务的执行时间； 
     *  
     * @param jobName 任务名； 
     * @param jobGroupName 任务的群组名； 
     * @param triggerName 触发器名； 
     * @param triggerGroupName 触发器群组名； 
     * @param cronExpression cron表达式，用于指定任务的执行时间，参考 Quartz 说明文档； 
     * @throws SchedulerException  
     * @throws ParseException  
     */  
    public void modifyJobTime(String jobName, String jobGroupName, String triggerName, String triggerGroupName, String cronExpression) throws SchedulerException, ParseException;  
      
    /** 
     * 移除指定任务； 
     *  
     * @param jobName 任务名； 
     * @param jobGroupName 任务的群组名； 
     * @param triggerName 触发器名； 
     * @param triggerGroupName 触发器群组名； 
     * @throws SchedulerException  
     */  
    public void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName) throws SchedulerException;  
  
    /** 
     * 启动所有定时任务； 
     * @throws SchedulerException  
     */  
    public void startAllJobs() throws SchedulerException;  
  
    /** 
     * 关闭所有定时任务； 
     * @throws SchedulerException  
     */  
    public void shutdownAllJobs() throws SchedulerException;  
      
    /** 
     * 暂停指定任务； 
     *  
     * @param jobName 任务名； 
     * @param jobGroupName 任务的群组名； 
     * @throws SchedulerException  
     */  
    public void pauseJob(String jobName, String jobGroupName) throws SchedulerException;  
      
    /** 
     * 恢复指定任务； 
     *  
     * @param jobName 任务名； 
     * @param jobGroupName 任务的群组名； 
     * @throws SchedulerException  
     */  
    public void resumeJob(String jobName, String jobGroupName) throws SchedulerException;  
}
