package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Alpha {
	public static void main(String[] args) {

		Alpha client = new Alpha();

	    try {
	        client.sendMail();
	    } catch (AddressException ae) {
	        ae.printStackTrace();
	    } catch (MessagingException me) {
	        me.printStackTrace();
	    }

	}

	/**
	 * Sends an email
	 * 
	 * @param none
	 */
	private void sendMail() throws AddressException, MessagingException {

	    // Get a Properties object
	    Properties props = System.getProperties();

	    // ******************** FOR PROXY ******************

	    // props.setProperty("proxySet","true");
	    // props.setProperty("socksProxyHost","9.10.11.12");
	   // props.setProperty("socksProxyPort","80");
	    // props.setProperty("socksProxyVersion","5");
	  //  props.put("mail.smtp.port", "587");
	    props.setProperty("mail.smtp.host", "smtp.gmail.com");

	    // ******************** FOR SSL ******************
	/*   final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	    props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	    props.setProperty("mail.smtp.socketFactory.fallback", "false");
	    props.setProperty("mail.smtp.port", "465");
	    props.setProperty("mail.smtp.socketFactory.port", "465");*/
	    props.put("mail.smtp.user","nibilin33@gmail.com"); 
	    props.put("mail.smtp.host", "smtp.gmail.com"); 
	    props.put("mail.smtp.port", "25"); 
	    props.put("mail.debug", "true"); 
	    props.put("mail.smtp.auth", "true"); 
	    props.put("mail.smtp.starttls.enable","true"); 
	    props.put("mail.smtp.EnableSSL.enable","true");

	    props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
	    props.setProperty("mail.smtp.socketFactory.fallback", "false");   
	    props.setProperty("mail.smtp.port", "465");   
	    props.setProperty("mail.smtp.socketFactory.port", "465"); 
	    final String username = "nibilin33@gmail.com";
	    final String password = "bc5201314";
	    Session session = Session.getDefaultInstance(props,
	            new Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });

	    // -- Create a new message --
	    Message msg = new MimeMessage(session);
	    msg.setFrom(new InternetAddress("nibilin33@gmail.com"));
	    msg.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse("ni.bilin@163.com", false));
	    msg.setSubject("Hello");
	    msg.setSentDate(new Date());

	    // **************** Without Attachments ******************
	    msg.setText("How are you");


	    Transport.send(msg);
	    System.out.println("Message sent.");

	}

}
