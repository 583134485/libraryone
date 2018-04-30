package com.guo.ssm.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guo.ssm.model.ShengejingModel;

public interface ShengejingModelDao {
	
	//查找所有
	List<ShengejingModel> findall();
	
	//动态按字段查找,只会找参数出现的字段,没设置的字段为空
	List<ShengejingModel> findByModel(ShengejingModel shengejingModel);
	
	//一天的一家电
	//按内容找，找到符合条件的所有字段
	List<ShengejingModel> findallByModel(ShengejingModel shengejingModel);
	
	//一家店一段时间的数据
	List<ShengejingModel> findLongDayModel(@Param("begin")Timestamp begin,@Param("end")Timestamp end ,@Param("shop")String shop);

	
	
	
	

}
