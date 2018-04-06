package com.guo.ssm.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONReader;

public class JsonUtil {
	Logger logger=Logger.getLogger(Class.class);
	
	public static String ReadJsonToString(String jsonfilepath) throws FileNotFoundException{
		JSONReader reader = new JSONReader(new FileReader(jsonfilepath));
		String a=reader.readString();
		return a;
	}

}
