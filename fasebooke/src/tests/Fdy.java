package tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.Pageinfo;

import com.fase.mapper.AskpermissionMapper;
import com.fase.mapper.DynamicInfoMapper;
import com.fase.mapper.HelpcenterMapper;
import com.fase.po.Askpermission;
import com.fase.po.DynamicInfo;
import com.fase.service.imp.Fdynamic;

public class Fdy {
	private static Logger logger = Logger.getLogger(Fdy.class);
	private static ApplicationContext	applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
	AskpermissionMapper fm=(AskpermissionMapper)applicationContext.getBean("askpermissionMapper");
	@Test
	public  void main2()  {  
        Properties props = new Properties();  
        // 开启debug调试  
        props.setProperty("mail.debug", "true");  
        // 发送服务器需要身份验证  
        props.setProperty("mail.smtp.auth", "true");  
        // 设置邮件服务器主机名  
        props.setProperty("mail.host", "smtp.gmail.com");  
        // 发送邮件协议名称  
        props.setProperty("mail.transport.protocol", "smtp");  
          
        // 设置环境信息  
        Session session = Session.getInstance(props);  
        try {  
        // 创建邮件对象  
        Message msg = new MimeMessage(session);  
        msg.setSubject("JavaMail测试");  
        // 设置邮件内容  
        msg.setText("这是一封由JavaMail发送的邮件！");  
        // 设置发件人  
        msg.setFrom(new InternetAddress("ni.bilin@163.com"));  
          
        Transport transport = session.getTransport();  
        // 连接邮件服务器  
        transport.connect();  
        // 发送邮件  
      
			transport.sendMessage(msg, new Address[] {new InternetAddress("819231957@qq.com")});
		    transport.close();  
		} catch (MessagingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}  
        // 关闭连接  
    
    }  
}
