package utiltest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import org.junit.Test;

import com.guo.ssm.model.NewGoodsModel;
import com.guo.ssm.model.NewHotGoodsModel;
import com.guo.ssm.util.DtoToModelUtil;
import com.guo.ssm.util.HotGoodsExcelUtilNew;

public class DtoToModelUtilTest {
	DtoToModelUtil dtoToModelUtil= new DtoToModelUtil();
	Logger logger=Logger.getLogger(Class.class);
	HotGoodsExcelUtilNew newexcelutil = new HotGoodsExcelUtilNew();
	
	
	@Test
	public void dtitimodelutiltest() throws Exception{
		NewHotGoodsModel a =newexcelutil.GetOneExcel("F:\\excel\\0.xlsx");
		NewHotGoodsModel b =newexcelutil.GetOneExcel("F:\\excel\\1.xlsx");
		NewHotGoodsModel c =newexcelutil.GetOneExcel("F:\\excel\\2.xlsx");
		List <NewHotGoodsModel> newHotGoodsModels=new ArrayList<NewHotGoodsModel>();
		newHotGoodsModels.add(a);
		newHotGoodsModels.add(b);
		newHotGoodsModels.add(c);
		/*List<NewGoodsModel> newGoodsModels=dtoToModelUtil.changeOneDtoToModel(a);
		for(NewGoodsModel newGoodsModel:newGoodsModels)
		{
			logger.info(newGoodsModel.getDatatime()+"//"+newGoodsModel.getId()+"//"+newGoodsModel.getStyleNumber());
		}*/
		List<NewGoodsModel> newGoodsModels2=dtoToModelUtil.changeManyDtoToModel(newHotGoodsModels);
		for(NewGoodsModel newGoodsModel:newGoodsModels2)
		{
			logger.info(newGoodsModel.getDatatime()+"//"+newGoodsModel.getId()+"//"+newGoodsModel.getStyleNumber());
			logger.info("尺寸"+newGoodsModels2.size());
		}
		
	}

}
