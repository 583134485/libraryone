package com.guo.ssm.util;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guo.ssm.dto.GoodSale3DDto;
import com.guo.ssm.model.ExcelViewModel;
import com.guo.ssm.model.ShengecanmouModel;

/**
 * 
 * 集中处理excel 操作
 */

public class ExcelUtil {

	private  static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

	// 集合对象 表示 不需要  声明 类
	//解析 excel  直接 的成为  前端 可用 视图  （并列 模式）
 	public  static Map<String, List<String>> ParseExcelToExcelModel(String filepath) throws InvalidFormatException, IOException {
		File file=new File(filepath);
		if(file.isFile()&&file.exists()) {
			FileInputStream fileInputStream = new FileInputStream(file);
			// 用新的api
			Workbook workbook = WorkbookFactory.create(fileInputStream);

			Sheet spreadsheet = workbook.getSheetAt(0);

			Sheet spreadsheet2 = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = spreadsheet.iterator();
			Map<String, List<String>> excelViewMap=new HashMap<>();
			String keyname=null;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// 每个单元
				Iterator<Cell> cellIterator = row.cellIterator();
            List<String> data=new ArrayList<>();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					//all to string 避免 各种格式
					int columnIndex=cell.getColumnIndex();
					int cellType=cell.getCellType();
					String cellvalue=null;
					if(cellType==cell.CELL_TYPE_NUMERIC) {
						//logger.info(" number cell="+cellvalue+"type"+cell.getCellType());
						//is date 
						if(XSSFDateUtil.isCellDateFormatted(cell))
						{
							//logger.info("is date");

							double d=cell.getNumericCellValue();
							java.util.Date date=XSSFDateUtil.getJavaDate(d);
							//SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
							SimpleDateFormat format=new SimpleDateFormat("MM/dd");
							String datestring =format.format(date);
							cellvalue=datestring;
							//logger.info("is date:"+datestring);							
						}
						else {
							 double d=cell.getNumericCellValue();
							 d=MathUtil.KeepDecimal(d, 2);
							// logger.info("d=="+d);
							// cell.setCellType(Cell.CELL_TYPE_STRING);
							 cellvalue=Double.toString(d);
						}
					}
					else {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						 cellvalue=cell.getStringCellValue();
					}
	   

					//logger.info("cell="+cellvalue+"type"+cell.getCellType());
					String rowname=null;
					//row key name

					int rowIndex=cell.getRowIndex();
					if(cellvalue==null) {
						logger.info("cell have null cell");
						return null;
					}
					if(columnIndex==0) {
						 rowname=cell.getStringCellValue();	

							 if(excelViewMap.containsKey(rowname)) {
								 logger.info("repeat row name"+rowname);
								 return null;
							 }
							 else {
								 //put key name in map
								 excelViewMap.put(rowname, null);
							 }
				 
					}
					//data list
					else {
					
						 keyname = spreadsheet2.getRow(rowIndex).getCell(0).toString();
							 data.add(cellvalue);
						 
					}
					
					
				
				}
				//add data
				excelViewMap.put(keyname, data);
        
				
			}
			logger.info("Result map==="+excelViewMap.toString());
			return excelViewMap;
			
		}
      
		else {
			return null;
		}
	
		
	}
	
	
	
	// 一个excel文件转化成model,同时识别 xls 和 xlsx
 	//需要 事先 声明类
	/**
	 * @param excelpath
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 * @throws ParseException
	 */
	public  static List<ShengecanmouModel> SingleExcelOfShengecanmouToModel(String excelpath)
			throws IOException, InvalidFormatException, ParseException { 		
		// 创建file
		File file = new File(excelpath);
		if(!file.isFile()||!file.exists()) {
			logger.info("文件打开有问题");
			return null;
		}	
		
			// 假设字段行的位置不固定,但为了保险起见，应为可能字段列没有被记录
			// 3应该是第4行
			int rowindex = 3;
			// 假设字段列的位置也不固定
			int ColumnIndex = 0;
			// 每new 个文件 一个 shengecanmou list，but only dao in one file
			List<ShengecanmouModel> shengecanmouModels = new ArrayList<ShengecanmouModel>();
			// 文件输入流
			FileInputStream fileInputStream = new FileInputStream(file);
			String filename = file.getName();
			/*
			 * if(getFiletype(filename).equals("xls")||getFiletype(filename).
			 * equals("xlsx")){
			 * 
			 * }
			 */
			// 用新的api
			Workbook workbook = WorkbookFactory.create(fileInputStream);

			Sheet spreadsheet = workbook.getSheetAt(0);

			Sheet spreadsheet2 = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = spreadsheet.iterator();

			// 至于先声明类 再 赋值，这样操作不懂
			/*
			 * HSSFSheet spreadsheet2; Iterator<Row> rowIterator ;
			 * 
			 * 
			 * if(getFiletype(filename).equals(new String("xls"))){ HSSFWorkbook
			 * workbook = new HSSFWorkbook(fileInputStream);
			 * 
			 * HSSFSheet spreadsheet = workbook.getSheetAt(0);
			 * 
			 * spreadsheet2 = workbook.getSheetAt(0);
			 * 
			 * rowIterator = spreadsheet.iterator(); }
			 * if(getFiletype(filename).equals(new String("xlsx"))){
			 * XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
			 * //找到sheet，第一页 XSSFSheet spreadsheet=workbook.getSheetAt(0);
			 * 
			 * spreadsheet2=(HSSFSheet)workbook.getSheetAt(0);
			 * 
			 * rowIterator = spreadsheet.iterator(); } else{
			 * logger.info("not xls or xlsx"); }
			 */
			// 打开xlsx
			/*
			 * XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
			 * //找到sheet，第一页 XSSFSheet spreadsheet=workbook.getSheetAt(0);
			 * 
			 * XSSFSheet spreadsheet2=workbook.getSheetAt(0);
			 */

			// 遍历每行

			// int nrow=0;
			// int testr=0;
			// 遍历
			while (rowIterator.hasNext()) {
				// nrow++;
				// 每行 new 一个model
				ShengecanmouModel shengecanmouModel = new ShengecanmouModel();
				// 每行
				// Row row = (XSSFRow) rowIterator.next();
				// Row row = (HSSFRow) rowIterator.next();
				// new api
				Row row = rowIterator.next();
				// 每个单元
				Iterator<Cell> cellIterator = row.cellIterator();
				// int nc=0;
				// int testc=0;
				while (cellIterator.hasNext()) {
					// nc++;
					Cell cell = cellIterator.next();
					// 只是为了识别type，目前只有0，1type
					// logger.info("row"+nrow+"nc"+nc+"type"+cell.getCellType());
					// logger.info(cell.getColumnIndex() + "III" +
					// cell.getCellType());

					/*
					 * test 最小的 是 0，0 if(cell.getRowIndex()<testr){
					 * testr=cell.getRowIndex(); }
					 * if(cell.getColumnIndex()<testc){
					 * testc=cell.getColumnIndex(); } logger.info(testr+testc);
					 */
					// cell的分类方式如何分类
					switch (cell.getCellType()) {
					// 空格，不做任何操作
					case Cell.CELL_TYPE_BLANK:
						break;
					case Cell.CELL_TYPE_STRING:
						// string 值
						String stringvalue = cell.getStringCellValue();
						//logger.info("行" + cell.getRowIndex() + "列" + cell.getColumnIndex() + "string:" + stringvalue);
						// 找到字段列，还有其他方式可选
						if (stringvalue.equals(new String("所属终端"))) {
							// 只是为了 设置 字段列，还是有必要的
							rowindex = cell.getRowIndex();
						}
						// 有效字段
						if (cell.getRowIndex() > rowindex) {
							// 直接获取本列的 字段 table name
							String tablename = spreadsheet2.getRow(rowindex).getCell(cell.getColumnIndex()).toString();
							if (tablename.equals(new String("所属终端"))) {
								shengecanmouModel.setTerminal(stringvalue);
							}
							if (tablename.equals(new String("商品标题"))) {
								shengecanmouModel.setTitle(stringvalue);
							}
							if (tablename.equals(new String("商品在线状态"))) {
								shengecanmouModel.setState(stringvalue);
							}
							if (tablename.equals(new String("商品链接"))) {
								shengecanmouModel.setUrl(stringvalue);
							}
						}

						// shengecanmou得不到 cannot get numriic value from text
						// cell
					case Cell.CELL_TYPE_NUMERIC:
						// 不明原因，转化位string
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String value = cell.getStringCellValue();
						if (cell.getRowIndex() > rowindex) {
							// 直接获取本列的 字段 table name
							String tablename2 = spreadsheet2.getRow(rowindex).getCell(cell.getColumnIndex()).toString();
							if (tablename2.equals(new String("商品id"))) {
								shengecanmouModel.setId(value);
							}
							if (tablename2.equals(new String("浏览量"))) {
								shengecanmouModel.setViews(value);
							}
							if (tablename2.equals(new String("访客数"))) {
								shengecanmouModel.setVisitors(value);
							}
							if (tablename2.equals(new String("平均停留时长"))) {
								shengecanmouModel.setStaytime(value);
							}
							if (tablename2.equals(new String("详情页跳出率"))) {
								shengecanmouModel.setDetailspage(value);
							}
							if (tablename2.equals(new String("下单转化率"))) {
								shengecanmouModel.setOrderconrate(value);
							}
							if (tablename2.equals(new String("下单支付转化率"))) {
								shengecanmouModel.setOrderpayconrate(value);
							}
							if (tablename2.equals(new String("支付转化率"))) {
								shengecanmouModel.setPayconrate(value);
							}
							if (tablename2.equals(new String("下单金额"))) {
								shengecanmouModel.setOrderamount(value);
							}
							if (tablename2.equals(new String("下单商品件数"))) {
								shengecanmouModel.setOrdergoods(value);
							}
							if (tablename2.equals(new String("下单买家数"))) {
								shengecanmouModel.setOrderbuyers(value);
							}
							if (tablename2.equals(new String("支付金额"))) {
								shengecanmouModel.setPayamount(value);
							}
							if (tablename2.equals(new String("支付商品件数"))) {
								shengecanmouModel.setPaygoods(value);
							}
							if (tablename2.equals(new String("加购件数"))) {
								shengecanmouModel.setPurchase(value);
							}
							if (tablename2.equals(new String("访客平均价值"))) {
								shengecanmouModel.setVisitorsvalue(value);
							}
							if (tablename2.equals(new String("点击次数"))) {
								shengecanmouModel.setClicktimes(value);
							}
							if (tablename2.equals(new String("点击率"))) {
								shengecanmouModel.setClickrate(value);
							}
							if (tablename2.equals(new String("曝光量"))) {
								shengecanmouModel.setExposure(value);
							}
							if (tablename2.equals(new String("收藏人数"))) {
								shengecanmouModel.setCollection(value);
							}
							if (tablename2.equals(new String("搜索引导支付买家数"))) {
								shengecanmouModel.setSearchbuyers(value);
							}
							if (tablename2.equals(new String("客单价"))) {
								shengecanmouModel.setUnitprice(value);
							}
							if (tablename2.equals(new String("搜索支付转化率"))) {
								shengecanmouModel.setSearchpay(value);
							}
							if (tablename2.equals(new String("搜索引导访客数"))) {
								shengecanmouModel.setSearchvisitors(value);
							}
							if (tablename2.equals(new String("支付买家数"))) {
								shengecanmouModel.setPaybuyers(value);
							}
							if (tablename2.equals(new String("售中售后成功退款金额"))) {
								shengecanmouModel.setRefundamount(value);
							}
							if (tablename2.equals(new String("售中售后成功退款笔数"))) {
								shengecanmouModel.setRefundnumbers(value);
							}
						}
						// logger.info("number"+cell.getRowIndex()+"col"+cell.getColumnIndex()+"type"+cell.getCellType());
						// String doublevalue=cell.getNumericCellValue();
						// logger.info("numberic:"+cell.getNumericCellValue());
						//logger.info("numtosring" + "行" + cell.getRowIndex() + "列" + cell.getColumnIndex() + "value:"
						//		+ cell.getStringCellValue());
					default:
						break;
					}
				}
				// 每行都new model 前三行的也会null填入数据，if判断变得没用了
				if (shengecanmouModel.getId() != null) {

					shengecanmouModel.setRecordtime(FileNametoDate(filename));
					shengecanmouModels.add(shengecanmouModel);
				}
			}
			//close
			fileInputStream.close();
			// both if and else has return
			return shengecanmouModels;
		}


	//一堆excel同时导入model 性能不知到会怎样,需要重新设计
	public List<ShengecanmouModel> ManyExcelOfShengecanmouToModel(List<String> excelpathlist)
			throws IOException, InvalidFormatException, ParseException {
		return null;
		
	}
	// 解析文件标题 to 日期
	public  static java.sql.Date  FileNametoDate(String filename) throws ParseException {
		String[] a = filename.split("\\-");
		TimeDateUtil timeDateUtil = new TimeDateUtil();
		String stringdate = a[1] + "-" + a[2] + "-" + a[3];
		java.sql.Date date = timeDateUtil.StringtoDate(stringdate);

		return date;
	}

	// get file type
	public String getFiletype(String filename) {
		String[] a = filename.split("\\.");
		return a[1];
	}

	// 针对所有的model 一维的数据都能转化成 excel
	// 但字段都是英文。。用的人估计在意 ，暂时通过带入集合，暂时用set好了,set会去重 ，其实都一样
	// 指定保存路径,失败返回null
    //
	/**
	 * @throws IOException 
	 * @Title: MakeModelToExcel @Description:將所有model 转化 xlsx
	 * 格式的，关于字段name的顺序,都参照最原始的excel表格 @param @param
	 * shengecanmouModelsd @param @param name @param @param
	 * excelpath @param @return 参数 @return String 返回类型 @throws
	 */
	public static String MakeModelToExcel(List<ShengecanmouModel> shengecanmouModels, List<String> name,String filename) throws IOException {
		// create a 工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet();

		workbook.setSheetName(0, "先随便定了个sheet");
    
		XSSFRow titleRow2 = sheet.createRow(0);
		titleRow2.createCell(0).setCellValue("服务器系统导入时间时间日期（服务器时间）："+new java.util.Date().toString());
		int indexrow = 3;
		//filename
		
		//String filename="生意参谋-商品效果-导出"+shengecanmouModels.get(0).getRecordtime().toString()+".xlsx";
		// 暂时创建第3行，字段行
		XSSFRow titleRow = sheet.createRow(indexrow);
		for (int i = 0; i < name.size(); i++) {
			titleRow.createCell(i).setCellValue(name.get(i));
		}
       //每一行
		for (int i = 0; i <shengecanmouModels.size(); i++) {
			// 从第4行开始写
			XSSFRow row = sheet.createRow(4 + i);
			//logger.info("writemodel:"+shengecanmouModels.get(i));
			ShengecanmouModel smModel=shengecanmouModels.get(i);
			List<String> value=new ArrayList<String>();
			value.add(smModel.getTerminal());
			value.add(smModel.getId());
			value.add(smModel.getTitle());
			value.add(smModel.getState());
			value.add(smModel.getUrl());
			value.add(smModel.getViews());
			value.add(smModel.getVisitors());
			value.add(smModel.getStaytime());
			value.add(smModel.getDetailspage());
			value.add(smModel.getOrderconrate());
			value.add(smModel.getOrderpayconrate());
			value.add(smModel.getPayconrate());
			value.add(smModel.getOrderamount());
			value.add(smModel.getOrdergoods());
			value.add(smModel.getOrderbuyers());
			value.add(smModel.getPayamount());
			value.add(smModel.getPaygoods());
			value.add(smModel.getPurchase());
			value.add(smModel.getVisitorsvalue());
			value.add(smModel.getClicktimes());
			value.add(smModel.getClickrate());
			value.add(smModel.getExposure());
			value.add(smModel.getCollection());
			value.add(smModel.getSearchbuyers());
			value.add(smModel.getUnitprice());			
			value.add(smModel.getSearchpay());
			value.add(smModel.getSearchvisitors());
			value.add(smModel.getPaybuyers());
			value.add(smModel.getRefundamount());
			value.add(smModel.getRefundnumbers());

			// 每一列 // 便利  集合 再次输入  （可以一利用反射 遍历 类 model 输入）
			for (int column = 0; column < value.size(); column++) {
				row.createCell(column).setCellValue(value.get(column));

			}

		}
		//create new excel file
		
 
/*    File file=new File(excelpath+filename);
    
    FileOutputStream fileOutputStream =new FileOutputStream(file);
    workbook.write(fileOutputStream);
    
    
    //flush
    fileOutputStream.flush();
    //close
    fileOutputStream.close();*/
		String filepath=FileDaoUtil.WorkSheetToFile(workbook, filename);  
         logger.info("finish excel"+filename);
		return filepath;
	}

	//临时读取excel file to dto 的 util 
	public  List<GoodSale3DDto> ReadExcelToGoodSaleDto(String excelpath) throws IOException, InvalidFormatException{
		// 创建file
				File file = new File(excelpath);

				if (file.isFile() && file.exists()) {
					
					// 假设字段行的位置不固定,但为了保险起见，应为可能字段列没有被记录
					// 3应该是第4行
					int rowindex = 0;
					// 假设字段列的位置也不固定
					int ColumnIndex = 0;
					// 每new 个文件 一个 shengecanmou list，but only dao in one file
					List<GoodSale3DDto> goodSale3DDtos = new ArrayList<GoodSale3DDto>();
					// 文件输入流
					FileInputStream fileInputStream = new FileInputStream(file);

					String filename = file.getName();

				
					// 用新的api
					Workbook workbook = WorkbookFactory.create(fileInputStream);

					Sheet spreadsheet = workbook.getSheetAt(0);

					Sheet spreadsheet2 = workbook.getSheetAt(0);

					Iterator<Row> rowIterator = spreadsheet.iterator();

					// 遍历每行

					// int nrow=0;
					// int testr=0;
					// 遍历
					while (rowIterator.hasNext()) {
						// nrow++;
						// 每行 new 一个model list
						List<GoodSale3DDto> goodSale3DDtos2=new ArrayList<GoodSale3DDto>();
						String typename=new String();
						
						// 每行
						// Row row = (XSSFRow) rowIterator.next();
						// Row row = (HSSFRow) rowIterator.next();
						// new api
						Row row = rowIterator.next();
						// 每个单元
						Iterator<Cell> cellIterator = row.cellIterator();
						// int nc=0;
						// int testc=0;
						while (cellIterator.hasNext()) {
							//cell 一哥类
							GoodSale3DDto goodSale3DDto = new GoodSale3DDto();
							
							
							// nc++;
							Cell cell = cellIterator.next();
							// 只是为了识别type，目前只有0，1type
							// logger.info("row"+nrow+"nc"+nc+"type"+cell.getCellType());
							// logger.info(cell.getColumnIndex() + "III" +
							// cell.getCellType());

							/*
							 * test 最小的 是 0，0 if(cell.getRowIndex()<testr){
							 * testr=cell.getRowIndex(); }
							 * if(cell.getColumnIndex()<testc){
							 * testc=cell.getColumnIndex(); } logger.info(testr+testc);
							 */
							// cell的分类方式如何分类
							switch (cell.getCellType()) {
							// 空格，不做任何操作
							case Cell.CELL_TYPE_BLANK:
								break;
							case Cell.CELL_TYPE_STRING:
								// string 值
								String stringvalue = cell.getStringCellValue().toString();
								logger.info("行" + cell.getRowIndex() + "列" + cell.getColumnIndex() + "string:" + stringvalue);
								// 找到字段列，还有其他方式可选
								if (stringvalue.equals(new String("类别"))) {
									// 只是为了 设置 字段列，还是有必要的
									rowindex = cell.getRowIndex();
									logger.info("set tppe 所在行"+rowindex);
								}
								// 有效字段
								if (cell.getRowIndex() > rowindex) {
									logger.info("设置前");
									// 直接获取本列的 字段 table name
									String tablename = spreadsheet2.getRow(rowindex).getCell(cell.getColumnIndex()).toString();
									logger.info("首行"+tablename);
									if (tablename.equals(new String("类别"))) {
										logger.info("is type");
									   typename=stringvalue;
									  logger.info(" set typename "+stringvalue);
									}
									else{
										logger.info("is not type ?");
										//typename=stringvalue;
									}
									
									
									
								}

								// shengecanmou得不到 cannot get numriic value from text
								// cell
							case Cell.CELL_TYPE_NUMERIC:
								// 不明原因，直接转化位string
								cell.setCellType(Cell.CELL_TYPE_STRING);
								String value = cell.getStringCellValue();
								if (cell.getRowIndex() > rowindex) {
									// 直接获取本列的 字段 table name
									String tablename2 = spreadsheet2.getRow(rowindex).getCell(cell.getColumnIndex()).toString();
									if (tablename2.equals(new String("1月销量"))) {
										goodSale3DDto.setMonth(tablename2);
										goodSale3DDto.setSale(value);
										goodSale3DDto.setType(typename);
									}
									if (tablename2.equals(new String("2月销量"))) {
										goodSale3DDto.setMonth(tablename2);
										goodSale3DDto.setSale(value);
										goodSale3DDto.setType(typename);
									}
									if (tablename2.equals(new String("3月销量"))) {
										goodSale3DDto.setMonth(tablename2);
										goodSale3DDto.setSale(value);
										goodSale3DDto.setType(typename);
									}
									if (tablename2.equals(new String("4月销量"))) {
										goodSale3DDto.setMonth(tablename2);
										goodSale3DDto.setSale(value);
										goodSale3DDto.setType(typename);
									}
									if (tablename2.equals(new String("5月销量"))) {
										goodSale3DDto.setMonth(tablename2);
										goodSale3DDto.setSale(value);
										goodSale3DDto.setType(typename);
									}
									if (tablename2.equals(new String("6月销量"))) {
										goodSale3DDto.setMonth(tablename2);
										goodSale3DDto.setSale(value);
										goodSale3DDto.setType(typename);
									}
									if (tablename2.equals(new String("7月销量"))) {
										goodSale3DDto.setMonth(tablename2);
										goodSale3DDto.setSale(value);
										goodSale3DDto.setType(typename);
									}
									if (tablename2.equals(new String("8月销量"))) {
										goodSale3DDto.setMonth(tablename2);
										goodSale3DDto.setSale(value);
										goodSale3DDto.setType(typename);
									}
									if (tablename2.equals(new String("9月销量"))) {
										goodSale3DDto.setMonth(tablename2);
										goodSale3DDto.setSale(value);
										goodSale3DDto.setType(typename);
									}



								}
							 
								logger.info("numtosring" + "行" + cell.getRowIndex() + "列" + cell.getColumnIndex() + "value:"
										+ cell.getStringCellValue());
							default:
								break;
								
							}
							if(goodSale3DDto.getMonth()!=null&goodSale3DDto.getSale()!=null&goodSale3DDto.getType()!=null){
								goodSale3DDtos2.add(goodSale3DDto);
								logger.info("add once"+goodSale3DDto);
							}
							else{
								logger.info("无效数据 无法 读入");
							}
						
						}
						// 每行都new model 前三行的也会null填入数据，if判断变得没用了
					

							goodSale3DDtos.addAll(goodSale3DDtos2);
							logger.info("add model list");
						

					}
				
					//close
					fileInputStream.close();
					// both if and else has return
					return goodSale3DDtos;

				} else {
					logger.info("文件打开有问题");
					return null;
				}
		
	}
}
