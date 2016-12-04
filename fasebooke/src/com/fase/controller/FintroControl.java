package com.fase.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fase.iservice.Icollege;
import com.fase.iservice.Ieducation;
import com.fase.iservice.Ifuser;
import com.fase.iservice.Iliferecord;
import com.fase.iservice.IlocalP;
import com.fase.iservice.Iwork;
import com.fase.po.Fuser;
import com.fase.po.Liferecord;
import com.fase.po.Localp;
import com.fase.po.UEducation;
import com.fase.po.UWork;

@Controller
@RequestMapping(value="/jian")
public class FintroControl {
	@Resource
	private Ifuser fuserver;
	@Resource
	private Ieducation edu;
	@Resource
	private Iwork work;
	@Resource
	private IlocalP local;
	@Resource 
	private Icollege college;
	@Resource
	private Iliferecord life;
	@RequestMapping(value="/{fuid}/firstin.action")
	public ModelAndView firstin(@PathVariable("fuid")String fuid,HttpServletRequest re){
		ModelAndView mv=new ModelAndView();
		HttpSession s=re.getSession();
		Fuser us=(Fuser) s.getAttribute("current_user");
		if(us==null){
		  us=fuserver.selectbyid(fuid);
	  s.setAttribute("current_user", us);
		}
	
		if(us.getFhometown()!=null){
			Localp url=local.selectURL(us.getFhometown());
	
			us.setFhome(url);
		}
		if(us.getFliveplace()!=null){
			Localp url=local.selectURL(us.getFliveplace());
		    us.setFplace(url);
		}
	 UWork uw=work.selectbyFuid(fuid);
	 List<UEducation> cation=edu.selectbyFuid(fuid);
	 if(cation!=null){
		 for(int i=0;i<cation.size();i++){
			String url=college.selectURL( cation.get(i).getUschool());
			cation.get(i).setUrl(url);
		 }
	 }
	    mv.addObject("work",uw);
	    mv.addObject("edu",cation);
	    mv.setViewName("aboutme");
		return mv;
	}
	@RequestMapping(value="/addlife.action")
	public void addlife(@RequestBody Liferecord ue,HttpServletRequest re,HttpServletResponse res){
	int n =	life.addLife(ue);
	System.out.println(ue.getFuid());
	if(n==1){
		try {
			res.getWriter().print(ue.getLfid());
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}else
	{
		try {
			res.getWriter().print("wrong");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	}
	@RequestMapping(value="/{lifeid}/del.action")
	public void del(@PathVariable("lifeid")String lifeid,HttpServletResponse responce){
		int n=life.deleteLife(lifeid);
		if(n==1){
			try {
				responce.getWriter().print("sucesss");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}else
		{
			try {
				responce.getWriter().print("wrong");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	@RequestMapping(value="/{visitfuid}/{current_fuid}/firstin.action")
	public ModelAndView TOSEE(@PathVariable("visitfuid")String visitfuid,@PathVariable("current_fuid")String current_fuid,HttpServletRequest re){
		ModelAndView mv=new ModelAndView();
		HttpSession s=re.getSession();
		Fuser us=(Fuser) s.getAttribute("current_user");
		if(us==null){
		  us=fuserver.selectbyid(current_fuid);
	  s.setAttribute("current_user", us);
		}
		Fuser vi=fuserver.selectbyid(visitfuid);
		if(vi.getFhometown()!=null){
			Localp url=local.selectURL(vi.getFhometown());
	
			vi.setFhome(url);
		}
		if(vi.getFliveplace()!=null){
			Localp url=local.selectURL(vi.getFliveplace());
		    vi.setFplace(url);
		}
	 UWork uw=work.selectbyFuid(visitfuid);
	 List<UEducation> cation=edu.selectbyFuid(visitfuid);
	 if(cation!=null){
		 for(int i=0;i<cation.size();i++){
			String url=college.selectURL( cation.get(i).getUschool());
			cation.get(i).setUrl(url);
		 }
	 }
	    mv.addObject("work",uw);
	    mv.addObject("edu",cation);
		s.setAttribute("visit", vi);
		mv.setViewName("aboutmetosee");
		return mv;
	}
	
	@RequestMapping(value="/{fuid}/education.action")
	public ModelAndView education(@PathVariable("fuid")String fuid,HttpServletRequest re){
		ModelAndView mv=new ModelAndView();
		HttpSession s=re.getSession();
		Fuser us=(Fuser) s.getAttribute("current_user");
		if(us==null){
		  us=fuserver.selectbyid(fuid);
	  s.setAttribute("current_user", us);
		}
		UWork uw=work.selectbyFuid(fuid);
		 List<UEducation> cation=edu.selectbyFuid(fuid);
		 if(cation!=null){
			 for(int i=0;i<cation.size();i++){
				String url=college.selectURL( cation.get(i).getUschool());
				cation.get(i).setUrl(url);
			 }
		 }
		    mv.addObject("work",uw);
		    mv.addObject("edu",cation);
		 mv.setViewName("education");
			return mv;
	}
	@RequestMapping(value="/{fuid}/updateE.action")
	public void updateE(@PathVariable("fuid")String fuid,@RequestBody UEducation ue,HttpServletRequest re,HttpServletResponse res){
		HttpSession s=re.getSession();
		Fuser us=(Fuser) s.getAttribute("current_user");
		if(us==null){
		  us=fuserver.selectbyid(fuid);
	  s.setAttribute("current_user", us);
		}
		int n=edu.updateEducation(ue);

		if(n==1){
			try {
				res.getWriter().print("update");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}else
		{
			n=edu.Addeducation(ue);
			if(n==1){
				try {
					res.getWriter().print(ue.getUedid());
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}else
			{
				try {
					res.getWriter().print("wrong");
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}
	@RequestMapping(value="/{fuid}/updateW.action")
	public void updateW(@PathVariable("fuid")String fuid,@RequestBody UWork uw,HttpServletRequest re,HttpServletResponse res){
		HttpSession s=re.getSession();
		Fuser us=(Fuser) s.getAttribute("current_user");
		if(us==null){
		  us=fuserver.selectbyid(fuid);
	  s.setAttribute("current_user", us);
		}
		int n=work.updateWork(uw);
		if(n==1){
			try {
				res.getWriter().print("update");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}else
		{
			n=work.AddWork(uw);
			if(n==1){
				try {
					res.getWriter().print(uw.getUworkid());
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}else{
				try {
					res.getWriter().print("wrong");
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}
	@RequestMapping(value="/{fuid}/liveing.action")
	public ModelAndView liveing(@PathVariable("fuid")String fuid,HttpServletRequest re){
		ModelAndView mv=new ModelAndView();
		HttpSession s=re.getSession();
		Fuser us=(Fuser) s.getAttribute("current_user");
		if(us==null){
		  us=fuserver.selectbyid(fuid);
	  s.setAttribute("current_user", us);
		}
		if(us.getFhometown()!=null){
			Localp url=local.selectURL(us.getFhometown());
			us.setFhome(url);
		}
		if(us.getFliveplace()!=null){
			Localp url=local.selectURL(us.getFliveplace());
			us.setFplace(url);
		}
		  s.setAttribute("current_user", us);
		  System.out.println(us.getFplace().getLurl());
		List<Liferecord> lrecord=life.selectlife(us.getFuid());
		System.out.println(lrecord.size()+"生活记录");
		 mv.addObject("lrecord",lrecord);
		 mv.setViewName("livingprof");
			return mv;
	}
	@RequestMapping(value="/{fuid}/contactinfo.action")
	public ModelAndView contactinfo(@PathVariable("fuid")String fuid,HttpServletRequest re){
		ModelAndView mv=new ModelAndView();
		HttpSession s=re.getSession();
		Fuser us=(Fuser) s.getAttribute("current_user");
		if(us==null){
		  us=fuserver.selectbyid(fuid);
	  s.setAttribute("current_user", us);
		}
		 mv.setViewName("contact-info");
			return mv;
	}
	@RequestMapping(value="/{fuid}/biomore.action")
	public ModelAndView biomore(@PathVariable("fuid")String fuid,HttpServletRequest re){
		ModelAndView mv=new ModelAndView();
		HttpSession s=re.getSession();
		Fuser us=(Fuser) s.getAttribute("current_user");
		if(us==null){
		  us=fuserver.selectbyid(fuid);
	  s.setAttribute("current_user", us);
		}
		 mv.setViewName("biomore");
			return mv;
	}

}
