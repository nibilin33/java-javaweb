<%@ page language="java" import="java.util.*,net.sf.json.*,com.fase.po.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import="org.springframework.web.util.UrlPathHelper" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
	  <base href="<%=basePath%>">
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"> 
        <meta charset="utf-8">
      <title>fasebooke</title>
         
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
          <link href="<%=request.getContextPath()%>/resources/css/jscrollpane1.css" rel="stylesheet" type="text/css"/>
        <link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
   <link href="<%=request.getContextPath()%>/resources/css/facebook.css" rel="stylesheet" type="text/css"/>
     <link href="<%=request.getContextPath()%>/resources/css/share.min.css" rel="stylesheet" type="text/css"/>
     
        
         <link href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/facebook_128px_1160395_easyicon.net.ico"/>
      <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script> 
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/social-share.min.js" id="wei"></script> 
      <script language="javascript" type="text/javascript" src="http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js
"></script>
 <script language="javascript" type="text/javascript">
 <% Fuser us =(Fuser)request.getSession().getAttribute("current_user") ;  %>
 var cuserid='<%=us.getFuid()%>';
 var curername='<%=us.getFname()%>';
 var curhead='${current_user.fheadimage}'; 
  if(curhead==''){
	 curhead="http://localhost:8080/img/face/head_male_man_user_64px_1578_easyicon.net.png";
	 
 }else
	 {
	 var s="http://localhost:8080/img/"+cuserid+"/"+curhead;
  console.log(s); 
	 curhead=s; 
	 }  
 
  localStorage.setItem("current_id",cuserid); 
  localStorage.setItem("current_name",curername); 
  localStorage.setItem("current_head",curhead);
 window.onload=function(){
	 window.p=remote_ip_info.province+remote_ip_info.city;
 }
 
 </script>
   <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js"></script> 
    </head>

    
    <body>
        
        <div class="wrapper">
			<div class="box">
				<div class="row row-offcanvas row-offcanvas-left">
					
					<!-- sidebar -->
					<div class="column col-sm-2 col-xs-1 sidebar-offcanvas" id="sidebar">
					  
						<ul class="nav">
							<li><a href="javascript:;" data-toggle="offcanvas" class="visible-xs text-center"><i class="glyphicon glyphicon-chevron-right"></i></a></li>
						</ul>
					   
						<ul class="nav hidden-xs" id="lg-menu">
							<li class="active"><a href="javascript:;"><i class="fa fa-facebook-square"></i> 欢迎来到fasebooke</a></li>
							<li><a href="javascript:;" onclick="openChatService()"><i class="glyphicon glyphicon-list"></i> fasebooke聊天窗</a></li>
							<li><a href="http://localhost:8080/fasebooke/picture/${current_user.fuid}/onthisday.action"><i class="glyphicon glyphicon-picture"></i> 照片墙</a></li>
							<li>
							    <a href="http://localhost:8080/fasebooke/comment/${current_user.fuid}/seenote.action"><i class="fa  fa-history" ></i>留言墙</a>
							</li>
						</ul>
						<ul class="list-unstyled hidden-xs" id="sidebar-footer">
							
						</ul>
					  
						<!-- tiny only nav-->
					  <ul class="nav visible-xs" id="xs-menu">
							<li><a href="#featured" class="text-center"><i class="glyphicon glyphicon-list-alt"></i></a></li>
							<li><a href="#stories" class="text-center"><i class="glyphicon glyphicon-list"></i></a></li>
							<li><a href="#" class="text-center"><i class="glyphicon glyphicon-paperclip"></i></a></li>
							<li><a href="#" class="text-center"><i class="glyphicon glyphicon-refresh"></i></a></li>
						</ul>
					  
					</div>
					<!-- /sidebar -->
				  
					<!-- main right col -->
					<div class="column col-sm-10 col-xs-11" id="main">
						
						<!-- top nav -->
						<div class="navbar navbar-blue navbar-static-top">  
							<div class="navbar-header">
							  <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							  </button>
							  <a href="" class="navbar-brand logo">f</a>
							</div>
							<nav class="collapse navbar-collapse" role="navigation">
							<form class="navbar-form navbar-left" method="post" action="/fasebooke/user/${current_user.fuid}/plusfd.action">
								<div class="input-group input-group-sm" style="max-width:360px;">
								  <input class="form-control" placeholder="搜好友" name="srch-term" id="srch-term" type="text">
								  <ul name="EngineModel" style="height: auto;width:305px; margin-left: 20px; position: absolute; display: none;background:-webkit-gradient(linear, left top, left 25, from(#FFFFFF), color-stop(4%, #EEEEEE), to(#FFFFFF))"></ul>
								  <div class="input-group-btn">
									<button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
								  </div>
								</div>
							</form>
							<ul class="nav navbar-nav">
                          <li>
                             <a href="http://localhost:8080/fasebooke/user/${current_user.fuid}.action"> 
                             
                             <c:choose>
                             <c:when test="${!empty current_user.fheadimage}">
                             <img src="http://localhost:8080/img/${current_user.fuid}/${current_user.fheadimage}" style="border: 1px solid rgba(0, 0, 0, .1);width:24px;height:24px"><span>${current_user.fname}</span>
                            </c:when>
                            <c:otherwise>
                             <img src="http://localhost:8080/img/face/head_male_man_user_64px_1578_easyicon.net.png" style="border: 1px solid rgba(0, 0, 0, .1);width:24px;height:24px"><span>${current_user.fname}</span>
                            </c:otherwise>
                            </c:choose>
                            
                             </a>
                          </li>
							  <li>
								<a href="http://localhost:8080/fasebooke/user/show.action?fuid=${current_user.fuid }">
								<i class="glyphicon glyphicon-home"></i> 首页</a>
							  </li>

							  <li>
							    
								<a href="javascript:;" title="消息" onclick="opennoticeSou(this)"><span class="fa fa-comments"></span></a>
								<ul class="dropdown-menu" role="menu" ></ul>
							  </li>
							  <li>
							  <li>
							<a  href="javascript:;" onclick="openbroadcast(this)" title="通知" > <span class="glyphicon glyphicon-globe"></span></a>
                          <ul class="dropdown-menu" role="menu"></ul> 
							  </li>
				
							  </li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
				<!-- 			隐私设置块
							 -->
                          <li>
                            <a href="javascript:;" onclick="openL(this)"><div style="width:10px;height:100%"><img src="<%=request.getContextPath()%>/resources/img/secret.png"></div></a>
                          <ul style="width:380px ;display:none;z-index:9999;position:absolute;top:60px;left:-350px;background:#3B5999" >
