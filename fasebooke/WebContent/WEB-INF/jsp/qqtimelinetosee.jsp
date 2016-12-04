<%@ page language="java" import="java.util.*,net.sf.json.*,com.fase.po.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import="org.springframework.web.util.UrlPathHelper" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
        <meta charset="utf-8">
   
      
       <base href="<%=basePath%>">
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"> 
        <meta charset="utf-8">
        <title>fasebooke</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
   <link href="<%=request.getContextPath()%>/resources/css/facebook.css" rel="stylesheet" type="text/css"/>
         <link href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/facebook_128px_1160395_easyicon.net.ico"/>
      <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script> 
       <link href="<%=request.getContextPath()%>/resources/css/share.min.css" rel="stylesheet" type="text/css"/>
             <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/social-share.min.js" id="wei"></script> 
         <script  type="text/javascript" src="<%=request.getContextPath()%>/resources/js/ajaxfileupload.js"></script>
           <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js"></script>
<script language="javascript" type="text/javascript" src="http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js
"></script>
 <script language="javascript" type="text/javascript">
 window.onload=function(){
	 window.p=remote_ip_info.province+remote_ip_info.city;
 }
 var cuserid='${visit.fuid}';
 localStorage.setItem("visit_id",cuserid); 
 
 </script>
   <style>
   
   .mask {       
            position: absolute; top: 58px; filter: alpha(opacity=60); background-color: #777;     
            z-index: 1002; left: 0px;     
            opacity:0.5; -moz-opacity:0.5;     
} 

   .zuobian{
    margin-top: -11px;
    margin-left: 40px;
    color: darkgray;
    }
       body{font-size:14px;font-family:"微软雅黑";height:100%;background:url("http://localhost:8080/img/face/2.jpg")top no-repeat;background-attachment:fixed;z-index:0;background-size:100%;}
       a{      color: black;
         }
