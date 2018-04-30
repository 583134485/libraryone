package shirotest;

import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.Test;

public class MD5Test {
	Logger logger=Logger.getLogger(Class.class);

  @Test
  public void testmd5(){
	  String a="hello";
	  String b="123";
	  String string=new Sha256Hash(a,b).toString();
	  logger.info(string);
  }
}