<li><a href="javascript:;" style="padding:0"><div style="background-color:#3b5998;">
<span class="glyphicon glyphicon-eye-close" style="padding-left:10px;padding-right:10px;color:white"></span>
<div style="display: inline-block;margin-left:10px">
<h5 style="color:white">隐私设置检查</h5>
</div>
<div style="display: inline-block;margin-left:145px">
<img src="<%=request.getContextPath()%>/resources/img/secretcheck.png" style="margin-top:-90px">
</div>
</div></a></li>
<li> <a href="#demo" style="padding:0" data-toggle="collapse"><span class="glyphicon glyphicon-globe" style="padding-left:10px;padding-right:10px"></span>
<div style="display:inline-block">
<h5>谁能看我的资料？</h5>
</div>
<div style="display: inline-block;margin-left:50%">
<span class="caret"></span>

</div>
</a>
<div id="demo" class="collapse">

<ul style="padding:0;margin:0">

<li class="yinsi">
<i class="fa fa-shield"></i> 
<div class="zuobian" >
<p>谁以后可以看见我的帖子</p>
<div class="dropdown pull-left" style="margin-right:2px">
<button class="btn btn-sm dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
<span class="glyphicon glyphicon-globe">公开</span>
<span class="caret"></span>
</button>
<ul class="dropdown-menu" aria-labelledby="dropdownMenu1" id="timeline" style="color:darkgray;text-align:center">
<li><span class="glyphicon glyphicon-globe"><a href="javascript:;">公开</a></span></li>
<li><span class="fa fa-user"><a href="javascript:;">好友</a></span>
</li>
<li><span class="fa  fa-unlock-alt"><a href="javascript:;">仅限自己</a></span></li>
</ul>
</div>
</div>
</li>
<li class="yinsi">
<i class="fa fa-eye"></i>
<div class="zuobian">
<p>其他人在我的时间线上能看见什么？</p>
<a href="http://localhost:8080/fasebooke/user/${current_user.fuid}/${current_user.fuid}.action" style="display:block;margin:10px">访客视图</a>
</div>
</li>

