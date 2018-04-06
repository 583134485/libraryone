package com.guo.ssm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.guo.ssm.model.ShengecanmouModel;

public interface ShengecanmouService {

	//文件导入，返回导入结果
	//传入文件
	String FileUpload(HttpServletRequest request,HttpServletResponse response, @RequestParam("file") MultipartFile[] files);
	
	//简单选择文件名的纯文件下载
	String FileDownLoad(HttpServletRequest request,HttpServletResponse response);
	
	//选择条件性从sql生产excel,再下载
	String DownLoadSearchDataBaseToExcel(HttpServletRequest request,HttpServletResponse response);
	
	//检查iD
	Boolean CheckID(HttpServletRequest request);
	
	//条件搜索shengecanmoumodel
	List<ShengecanmouModel> searchfortable(HttpServletRequest request);
	
	//单个商品全生命周期 字段 随时间 展示
	List<ShengecanmouModel> showLongDayByID(String id,String detail);
	
	//下单 退单
	List<ShengecanmouModel> showOderAndRefun(String id);
	
	
	//展示 一个 时间端 内的  有效数据 的 占比重 分析
	List<ShengecanmouModel> showquarter(String keyword);
	
	//一哥id 的统计  转化过程
	ShengecanmouModel showconversion(String id);
	
	//统计  keyword 所有值 关系中的占比  因为  没有完全生命周期统计 所以 目前 取 平均值 
	List<ShengecanmouModel> showfullgraph(String keyword);
	
	//粗略 统计 热度 也就是综合比 
	List<ShengecanmouModel> showHotWord(String keyword,int limit);
	
}
