package com.guo.ssm.service.impl;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.logging.Log;
import com.guo.ssm.cache.RedisCache;
import com.guo.ssm.dao.KeysDao;
import com.guo.ssm.dao.NewGoodsModelDao;
import com.guo.ssm.dao.TaobaoshopDao;
import com.guo.ssm.dto.Brand_Sale;
import com.guo.ssm.dto.JsonDemoDto;
import com.guo.ssm.dto.TaoDataForView;
import com.guo.ssm.model.KeysModel;
import com.guo.ssm.model.NewGoodsModel;
import com.guo.ssm.model.NewHotGoodsModel;
import com.guo.ssm.model.Taobaoshop;
import com.guo.ssm.service.TaobaoshopService;
import com.guo.ssm.util.Brand_SaleCount;
import com.guo.ssm.util.DtoToModelUtil;
import com.guo.ssm.util.HotGoodsExcelUtil;
import com.guo.ssm.util.HotGoodsExcelUtilNew;
import com.guo.ssm.util.ShopFilter;
import com.guo.ssm.util.TaoshopToJsonDemoUtil;

@Service // @Service 不加会报错
public class TaobaoshopServiceImpl implements TaobaoshopService {
	Logger log = Logger.getLogger(Class.class);
	@Autowired
	private TaobaoshopDao taobaoshopdao;
	@Autowired
	private KeysDao keysDao;
	@Autowired
	private RedisCache redisCache;
	
	@Autowired
	private NewGoodsModelDao newGoodsModelDao;

	/*
	 * @Autowired Brand_SaleCount doCount;
	 */
	Brand_SaleCount doCount = new Brand_SaleCount();
	List<Brand_Sale> c = new ArrayList<Brand_Sale>();
	Map<String, String> map = new HashMap<String, String>();
	ShopFilter shopFilter = new ShopFilter();
	TaoshopToJsonDemoUtil todemouitl = new TaoshopToJsonDemoUtil();

	@Override
	public Map<String, String> CountAll(int limit) {
		log.info("findstart");
		List<Taobaoshop> taobaoshops = taobaoshopdao.findAll(0, limit);
		log.info("findend");
		// 上商品去重
		taobaoshops = shopFilter.shopfilter(taobaoshops);

		// 转化成DTO
		for (Taobaoshop a : taobaoshops) {
			Brand_Sale brand_Sale = new Brand_Sale(a);
			/* System.out.print(brand_Sale); */
			c.add(brand_Sale);
			/* log.info(c.toString()); */// 太慢无视。。。
		}

		map = doCount.count(c);
		// 防止C变量的c.add叠加，具体原因未知
		c = new ArrayList<Brand_Sale>();
		// 貌似还是要new 亲空 。。。
		doCount = new Brand_SaleCount();
		log.info("finsh count");
		return map;
	}

	@Override
	public void MakeNewShop() {
		List<KeysModel> models = keysDao.findall();
		for (KeysModel keysModel : models) {
			log.info("遍历keys" + keysModel.getId());
			List<Taobaoshop> taobaoshops = taobaoshopdao.findbykeys(keysModel);
			log.info("findshop" + taobaoshops.size());
			taobaoshops = shopFilter.shopfilter(taobaoshops);
			log.info("afterfilter" + taobaoshops.size());
			if (taobaoshops.size() > 0) {
				log.info("可以插入");
				// 1.这里使用遍历插入
				/*
				 * for(Taobaoshop taobaoshop:taobaoshops){
				 * taobaoshopdao.add(taobaoshop); log.info("入库..."); }
				 * log.info("endinsert");
				 */
				// 2.使用批量插入
				long starttime = System.currentTimeMillis();
				taobaoshopdao.insertByBatch(taobaoshops);
				long endtime = System.currentTimeMillis();
				log.info("insert+time=" + (endtime - starttime) / 1000 + "s");
			} else {
				log.info("空，不插入");
			}

		}

	}

