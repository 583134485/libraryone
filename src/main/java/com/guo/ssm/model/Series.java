package com.guo.ssm.model;

import java.util.List;

public class Series  {
    @Override
	public String toString() {
		return "Series [name=" + name + ", type=" + type + ", data=" + data + "]";
	}
	public  String name;
    public  String type;
   /* private List<Integer> data;*/
    public  List<Long> data;
    public Series( String name, String type, List<Long> data) {
        super();
        this.name = name;
        this.type = type;
        this.data = data;
    }
}