.box2{width:960px;height:auto; margin:5px auto;position:relative;z-index:1;}
/*内容发布区域*/
.box2 .boxcenter{width:555px;height:auto;background:#fff;position:absolute;top:80px;left:180px;border:1px solid #ebccd1;border-radius:6px;}
.box2 .boxcenter .boxc_t{height:30px;line-height:30px;}
.box2 .boxcenter .boxc_t h4{padding-left:20px;background:#3BBFB4;border-top-left-radius:6px;
		border-top-right-radius:6px;}
.box2 .boxcenter .boxc_c{width:460px;height:100px;border:1px solid #A6C8FF;margin:8px auto;text-indent:10px;box-shadow:0 0 4px #A6C8FF;background-color: white}
.box2 .boxcenter .boxc_b{width:80px;height:30px;position:absolute;right:10px;bottom:8px;}
.box2 .boxcenter .boxc_b a{font-size:14px;color:#fff;line-height:30px;background:#3bbfb4;border-radius:6px;
		display:block;text-align:center;text-decoration:none;}
.box2 .boxcenter .boxc_b a:hover{background:#2C8E86;}
.timeline{width:76px;height:auto; position:relative;left:160px;border-right:3px solid #428bca;}/**/
.timeline .timeline_t{width:62px;height:62px;border-radius:50%;border:1px solid #3b5999;background:url("http://localhost:8080/img/face/100.png")no-repeat;background-size:100%;text-align:center;font-size:20px;color:white}
.timeline .nextbox{width:380px;height:80px;position:absolute;top:509px;left:76px;}
.a{width:380px;height:80px;background:#e7e7e7;border-radius:6px;margin-top:100px;top:300px;font-size:16px;line-height:20px;text-indent:20px;word-break:break-all;position:relative;left:94px;}
.b{width:80px;min-height:80px;height: auto; border-radius:50%;border:2px solid #fff;background:#9DCFE1;position:relative;top:25px;margin-left:-137px;}
#time{font-size:20px;color:#ababab;}
#hour{font-size:12px;color:#92CADE;}


</style>
    </head><body>
<!--head-->
   <div class="wrapper">
			<div style="width:100%">
	<div class="navbar navbar-blue navbar-static-top">  
							<div class="navbar-header">
							  <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							  </button>
							  <a href="javascript:;" class="navbar-brand logo">f</a>
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
                             <a href="http://localhost:8080/fasebooke/user/${current_user.fuid}.action">  <c:choose>
                             <c:when test="${!empty current_user.fheadimage}">
                             <img src="http://localhost:8080/img/${current_user.fuid}/${current_user.fheadimage}" style="border: 1px solid rgba(0, 0, 0, .1);width:24px;height:24px">
                            </c:when>
                            <c:otherwise>
                             <img src="http://localhost:8080/img/face/head_male_man_user_64px_1578_easyicon.net.png" style="border: 1px solid rgba(0, 0, 0, .1);width:24px;height:24px">
                            </c:otherwise>
                            </c:choose><span>${current_user.fname}</span>
                             </a>
                          </li>
							  <li>
								<a href="http://localhost:8080/fasebooke/user/show.action?fuid=${current_user.fuid}">
								<i class="glyphicon glyphicon-home"></i> 首页</a>
							  </li>
							
							  <li>
							    
								<a href="javascript:;" title="消息" onclick="opennotice(this)" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="fa fa-comments"></span></a>
								<ul class="dropdown-menu" role="menu"> </ul>
							  </li>
							  <li>
							  <li>
							<a  href="javascript:;" onclick="openbroadcast(this)" title="通知" > <span class="glyphicon glyphicon-globe"></span></a>
                          <ul class="dropdown-menu" role="menu"> </ul> 
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
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-sort-desc"></i></a>
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
  
  
<!--  headnext-->
 
 <div class="imagrap" id="imagewrap">
    
  <script>
 var bk='${visit.fbackimage}';
 if(bk!=''){
	 $('#imagewrap').removeClass("imagrap").addClass("imagrap2");
 $('#imagewrap').css("background",'url("'+bk+'") no-repeat 0px 55px');
 $('#imagewrap').css("background-size","cover");
 }
 
 </script>
    <a href="javascript:;" class="_30x-">
          
     <div  class="_30x">
      <span class="fa  fa-camera" style="color:white"></span>
         <span>添加封面照片</span>
           <input type="file" id="imagefile2" style="position:relative;opacity:0;position:relative;opacity:0;margin-top:-20px" onchange="backimage(this)"title="选择图片" name="sendimage" accept="image/*" >
     </div>
     </a>

      <c:choose>
                             <c:when test="${!empty visit.fheadimage}">
                             <img class="pic" src="http://localhost:8080/img/${visit.fuid}/${visit.fheadimage}">
                            </c:when>
                            <c:otherwise>
                             <img class="pic" src="http://localhost:8080/img/face/head_male_man_user_64px_1578_easyicon.net.png" >
                            </c:otherwise>
                            </c:choose>
     <span style="color:white;font-size:30px;">${visit.fname}</span>
 </div>
  <div class="container" style="margin-left:20%;min-height:41px">
  <div id="mask" class="mask"></div> 
  <div class="col-md-12">

  <ul class="lead nav nav-pills">
  <li class="active">
  <a href="http://localhost:8080/fasebooke/user/${visit.fuid}/${current_user.fuid}.action">时间线</a></li><li><a href="http://localhost:8080/fasebooke/jian/${visit.fuid}/${current_user.fuid}/firstin.action">简介</a></li><li><a href="http://localhost:8080/fasebooke/comment/${visit.fuid}/${current_user.fuid}/toseenote.action">留言</a></li><li><a href="http://localhost:8080/fasebooke/picture/${visit.fuid}/${current_user.fuid}/fuck.action">照片</a></li>

  </ul>
  </div>
  </div>


<!--right-->

	<div class="timeline">
	
 <div class="box2"> 
 <div class="row" style="background-color:rgba(0,0,0,0.075);"> 
  <div class="timeline_t" >	
 <a href="#postModal" role="button" data-toggle="modal"> 留言</a>		
		</div>
  <div class="col-sm-7" style="margin-left:200px" id="main2"> 
		 <div class="well" style="margin-bottom:20px;width:600px"> 
  
  <form class="form-horizontal" role="form"  method="post" action="/fasebooke/fdynamiccontrol/timeline.action" onsubmit="return comf()" id="zz">
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
			<textarea class="form-control" placeholder="分享新鲜事" name="sendwords" id="sendwords" rows=6">
											      
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
<!--时光轴线-->
      
	
                  <c:forEach items="${timeline}"  var="obj" varStatus="vs">
										     <div class="b"></div>
										  <div class="panel panel-default " style="width:600px">
										
										 <div class="panel-heading">
										 <div class="_commentimg">
										    <img src="${obj.imagehead}" style="height:50px;width:50px;border:1px solid #eee">
										 </div>
                                          <div class="_commentnav">
										   <h5>${obj.fname}</h5> 
										     <span>	<fmt:formatDate pattern="yyyy-MM-dd" value="${obj.sendtime}" /></span>
										   
										 </div> </div>
										  <div class="panel-body" id="panel${obj.did}">
		                                 
		                                     <script>  
		                             var sendwords="${obj.sendwords}";
		                             var sendimage="${obj.sendimage}";
		                             var dataid="panel${obj.did}";
		                           jiexi(sendwords,dataid,sendimage);
		                                     </script>
											<div class="clearfix"></div>
																					                        <div class="social-share" data-initialized="true" data-description="${emp.sendwords}" data-image ="${emp.imagehead}" data-title="${emp.sendwords}">
    <a href="#" class="social-share-icon icon-weibo"></a>
    <a href="#" class="social-share-icon icon-qq"></a>
    <a href="#" class="social-share-icon icon-tencent"></a>
</div> 
										<hr>
											<div style="display:inline-flex">
											
		<a href="javascript:;" style="font-size:26px;" class="comeon" ><span class="glyphicon glyphicon-thumbs-up" style="font-size:26px;padding-left:10px;padding-right:30px"></span>赞</a>
                                            
                                           
								            <a href="javascript:;" onclick="commentshow(this)" data="" style="font-size:26px;"><span class="glyphicon glyphicon-comment" style="font-size:26px;padding-left:10px;padding-right:30px"></span>评论</a>
	
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
                                            <c:forEach var="zan" items="${obj.dianzan}" varStatus="state" >
                                            
                                               <c:if test="${state.count<4}">
                                               <% out.print("<img src='http://localhost:8080/img/face/");%>${zan.emotion}<% out.print("'>"); %>
                                               </c:if>
                                               </c:forEach>
                                               <span style="display: block">共${obj.dinazansize}人赞了你</span>
                                             
                                              </div>
                                              </div>
			<!-- 	                                                                    回复                                                                   		 -->			
											   <div style="display:none">
								              <div class="panel panel-default" >
								                  <div class="panel-body" >
								             <div class="clearfix"></div>
	                                         <c:if test="${!empty obj.tcomment}">
	                                   
	                                      <c:forEach var="comment" items="${obj.tcomment}">
	                              
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
								      <% out.print("<div class='overcom' id='pinlun");%>${reply.id}<%out.print("'><img src='");%>${reply.customer.fheadimage}<%out.print("'data='");%>${reply.customer.fuid}<%out.print("' style='border: 1px solidrgba(0,0,0,.1);width:24px;height:24px'>"); %>${reply.customer.fname}:
								              
                                                     
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
								               <a href="javascript:;" onclick="commenthide(this)" data="${obj.did}"><i class="glyphicon glyphicon-chevron-up"></i></a>     
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
              <a  href="javascript:;" class="btn btn-default" style="display:inline;float:right;position: relative;margin-top:-34px;" onclick="realsend(this)" data-id="${obj.did }"><i class="glyphicon glyphicon-share"></i></a>
              </div>
											</div>
											
										  </div>
										  </div>
	  </c:forEach>   
          
          
           
     
		
            
          
           
         
            
      

</div><!-- box -->
</div>
</div>
</div>
</div>
<div id="postModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true" >
		  <div class="modal-dialog">
		
		  <div class="modal-content">
			  <div class="modal-body">
	           <textarea rows="10" cols="76" style="margin-left:10px" id="leavenote"></textarea>
			  <div class="modal-footer">
				  <div>
				  <button class="btn btn-primary btn-sm" data-dismiss="modal" aria-hidden="true" data='${visit.fuid}' onclick="leaveM(this)">留言</button>
				  </div>	
			  </div>
		  </div>
		  </div>
		</div>
      </div>
<!--row-->
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/localsearch.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/scroll3.js"></script>
<script>
function commenthide(e){
    var parent=e.parentNode.parentNode.parentNode;
    parent.style="display:none";
        }
function commentshow(e){
  var parent=e.parentNode.nextElementSibling.nextElementSibling.nextElementSibling;
 
/*      var ta=parent.firstElementChild; */
console.log(parent);
/*    ta.style="display:block"; */
$(parent).css('display','block'); 
//  var show=ta.firstElementChild.firstElementChild;
//  var div=document.createElement('div');
//  div.innerHTML="hhhhh";
//  show.appendChild(div);

}
var v='${visit.fuid}';
var my='${current_user.fuid}';
console.log(v+"我们"+my);

$(document).ready(function() {
	if(v==my){
		 console.log(v==my);
		 $("#mask").css("height",$(document).height());     
		    $("#mask").css("width",$(document).width());     
		    $("#mask").show();  
	}
	$('[data-toggle=offcanvas]').click(function() {
		$(this).toggleClass('visible-xs text-center');
		$(this).find('i').toggleClass('glyphicon-chevron-right glyphicon-chevron-left');
		$('.row-offcanvas').toggleClass('active');
		$('#lg-menu').toggleClass('hidden-xs').toggleClass('visible-xs');
		$('#xs-menu').toggleClass('visible-xs').toggleClass('hidden-xs');
		$('#btnShow').toggle();
	});
	  $(".comeon").mouseover(function(){
	        $(this).next().next().css("display","");
	    });
	  $('.collapse.in').prev('.panel-heading').addClass('active');
	  $('#accordion, #bs-collapse')
		.on('show.bs.collapse', function(a) {
		  $(a.target).prev('.panel-heading').addClass('active');
		})
		.on('hide.bs.collapse', function(a) {
		  $(a.target).prev('.panel-heading').removeClass('active');
		});
    
	}); 

	
      
	


    </script>
</body>
</html>