package com.guo.ssm.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class testtime {
	
	public static void main(String[] args) {
		String expire_time ="20180205122222";
		long l_expire_time = Long.parseLong(expire_time);
		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
		String now = time.format(new Date());// 8位日期
		long l_now = Long.parseLong(now);
		System.out.println("now:"+l_now);
		System.out.println("expire:"+l_expire_time);
		
	}

}
