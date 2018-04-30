package com.guo.ssm.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface IExcelService {
	
	//解析
	public Map<String, List<String>> ParseSingleExcelToJson(MultipartFile file);

}
