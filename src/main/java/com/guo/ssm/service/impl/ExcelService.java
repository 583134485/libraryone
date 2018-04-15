package com.guo.ssm.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.guo.ssm.service.IExcelService;
import com.guo.ssm.util.ExcelUtil;
import com.guo.ssm.util.FileDaoUtil;

@Service
public class ExcelService implements IExcelService{

	private  static final Logger log=LoggerFactory.getLogger(ExcelService.class);
	
	@Override
	public Map<String, List<String>> ParseSingleExcelToJson(MultipartFile file) {
		String filepath=FileDaoUtil.UploadFile(file);
		log.info("filepath saved as "+filepath);
		Map<String, List<String>> result=null;
		try {
			result = ExcelUtil.ParseExcelToExcelModel(filepath);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
