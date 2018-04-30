package com.guo.ssm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFPictureData;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.guo.ssm.model.HotGoodsModel;
import com.guo.ssm.model.NewHotGoodsModel;

public class HotGoodsExcelUtilNew {
	Logger logger=Logger.getLogger(Class.class);
	
	 
	public NewHotGoodsModel GetOneExcel(String string) throws IOException{
	//	logger.info("util的路径"+Class.class.getClass().getResource("/").getPath());
	//由于excel 表格的格式不是database table 的格式，所以用arrylist 有序存储，再有序存入model,再到database	
	 XSSFRow row;
	 NewHotGoodsModel newHotGoodsModel=new NewHotGoodsModel();
		//如果不try catch 会报错,也可以方法直接throws ioException
	        List <String>datetime=new ArrayList<String>();
	        List <Integer>flow=new ArrayList<Integer>();
	        List <Integer> payment=new ArrayList<Integer>();
	        List <Integer> plus=new ArrayList<Integer>();
	        List<String> purchaserate=new ArrayList<String>();
	        List <Integer>money=new ArrayList<Integer>();
	        List <String> conversion=new ArrayList<String>();
	        //单价
	        List<Integer>price=new ArrayList<Integer>();
	        //用map加List的方式存放数据,在这个工具类里用类表示对象
	        //Map map=new HashMap<String, List>();
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
								//logger.info("是日期");
								double d=cell.getNumericCellValue();
								java.util.Date date=XSSFDateUtil.getJavaDate(d);
								SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
								String datestring =format.format(date);
								//logger.info(datestring);							
								datetime.add(datestring);
							}
							else{
								//logger.info("数字"+cell.getNumericCellValue());
							    String first=cell.getRow().getCell(0).toString();
							    String flow1=new String("流量");
							    String pay1=new String("支付");
							    String plus1=new String("加购");
							    //类单个属性
							    String id1=new String("ID");
								 String tagPrice1=new String("吊牌价");
								 String newquotation=new String("上新价");
								 String discount1=new String("折扣");
								 String year=new String("年份");
 							    //需要int
								double dou=cell.getNumericCellValue();
								int a=(int)dou;
								
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
							    	//logger.info("支付："+a);
							    	payment.add(a);
									
								}
							    else if(first.equals(id1)){
							    	
							    	newHotGoodsModel.setId(Integer.toString(a));
							    }
							    else if(first.equals(tagPrice1))
							    {
							    	newHotGoodsModel.setTagPrice(a);
							    }
							    else if(first.equals(newquotation))
							    {
							    	newHotGoodsModel.setNewquotation(a);
							    }
							    else if(first.equals(discount1))
							    {
							    	String dis=new  java.text.DecimalFormat("0.00").format(dou*100);
							    	newHotGoodsModel.setDiscount(dis);
							    }
							    else if(first.equals(year))
							    {
							    	newHotGoodsModel.setYear(String.valueOf(a));
							    }
													
							}
								
							break;
						case Cell.CELL_TYPE_FORMULA:
							
							 String first=cell.getRow().getCell(0).toString();
							 String money1=new String("金额");
							 String conversion1=new String("转化");
							 String purchaserate1=new String("加购率");
							 String price1= new String("单价");
							 double b=cell.getNumericCellValue();
							if(first.equals(conversion1))
							{
								
								String con=new  java.text.DecimalFormat("0.00").format(cell.getNumericCellValue()*100);
							
								//转化率这里是
								//logger.info(con);
								conversion.add(con);
							}
							else if(first.equals(money1)){
							
								
								int a=(int)b;
								//这里是公式的金额
								//logger.info("金额类添加了"+a);
								money.add(a);
							}
							else if(first.equals(purchaserate1)){
								
								String pur=new  java.text.DecimalFormat("0.00").format(cell.getNumericCellValue()*100);
								purchaserate.add(pur);
								
							}
							else if(first.equals(price1))
							{
								int a=(int)b;
								price.add(a);
							}
							
							
							break;
						case Cell.CELL_TYPE_STRING:
							String firstname=cell.getRow().getCell(0).toString();
							String stringvalue=cell.getStringCellValue();
							/*if(firstname.equals(new String("ID")))
							{
								newHotGoodsModel.setId(stringvalue);
							}*/
							if(firstname.equals(new String("款号")))
							{
								newHotGoodsModel.setStyleNumber(stringvalue);
							}
							else if(firstname.equals(new String("品类")))
							{
								newHotGoodsModel.setCategory(stringvalue);
							}
							else if(firstname.equals(new String("面料")))
							{
								newHotGoodsModel.setFabric(stringvalue);
							}
							else if(firstname.equals(new String("版型")))
							{
								newHotGoodsModel.setTypeVersion(stringvalue);
							}
							else if(firstname.equals(new String("季节")))
							{
								newHotGoodsModel.setSeason(stringvalue);
							}
							else if(firstname.equals(new String("品牌")))
							{
								newHotGoodsModel.setBrand(stringvalue);
							}
							else if(firstname.equals(new String("产品线")))
							{
								newHotGoodsModel.setProductLine(stringvalue);
							}
							
							   // logger.info(cell.toString()+"string");						
						break;

						default:
							break;
						}
					}
					
					
				}
				//对图片的读取,但放到本地路径读取不到
				List<XSSFPictureData> pictureDatas=workbook.getAllPictures();
			for(int i=0;i<pictureDatas.size();i++)
			{  
				logger.info("图片张数"+pictureDatas.size());
				//String basepath="F:\\excel\\pic\\";
				//获取的路径不确定，不一定会定位在项目的路径上会报错，但项目的图片已经事先存到项目里，暂时不会报错
				//String basepath=System.getProperty("user.dir")+"\\src\\main\\webapp\\static\\img\\";
                logger.info("systemdir"+System.getProperty("user.dir"));
                //手动制定路径图片地址，临时解决方案
				String basepath="C:\\Users\\58313\\Desktop\\10.11晚上\\10.11晚上\\libraryone\\src\\main\\webapp\\static\\img\\";
				XSSFPictureData pictureData=pictureDatas.get(i);
				byte[] picData=pictureData.getData();
				String ext=pictureData.suggestFileExtension();
				logger.info("image-size:"+picData.length+ext);
				//定一个picureUrl
				String picurl=new String(basepath+newHotGoodsModel.getId()+newHotGoodsModel.getStyleNumber()+"."+ext);
				logger.info("保存路径picurl:"+picurl);
				newHotGoodsModel.setPictureUrl("\\static\\img\\"+newHotGoodsModel.getId()+newHotGoodsModel.getStyleNumber()+"."+ext);
				logger.info("相对路径picname:"+newHotGoodsModel.getPictureUrl());
				//暂时放在一个地址清楚的位置
				FileOutputStream outputStream=new FileOutputStream(picurl);
				outputStream.write(picData);
				logger.info("图片保存OK，输出流关闭");
				outputStream.close();
			}
			
				newHotGoodsModel.setDatatime(datetime);
				newHotGoodsModel.setFlow(flow);
				newHotGoodsModel.setPayment(payment);
				newHotGoodsModel.setPlus(plus);
				newHotGoodsModel.setMoney(money);
				newHotGoodsModel.setConversion(conversion);
				newHotGoodsModel.setPurchaseRate(purchaserate);
				newHotGoodsModel.setPrice(price);
				
				logger.info(datetime.size()+"日期");				
				logger.info(flow.size()+"流量");				
				logger.info(payment.size()+"支付");				
				logger.info(plus.size()+"加购");				
				logger.info(money.size()+"金额");				
				logger.info(conversion.size()+"转化率");
				logger.info(purchaserate.size()+"加购率");
				logger.info(price.size()+"单价");
			/*	map.put("日期", datetime);
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
				logger.info(conversion.size()+"转化率");*/
				

				//输入流关闭close位置放不对也要出错
				  fileInputStream.close();
				  logger.info("文件输入流关闭");
				return newHotGoodsModel;
				
	        }
	        else
	        {
	        logger.info("打开文件有问题:传空数据");
	        return null;
	        }
	      
		
	
	}
	
	

}
