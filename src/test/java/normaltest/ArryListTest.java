package normaltest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guo.ssm.dto.JsonDemoChildrenDto;


public class ArryListTest {
	Logger log = Logger.getLogger(Class.class);
	
	@Test
	public void tesarrylist(){
		/*
		List<String> list=new ArrayList<String>();
	    list.add("保护环境");     //向列表中添加数据
	    list.add("爱护地球");     //向列表中添加数据
	    list.add("从我做起");     //向列表中添加数据
	    //通过循环输出列表中的内容
	    for(int i=0;i<list.size();i++){
	     System.out.println(i+":"+list.get(i));
	    }*/
	}
	@Test
	public void testarry(){
		
		List<JsonDemoChildrenDto> jsonDemoChildrenDtos=new ArrayList<JsonDemoChildrenDto>();
		JsonDemoChildrenDto jsonDemoChildrenDto=new JsonDemoChildrenDto();
		List <String> value=new ArrayList<String>();
		jsonDemoChildrenDto.setDiscretion(null);
		jsonDemoChildrenDto.setId("22");
		jsonDemoChildrenDto.setName("dsf");
		value.add("dd");
		value.add("ssdd");
		value.add("dssd");
		jsonDemoChildrenDto.setValue(value);
		jsonDemoChildrenDtos.add(jsonDemoChildrenDto);
		log.info(jsonDemoChildrenDtos);
	}

}
