package com.guo.ssm.util;

import java.io.File;
import java.util.List;



//字符串操作工具
public class StringDaoUtil {
	
	//返回纯文件名不带.xlsx
	public String PathToName(String filepath){
		File file=new File(filepath);
		String name=file.getName();
		String []a =name.split("\\.");
		return a[0];
	}
	
	public String PathToFileName(String filepath){
		File file=new File(filepath);
		String filename=file.getName();
		return filename;
	}
	
	//百分比 取 数
	public double StringToDouble(String percent){
		String []aStrings=percent.split("%");
		
		return Double.valueOf(aStrings[0]);
	}
	
	//出去某个字段
	public String ReduceString(String name,String keyword){
       String aname=name;
		
      //移除指定开头
    	   aname=StringUtils.removeStart(aname, keyword);
      aname=aname.replaceAll("[a-zA-Z]","" );
      aname=aname.replaceAll("\\d+", "");
		return aname;
	}

}
