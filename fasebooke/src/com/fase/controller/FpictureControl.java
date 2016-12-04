package com.fase.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fase.iservice.Ifuser;
import com.fase.iservice.Iphotogra;
import com.fase.iservice.Ipictureservice;
import com.fase.po.DynamicInfo;
import com.fase.po.Fuser;
import com.fase.po.Photogallery;
import com.fase.po.Picture;

@Controller
@RequestMapping(value="/picture")
public class FpictureControl {
@Resource
private Iphotogra pservice;
@Resource
private Ifuser ifuser;
@Resource
private Ipictureservice ipic;
@RequestMapping(value="/{fuid}/fuck.action") /* 进入照片查看相册照片*/
 public ModelAndView opengay(@PathVariable("fuid")String fuid,HttpServletRequest re){
        ModelAndView mv=new ModelAndView();
       List<Photogallery> po=pservice.selectall(fuid);
       HttpSession s=re.getSession();
       Fuser ii=(Fuser) s.getAttribute("current_user");
       if(ii==null){
    	   ii=ifuser.selectbyid(fuid);
       }
        s.getCreationTime() ;  /*获取session的创建时间*/
       s.getLastAccessedTime(); /* 获取上次与服务器交互时间*/
       s.getMaxInactiveInterval() ;/*获取session最大的不活动的间隔时间，以秒为单位120秒。*/
       System.out.println( s.getCreationTime()+ "gg"+s.getLastAccessedTime()+ "gg"+s.getMaxInactiveInterval());
       s.setAttribute("current_user", ii);
       mv.addObject("mygay", po);
       mv.setViewName("photo");
       return mv;
}
@RequestMapping (value="/{visitfuid}/{fuid}/fuck.action")
public ModelAndView vopengay(@PathVariable("fuid")String fuid,@PathVariable("visitfuid")String visitfuid,HttpServletRequest re){
    ModelAndView mv=new ModelAndView();
   HttpSession s=re.getSession();
   Fuser ii=(Fuser) s.getAttribute("current_user");
   if(ii==null){
	   ii=ifuser.selectbyid(fuid);
   }
   s.setAttribute("current_user", ii);
   Fuser vi=ifuser.selectbyid(visitfuid);
   s.setAttribute("visit", vi);
	List<Photogallery> pall=pservice.selectall(visitfuid);
	 mv.addObject("gaypic", pall);
	 mv.setViewName("xiangce");
   return mv;
}
@RequestMapping(value="/{fuid}/onthisday.action")
public ModelAndView onthisday(@PathVariable("fuid")String fuid,HttpServletRequest re){
	  ModelAndView mv=new ModelAndView();
	 
	  HttpSession s=re.getSession();
	   Fuser ii=(Fuser) s.getAttribute("current_user");
	   if(ii==null){
		   ii=ifuser.selectbyid(fuid);
	   }
	   s.setAttribute("current_user", ii);
	List<Photogallery> pall=pservice.selectall(fuid);
	 mv.addObject("gaypic", pall);
	   mv.setViewName("onthisday");
	return mv;
}
@RequestMapping(value="/{gid}/ingay.action")
public ModelAndView ingay(@PathVariable("gid")String gid,HttpServletRequest re){
   String fuid=re.getParameter("fuid");
   System.out.println(gid);
   ModelAndView mv=new ModelAndView();
   Photogallery po=pservice.selectone(gid);
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
   System.out.println(po.getGpid());
   List<Picture> ps=po.getPictures();
/*   s.setAttribute("gaypic", po);*/
 mv.addObject("gaypic", po);
   mv.setViewName("gallary");
   return mv;
}
@RequestMapping(value="/CreatePbefore.action")   /*创建相册*/
 public void CreatePbefore(@RequestBody Photogallery pg,HttpServletResponse re){

  int n=pservice.isenableinsert(pg.getGicname());
  re.setHeader("Pragma", "No-cache");
  re.setHeader("Cache-Control", "no-cache");
  re.setCharacterEncoding("UTF-8");
  if(n==1){
	  try {
		re.getWriter().print("wrong");
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
  }else
  {
	 pservice.insert(pg);
	  try {
		re.getWriter().print(pg.getGpid());
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
  }
	 
   
  
}
@RequestMapping(value="/delete.action") /* 删除相册*/
public void delete(HttpServletRequest re,HttpServletResponse res){
	String gid=re.getParameter("gid");
	String fuid=re.getParameter("fuid");
/*	Photogallery dep=pservice.selectone(gid);
	String path="E:img/temps/";
	for(int i=0;i<dep.getPictures().size();i++){
		String tmp=path+dep.getPictures().get(i).getPicname();
		File file=new File(tmp);
		if (file.exists()) {// 上面文件创建,已存在就删除
                file.delete();
            }
	}*/
	System.out.println(gid);
	pservice.deletebygid(gid);
   try {
	res.getWriter().print("sucess");
} catch (IOException e) {
	// TODO 自动生成的 catch 块
	e.printStackTrace();
}
}
@RequestMapping(value="/deleteone.action")   /* 删除一张照片*/
public void deleteone(HttpServletRequest re,HttpServletResponse response){
	String fuid=re.getParameter("fuid");
	String pid=re.getParameter("pid");
	ipic.deletebypid(pid);
	 try {
	          response.setHeader("Pragma", "No-cache");
	          response.setHeader("Cache-Control", "no-cache");
	          response.setCharacterEncoding("UTF-8");
			  response.getWriter().print("success");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
}
@RequestMapping(value="/createg.action")
public void createg(@RequestBody Photogallery po,HttpServletResponse response){
	pservice.insert(po);
	JSONObject json=new JSONObject();
	json.put("newp", po);
	  try {
   	   response.setContentType("application/json");
          response.setHeader("Pragma", "No-cache");
          response.setHeader("Cache-Control", "no-cache");
          response.setCharacterEncoding("UTF-8");
		  response.getWriter().print(json);
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} 
}
@RequestMapping(value="/dotest.action") /* 上传照片*/
public void dotest(HttpServletResponse response,HttpServletRequest request) throws IllegalStateException, IOException{
	 
	  String gid=request.getParameter("gid");
	// 创建一个通用的多部分解析器
   CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
           request.getSession().getServletContext());
   String myFileName="";
   String realpath="";
   // 判断 request 是否有文件上传,即多部分请求
   if (multipartResolver.isMultipart(request)) {
       // 转换成多部分request
       MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
       // 取得request中的所有文件名
       Iterator<String> iter = multiRequest.getFileNames();
       while (iter.hasNext()) {
           // 记录上传过程起始时的时间，用来计算上传时间
           int pre = (int) System.currentTimeMillis();
           // 取得上传文件
           MultipartFile file = multiRequest.getFile(iter.next());
           if (file != null) {
               // 取得当前上传文件的文件名称
        	   myFileName  = file.getOriginalFilename();
               String str=myFileName.substring(myFileName.lastIndexOf(".")+1);
               System.out.println(myFileName);
             
               // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
               if (myFileName.trim() != "") {
              
                   // 重命名上传后的文件名
               	 String fileName =""+pre+"."+str;
                 
                
                   // 定义上传路径
                   String path = "E:/img/" +"temps";
                  
                   File localFilew = new File(path);
                   if(!localFilew.exists()&&!localFilew.isDirectory()){
                   	localFilew.mkdir();
                   }
                   File localFile=new File(path+"/"+ fileName);
                   file.transferTo(localFile);
                   realpath="http://localhost:8080/img/temps/"+fileName;
               }
           }
           // 记录上传该文件后的时间
           int finaltime = (int) System.currentTimeMillis();
           
       }

   }
   Picture p=new Picture();
   p.setGpid(gid);
   p.setPicdescribe(realpath);
   p.setPicname(myFileName);
   p.setPtime(new Date());
   ipic.insertpic(p);
   String pid=p.getPid();
	JSONObject json=new JSONObject();
    json.put("filename", myFileName);
    json.put("path",realpath);
    json.put("pid",pid);
	  try {
  	   response.setContentType("application/json");
         response.setHeader("Pragma", "No-cache");
         response.setHeader("Cache-Control", "no-cache");
         response.setCharacterEncoding("UTF-8");
		  response.getWriter().print(json);
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} 
}

@RequestMapping(value="/dofile.action") /* 上传文件*/
public void dofile(HttpServletResponse response,HttpServletRequest request) throws IllegalStateException, IOException{
	 // 创建一个通用的多部分解析器
  CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
          request.getSession().getServletContext());
  String myFileName="";
	 String fileName="";
  // 判断 request 是否有文件上传,即多部分请求
  if (multipartResolver.isMultipart(request)) {
      // 转换成多部分request
      MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
      // 取得request中的所有文件名
      Iterator<String> iter = multiRequest.getFileNames();
      while (iter.hasNext()) {
          // 记录上传过程起始时的时间，用来计算上传时间
          int pre = (int) System.currentTimeMillis();
          // 取得上传文件
          MultipartFile file = multiRequest.getFile(iter.next());
          if (file != null) {
              // 取得当前上传文件的文件名称
       	   myFileName  = file.getOriginalFilename();
              String str=myFileName.substring(myFileName.lastIndexOf(".")+1);
              System.out.println(myFileName);
            
              // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
              if (myFileName.trim() != "") {
             
                  // 重命名上传后的文件名
            	  fileName =""+pre+"."+str;
                
               
                  // 定义上传路径
                  String path = "E:/img/" +"temps";
                 
                  File localFilew = new File(path);
                  if(!localFilew.exists()&&!localFilew.isDirectory()){
                  	localFilew.mkdir();
                  }
                  File localFile=new File(path+"/"+ fileName);
                  file.transferTo(localFile);
              }
          }
          // 记录上传该文件后的时间
          int finaltime = (int) System.currentTimeMillis();
          
      }

  }
   JSONObject json=new JSONObject();
   json.put("filepath", fileName);
	  try {
 	   response.setContentType("application/json");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
		  response.getWriter().print(json);
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} 
}

}
