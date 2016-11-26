package util;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class JavaMailSendUtil {
	 public  void sendmail(String subject, String from, String[] to,  
	            String text, String[] filenames, String mimeType) {  
	        try {  
	            Properties props = new Properties();  
	 
	            String smtp = "smtp.gmail.com"; // 设置发送邮件所用到的smtp  
	            String servername = "nibilin33@gmail.com";  //邮箱账号名
	            String serverpaswd = "bc5201314";  //邮箱密码
	 
	            javax.mail.Session mailSession = null; // 邮件会话对象  
	            javax.mail.internet.MimeMessage mimeMsg = null; // MIME 邮件对象  
	 
	            props = java.lang.System.getProperties(); // 获得系统属性对象  
	            props.put("mail.smtp.host", smtp); // 设置SMTP主机  
	            props.put("mail.smtp.auth", "true"); // 是否到服务器用户名和密码验证  
	            // 到服务器验证发送的用户名和密码是否正确  
	            SmtpAuthenticator myEmailAuther = new SmtpAuthenticator(servername,  
	                    serverpaswd);  
	            // 设置邮件会话 注意这里将认证信息放进了Session的创建参数里  
	            mailSession = javax.mail.Session.getInstance(props,  
	                    (Authenticator) myEmailAuther);  
	            // 设置传输协议  
	            javax.mail.Transport transport = mailSession.getTransport("smtp");  
	           // 设置from、to等信息  
	           mimeMsg = new javax.mail.internet.MimeMessage(mailSession);  
	           if (null != from && !"".equals(from)) {  
	               InternetAddress sentFrom = new InternetAddress(from);  
	               mimeMsg.setFrom(sentFrom); // 设置发送人地址  
	           }  
	 
	           InternetAddress[] sendTo = new InternetAddress[to.length];  
	           for (int i = 0; i < to.length; i++) {  
	               System.out.println("发送到:" + to[i]);  
	               sendTo[i] = new InternetAddress(to[i]);  
	           }  
	 
	           mimeMsg.setRecipients(  
	                   javax.mail.internet.MimeMessage.RecipientType.TO, sendTo);  
	           mimeMsg.setSubject(subject, "gb2312");  
	 
	           MimeBodyPart messageBodyPart1 = new MimeBodyPart();  
	           // messageBodyPart.setText(UnicodeToChinese(text));  
	           messageBodyPart1.setContent(text, mimeType);  
	 
	           // 附件传输格式  
	           Multipart multipart = new MimeMultipart();  
	           multipart.addBodyPart(messageBodyPart1);  
	 
	           for (int i = 0; i < filenames.length; i++) {  
	               MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
	 
	               String filename = filenames[i].split(";")[0];  
	               String displayname = filenames[i].split(";")[1];  
	               // 得到数据源  
	               FileDataSource fds = new FileDataSource(filename);  
	               // BodyPart添加附件本身  
	               messageBodyPart2.setDataHandler(new DataHandler(fds));  
	               // BodyPart添加附件文件名  
	               messageBodyPart2.setFileName(MimeUtility  
	                       .encodeText(displayname));  
	               multipart.addBodyPart(messageBodyPart2);  
	           }  
	           mimeMsg.setContent(multipart);  
	           // 设置信件头的发送日期  
	           mimeMsg.setSentDate(new Date());  
	           mimeMsg.saveChanges();  
	           // 发送邮件  
	           transport.send(mimeMsg);  
	           transport.close();  
	           System.out.println("发送到成功!!!");  
	       } catch (Exception e) {  
	           e.printStackTrace();  
	       }  
	   }  
	 
	    
	   public static void main(String[] args) throws Exception {  
	       String title = "测试邮件";// 所发送邮件的标题  
	       String from = "nibilin33@gmail.com";// 从那里发送  
	       String sendTo[] = { "819231957@qq.com" };// 发送到那里  
	       // 邮件的文本内容，可以包含html标记则显示为html页面  
	       String content = "test java send mail !!!!!!";  
	     // 所包含的附件，及附件的重新命名  
	     String fileNames[] = { "E:\\img\\face\\2.jpg;test.jpg" };  

	     JavaMailSendUtil test = new JavaMailSendUtil();  
	     try {  
	         // MailSender mailsender = new MailSender();  
	         test.sendmail(title, from, sendTo, content, fileNames,  
	                 "text/html;charset=gb2312");  
	     } catch (Exception ex) {  
	         ex.printStackTrace();  
	     }  
	 }  

	   
	 class SmtpAuthenticator extends Authenticator {  
	     String username = null;  
	     String password = null;  

	      
	     public SmtpAuthenticator(String username, String password) {  
	         super();  
	         this.username = username;  
	         this.password = password;  
	     }  

	      
	     public PasswordAuthentication getPasswordAuthentication() {  
	         return new PasswordAuthentication(this.username, this.password);  
	       }  
	   }  
}
