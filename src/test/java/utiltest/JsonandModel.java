package utiltest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiDevice.Info;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.apache.log4j.Logger;

import com.alibaba.druid.support.json.JSONWriter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.alibaba.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guo.ssm.dto.JsonDemoDto;
import com.guo.ssm.model.KeysModel;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")*/
public class JsonandModel {
	Logger log=Logger.getLogger(Class.class);

	//序列化
	@Test
	public void objecttojson() throws Exception{
		KeysModel keysModel=new KeysModel(1,"22","dd","sds",2);
		String text=JSON.toJSONString(keysModel);
		log.info(text+"then,text to object");
		//JSON.parse parse用于从一个字符串中解析出json对象
		JSONObject jObject=(JSONObject) JSON.parse(text);
		KeysModel keysModel2=(KeysModel) JSON.parseObject(text,KeysModel.class);
		log.info(jObject+"ss"+keysModel2);
		
	}
	
	/** 
     * 将javaBean转化为json对象 
     */ 
	@Test
	public void objecttojsonobject() throws Exception{
		KeysModel keysModel=new KeysModel(1,"22","dd","sds",2);
	/*	String text=JSON.toJSONString(keysModel);*/
		JSONObject text=(JSONObject) JSON.toJSON(keysModel);
		log.info(text);
	}
	
	//fastjson api
	@Test
	public void readjson ()  throws Exception{
		 JSONReader reader = new JSONReader(new FileReader("D:\\Json.json"));
		  reader.startArray();
		  List<JsonDemoDto>jsonDemoDtos=new ArrayList<JsonDemoDto>();
		  while(reader.hasNext()) {
		        JsonDemoDto vo = reader.readObject(JsonDemoDto.class);
		        // handle vo ...
		       jsonDemoDtos.add(vo);
		  }
		  reader.endArray();
		  reader.close();
		  log.info("2222222222");
		  for(JsonDemoDto jsonDemoDto:jsonDemoDtos){
			  log.info(jsonDemoDto);
		  }
		  log.info(jsonDemoDtos.size());
	
		 
	}
	
	@Test
	public void readjsons() throws FileNotFoundException{
		JSONReader reader = new JSONReader(new FileReader("D:\\Json.json"));
		String a=reader.readString();
		log.info(a);
	}
	
	@Test
	public void stirngtosjon(){
		String a="{" +
		          "        \"id\":\"1\"," +
		          "        \"cell\":[\"1\",\"item 4\",\"1.00\",\"50.00\",\"50.00\"]" +
		          "  }";
		JSONObject jsonObject=JSONObject.parseObject(a);
		log.info(jsonObject);
		          
		          
	}


}


	

