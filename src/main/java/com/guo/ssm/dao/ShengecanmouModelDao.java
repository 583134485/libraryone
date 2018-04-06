package com.guo.ssm.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.guo.ssm.model.ShengecanmouModel;

public interface ShengecanmouModelDao {
	
	//只会返回 0，1
	int isExistByIdNew(String id);
	
	//通过id检查是否存在，不存在则会后台红字。。
	 ShengecanmouModel isExistById(String id);
	
	 // find all
	 List<ShengecanmouModel> findall();
	 
	
	List<ShengecanmouModel> findConversionById(String id);
	 
	 //某一天某个id的 ，单条数据,可可以是某一天，也可以是某一个id
    List<ShengecanmouModel> findOneDayOneGood(@Param("recordtime")Date recordtime,@Param("id")String id);
    
    //一段时间的，一条id,或者一段时间的一个id,别全文搜索
    List<ShengecanmouModel> findLongDayGood(@Param("start")Date start,@Param("end")Date end,@Param("id")String id);
	 
     //动态查询，符合条件的:字段过多，这里展示对id..
     List<ShengecanmouModel> findByModel(ShengecanmouModel shengecanmouModel);
	 
	 //批量插入，应该没有什么批量搜索啥的（不久时普通select吗）,考虑到重复插入情况
	 void insertByBatch(List<ShengecanmouModel> shengecanmouModels);
	 
	 //单条插入，测试重复插入的情况
	 void add(ShengecanmouModel shengecanmouModel);
	 
	 //退 订单
	 List<ShengecanmouModel> OderAndRefund(String id);
     
	 List<ShengecanmouModel> findallByIdAndOther(@Param("id")String id,@Param("word")String word);
	 //统计 某个值  在这段时间
	 List<ShengecanmouModel> findAllQuarter(@Param("keyword") String keyword,@Param("limit")int limit);
	
	 //对 针对 各个 id的 keyword 统计值 求 平均   保留 两位小数
	 List<ShengecanmouModel> findKeyWordAverage(@Param("keyword") String keyword,@Param("limit")int limit);
	 
	 //总的 keyword  统计 平均值 保留两位小数
	 ShengecanmouModel AllKeyWordAverage(@Param("keyword")String keyword);
     
	 //
	 List<ShengecanmouModel> AllPlusByKeyword(@Param("keyword")String keyword,@Param("limit")int limit );
}
