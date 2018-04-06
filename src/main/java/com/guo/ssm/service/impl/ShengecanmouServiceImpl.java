package com.guo.ssm.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64.Decoder;
import java.util.List;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.aspectj.apache.bcel.classfile.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.guo.ssm.dao.ShengecanmouModelDao;
import com.guo.ssm.model.ShengecanmouModel;
import com.guo.ssm.service.ShengecanmouService;
import com.guo.ssm.util.DtoDataFilterUtil;
import com.guo.ssm.util.ExcelUtil;
import com.guo.ssm.util.FileDaoUtil;
import com.guo.ssm.util.StringDaoUtil;
import com.guo.ssm.util.TimeDateUtil;

//最好好事放 缓存吧。。。
@Service 
public class ShengecanmouServiceImpl  implements ShengecanmouService{

	Logger logger=Logger.getLogger(Class.class);
	
	@Autowired
	ShengecanmouModelDao shengecanmouModelDao;
	
	//request and reponse 待用
	@Override
	public String FileUpload(HttpServletRequest request,HttpServletResponse response, @RequestParam("file") MultipartFile[] files) {
		
		FileDaoUtil fileDaoUtil=new FileDaoUtil();
		ExcelUtil excelUtil=new ExcelUtil();
		
		//返回文件路径list
	 
		List<String> pathlist=fileDaoUtil.UploadFilesAndReturnPath(files);
		logger.info("filepathlist:"+pathlist);
		for(String excelpath:pathlist){
			
			List<ShengecanmouModel> shengecanmouModels = null;
			try {
				logger.info("读取excel");
				//读取excel
				shengecanmouModels = excelUtil.SingleExcelOfShengecanmouToModel(excelpath);
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("批量插入数据库");
			//批量长如并忽略重复数据
			shengecanmouModelDao.insertByBatch(shengecanmouModels);
		   logger.info("插入完毕");
		}
		
		//程序不报错测显示
		return "上传并存入数据库";
	}

	
	//文件导出这里只是简单的excel 原有文件导出
	@Override
	public String FileDownLoad(HttpServletRequest request, HttpServletResponse response) {	
		FileDaoUtil fileDaoUtil=new FileDaoUtil();
		String msg=FileDownLoad(request, response);
	
		return msg;
	}


	
	//选择性的sql生成excel，并下载（压缩过的文件）
	@Override
	public String DownLoadSearchDataBaseToExcel(HttpServletRequest request, HttpServletResponse response) {
		logger.info("enterservice");
/*		String startdate=null;
		String enddate=null;
		String id=null;
		try {
			//前台用了encodeurlcom
			//为了解析前台的特殊字符和中文，只正对get 方式，应为  get能进行比较方便的下载
			startdate=URLDecoder.decode(request.getParameter("start"), "UTF-8").toString();
			logger.info("startdate"+startdate);
			enddate=URLDecoder.decode(request.getParameter("end"), "UTF-8").toString();
			logger.info("end"+enddate);
			id=URLDecoder.decode(request.getParameter("id"), "UTF-8").toString();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		//防止全数据库搜索，虽然前端已经不能为空了。。。
		String startdate=request.getParameter("start");
		logger.info("start"+startdate);
		String enddate=request.getParameter("end");
		logger.info("end"+enddate);
		String id=request.getParameter("id");
		logger.info("id"+id);
		List<ShengecanmouModel> shengecanmouModels=null;
		ExcelUtil excelUtil=new ExcelUtil();
		TimeDateUtil timeDateUtil=new TimeDateUtil();
	
		//虽说前端jquery已经避免了时期错误，这里就暂时不做了
		//可以查一天，也可一id,也可以一天，一id
		if(startdate.equals(enddate)){
		
			
			java.sql.Date day = null;
			try {
				day = timeDateUtil.StringtoDate(startdate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("查找数据库");
		shengecanmouModels=	shengecanmouModelDao.findOneDayOneGood(day,id);
	
		//必须按顺序存放
				List<String> name=new ArrayList<String>();
				name.add("所属终端");
				name.add("商品id");
				name.add("商品标题");
				name.add("商品在线状态");
				name.add("商品链接");
				name.add("浏览量");
				name.add("访客数");
				name.add("平均停留时长");
				name.add("详情页跳出率");
				name.add("下单转化率");		
				name.add("下单支付转化率");
				name.add("支付转化率");
				name.add("下单金额");
				name.add("下单商品件数");
				name.add("下单买家数");
				name.add("支付金额");
				name.add("支付商品件数");
				name.add("加购件数");		
				name.add("访客平均价值");
				name.add("点击次数");
				name.add("点击率");
				name.add("曝光量");
				name.add("收藏人数");
				name.add("搜索引导支付买家数");
				name.add("客单价");
				name.add("搜索支付转化率");
				name.add("搜索引导访客数");
				name.add("支付买家数");
				name.add("售中售后成功退款金额");
				name.add("售中售后成功退款笔数");
				String filepath=null;
			try {
				 filepath=excelUtil.MakeModelToExcel(shengecanmouModels, name, "F:\\fileDownLoad\\");
				 logger.info("make excel");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FileDaoUtil fileDaoUtil=new FileDaoUtil();
			String message=null;
			 try {
				 logger.info("filepath"+filepath);
				message=fileDaoUtil.FileDownLoadNew(filepath, response);
				logger.info("down");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 //返回信息
			return message;
			
			
		}
		
		
		//虽然前端控制了错误日期顺序，但虽知道前端是我写的呢
		//还是要判断一下先后顺序
		else {
			//一段时间查询
		
			java.sql.Date start=null;
			java.sql.Date end=null;
			try {
				start =timeDateUtil.StringtoDate(startdate);
				end=timeDateUtil.StringtoDate(enddate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			shengecanmouModels=shengecanmouModelDao.findLongDayGood(start, end,id);
			
			//必须按顺序存放
			List<String> name=new ArrayList<String>();
			name.add("所属终端");
			name.add("商品id");
			name.add("商品标题");
			name.add("商品在线状态");
			name.add("商品链接");
			name.add("浏览量");
			name.add("访客数");
			name.add("平均停留时长");
			name.add("详情页跳出率");
			name.add("下单转化率");		
			name.add("下单支付转化率");
			name.add("支付转化率");
			name.add("下单金额");
			name.add("下单商品件数");
			name.add("下单买家数");
			name.add("支付金额");
			name.add("支付商品件数");
			name.add("加购件数");		
			name.add("访客平均价值");
			name.add("点击次数");
			name.add("点击率");
			name.add("曝光量");
			name.add("收藏人数");
			name.add("搜索引导支付买家数");
			name.add("客单价");
			name.add("搜索支付转化率");
			name.add("搜索引导访客数");
			name.add("支付买家数");
			name.add("售中售后成功退款金额");
			name.add("售中售后成功退款笔数");
			String filepath=null;
		try {
			 filepath=excelUtil.MakeModelToExcel(shengecanmouModels, name, "F:\\fileDownLoad\\");
			 logger.info("make excel");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileDaoUtil fileDaoUtil=new FileDaoUtil();
		String message=null;
		 try {
			 logger.info("filepath"+filepath);
			message=fileDaoUtil.FileDownLoadNew(filepath, response);
			logger.info("down");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //返回信息
		return message;
		}
	/*	//找到为空，有待考证
		if(shengecanmouModels.size()==0){
			return "nothing find";
		}*/
		//
		/*else{
			ExcelUtil excelUtil=new ExcelUtil();
			//导出的文件明暂时不合理
			String filepath=excelUtil.MakeModelToExcel(shengecanmouModels, "", "");
		}*/
		
	
		
		
	}


	//检查id是否存在API
	@Override
	 public Boolean CheckID(HttpServletRequest request) {
		String id=request.getParameter("id");
		logger.info("id:"+id);
		ShengecanmouModel shengecanmouModel=null;

			//其实可以加入缓存，待会加
		// shengecanmouModel=shengecanmouModelDao.isExistById(id);
		//用count 方式防止出现红字
		int count=shengecanmouModelDao.isExistByIdNew(id);
		if(count>0){
			return true;
		}
		else{
			return false;
		}

		
	
	}


	
	//条件搜索model
	//id 暂时不能为空
	@Override
	public List<ShengecanmouModel> searchfortable(HttpServletRequest request) {
		String start=request.getParameter("start");
		String end =request.getParameter("end");
		String id= request.getParameter("id");
		String oneday=request.getParameter("oneday");
		TimeDateUtil timeDateUtil=new TimeDateUtil();
		List<ShengecanmouModel> shengecanmouModels=null;
		//当天查询
		if(start.equals("0")||end.equals("0")&&!oneday.equals("0")){
			java.sql.Date date=null;
			try {
				date = timeDateUtil.StringtoDate(oneday);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	shengecanmouModels=shengecanmouModelDao.findOneDayOneGood(date, id);
			//return shengecanmouModels;
		}
		//查询一段时间的
		if(!start.equals("0")&&!end.equals("0")&&oneday.equals("0")){
			try {
				 shengecanmouModels=shengecanmouModelDao.findLongDayGood(timeDateUtil.StringtoDate(start), timeDateUtil.StringtoDate(end), id);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//return shengecanmouModels;
		}
		return shengecanmouModels;
	}


	@Override
	public List<ShengecanmouModel> showLongDayByID(String id, String word) {
		
		List<ShengecanmouModel> shengecanmouModels=shengecanmouModelDao.findallByIdAndOther(id,word);
		
		return shengecanmouModels;
	}


	@Override
	public List<ShengecanmouModel> showOderAndRefun(String id) {
		List<ShengecanmouModel> shengecanmouModels=shengecanmouModelDao.OderAndRefund(id);
		//logger.info("dao"+shengecanmouModels.size());
		return shengecanmouModels;
	}


	@Override
	public List<ShengecanmouModel> showquarter(String keyword) {
		List<ShengecanmouModel> shengecanmouModels=shengecanmouModelDao.findAllQuarter(keyword,10);
		return shengecanmouModels;
	}


	@Override
	public ShengecanmouModel showconversion(String id) {
		List<ShengecanmouModel> shengecanmouModels=shengecanmouModelDao.findConversionById(id);
		DtoDataFilterUtil dataFilterUtil=new DtoDataFilterUtil();
		ShengecanmouModel shengecanmouModel=dataFilterUtil.averageconversion(shengecanmouModels);
		return shengecanmouModel;
	}


	@Override
	public List<ShengecanmouModel> showfullgraph(String keyword) {
		ShengecanmouModel shengecanmouModel=shengecanmouModelDao.AllKeyWordAverage(keyword);
		shengecanmouModel.setTitle("卓雅");
		List<ShengecanmouModel > shengecanmouModels=shengecanmouModelDao.findKeyWordAverage(keyword, 30);
		shengecanmouModels.add(shengecanmouModel);
		
		return shengecanmouModels;
	}


	@Override
	public List<ShengecanmouModel> showHotWord(String keyword,int limit) {
		if(limit>=60){
			limit=60;
		}
		List<ShengecanmouModel> shengecanmouModels=shengecanmouModelDao.AllPlusByKeyword(keyword, limit);
		StringDaoUtil stringDaoUtil=new StringDaoUtil();
		for(ShengecanmouModel shengecanmouModel:shengecanmouModels){
			String title=shengecanmouModel.getTitle();
			title=stringDaoUtil.ReduceString(title, "JORYA");
			title=stringDaoUtil.ReduceString(title, "欣贺卓雅");
			title=stringDaoUtil.ReduceString(title, "卓雅周末");
			shengecanmouModel.setTitle(title);
			
		}
		return shengecanmouModels;
	}
	
	
	
	

}
