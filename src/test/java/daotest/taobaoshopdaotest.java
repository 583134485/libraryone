package daotest;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiDevice.Info;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.support.logging.Log;
import com.guo.ssm.dao.NewGoodsModelDao;
import com.guo.ssm.dao.TaobaoshopDao;
import com.guo.ssm.dto.Brand_Sale;
import com.guo.ssm.dto.TaoDataForView;
import com.guo.ssm.dto.TaobaoDto;
import com.guo.ssm.model.KeysModel;
import com.guo.ssm.model.NewGoodsModel;
import com.guo.ssm.model.NewHotGoodsModel;
import com.guo.ssm.model.Taobaoshop;
import com.guo.ssm.util.DtoToModelUtil;
import com.guo.ssm.util.HotGoodsExcelUtilNew;
import com.guo.ssm.util.ShopFilter;
import com.mysql.fabric.xmlrpc.base.Data;
import com.mysql.jdbc.integration.jboss.ExtendedMysqlExceptionSorter;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)  
@Transactional
@ContextConfiguration({"classpath:spring/*.xml"})
public class taobaoshopdaotest {

	Logger log = Logger.getLogger(Class.class);

	@Autowired
	private NewGoodsModelDao newGoodsModelDao;
	@Autowired
	private TaobaoshopDao shoodao;
	/*
	 * @Autowired private Brand_Sale brand_Sale;
	 */
	

	
	public Taobaoshop maketoabaoshop() throws ParseException{		
			String s = new String("ds");
			int x=(int)(Math.random()*10);		
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/*	String ss = "2017-7-1 00:00:00";
			java.util.Date date = sdf.parse(ss);*/
   //			批量操作可能需要精确到毫秒
			 java.util.Date date=new java.util.Date();
			/* log.info(date);*/
		    log.info(sdf.format(date));
		    date=sdf.parse(sdf.format(date));
		  /*  log.info(date);*/
			Timestamp dat = new Timestamp(date.getTime());
			log.info(dat);
			Taobaoshop t=new Taobaoshop(s+x, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s+x, s+x, s+x, s+x, dat);			
	         return t;
	}
	@Test
	public void maketoaba() throws ParseException{		
		String s = new String("ds");
		int x=(int)(Math.random()*10);		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/*	String ss = "2017-7-1 00:00:00";
		java.util.Date date = sdf.parse(ss);*/
//			批量操作可能需要精确到毫秒
		 java.util.Date date=new java.util.Date();
		/* log.info(date);*/
	    log.info(sdf.format(date));
	    date=sdf.parse(sdf.format(date));
	  /*  log.info(date);*/
		Timestamp dat = new Timestamp(date.getTime());
		log.info(dat);
		//Taobaoshop t=new Taobaoshop(s+x, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s+x, s+x, s+x, s+x, dat);			
      
}
	@Test
	public void findshop() {
		long startTime = System.currentTimeMillis();// 获取当前时间
		long endTime = System.currentTimeMillis();
		/*
		 * for(Taobaoshop a:b){ Brand_Sale cBrand_Sale=new Brand_Sale(a);
		 * log.info(cBrand_Sale); }
		 */
		log.info("speed=" + (endTime - startTime) + "ms");
	}

/*	@Test
	public void findlint() throws ParseException {
		String s = new String("ds");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String string = "2017-7-1 00:00:00";
		java.util.Date date = sdf.parse(string);
		Timestamp dat = new Timestamp(date.getTime());
		TaobaoDto taobaoDto = new TaobaoDto(s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, dat);
		List<TaobaoDto> b = shoodao.findaall(taobaoDto);
		for (TaobaoDto a : b) {
			log.info(a);
		}
	}*/
	
	//添加测试
/*	@Test
	public void addtonewtaobao() throws Exception{
		
		Taobaoshop taobaoshop=maketoabaoshop();
		shoodao.add(taobaoshop);
		
	}*/
	
	/*	@Test
	public void update() throws Exception{
		Taobaoshop taobaoshop=maketoabaoshop();
		taobaoshop.setSKU("ds");
		shoodao.update(taobaoshop);
	
	}*/
	
	@Test
	public void findbykeys() throws Exception{
		KeysModel keysModel=new KeysModel();
		keysModel.setName("t400旗舰店");
		List<Taobaoshop>  taobaoshops= shoodao.findbykeys(keysModel);
        log.info("t400旗舰店"+taobaoshops.size());
		
	}
	//去重工具类测试
	@Test
	public void shopfilter() throws Exception{
		List <Taobaoshop> taobaoshops=shoodao.findAll(0,10000);
		ShopFilter shopFilter=new ShopFilter();
		log.info(taobaoshops.size());
		taobaoshops=shopFilter.shopfilter(taobaoshops);
		log.info(taobaoshops.size());	
	}
	//批量操作测试 批量对比原始遍历插入，
	//关于数据库测试操纵回滚
	
	@Test
	/*@Rollback(false)*/
	public void addbybatch() throws Exception{
		List<Taobaoshop> taobaoshops=shoodao.findAll(0,10);
		log.info("getshops");
		long starttime=System.currentTimeMillis();
		shoodao.insertByBatch(taobaoshops);
		long endtime=System.currentTimeMillis();
		log.info("batchtime"+(endtime-starttime));
	/*log.info("beginadd");
		List<Taobaoshop> taobaoshops2=shoodao.findAll(501, 500);
		log.info("getshop");
		long starttime2=System.currentTimeMillis();
		for(Taobaoshop taobaoshop:taobaoshops2){
			log.info("add");
			shoodao.add(taobaoshop);
		}
		long endtime2=System.currentTimeMillis();
		log.info("addtime"+(endtime2-starttime2));*/
	
		
	}
	
	
	@Test
	public void savemodeltodatabase() throws Exception{
		DtoToModelUtil dtoToModelUtil= new DtoToModelUtil();
		HotGoodsExcelUtilNew newexcelutil = new HotGoodsExcelUtilNew();
		NewHotGoodsModel a =newexcelutil.GetOneExcel("F:\\excel\\0.xlsx");
		NewHotGoodsModel b =newexcelutil.GetOneExcel("F:\\excel\\1.xlsx");
		NewHotGoodsModel c =newexcelutil.GetOneExcel("F:\\excel\\2.xlsx");
		List <NewHotGoodsModel> newHotGoodsModels=new ArrayList<NewHotGoodsModel>();
		newHotGoodsModels.add(a);	
		newHotGoodsModels.add(b);
		newHotGoodsModels.add(c);

    List<NewGoodsModel> newGoodsModels1=dtoToModelUtil.changeManyDtoToModel(newHotGoodsModels);
    
      log.info("开始插入");
    newGoodsModelDao.insertByBatch(newGoodsModels1);
		
	}
	

	
}
