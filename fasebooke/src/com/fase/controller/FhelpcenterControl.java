package com.fase.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;











import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.annotations.Ignore;
import net.sf.json.JSONObject;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;






import com.fase.iservice.Ihelpcenter;
import com.fase.po.College;
import com.fase.po.Helpcenter;
import com.fase.po.Localp;


@Controller
@RequestMapping(value ="/help")
public class FhelpcenterControl {
	@Resource
	private Ihelpcenter ihelp;
	
	@RequestMapping(value ="/hahaha.action")
	public void selectLike(HttpServletRequest request,HttpServletResponse response){
		
	 JSONObject jsonObject = new JSONObject();  
     String s=request.getParameter("query");
     
     if(!"".equals(s)){
       List<Helpcenter>  hh=ihelp.checksmartSearch(s);
       jsonObject.put("hah", hh);
       try {
    	   response.setContentType("application/json");
           response.setHeader("Pragma", "No-cache");
           response.setHeader("Cache-Control", "no-cache");
           response.setCharacterEncoding("UTF-8");
		  response.getWriter().print(jsonObject.toString());
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} 
     }
    
	}
	@RequestMapping(value ="/help2.action")
	public void selectans(HttpServletRequest request,HttpServletResponse response){
		 JSONObject jsonObject = new JSONObject();
		 String s=request.getParameter("query");
	     if(!"".equals(s)){
		List<String> sns=ihelp.checklike(s);
		if(sns.size()>0){
		  jsonObject.put("hah",sns.get(0));
		  try {
	    	   response.setContentType("application/json");
	           response.setHeader("Pragma", "No-cache");
	           response.setHeader("Cache-Control", "no-cache");
	           response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jsonObject.toString());
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
	     }
	     }else
	     {
	    	 try {
				response.getWriter().print("404");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	     }
	}
	@RequestMapping(value="/college.action")
  public void college(HttpServletRequest request,HttpServletResponse response){
		 JSONObject jsonObject = new JSONObject();  
	     String s=request.getParameter("college");
	   
	     if(!"".equals(s)&&s!=null){
	       List<College>  hh=ihelp.checksmartSearchcolle(s);
	       System.out.println(hh.size());
	       jsonObject.put("college", hh);
	       try {
	    	   response.setContentType("application/json");
	           response.setHeader("Pragma", "No-cache");
	           response.setHeader("Cache-Control", "no-cache");
	           response.setCharacterEncoding("UTF-8");
			  response.getWriter().print(jsonObject);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
	     }else
	     {
	    	 try {
				response.getWriter().print("wrong");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	     }
	}
	@RequestMapping(value="/local.action")
	  public void local(HttpServletRequest request,HttpServletResponse response){
			 JSONObject jsonObject = new JSONObject();  
		     String s=request.getParameter("local");
		     
		     if(!"".equals(s)){
		       List<Localp>  hh=ihelp.checksmartSearchlive(s);
		       jsonObject.put("local", hh);
		       try {
		    	   response.setContentType("application/json");
		           response.setHeader("Pragma", "No-cache");
		           response.setHeader("Cache-Control", "no-cache");
		           response.setCharacterEncoding("UTF-8");
				  response.getWriter().write(jsonObject.toString());
				
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} 
		     }
		}
}