	// 查店铺的相关信息
	// param name
	@Override
	public List<Taobaoshop> FindShopByName(String name) {
		long a = System.currentTimeMillis();
		ShopFilter shopFilter = new ShopFilter();
		//keyModel 数据不在了。。
		//KeysModel keysModel = keysDao.findbyname(name);
		KeysModel keysModel=new KeysModel();
		keysModel.setName("无印良品MUJI");
		// log.info("find keysmodel");
		List<Taobaoshop> taobaoshops = taobaoshopdao.findbykeys(keysModel);
		// log.info("findall shops");
		// log.info("shop找到+"+taobaoshops.size()+"家");
		// shopliter
		taobaoshops = shopFilter.shopfilter(taobaoshops);
		// log.info("shopfilter筛选后+"+taobaoshops.size()+"家");
		long b = System.currentTimeMillis();
		log.info("find费时" + (b - a));
		return taobaoshops;
	}

	@Override
	public List<Taobaoshop> FindShop(int index, int limit) {
		List<Taobaoshop> taobaoshops = taobaoshopdao.findAll(index, limit);
		return taobaoshops;
	}

	//数据多，暂时本地缓存
	@Override
	public List<JsonDemoDto> ShowTreeMap(String name) {
		String cache_key = RedisCache.CAHCENAME + "|getShopByName"+"|"+name;
		String cache_key2 = RedisCache.CAHCENAME + "|JsonDemoDto"+"|"+name;
		//List<Taobaoshop> taobaoshops=FindShopByName(name);
		List<Taobaoshop> taobaoshops = redisCache.getListCache(cache_key, Taobaoshop.class);
		if (taobaoshops == null) {
			log.info("findinmysql");
			taobaoshops = FindShopByName(name);
			redisCache.putListCacheWithExpireTime(cache_key, taobaoshops, RedisCache.CAHCETIME);
			log.info("putintaobaoshop" + cache_key);
		} else {
			log.info("GetinCache");
		}
		// 调用本类中的方法
		log.info("找到后开始转化");	
		 List<JsonDemoDto> jsonDemoDtos=redisCache.getListCache(cache_key2,JsonDemoDto.class); 
		  if(jsonDemoDtos==null){
		  jsonDemoDtos=todemouitl.ChangeToJsonDemoDto(taobaoshops);
		  log.info("useutil"); 
		  redisCache.putListCacheWithExpireTime(cache_key2,jsonDemoDtos, RedisCache.CAHCETIME);
		  log.info("putjsondemodtos"+cache_key2); }		 
		//List<JsonDemoDto> jsonDemoDtos = todemouitl.ChangeToJsonDemoDto(taobaoshops);
		return jsonDemoDtos;
	}

	@Override
	public Map ShowHotGoods(String string)  {
		HotGoodsExcelUtil util=new HotGoodsExcelUtil();
		Map map =new HashMap<String, List>();
		try {
			map = util.getexcel(string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public NewHotGoodsModel ShowNewHotGoods(String string) {
		HotGoodsExcelUtilNew utilNew=new HotGoodsExcelUtilNew();
		DtoToModelUtil dtoToModelUtil=new DtoToModelUtil();
		NewHotGoodsModel newHotGoodsModel =new NewHotGoodsModel();
		List<NewGoodsModel> newGoodsModels=new ArrayList<NewGoodsModel>();
		try {
			log.info("读取ecel到DTO");
			 newHotGoodsModel=utilNew.GetOneExcel(string);
			 //会重复存储，以下注释掉
			/* log.info("将DTO转化为MODEL");
			 newGoodsModels=dtoToModelUtil.changeOneDtoToModel(newHotGoodsModel);
			 log.info("顺便存到数据库");
			 newGoodsModelDao.insertByBatch();*/
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("excel操作失败");
		}
		
		
		return newHotGoodsModel;
	}

}
