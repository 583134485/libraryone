package com.guo.ssm.service;

import java.util.List;
import java.util.Map;

import com.guo.ssm.dto.JsonDemoDto;
import com.guo.ssm.model.NewHotGoodsModel;
import com.guo.ssm.model.Taobaoshop;

public interface TaobaoshopService {
    //累计品牌——销量
	Map<String, String> CountAll(int limit);
	
	
	//构造并更新最新不重复的SKU的新的数据库
    void MakeNewShop();
	
    //调用一家店铺的所有信息b
    List <Taobaoshop> FindShopByName(String name);
    
    //找到所有商铺
    List<Taobaoshop> FindShop(int index,int limit);
    //Treemap echarts的树形数据结构的构造
    List<JsonDemoDto> ShowTreeMap(String name);
    //爆款的初步展示，传入（.xlsx路径）
    Map ShowHotGoods(String string);
  //爆款的进一步展示，传入（.xlsx路径）
    NewHotGoodsModel ShowNewHotGoods(String string);
	
		
}
