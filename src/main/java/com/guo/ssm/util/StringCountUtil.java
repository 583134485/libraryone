package com.guo.ssm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;





//包装String 算数
public class StringCountUtil {
	Logger logger=Logger.getLogger(Class.class);
	
	//String puls to string
	public String StringPlusToString(String a,String b){
		String c =new String();
		int inta=Integer.valueOf(a);
		int intb=Integer.valueOf(b);
		int intc=inta+intb;
		c=String.valueOf(intc);
		return c;
	}
	
	//比较String list 日期集合 
	public String StringDateListToString(List<String> datelist) throws Exception{
		logger.info("datelistcount:");
		
		//取list中的数据比较才有效!
		String mindate =new String(datelist.get(0));
		String maxdate =new String(datelist.get(0));
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date day=new Date();
		java.util.Date minday=new Date();
		java.util.Date maxday=new Date();
		for(String date:datelist){
        day=simpleDateFormat.parse(date);
        minday=simpleDateFormat.parse(mindate);
        maxday=simpleDateFormat.parse(maxdate);
			//取代小的
				if(day.compareTo(minday)<0){
					mindate=date;
					logger.info("min:"+mindate);
				}
				//取代大的
				else  if(day.compareTo(maxday)>0){
					maxdate=date;
					logger.info("max:"+maxdate);
				}
			}

		String datetime=mindate+"-"+maxdate;
		return datetime;
	}

}
