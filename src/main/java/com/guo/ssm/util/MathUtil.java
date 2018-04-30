package com.guo.ssm.util;

import java.math.BigDecimal;

public class MathUtil {

	//为 double 保留小数个
	//
	public static double KeepDecimal(double input,int decimal) {
		BigDecimal   b   =   new   BigDecimal(input);    
		double   output   =   b.setScale(decimal,   BigDecimal.ROUND_HALF_UP).doubleValue();    
		return output;
		
	}
}
