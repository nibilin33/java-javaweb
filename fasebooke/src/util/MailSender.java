package util;

import java.util.Calendar;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.util.BASE64EncoderStream;

public class MailSender {
	 public static void sendMessage( String to, String subject, String messageText) throws MessagingException {  
	        // 第一步：配置javax.mail.Session对象  
	        System.out.println("为 配置mail session对象");  
	         System.out.println(to);
	          
	        Properties props = new Properties();  
	        props.put("mail.smtp.host", "smtp.163.com");  
	        props.put("mail.smtp.port", "25");             //google使用465或587端口  
	        props.put("mail.smtp.auth", "true");        // 使用验证  
	        props.put("mail.debug", "true");  
	        Session mailSession = Session.getInstance(props,new MyAuthenticator("ni.bilin@163.com","bc1308190208"));  
	 
	        // 第二步：编写消息  
	
	  
	        InternetAddress fromAddress = new InternetAddress("ni.bilin@163.com");  
	        InternetAddress toAddress = new InternetAddress(to);  
	  
	        MimeMessage message = new MimeMessage(mailSession);  
	  
	        message.setFrom(fromAddress);  
	        message.addRecipient(RecipientType.TO, toAddress);  
	  
	        message.setSentDate(Calendar.getInstance().getTime());  
	        message.setSubject(subject);  
	        message.setContent(messageText,  "text/html;charset=gb2312");  
	  
	        // 第三步：发送消息  
	        Transport transport = mailSession.getTransport("smtp");  
	        transport.connect("smtp.163.com","ni.bilin@163.com", "bc1308190208");  
	        transport.send(message, message.getRecipients(RecipientType.TO));  
	        System.out.println("message yes");  
	    }  
	  
/*	public static void main(String[] args) {
		try {  
			MailSender.sendMessage( "nibilin33@gmail.com", "nihao", "---------------wrwe-----------");  
        } catch (MessagingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
	}*/

}
 
