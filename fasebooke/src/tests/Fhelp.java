package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fase.mapper.FuserMapper;
import com.fase.mapper.HelpcenterMapper;
import com.fase.po.Helpcenter;

public class Fhelp {
	private static Logger logger = Logger.getLogger(Fhelp.class);
	private static ApplicationContext	applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
	HelpcenterMapper fm=(HelpcenterMapper)applicationContext.getBean("helpcenterMapper");
	@Test
	public void testChecksmartSearch() {
		List<Helpcenter> hh=fm.selectBylike("手机号码");
		for(int i=0;i<hh.size();i++){
		System.out.println(hh.get(i).getQuestions());
		}
	}

}
