package com.guo.ssm.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;

/*excelmodel  mongodb 持久话*/
public class ExcelModel {
	@Id
	public String id;
	
	public String filename;
	
	public Map<String, List<String>> data;
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Map<String, List<String>> getData() {
		return data;
	}
	public void setData(Map<String, List<String>> data) {
		this.data = data;
	}


}
