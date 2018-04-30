package utiltest;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guo.ssm.core.ExcelConstant;
import com.guo.ssm.dto.GoodSale3DDto;
import com.guo.ssm.model.ShengecanmouModel;
import com.guo.ssm.util.ExcelUtil;

public class ExcelDaoTest {
	private static Logger logger=LoggerFactory.getLogger(ExcelDaoTest.class);
	
	
	
	@Test
	public  void ParseExcelToExcelModeltest() throws InvalidFormatException, IOException {
		
      String filepath="C:\\Users\\58313\\Desktop\\css问题\\数据源564940950728.xlsx";
		Map<String, List<String>> result=ExcelUtil.ParseExcelToExcelModel(filepath);
		logger.info(result.toString());
	}
	
	
	@Test
	public void testexcel() throws IOException, InvalidFormatException, ParseException{
		ExcelUtil tExcelUtil=new ExcelUtil();
		String excelpath="F:\\excel\\【生意参谋】商品效果-2017-03-22-2017-03-22.xls";
//	File file =new File(excelpath);
	//	logger.info("name:"+file.getName());
		List<ShengecanmouModel> shengecanmouModels=tExcelUtil.SingleExcelOfShengecanmouToModel(excelpath);
		//logger.info(shengecanmouModels.size());
		//太多便利不方便
	/*	for(ShengecanmouModel s:shengecanmouModels){
			logger.info(s);
		}*/
		logger.info(shengecanmouModels.get(0).toString());
		logger.info(shengecanmouModels.get(1).toString());
		logger.info(shengecanmouModels.get(2).toString());
		logger.info(shengecanmouModels.get(3).toString());
		logger.info(shengecanmouModels.get(4).toString());
		logger.info(shengecanmouModels.get(5).toString());
		//省的重复构造
		logger.info(shengecanmouModels.get(5).getRecordtime().toString());
 	}
	
	@Test
	public void testfilename(){
		String str=new String("test.xls");  
		String[] a = str.split("\\.");  
		logger.info(a[1]);
	}
	
	@Test 
	public void testtiletodate(){
		String a="【生意参谋】商品效果-2017-03-22-2017-03-22.xls";
		String[] b = a.split("\\-"); 
		logger.info(b[1]+"-"+b[2]+"-"+b[3]);
	}
	
	//测试制作excel表格
/*	@Test
	public void testmakemodeltoexcel() throws InvalidFormatException, IOException, ParseException{
		ExcelUtil tExcelUtil=new ExcelUtil();
		String excelpath="F:\\excel\\【生意参谋】商品效果-2017-03-22-2017-03-22.xls";
		List<ShengecanmouModel> shengecanmouModels=ExcelUtil.SingleExcelOfShengecanmouToModel(excelpath);
		//必须按顺序存放
List<String> name =ExcelConstant.getname();
		String path=ExcelUtil.MakeModelToExcel(shengecanmouModels, name);
		
	}*/
	
	@Test
	public  void readexceltogoodsale3d(){
		ExcelUtil excelUtil=new ExcelUtil();
		List<GoodSale3DDto> goodSale3DDtos=new ArrayList<GoodSale3DDto>();
		try {
			goodSale3DDtos=excelUtil.ReadExcelToGoodSaleDto("D:\\excel\\三位立体图时间对应品类销量.xlsx");
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	/*	for(GoodSale3DDto goodSale3DDto:goodSale3DDtos){
			logger.info(goodSale3DDto);
		}*/
		//logger.info(goodSale3DDtos.size());
	}

}