</ul>

</div>

</li>
<li><a href="#demo2"style="padding:0" data-toggle="collapse"><span class="fa fa-group" style="padding-left:10px;padding-right:10px"></span>
<div style="display:inline-block">
<h5>谁能够联系我？</h5>
</div>
<div style="display: inline-block;margin-left:50%">
<span class="caret"></span>

</div>
</a>
<div id="demo2" class="collapse">

<ul style="padding:0;margin:0">

<li class="yinsi">
<i class="fa  fa-plus"></i> 
<div class="zuobian" >
<p>谁可以向我发送加好友请求？</p>
<div class="dropdown pull-left" style="margin-right:2px">
<button class="btn btn-sm dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
<span class="glyphicon glyphicon-globe">公开</span>
<span class="caret"></span>
</button>
<ul class="dropdown-menu" aria-labelledby="dropdownMenu1" id="befriend" style="color:darkgray;text-align:center">
<li>
<span class="glyphicon glyphicon-globe"><a href="javascript:;">公开</a></span></li>
<li>
<span class="fa  fa-users"><a href="javascript:;">好友的好友</a></span></li>
</ul>
</div>
</div>
</li>


</ul>

</div>
</li>

<li><a href="#demo3"style="padding:0" data-toggle="collapse"><span class="glyphicon glyphicon-minus-sign" style="padding-left:10px;padding-right:10px"></span> <div style="display:inline-block">
<h5>如何阻止他人骚扰我？</h5>
</div>
<div style="display: inline-block;margin-left:43%">
<span class="caret"></span>

</div></a>
<div id="demo3" class="collapse" style="margin-bottom:10px">

<ul style="padding:0;margin:0">

<li class="yinsi">
<i class="fa  fa-minus-circle"></i> 
<div class="zuobian" >
<p>你可以拉黑用户，进而解除与对方的好友关系，并阻止其与你沟通、或查看你时间线上的内容</p>
<input type="text" placeholder="输入名字或者邮箱"><button type="button" onclick="lahei(this)">拉黑</button>
</div>
</li>


</ul>

</div>

</li>
</ul>
                          </li>
                          
             <!-- 			隐私设置块
							                                    -->               
							  <li class="dropdown">
								<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-sort-desc"></i></a>
								<ul class="dropdown-menu">
			
								   <li  role="separator" class="divider"></li>
								  <li><a href="/fasebooke/user/out/${current_user.fuid}.action">退出</a></li>
								   <li  role="separator" class="divider"></li>
								  <li><a href="http://localhost:8080/fasebooke/user/helpcenter.action?fuid=${current_user.fuid}">帮助中心</a></li>
								</ul>
							  </li>
							</ul>
							</nav>
						</div>
						<!-- /top nav -->
					  
						<div class="padding">
							<div class="full col-sm-9">
							  
								<!-- content -->                      
								<div class="row">
								  
								 <!-- main col left --> 
								 <div class="col-sm-7">
								   
									  <div class="well"> 
										   <form class="form-horizontal" role="form"  method="post" action="/fasebooke/fdynamiccontrol/file2.action" onsubmit="return comf()" id="zz">
											<div class="clearfix">
                                           <div style="border-bottom: 1px solid #e5e5e5;">
											   <ul class="list-inline"><li>
										   <a href="" style="padding-left:5px;padding-right:5px">
											   <input type="file" id="imagefile" style="position:relative;opacity:0;height:30px;" onchange="preview(this)"title="选择图片" name="sendimage" accept="image/*" >
											   <div style="margin-top:-34px;z-index:22">
											   <span class="fa  fa-camera"></span>
											   <span>照片</span>
											     </div> 
							           </a>
											   </li></ul>
											</div>
                                       </div>
