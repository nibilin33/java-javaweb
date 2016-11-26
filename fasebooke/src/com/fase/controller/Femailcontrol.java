package com.fase.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fase.iservice.IEmail;
import com.fase.iservice.Ifuser;
import com.fase.po.Emailmessage;
import com.fase.po.Fuser;

import util.FileTools;

@Controller
@RequestMapping(value="/email")
public class Femailcontrol {
     @Resource
     private IEmail mail;
     @Resource
     private Ifuser ifuser;
    @RequestMapping(value = "/download.action")  /*文件下载*/
    public void downloadFile(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	String fileName=request.getParameter("fileName");
    	System.out.println(fileName+"文件名");
    	response.setCharacterEncoding("utf-8");
    	response.setContentType("multipart/form-data");
    	response.setHeader("Content-Disposition", "attachment;fileName="
    	+ fileName);
    	OutputStream os = null;
    	try {
    	String realPath ="E:/img/temps" ;
    /*			request.getSession().getServletContext().getRealPath("/upload"); */
    	InputStream inputStream = new FileInputStream(new File(realPath
    	+ File.separator + fileName));

    	os = response.getOutputStream();
    	byte[] b = new byte[2048];
    	int length = 0;
    	while ((length = inputStream.read(b)) != -1) {
    	os.write(b, 0, length);
    	}
    	// 这里主要关闭。
    	inputStream.close();
    	} catch (FileNotFoundException e) {
    	e.printStackTrace();
    	} catch (IOException e) {
    	e.printStackTrace();
    	}finally{
    	try { 
    	if(os != null){
    	os.close();
    	}
    	}catch (IOException e) { 
    	e.printStackTrace(); 
    	}
    	try { 
    	if (os != null) 
    	os.flush(); 
    	} catch (IOException e) { 
    	e.printStackTrace(); 
    	} 
       
    }
}       
    @RequestMapping(value="/sendEmail.action")
    public void sendEmail(@RequestBody Emailmessage email,HttpServletResponse re){
    	Fuser ffid=ifuser.selectForMail(email.getFfid());
    	email.setFfid(ffid.getFuid());
    	int n=mail.insertImail(email);
    	 re.setHeader("Pragma", "No-cache");
    	  re.setHeader("Cache-Control", "no-cache");
    	  re.setCharacterEncoding("UTF-8");
    	  System.out.println(n+"插入邮件啦啦啦啦啦");
    	if(n==1){
    		try {
				re.getWriter().print("ok");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
    	}else
    	{
    		try {
				re.getWriter().print("wrong");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
    	}
    	
    }
    @RequestMapping(value="/{eid}/{fuid}/checkemail.action")
    public ModelAndView checkemail(@PathVariable("eid")String eid,@PathVariable("fuid")String fuid,HttpServletRequest re){
    	ModelAndView mv=new ModelAndView();
    	Map<Object,String> param=new HashMap<Object, String>();
    	param.put("estate","1" );
    	param.put("eid", eid);
    	int n=mail.updateEmail(param);
    	  HttpSession s=re.getSession();
    	  Fuser ii=(Fuser) s.getAttribute("current_user");
    	   if(ii==null){
    		   ii=ifuser.selectbyid(fuid);
    	   }
    	 /*   s.getCreationTime() ;  获取session的创建时间
    	   s.getLastAccessedTime();  获取上次与服务器交互时间
    	   s.getMaxInactiveInterval() ;获取session最大的不活动的间隔时间，以秒为单位120秒。
    	   System.out.println( s.getCreationTime()+ "gg"+s.getLastAccessedTime()+ "gg"+s.getMaxInactiveInterval());*/
    	   s.setAttribute("current_user", ii);
    	   Emailmessage email=mail.selectbymailid(eid);
    	   System.out.println(email.getUser()+"用户啊啊啊啊");
    	   mv.addObject("email",email);
    	   mv.setViewName("email");
    	return mv;
    }
    @RequestMapping(value="/{eid}/readmail.action")
      public void readmail(@PathVariable("eid")String eid,HttpServletResponse re){
    	Map<Object,String> param=new HashMap<Object, String>();
    	param.put("estate","1" );
    	param.put("eid", eid);
    	int n=mail.updateEmail(param);
   	 re.setHeader("Pragma", "No-cache");
   	  re.setHeader("Cache-Control", "no-cache");
   	  re.setCharacterEncoding("UTF-8");
   	  System.out.println(n+"读邮件啦啦啦啦啦");
   	if(n==1){
   		try {
				re.getWriter().print("ok");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
   	}else
   	{
   		try {
				re.getWriter().print("wrong");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
   	}
    	
    }
    @RequestMapping(value="/{eid}/demail.action")
    public void demail(@PathVariable("eid")String eid,HttpServletResponse re){
    	int n=mail.deleteImail(eid);
   	 re.setHeader("Pragma", "No-cache");
   	  re.setHeader("Cache-Control", "no-cache");
   	  re.setCharacterEncoding("UTF-8");
   	  System.out.println(n+"删邮件啦啦啦啦啦");
   	if(n==1){
   		try {
				re.getWriter().print("ok");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
   	}else
   	{
   		try {
				re.getWriter().print("wrong");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
   	}
    	
    }
    
}
