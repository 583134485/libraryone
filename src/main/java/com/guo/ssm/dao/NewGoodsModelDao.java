package com.guo.ssm.dao;

import java.util.List;

import com.guo.ssm.model.NewGoodsModel;

//如果数据库字段设置not null，sql语句加入判断是否为空
public interface NewGoodsModelDao {
	
	List<NewGoodsModel> findall();
	
	void add(NewGoodsModel newGoodsModel);
	//单个插入时用用挺好
	void insert(NewGoodsModel newGoodsModel);
	//批量插入
	void insertByBatch(List<NewGoodsModel> newGoodsModels);
		

}
