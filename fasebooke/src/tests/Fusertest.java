package tests;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fase.mapper.FuserMapper;
import com.fase.po.Fuser;
import com.fase.service.imp.FuserService;

public class Fusertest {
private static Logger logger = Logger.getLogger(Fusertest.class);
	private static ApplicationContext	applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
	FuserMapper fm=(FuserMapper)applicationContext.getBean("fuserMapper");
	@Test
	public void testinsert() {
		
	  
		/*Fuser fuser=new Fuser();
		fuser.setFname("nibilin33");
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
		logger.info(fuser);
	    fm.insertSelective(fuser);*/
//	
/*List<Fuser> f=fm.selectBymap2("13960845178","123456r");
	      logger.info(f.get(0).getFcount()+f.get(1).getFcount());*/
		 Fuser pas=fm.selectByphoneOrmail("1@qq.cm");
		System.out.println(pas);
	}
	

}