<!--                                         
发表动态
						 -->					 <div class="form-group" style="padding:14px;">
											  <textarea class="form-control" placeholder="分享新鲜事" name="sendwords" id="sendwords" rows=10">
											      
											  </textarea>
											  <div id="result"  style="column-count:2" >
								
											      </div>
											</div>
	                                    <input type="hidden" name="isvisiable" value="公开" id="isvisiable">
	                                    <input type="hidden" name="fuid" value="${current_user.fuid}" id="fuid">
											<button class="btn btn-primary pull-right" type="submit">发布</button>
							<div class="dropdown pull-right" style="margin-right:2px">
  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
  <span class="fa fa-user">好友</span>
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1" id="ispublic">
     <li>谁能看这些内容？</li>
    <li><span class="glyphicon glyphicon-globe"><a href="javascript:;">公开</a></span><p style="background:#cecec2;font-size:4px">
        任何fasebooke用户或非用户
    </p></li>
    <li><span class="fa fa-user"><a href="javascript:;">好友</a></span>
    <p style="background:#cecec2;font-size:4px" >你的fasebooke好友</p></li>
    <li><span class="fa  fa-unlock-alt"><a href="javascript:;">仅限自己</a></span></li>
  </ul>
</div>
<ul class="list-inline"><li><a href="javascript:;" onclick="getPbiao(this)"><i class="fa fa-smile-o"></i></a></li><li><a href="javascript:;" onclick="getp(this)"><i class="glyphicon glyphicon-map-marker"></i></a></li></ul>
										  </form>
									  </div>
<!--                                         
                                                                                                                                                           发表动态
						                                                             -->		
                            <c:forEach items="${dinfo}" var="emp" varStatus="vs">
								    <div class="panel panel-default">
										 <div class="panel-heading">
										 <div class="_commentimg">
										     <img src="${emp.imagehead}" style="height:50px;width:50px;border:1px solid #eee">
										 </div>
                                         <div class="_commentnav">
										   <h5>${emp.fname}</h5> 
										     <span>	<fmt:formatDate pattern="yyyy-MM-dd" value="${emp.sendtime}" /></span>
										   
										 </div>
										
										 
										  </div>
										  <div class="panel-body" id="panel${emp.did}" name="title">
		                                 
		                                     <script>  
		                             var sendwords="${emp.sendwords}";
		                             var sendimage="${emp.sendimage}";
		                             var dataid="panel${emp.did}";
		                             
		                           jiexi(sendwords,dataid,sendimage);
		            
		                        

		                                     </script>
	
											<div class="clearfix"></div>
											
											
		                        <div class="social-share" data-initialized="true" data-description="${emp.sendwords}" data-image ="${emp.imagehead}" data-title="${emp.sendwords} " data-source="${emp.sendwords}">
    <a href="#" class="social-share-icon icon-weibo"></a>
    <a href="#" class="social-share-icon icon-qq"></a>
    <a href="#" class="social-share-icon icon-tencent"></a>
  
    
