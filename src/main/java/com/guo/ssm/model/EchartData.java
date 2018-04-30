package com.guo.ssm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EchartData implements Serializable {
	public EchartData(List<String> legendList, List<String> categoryList, List<Series> seriesList) {
        super();
        this.legend = legendList;
        this.category = categoryList;
        this.series = seriesList;
    }
	@Override
	public String toString() {
		return "EchartData [legend=" + legend + ", category=" + category + ", series=" + series + "]";
	}
     //设置为public和private的区别 private 会出现前台数据为空，即没有成功调用的情况
	  /*private*/ public List<String> legend = new ArrayList<String>();//数据分组
	   public  List<String> category = new ArrayList<String>();//横坐标
	    public  List<Series> series = new ArrayList<Series>();//纵坐标
	

}
