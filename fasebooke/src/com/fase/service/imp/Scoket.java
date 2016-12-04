package com.fase.service.imp;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;









import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fase.mapper.HelpcenterMapper;
import com.fase.mapper.OfflinemssageMapper;
import com.fase.po.Offlinemssage;

import net.sf.json.JSONObject;


//注意此访问地址格式如:"ws://"+ window.location.host+"/${pageContext.request.contextPath}/game"是ws开头的,而不是以http:开头的.
@ServerEndpoint(value = "/game")
public class Scoket {

  private Logger logger = Logger.getLogger(this.getClass().getName());
  static Map<String,Session> sessionMap = new Hashtable<String,Session>(); 
  private static Set<Scoket> chatsocket=new HashSet<Scoket>();
  private static List<String>names=new ArrayList<String>();
  private JSONObject jsonobject=new JSONObject();
  private static Map<String,Session>map=new HashMap<String, Session>(); 
  private Session session;
  private String username;
  private static ApplicationContext	applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
  OfflinemssageMapper om=(OfflinemssageMapper)applicationContext.getBean("offlinemssageMapper");
@SuppressWarnings("unused")
@OnOpen
public void onOpen(Session session) throws Exception{
/*    sessionMap.put(session.getId(), session);*/
	this.session=session;
	chatsocket.add(this);
	String querystring=session.getQueryString();
	this.username=querystring.substring(querystring.indexOf("=")+1);
	System.out.println(this.username);
	List<Offlinemssage> ol=om.selectByPrimaryKey(username);
	if(ol.size()>0){
		for(int i=0;i<ol.size();i++){
			 JSONObject jsonObject=new JSONObject();
			 jsonObject.put("fuid", ol.get(i).getFuid());
			 jsonObject.put("tfuid", ol.get(i).getTofuid());
			 jsonObject.put("msg", ol.get(i).getMsg());
			 jsonObject.put("sendtime", ol.get(i).getSendtime());
			 om.deleteByPrimaryKey( ol.get(i).getOfid());
			session.getBasicRemote().sendText(jsonObject.toString());
		}
	}
	names.add(this.username);
	map.put(this.username, session); 
}

  @OnMessage
public void onMessage(String msg, Session session) {
	  JSONObject jsonObject = JSONObject.fromObject(msg);
	  String fuid = jsonObject.getString("fuid");
	  String tfuid = jsonObject.getString("tfuid");
	  String msg2=jsonObject.getString("msg");
	  String dates=jsonObject.getString("sendtime");
	  java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
	  Date date=new Date();
	  jsonObject.put("sendtime", date);
	  Session ses2=this.map.get(tfuid);
	  if(ses2==null){
		  try {
		 Offlinemssage li=new Offlinemssage();
			  li.setFuid(fuid);
			  li.setTofuid(tfuid);
			  li.setMsg(msg2);
			  li.setSendtime(date);
			  om.insertSelective(li);
			 session.getBasicRemote().sendText("offline");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }else{
	  try {
		ses2.getBasicRemote().sendText(jsonObject.toString());
	} catch (IOException e1) {
		// TODO 自动生成的 catch 块
		e1.printStackTrace();
	}
	  }
  }

 @OnClose
public void onClose(Session session, CloseReason closeReason) {

   /*   sessionMap.remove(session.getId());*/
	 try{
	 this.map.remove(this.username); 
	 }catch (Exception e){
		 e.printStackTrace();
	 }

      logger.info(String.format("Session %s closed because of %s", this.username, closeReason));
}

 @OnError
public void error(Session session, java.lang.Throwable throwable){
	 try{
		 this.map.remove(this.username); 
		 }catch (Exception e){
			 e.printStackTrace();
		 }
      System.err.println("session "+session.getId()+" error:"+throwable);

  }
}
