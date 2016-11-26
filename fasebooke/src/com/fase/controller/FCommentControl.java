package com.fase.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import oracle.jdbc.driver.OracleTypes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fase.iservice.Icommentservice;
import com.fase.mapper.FuserMapper;
import com.fase.po.Askpermission;
import com.fase.po.DynamicInfo;
import com.fase.po.Fuser;
import com.fase.po.Helpcenter;
import com.fase.po.TComment;
import com.fase.service.imp.Fcomment;

@Controller
@RequestMapping(value="/comment")
public class FCommentControl {

	@Resource
	private Icommentservice fservice;
	@Resource
	private FuserMapper fuservice;
	@RequestMapping(value="/dycomment.action")
public ModelAndView findCommentByItemId(HttpServletRequest request, HttpServletResponse response){
   String parentid=request.getParameter("contentid");
   String fuid=request.getParameter("fuid");
   Map<String, Object> param = new HashMap<String, Object>(); 
	//对于in参数赋值 
	param.put("pid",parentid); 
	param.put("offset",0);
	param.put("maxs",9);
	param.put("result",OracleTypes.CURSOR); 
	List <TComment> findCommentByItemId=fservice.findParentCommentByItemId(param);
	for(TComment comment : findCommentByItemId){ 
		List<TComment> replys = new ArrayList<TComment>(); // 实例化回复的集合  
        comment.setReplyComment(replys); // 设置评论的回复集合  
        String customerId = comment.getCustomerId(); // 获取评论的人的Id  
        Fuser customer = fuservice.selectByPrimaryKey(customerId); // 通过评论人的Id获取评论人的信息  
        if(customer != null) customer.setFpassword(null);; // 把评论的人的密码设置为空  
        comment.setCustomer(customer); // 设置评论的人的信息  
	     buildReplyComment(comment, replys, 0, 9);
	}
	HttpSession s=request.getSession();
	s.setAttribute("itemComments", findCommentByItemId);
/*	JSONObject json=new JSONObject();
	json.put("itemComments", findCommentByItemId);
	 try {
  	   response.setContentType("application/json");
         response.setHeader("Pragma", "No-cache");
         response.setHeader("Cache-Control", "no-cache");
         response.setCharacterEncoding("UTF-8");
		  response.getWriter().print(json);
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} */
	return  new ModelAndView("redirect:/user/show.action?fuid="+fuid);
	}
	@RequestMapping(value="/reply.action")
	public void reply(@RequestBody TComment ask,HttpServletResponse response){
	Integer s=	fservice.InsertComment(ask);
	       try {
	           response.setHeader("Pragma", "No-cache");
	           response.setHeader("Cache-Control", "no-cache");
	           response.setCharacterEncoding("UTF-8");
			  response.getWriter().print(ask.getId());
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
	     
	}
	 private void buildReplyComment(TComment comment, List<TComment> replys, int offset, int limit){ 
			Map<String, Object> param = new HashMap<String, Object>(); 
			//对于in参数赋值 
			param.put("pid",comment.getId()); 
			param.put("offset",0);
			param.put("maxs",9);
			param.put("result",OracleTypes.CURSOR); 
	        List<TComment> replyComments =fservice.findReplyCommentByCommentId(param); // 获取评论的所有回复  
	        replys.addAll(replyComments); // 把所有的回复添加到评论实例化的回复集合中  
	        for(TComment c : replyComments){ // 遍历回复中的回复  
	            String customerId = c.getCustomerId(); // 获取回复人的id  
	            Fuser replyCustomer = fuservice.selectByPrimaryKey(customerId); // 获取回复人信息  
	            if(replyCustomer != null) replyCustomer.setFpassword(null);// 把回复人的密码设置为空  
	            if(replyCustomer.getFheadimage()!=null){
	            	replyCustomer.setFheadimage(DynamicInfo.imagebase+replyCustomer.getFuid()+"/"+replyCustomer.getFheadimage());
	            }else
	            {
	            	replyCustomer.setFheadimage("http://localhost:8080/img/face/head_male_man_user_64px_1578_easyicon.net.png");
	            }
	            Fuser customer =fuservice.selectByPrimaryKey(comment.getCustomerId()); // 获取评论人的信息  
	            c.setCustomer(customer); // 设置评论人的信息  
	            c.setReplyCustomer(replyCustomer); // 设置回复人的信息  
	            buildReplyComment(c, replys, offset, limit); // 递归调用  
	        }  
    }
}