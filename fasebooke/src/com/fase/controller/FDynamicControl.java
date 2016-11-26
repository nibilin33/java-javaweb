package com.fase.controller;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import util.GenImage;

import com.fase.iservice.Idynamicinfo;
import com.fase.mapper.DynamicInfoMapper;
import com.fase.po.DynamicInfo;
import com.fase.po.Fuser;
import com.sun.jmx.snmp.Timestamp;

@Controller
@RequestMapping(value="/fdynamiccontrol")
public class FDynamicControl {
	@Resource
	private Idynamicinfo dydao;
	private List<DynamicInfo> temp=new ArrayList<DynamicInfo>();
	
	@RequestMapping(value="/file2.action")
	public ModelAndView Upmessage(@RequestParam("sendwords")String sendwords,HttpServletRequest request){
		String isvisiable=request.getParameter("isvisiable");
		String fuid=request.getParameter("fuid");
		String sendimage=request.getParameter("bigimage");
		BigDecimal b=null;
		int count=0;
		for(int i=0;i<temp.size();i++){
			
			if(temp.get(i).getFuid().equals(fuid)){
				count++;
				if(count==1){
				sendimage=temp.get(i).getSendimage();
				}
				else
				{
					sendimage+=temp.get(i).getSendimage();
				}
			}
		}
		temp=null;
		temp=new ArrayList<DynamicInfo>();
		DynamicInfo one=new DynamicInfo();
	
		if(isvisiable.equals("公开")){
			b=new BigDecimal(0);
		}else if("好友".equals(isvisiable)){
			b=new BigDecimal(1);
		}else if("仅限自己".equals(isvisiable)){
			b=new BigDecimal(2);
		}
		one.setFuid(fuid);
		one.setSendwords(sendwords.trim());
		one.setSendtime(new Date());
		one.setSendimage(sendimage);
		one.setIsvisiable(b);
		dydao.insertIntody(one);
		return new ModelAndView("redirect:/user/show.action?fuid="+fuid);
	}
	@RequestMapping(value ="/{fuid}/city.action")
	public void city(HttpServletResponse res,@PathVariable("fuid")String fuid,HttpServletRequest re){
		String sendimage=re.getParameter("im");
		DynamicInfo one=new DynamicInfo();
		one.setFuid(fuid);
		one.setSendwords("签到位置：");
		one.setSendtime(new Date());
		one.setSendimage(sendimage);
	int n=	dydao.insertIntody(one);
	if(n==1){
		try {
			res.getWriter().print("success");
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
    @RequestMapping(value="/timeline.action")
    public ModelAndView timeline(@RequestParam("sendwords")String sendwords,HttpServletRequest request){
		String isvisiable=request.getParameter("isvisiable");
		String fuid=request.getParameter("fuid");
		String sendimage=request.getParameter("bigimage");
		BigDecimal b=null;
		int count=0;
		for(int i=0;i<temp.size();i++){
			
			if(temp.get(i).getFuid().equals(fuid)){
				count++;
				if(count==1){
				sendimage=temp.get(i).getSendimage();
				}
				else
				{
					sendimage+=temp.get(i).getSendimage();
				}
			}
		}
		DynamicInfo one=new DynamicInfo();
	
		if(isvisiable.equals("公开")){
			b=new BigDecimal(0);
		}else if("好友".equals(isvisiable)){
			b=new BigDecimal(1);
		}else if("仅限自己".equals(isvisiable)){
			b=new BigDecimal(2);
		}
		one.setFuid(fuid);
		one.setSendwords(sendwords.trim());
		one.setSendtime(new Date());
		one.setSendimage(sendimage);
		one.setIsvisiable(b);
		dydao.insertIntody(one);
		return new ModelAndView("redirect:/user/"+fuid+".action");
    }
	@RequestMapping(value="/delete.action")
	public void deimage(HttpServletRequest request, HttpServletResponse response){
		String uid=request.getParameter("uid");
		String fid=request.getParameter("fid");
		for(int i=0;i<temp.size();i++){
			if(temp.get(i).getFuid().equals(uid)&&temp.get(i).getSendimage().equals(fid)){
				temp.remove(i);
			}
		}
		String path="E:/"+uid+"/"+fid;
		File file=new File(path);
		if (file.exists()) {// 上面文件创建,已存在就删除
                file.delete();
            }
		response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=" + "utf-8");
        Writer writer = null;
        try {
            writer = response.getWriter();
            writer.write("success");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(writer);
        }
	}
	
	@RequestMapping(value="/file1.action")
	public void upimage(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException{
		 // 创建一个通用的多部分解析器
	    String username=request.getParameter("uid");
	    DynamicInfo te=new DynamicInfo();
	    te.setFuid(username);
	   
	    String record="";
	
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
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
                    String myFileName = file.getOriginalFilename();
                    String str=myFileName.substring(myFileName.lastIndexOf(".")+1);
                    System.out.println(myFileName);
                  
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                   
                        // 重命名上传后的文件名
                    	 String fileName =""+pre+"."+str;
                      
                     
                        // 定义上传路径
                        String path = "E:/img/" +username;
                        System.out.println(path);
                        File localFilew = new File(path);
                        if(!localFilew.exists()&&!localFilew.isDirectory()){
                        	localFilew.mkdir();
                        }
                        File localFile=new File(path+"/"+ fileName);
                        record=fileName;
                        file.transferTo(localFile);
                    }
                }
                // 记录上传该文件后的时间
                int finaltime = (int) System.currentTimeMillis();
                System.out.println(finaltime - pre);
            }

        }
        System.out.println(record+"传照片了");
         te.setSendimage(record);
         temp.add(te);
        responseMessage(response,record);
	}

	 private void responseMessage(HttpServletResponse response,String filename) {
	        response.setCharacterEncoding("utf-8");
	        response.setContentType("text/html; charset=" + "utf-8");
	        Writer writer = null;
	        try {
	            writer = response.getWriter();
	            writer.write("{\"code\":" + 200 + ",\"message\":\"" + filename
	                    + "\"}");
	            writer.flush();
	            writer.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            IOUtils.closeQuietly(writer);
	        }
	    }
      
	
}
