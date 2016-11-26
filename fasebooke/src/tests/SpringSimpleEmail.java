package tests;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.fase.mapper.HelpcenterMapper;
import com.fase.service.imp.MailServiceImpl;
public class SpringSimpleEmail {
	private static Logger logger = Logger.getLogger(Fhelp.class);
   public ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");  
   public MailServiceImpl mailer = (MailServiceImpl) ctx.getBean("mailService"); 
	@Test
	public  void mail() {
		// TODO 自动生成的方法存根
		//Send a composed mail
        mailer.sendMail("1");
	}

}
