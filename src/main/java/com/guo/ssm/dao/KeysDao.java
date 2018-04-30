package com.guo.ssm.dao;

import java.util.List;

import com.guo.ssm.model.KeysModel;

public interface KeysDao {
	
	//寻找店铺KEY
	List <KeysModel> findall();
	
	KeysModel findbyname(String name);
	

}
