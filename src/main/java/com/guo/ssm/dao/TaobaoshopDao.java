package com.guo.ssm.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.swing.text.TabableView;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.support.logging.Log;
import com.guo.ssm.dto.Brand_Sale;
import com.guo.ssm.dto.TaobaoDto;
import com.guo.ssm.model.KeysModel;
import com.guo.ssm.model.Taobaoshop;

public interface TaobaoshopDao {
	
  List <Taobaoshop> findAll(@Param("index")int index, @Param("limit") int limit);
  //查询所有
  //para dto
  List <TaobaoDto> findaall(TaobaoDto taobaoDto);
  
  List<Taobaoshop> findbykeys(KeysModel keysModel);
  
  //批量插入
 /* @Transactional(propagation=Propagation.NOT_SUPPORTED)*/
 void insertByBatch(List<Taobaoshop>taobaoshops);
  
  //添加  不能为空  不能重复
  void add(Taobaoshop taobaoshops);
  //更新操作
  void update(Taobaoshop taobaoshop);
  
  //按时间查找
 /* List<Taobaoshop> findByTime(@Param("starttime")Timestamp startime,@Param("endtime")Timestamp endtime);*/
  
  
  
  
  





   

}
