package com.guo.ssm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import org.apache.poi.ss.usermodel.Cell;


import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFPictureData;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.guo.ssm.model.HotGoodsModel;

public class HotGoodsExcelUtil {
	Logger logger=Logger.getLogger(Class.class);
	
	public Map getexcel(String string) throws IOException{
	 XSSFRow row;
		//如果不try catch 会报错,也可以方法直接throws ioException
	        List <String>datetime=new ArrayList<String>();
	        List <Integer>flow=new ArrayList<Integer>();
	        List <Integer> payment=new ArrayList<Integer>();
	        List <Integer> plus=new ArrayList<Integer>();
	        List <Integer>money=new ArrayList<Integer>();
	        List <String> conversion=new ArrayList<String>();
	        //用map加List的方式存放数据
	        Map map=new HashMap<String, List>();
			File file=new File(string);
			
	        if(file.isFile()&&file.exists())
	        {
	        	FileInputStream fileInputStream=new FileInputStream(file);
				XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
				XSSFSheet spreadsheet=workbook.getSheetAt(0);
				Iterator<Row> rowIterator=spreadsheet.iterator();
				while(rowIterator.hasNext())
				{
					row=(XSSFRow)rowIterator.next();
					Iterator<Cell> cellIterator=row.cellIterator();
					while(cellIterator.hasNext())
					{
						Cell cell=cellIterator.next();
						
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_BLANK:
							break;
						case Cell.CELL_TYPE_NUMERIC:
							if(XSSFDateUtil.isCellDateFormatted(cell))
							{
								logger.info("是日期");
								double d=cell.getNumericCellValue();
								java.util.Date date=XSSFDateUtil.getJavaDate(d);
								SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
								String datestring =format.format(date);
								logger.info(datestring);							
								datetime.add(datestring);
							}
							else{
								logger.info("数字"+cell.getNumericCellValue());
							    String first=cell.getRow().getCell(0).toString();
							    String flow1=new String("流量");
							    String pay1=new String("支付");
							    String plus1=new String("加购");
							    String money2=new String("金额");
							    //需要int
								double b=cell.getNumericCellValue();
								int a=(int)b;
							    //String 判断相等
							    if(first.equals(flow1))
							    {
							       
							    	flow.add(a);
							    }
							    else if(first.equals(plus1))
							    {
							    	plus.add(a);
							    }
							    else if(first.equals(pay1)){
							    	payment.add(a);
									
								}
							    else if(first.equals(money2))
							    {
							    	money=new ArrayList<>();
							    }
								logger.info((int)(cell.getNumericCellValue()));						
							}
								
							break;
						case Cell.CELL_TYPE_FORMULA:
							
							 String first=cell.getRow().getCell(0).toString();
							 String money1=new String("金额");
							 String conversion1=new String("转化");
							if(first.equals(conversion1))
							{
								
								String con=new  java.text.DecimalFormat("0.00").format(cell.getNumericCellValue()*100);
							
								//转化率这里是
								logger.info(con);
								conversion.add(con);
							}
							else if(first.equals(money1)){
							
								double b=cell.getNumericCellValue();
								int a=(int)b;
								//这里是公式的金额
								logger.info("金额类添加了"+a);
								money.add(a);
							}
							
							
							break;
						case Cell.CELL_TYPE_STRING:
							    logger.info(cell.toString()+"string");						
						break;

						default:
							break;
						}
					}
					//对图片的读取
					List<XSSFPictureData> pictureDatas=workbook.getAllPictures();
				for(int i=0;i<pictureDatas.size();i++)
				{
					String basepath="F:\\excel\\pic\\";
					XSSFPictureData pictureData=pictureDatas.get(i);
					byte[] picData=pictureData.getData();
					String ext=pictureData.suggestFileExtension();
					logger.info("image-size:"+picData.length+ext);
					FileOutputStream outputStream=new FileOutputStream(basepath+"img_"+i+"."+ext);
					outputStream.write(picData);
					logger.info("图片保存OK");
					outputStream.close();
				}
					
					//输入流关闭close位置放不对也要出错
					  fileInputStream.close();
				}
				map.put("日期", datetime);
				logger.info(datetime.size());
				map.put("流量", flow);
				logger.info(flow.size());
				map.put("支付", payment);
				logger.info(payment.size());
				map.put("加购", plus);
				logger.info(plus.size());
				map.put("金额", money);
				logger.info(money.size()+"金额");
				map.put("转化",conversion);
				logger.info(conversion.size()+"转化率");
				return map;
				
	        }
	        else
	        {
	        logger.info("打开文件出错");
	        return null;
	        }
	      
		
	
	}
	
	

}
