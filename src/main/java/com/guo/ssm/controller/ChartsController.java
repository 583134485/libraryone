package com.guo.ssm.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.guo.ssm.service.IExcelService;
import com.guo.ssm.service.impl.ExcelService;


/*charts接口*/
@Controller
@RequestMapping("/charts")
public class ChartsController {
	
	private  static final Logger log=LoggerFactory.getLogger(ChartsController.class);
	
	@Autowired
	IExcelService excelService;
	
    /*跨域*/
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/")
	@ResponseBody
	public String query(){
		return "charts api ready";
	}
	
	
	
    /*parse ecxcel to json for echarts */
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/parseexcel",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, List<String>> ParseExcel( MultipartFile uploadFile){
		if(uploadFile==null) {
			return null;
		}
		
		String filename =uploadFile.getOriginalFilename();
		if(filename.endsWith("xlsx")||filename.endsWith("xls"))
		{
			
			return excelService.ParseSingleExcelToJson(uploadFile);
		}
		else {
			return null;
		}

	}

}
