package com.fase.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import oracle.jdbc.driver.OracleBlobInputStream;
import oracle.jdbc.driver.OracleTypes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fase.iservice.IBlock;
import com.fase.iservice.IEmail;
import com.fase.iservice.Ifuser;
import com.fase.iservice.IlocalP;
import com.fase.iservice.Iufriend;
import com.fase.po.Blocking;
import com.fase.po.Emailmessage;
import com.fase.po.Fuser;
import com.fase.po.Localp;
import com.fase.po.Ufreind;
@Controller
@RequestMapping(value="/friend")
public class FfriendControl {
	@Resource
	private Iufriend iuservice;
	@Resource
	private Ifuser ifuser;
	@Resource
	private IBlock ib;
	@Resource
	private IlocalP il;
	   @Resource
	     private IEmail mail;
	@RequestMapping(value="/{fuid}/myfreind.action")
	public ModelAndView myfreind(@PathVariable("fuid")String fuid,HttpServletRequest re){
		ModelAndView mv=new ModelAndView();
		List<Ufreind> uf=iuservice.selectall(fuid);
		for(int i=0;i<uf.size();i++){
			List<Fuser>uu=uf.get(i).getFlist();
			for(int j=0;j<uu.size();j++){
			 System.out.println( uu.get(j).getFhometown()); 
			if( uu.get(j).getFhometown()!=null){
			Localp lo=il.selectURL(uu.get(j).getFhometown());
			
		       uu.get(j).setFhome(lo);
			}
			}
			uf.get(i).setFlist(uu);
		}
		    List<Blocking>  sb = ib.selectall(fuid);
		    System.out.println(sb.size()+"黑名单");
		HttpSession s=re.getSession();
		if(s.getAttribute("current_user")==null){
			Fuser us=ifuser.selectbyid(fuid);
			s.setAttribute("current_user",us);
		}
		List<Emailmessage> ei=mail.selectfuidmail(fuid);
		mv.addObject("myfreind",uf);
		mv.addObject("heiming",sb);
		mv.addObject("myemail",ei);
		mv.setViewName("friends");
		return mv;
	}
	@RequestMapping(value="/{fuid}/much.action")
	public ModelAndView Mu(@PathVariable("fuid")String fuid,HttpServletRequest re){
		HttpSession s=re.getSession();
		if(s.getAttribute("current_user")==null){
			Fuser us=ifuser.selectbyid(fuid);
			s.setAttribute("current_user",us);
		}
		ModelAndView mv=new ModelAndView();

		  Fuser us=new Fuser();
		 String sc=re.getParameter("uschool");
		 if(!"".equals(re.getParameter("fname")))
		  us.setFname(re.getParameter("fname"));
		 if(!"".equals(re.getParameter("fcount")))
		  us.setFcount(re.getParameter("fcount"));
		 if(!"".equals(re.getParameter("fliveplace")))
	      us.setFliveplace(re.getParameter("fliveplace"));
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");                
		  Date date=null;
		try {
			 if(!"".equals(re.getParameter("fbirthday"))){
			date = sdf.parse(re.getParameter("fbirthday"));
			  us.setFbirthday(date);
			}
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  List<Fuser> u=ifuser.selectByMulti(us);
 		  System.out.println(u.size()+"much");
 		  System.out.println(re.getParameter("fliveplace"));
 		if(sc!=""){
 			Map<String,Object>params=new HashMap<String,Object>();
 			params.put("uschool",sc);
 			params.put("result",OracleTypes.CURSOR);
 			List<Fuser> usch=ifuser.selectBYSchool(params);
 			u.addAll(usch);	
 		}
 		
 		  mv.addObject("pr",u);
 		  mv.setViewName("searchfirend");
		return mv;
	}
	
}
