package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fase.mapper.FuserMapper;
import com.fase.po.Fuser;
import com.fase.service.imp.FuserService;

public class Fuservices {
  
     private static ApplicationContext	applicationContext = new ClassPathXmlApplicationContext("classpath:spring-*.xml");
 	
       FuserService fu=(FuserService)applicationContext.getBean("fuserService");
       private static Logger logger = Logger.getLogger(Fuservices.class);
	@Test
	public void testInsertFuser() {

		Fuser fuser=new Fuser();
		fuser.setFname("nibili533");
		Date date=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
		try {
			fuser.setFbirthday(dateFormat.parse("1994-4-7"));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		fuser.setFsex(new BigDecimal(1));
		fuser.setFtel("13960845178");
		fuser.setFpassword("123456r");
		fu.insertFuser(fuser);
	}

	@Test
	public void testUpdateFuser() {

	}


	@Test
	public void testCheckLogin() {
		logger.info(   fu.checkLogin("nibilin33@gmail.com", "123456"));
	}

	@Test
	public void testLogOut() {
	
	}

}
