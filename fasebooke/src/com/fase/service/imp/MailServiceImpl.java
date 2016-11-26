package com.fase.service.imp;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.fase.iservice.MailService;
@Service("mailService")
public class MailServiceImpl implements MailService {
	 @Resource JavaMailSender mailSender;//注入Spring封装的javamail，Spring的xml中已让框架装配
	 
	 private Log log = LogFactory.getLog(getClass());
	 private StringBuffer message = new StringBuffer();
	@Override
	public void sendMail(String s) {
		// TODO 自动生成的方法存根
		MimeMessage mime = mailSender.createMimeMessage();
		  MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(mime, true, "utf-8");
			  helper.setFrom("ni.bilin@163.com");//发件人
			  helper.setTo("819231957@gmail.com");//收件人
			  helper.setReplyTo("ni.bilin@63.com");//回复到
			  helper.setSubject(s);//邮件主题
		} catch (MessagingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	
		mailSender.send(mime);
		  //内嵌资源，这种功能很少用，因为大部分资源都在网上，只需在邮件正文中给个URL就足够了.
		  //helper.addInline("logo", new ClassPathResource("logo.gif"));

	}

}