</div> 
										<hr>
											<div style="display:inline-flex">
											
		<a href="javascript:;" style="font-size:26px;" class="comeon" ><span class="glyphicon glyphicon-thumbs-up" style="font-size:26px;padding-left:10px;padding-right:30px"></span>赞</a>
                                            
                                           
								            <a href="javascript:;" onclick="commentshow(this)" data="${emp.did}" style="font-size:26px;"><span class="glyphicon glyphicon-comment" style="font-size:26px;padding-left:10px;padding-right:30px"></span>评论</a>
	
											 <div class="_dianzan" style="display:none;margin-left:2px" id="wobujianle" onmouseover="this.style.display=''" onmouseout="this.style.display='none'">
                                             
                                            <img src="<%=request.getContextPath()%>/resources/img/haha.png" onclick="imgChoose(this)">
                                            <img src="<%=request.getContextPath()%>/resources/img/angr.png" onclick="imgChoose(this)">
                                            <img src="<%=request.getContextPath()%>/resources/img/love.png" onclick="imgChoose(this)">
                                            <img src="<%=request.getContextPath()%>/resources/img/sad.png" onclick="imgChoose(this)">
                                            <img src="<%=request.getContextPath()%>/resources/img/wow.png" onclick="imgChoose(this)">
                                            <img src="<%=request.getContextPath()%>/resources/img/zan.png" onclick="imgChoose(this)">
                                        </div>
                                     
											</div>
                                              <hr>
                                              <div class="_sb">
                                              <div class="_leavemood overcom" id="leavemoods">
                                              <c:forEach var="zan" items="${emp.dianzan}" varStatus="state" >
                                            
                                               <c:if test="${state.count<4}">
                      <% out.print("<img src='http://localhost:8080/img/face/");%>${zan.emotion}<% out.print("'>"); %>
                                               </c:if>
                                               </c:forEach>
                                               <span style="display: block">共${emp.dinazansize}人赞了你</span>
                                              </div>
                                              </div>
			<!-- 	                                                                    回复                                                                   		 -->			
											   <div style="display:none">
								              <div class="panel panel-default" >
								                  <div class="panel-body">
								             <div class="clearfix"></div>
	                    <c:if test="${!empty emp.tcomment}">
	                                   
	                <c:forEach var="comment" items="${emp.tcomment}">
	                              
	 <% out.print("<div class='overcom' id='pinlun");%>${comment.id}<%out.print("'><img src='");%>${comment.customer.fheadimage}<%out.print("'data='");%>${comment.customer.fuid}<%out.print("' style='border: 1px solidrgba(0,0,0,.1);width:24px;height:24px'>"); %>${comment.customer.fname}:

								          
						<script>
						   var sendwords="${comment.content}";
                           var dataid="pinlun${comment.id}";
                         jiexi(sendwords,dataid,'');
						</script>
								              <%out.print("<span style='font-size:2px;'>"); %> ${comment.commetTime}<%out.print("</span>"); %>
								              
								                  <%out.print("<a href='javascript:;' style='float:right' onclick='huifu(this)' data='"); %>${comment.id}<%out.print("' parent-data='");%>${emp.did}<%out.print("'>回复</a>");%>
      <c:if test="${!empty comment.replyComment}">
   
