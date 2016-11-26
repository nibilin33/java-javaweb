package com.fase.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fase.iservice.Ifuser;
import com.fase.iservice.Inotification;
import com.fase.po.Fuser;
import com.fase.po.Notification;

@Controller
@RequestMapping(value="/nofican")
public class FnotificationControl {
@Resource
private Inotification notiservice;
@Resource
private Ifuser ifuservice;

@RequestMapping(value="/o.action")
public void OO(HttpServletRequest re,HttpServletResponse response){
	String fuid=re.getParameter("fuid");
	List<Notification> nti=notiservice.selectbyfuid(fuid);
	JSONObject json=new JSONObject();
	json.put("nti",nti);
	   try {
    	   response.setContentType("application/json");
           response.setHeader("Pragma", "No-cache");
           response.setHeader("Cache-Control", "no-cache");
           response.setCharacterEncoding("UTF-8");
		   response.getWriter().write(json.toString());
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} 
	
}
@RequestMapping(value="/read.action")
public void read(@RequestBody Notification nti,HttpServletResponse response){
	 notiservice.updatenotice(nti);
	 try {
  	   response.setContentType("application/json");
         response.setHeader("Pragma", "No-cache");
         response.setHeader("Cache-Control", "no-cache");
         response.setCharacterEncoding("UTF-8");
		   response.getWriter().write("success");
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} 
}
}
