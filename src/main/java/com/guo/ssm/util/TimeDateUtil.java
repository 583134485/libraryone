package com.guo.ssm.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;



//关于时间时期的工具
public class TimeDateUtil {
	Logger logger=Logger.getLogger(Class.class);
	 //String to Timestamp
	public Timestamp StringToTimestamp(String timestirng) throws ParseException{
		timestirng+=" 00:00:00";
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		//string to date
		java.util.Date date = simpleDateFormat.parse(timestirng);
		//date to simpledateformate
		Timestamp timestamp = new Timestamp(date.getTime());
		return timestamp;
	}
	
	public String TimestampToSimpleDate(Timestamp timestamp){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");	
		String simpledate=simpleDateFormat.format(timestamp);
		return simpledate;
	}
	
	
	
	//比较String list 日期集合 
	public String StringDateListToString(List<String> datelist) throws Exception{
		logger.info("datelistcount:");
		logger.info("index0"+datelist.get(0));
		//取list中的数据比较才有效!
		//datelist.get(3)随便取的，造成没有get(3)这个值
		String mindate =new String(datelist.get(0));
		String maxdate =new String(datelist.get(0));
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		//出现了2017-9-1《2017-8-30的情况出现,修改了mm就成了。。。。
		//SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date day=new Date();
		java.util.Date minday=new Date();
		java.util.Date maxday=new Date();
		logger.info("listsize:"+datelist.size());
		for(String date:datelist){
			
        day=simpleDateFormat.parse(date);
        minday=simpleDateFormat.parse(mindate);
        maxday=simpleDateFormat.parse(maxdate);
        //出现了2017-9-1《2017-8-30的情况出现
/*      //取代大的
		  if(day.compareTo(maxday)>0){
			maxdate=date;
			logger.info("max:"+maxdate);
		}
			//取代小的
		  else	if(day.compareTo(minday)<0){
					mindate=date;
					logger.info("min:"+mindate);
				}
				
			}*/
        //取代大的
    		  if(day.before(minday)){
    				mindate=date;
					logger.info("min:"+mindate);
    		}
    			//取代小的
    		  else	if(day.after(maxday)){
    				
    					maxdate=date;
    	    			logger.info("max:"+maxdate);
    				}
    				
    			}
        logger.info(mindate);
        logger.info(maxdate);
		String datetime=mindate+"-"+maxdate;
		return datetime;
	}
	
	
	/**
	 * 注意输出有效日期是end的前一天和mybatis的查询结果符合，暂时不会有错
	 * 获取两个日期之间的日期
	 * @param start 开始日期
	 * @param end 结束日期
	 * @return 日期集合 (string)
	 * @throws ParseException 
	 */
	public List<String> changeStringTimeToListStringTime(String begin,String end) throws ParseException{
		List<String> stringdate=new ArrayList<String>();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		//化为日期date
		java.util.Date beginday=simpleDateFormat.parse(begin);
		java.util.Date endday=simpleDateFormat.parse(end);
		//calendar
		Calendar startdate=Calendar.getInstance();
		startdate.setTime(beginday);
		Calendar enddate=Calendar.getInstance();
		enddate.setTime(endday);
		
		while (startdate.before(enddate)) {
			//从最小的往list添加
			stringdate.add(simpleDateFormat.format(startdate.getTime()));
			startdate.add(Calendar.DAY_OF_YEAR, 1);
			
		}
		logger.info("listdate集合"+stringdate);
		return stringdate;
	}
    
	//stringto date 得到sql date 快速
	//出现了java.util.date cannot be cast to java.sql.date
	public static java.sql.Date StringtoDate(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilday=sdf.parse(date);
		java.sql.Date sqlday=new java.sql.Date(utilday.getTime());
		return sqlday;
	}
	
	
	
}