<c:forEach var="reply" items="${comment.replyComment}">
		<% out.print("<div class='overcom' id='pinlun");%>${reply.id}<%out.print("'><img src='");%>${reply.replyCustomer.fheadimage}<%out.print("'data='");%>${reply.replyCustomer.fuid}<%out.print("' style='border: 1px solidrgba(0,0,0,.1);width:24px;height:24px'>"); %>${reply.replyCustomer.fname}回复${reply.customer.fname}:
								              
                                                     
                                                        	<script>
						   var sendwords="${reply.content}";
                           var dataid="pinlun${reply.id}";
                         jiexi(sendwords,dataid,'');
						</script>
                                        <%out.print("<span style='font-size:2px;'>"); %> ${reply.commetTime}<%out.print("</span>"); %>
                                          <%out.print("<a href='javascript:;' style='float:right' onclick='huifu(this)' data='"); %>${reply.id}<%out.print("' parent-data='");%>${emp.did}<%out.print("'>回复</a></div>"); %>
   </c:forEach>   
   </c:if> 
   <%out.print("</div>");%>
			 					            </c:forEach>   
	                                      </c:if>
								             
								                  </div>
                                                  <div class="panel-footer" style="text-align:center">          
								               <a href="javascript:;" onclick="commenthide(this)"><i class="glyphicon glyphicon-chevron-up"></i></a>     
                                                  </div>
								              </div>
	  
								           </div>
								      	<!-- 	                                                                                                                 回复                                                                   		 -->	     	
											<div class="input-group">
											  <div class="input-group-btn">
											  <a href="javascript:;" onclick="postcomment(this)" class="btn btn-default" ><span class="fa fa-smile-o"></span></a>
											  </div>
											  <div>
              <input class="form-control" style="display:inline;" placeholder="Add a comment.." type="text">
              <a  href="javascript:;" class="btn btn-default" style="display:inline;float:right;position: relative;margin-top:-34px;" onclick="realsend(this)" data-id="${emp.did }"><i class="glyphicon glyphicon-share"></i></a>
              </div>
											</div>
											
										  </div>
										  </div>
									  </c:forEach>
								   <!--一个动态  -->
									

										
								   
								  </div>
								
								  <!-- main col right -->
								  <div class="col-sm-5">
									   
									   <div class="panel panel-default">
										 <div class="panel-heading"><span class="fa fa-user" style="font-size:30px"></span>
										 <div style="display:inline-block">
										 <h4 style="margin:0">可能认识的人</h4>
										 </div></div>
										  <div class="panel-body">
										  <div id="myCarousel" class="carousel slide">
											<!-- 轮播（Carousel）项目 -->
	<div class="carousel-inner">
		 <c:forEach var="addf" items="${addfreinds}" varStatus="status" >
		<c:choose>
		<c:when test="${status.index==0}">
		<div class="item active">
		</c:when>
		<c:otherwise>
		<div class="item">
		</c:otherwise>
		</c:choose>
		
		   <div class="_addfr ix">
		    <c:choose>
                        <c:when test="${!empty current_user.fheadimage}">
                             <img src="http://localhost:8080/img/${current_user.fuid}/${current_user.fheadimage}" style="border: 1px solid rgba(0, 0, 0, .1);width:64px;height:64px">
                            </c:when>
                            <c:otherwise>
                             <img src="http://localhost:8080/img/face/head_male_man_user_64px_1578_easyicon.net.png" style="border: 1px solid rgba(0, 0, 0, .1);width:64px;height:64px">
                            </c:otherwise>
                            </c:choose>
		
			<p><c:out value="${addf.fname}"></c:out></p>
			<p><c:out value="${addf.fliveplace}"></c:out></p>
		
			    <button type="button" class="btn btn-default btn-info" data="${addf.fuid}" onclick="addask(this)">
			 
			     <i class="glyphicon glyphicon-plus"></i>加为好友
			    </button>
		
			</div>
		
		</div>
		</c:forEach>
	</div>
	<!-- 轮播（Carousel）导航 -->
	<a class="carousel-control left" href="#myCarousel" 
	   data-slide="prev">&lsaquo;</a>
	<a class="carousel-control right" href="#myCarousel" 
	   data-slide="next">&rsaquo;</a>
                                              </div>
