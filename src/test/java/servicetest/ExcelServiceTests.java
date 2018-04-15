package servicetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.guo.ssm.service.IExcelService;
import com.guo.ssm.service.impl.ExcelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( "classpath:spring/*.xml")
public class ExcelServiceTests {
	
	private Logger log=LoggerFactory.getLogger(ExcelServiceTests.class);
	

	IExcelService excelService=new ExcelService();
	
	@Test
	public void ParseSingleExcelJson() throws IOException {
		File testfile=new File("D:\\excel\\test.xls");
		
		//mockMultipartfile  use to test mock
		//FileInputStream inputStream=new FileInputStream(testfile);
		//MultipartFile file =new MockMultipartFile(testfile.getName(), inputStream);

		DiskFileItem fileItem = new DiskFileItem("file", "text/plain", false, testfile.getName(), (int) testfile.length(), testfile.getParentFile());
		fileItem.getOutputStream();
		MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
		log.info("mock multifile:"+multipartFile.getOriginalFilename());
		Map<String, List<String>> result=excelService.ParseSingleExcelToJson(multipartFile);
		log.info("test result"+result);
	}
	
	

}