</div> 
										  </div>
									  
									
								
                                     </div>
							   </div><!--/row-->
								
							  
							</div><!-- /col-9 -->
						</div><!-- /padding -->
					</div>
					<!-- /main -->
				  
				</div>
			</div>
		</div>

  <div class="talk" id="talk" style="display:none">
	<div class="talk_title"><span>fasebooke聊天窗</span></div>
	<div class="talk_record">
		<div style="overflow:auto;height:198px" class="jp-container" id="jp">
			
		
			</div>
			</div>
			<div class="talk_word">
		&nbsp;
		<input class="add_face" id="facial" type="button" title="选择好友" value="" />
		  <select style="position:absolute;left:-95px;background:#212121;color:white" size=3  id="tf">
	 <c:forEach items="${myf}" var="ep">
	 <c:if test="${!empty ep.flist }">
	 <c:forEach items="${ep.flist}" var="em">
	 <option>${em.fcount}</option>
	 </c:forEach>
	 </c:if>
	 </c:forEach>
	       </select>
		<input id="shuru" class="messages emotion" autocomplete="off" value="在这里输入文字" onFocus="if(this.value=='在这里输入文字'){this.value='';}"  onblur="if(this.value==''){this.value='在这里输入文字';}"  />
		<input class="talk_send" type="button" title="发送" value="发送" id="sendButton"/>
	
	
		
	</div>
			</div>
		<!--post modal-->
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/localsearch.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/scroll.js"></script>
       
    <script type="text/javascript">
    var socket =null;
    var tryTime = 0;
    $(function(){
    	initSocket();
    	window.onbeforeunload = function () {
    		//离开页面时的其他操作
    		};
    });


        //创建socket对象
       function initSocket() {
        	
        socket = new WebSocket("ws://"+ window.location.host+"${pageContext.request.contextPath}/game?fuid=${current_user.fcount}");
        socket.onopen = function() {
            console.log("连接成功");

         };
        socket.onmessage = function(message) {
        	var data=JSON.parse(message["data"]);
        	var t=data["sendtime"];
        	var time=(t["year"]+1900)+"-"+(t["month"]+1)+"-"+t["date"]+" "+t["hours"]+":"+t["minutes"]+":"+t["seconds"];
        	
        	$('#jp').append('<div class="talk_recordboxme"><div class="user"><img src=""/>'+data["fuid"]+'</div><div class="talk_recordtext"><h3>'+data["msg"]+'</h3><span class="talk_time">'+time+'</span></div></div>')
            console.log(data);
            
         };
         socket.onerror = function() {

             console.log("error");

         };
      // 断线重连
         socket.onclose = function () {
         // 重试10次，每次之间间隔10秒
         if (tryTime < 10) {
         setTimeout(function () {
         webSocket = null;
        tryTime++;
        initSocket();
         }, 500);
         } else {
         tryTime = 0;
        }
        };
        }
        //连接创建后调用

        //关闭连接的时候调用

       /*  socket.onclose = function(){

            alert("close");

        }; */

        //出错时调用
        $("#sendButton").click(function() {
        	var tf=document.getElementById("tf").value;
        
        	var date=new Date();
        	var s=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
          var test=$('#shuru').val();
          $('#shuru').val("");
          $('#jp').append('<div class="talk_recordboxme"><div class="user"><img src=""/>我 </div><div class="talk_recordtext"><h3>'+test+'</h3><span class="talk_time">'+s+'</span></div></div>')
            var msg={"fuid":'${current_user.fcount}',"tfuid":tf,"msg":test,"sendtime":s};
            socket.send(JSON.stringify(msg));

        });


  
        $(document).ready(function() {
     
			$('[data-toggle=offcanvas]').click(function() {
				$(this).toggleClass('visible-xs text-center');
				$(this).find('i').toggleClass('glyphicon-chevron-right glyphicon-chevron-left');
				$('.row-offcanvas').toggleClass('active');
				$('#lg-menu').toggleClass('hidden-xs').toggleClass('visible-xs');
				$('#xs-menu').toggleClass('visible-xs').toggleClass('hidden-xs');
				$('#btnShow').toggle();
			});
			  $(".comeon").mouseover(function(){
			        $(this).next().next().css("display",""); });});
        function commenthide(e){
            var parent=e.parentNode.parentNode.parentNode;
            parent.style="display:none";
                }
    

      </script>  
</body></html>