<%@ page language="java" import="java.util.*,net.sf.json.*,com.fase.po.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import="org.springframework.web.util.UrlPathHelper" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
      
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
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/styles.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/diyUpload/css/webuploader.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/diyUpload/css/diyUpload.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/diyUpload/js/webuploader.html5only.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/diyUpload/js/diyUpload.js"></script>
           <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js"></script>
           <script type="text/javascript">
           window.email=new Array();
           window.yeshu=1;
        
           window.userarray=new Array();
           </script>
   <style>
   #chat-messages{
	opacity:0;
	margin-top:30px;
	width:290px;
	height:320px;
	overflow-y:scroll;	
	overflow-x:hidden;
	padding-right: 20px;
 	-webkit-transition: all 200ms cubic-bezier(0.000, 0.995, 0.990, 1.000);
	   -moz-transition: all 200ms cubic-bezier(0.000, 0.995, 0.990, 1.000);
	    -ms-transition: all 200ms cubic-bezier(0.000, 0.995, 0.990, 1.000);
	     -o-transition: all 200ms cubic-bezier(0.000, 0.995, 0.990, 1.000);
	        transition: all 200ms cubic-bezier(0.000, 0.995, 0.990, 1.000); 
}
#chat-messages.animate{
	opacity:1;
	margin-top:0;
}
#chat-messages label{
	color:#aab8c2;
	font-weight:600;
	font-size:12px;
	text-align:center;
	margin:15px 0;
	width:290px;
	display:block;	
}
#chat-messages div.message{
	padding:0 0 30px 58px;
	clear:both;
	margin-bottom:45px;
}
#chat-messages div.message.right{
	  padding: 0 58px 30px 0;
	  margin-right: -19px;
	  margin-left: 19px;
}
#chat-messages .message img{
	  float: left;
	  margin-left: -38px;
	  border-radius: 50%;
	  width: 30px;
	  margin-top: 12px;
}
#chat-messages div.message.right img{
	float: right;	
    margin-left: 0;
	margin-right: -38px;	
}
.message .bubble{	
	background:#f0f4f7;
	font-size:13px;
	font-weight:600;
	padding:12px 13px;
	border-radius:5px 5px 5px 0px;
	color:#8495a3;
	position:relative;
	float:left;
}
  .floatingImg{
	width:40px;
	border-radius:50%;
	position:absolute;
	top:0;
	left:12px;
	border:3px solid #fff;
} 
#chatview{
	width:290px;
	height:484px;
	position:absolute;
	top:0;
	left:5px;	
	display:none;
	background:#fff;
}
#profile{
	height:153px;
	overflow:hidden;
	text-align:center;
	color:#fff;
}
.p1 #profile{
	background:#fff url("http://localhost:8080/img/face/timeline1.png") 0 0 no-repeat;
}
#profile .avatar{
	width:68px;
	border:3px solid #fff;
	margin:23px 0 0;
	border-radius:50%;
}
#profile  p{
	font-weight:600;
	font-size:15px;
	margin:118px 0 -1px;
	opacity:0;
	-webkit-transition: all 200ms cubic-bezier(0.000, 0.995, 0.990, 1.000);
	   -moz-transition: all 200ms cubic-bezier(0.000, 0.995, 0.990, 1.000);
	    -ms-transition: all 200ms cubic-bezier(0.000, 0.995, 0.990, 1.000);
	     -o-transition: all 200ms cubic-bezier(0.000, 0.995, 0.990, 1.000);
	        transition: all 200ms cubic-bezier(0.000, 0.995, 0.990, 1.000);	
}
#profile  p.animate{
	margin-top:97px;
	opacity:1;
	-webkit-transition: all 200ms cubic-bezier(0.000, 0.995, 0.990, 1.000);
	   -moz-transition: all 200ms cubic-bezier(0.000, 0.995, 0.990, 1.000);
	    -ms-transition: all 200ms cubic-bezier(0.000, 0.995, 0.990, 1.000);
	     -o-transition: all 200ms cubic-bezier(0.000, 0.995, 0.990, 1.000);
	        transition: all 200ms cubic-bezier(0.000, 0.995, 0.990, 1.000);	
}
#profile  span{
	font-weight:400;
	font-size:11px;
}
#close {
    position: absolute;
    top: 8px;
    opacity: 0.8;
    right: 10px;
    width: 20px;
    height: 20px;
    cursor: pointer;
}
#close:hover{
	opacity:1;
}
.cx,.cy{
	background:#fff;
	position:absolute;
	width:0px;
	top:15px;
	right:15px;
	height:3px;
	-webkit-transition: all 250ms ease-in-out;
	   -moz-transition: all 250ms ease-in-out;
		-ms-transition: all 250ms ease-in-out;
		 -o-transition: all 250ms ease-in-out;
			transition: all 250ms ease-in-out;
}
.cx.s1, .cy.s1{	
	right:0;	
	width:20px;	
	-webkit-transition: all 100ms ease-out;
	   -moz-transition: all 100ms ease-out;
		-ms-transition: all 100ms ease-out;
		 -o-transition: all 100ms ease-out;
			transition: all 100ms ease-out;
}
.cy.s2{	
	-ms-transform: rotate(50deg); 
	-webkit-transform: rotate(50deg); 
	transform: rotate(50deg);		 
	-webkit-transition: all 100ms ease-out;
	   -moz-transition: all 100ms ease-out;
		-ms-transition: all 100ms ease-out;
		 -o-transition: all 100ms ease-out;
			transition: all 100ms ease-out;
}
.cy.s3{	
	-ms-transform: rotate(45deg); 
	-webkit-transform: rotate(45deg); 
	transform: rotate(45deg);		 
	-webkit-transition: all 100ms ease-out;
	   -moz-transition: all 100ms ease-out;
		-ms-transition: all 100ms ease-out;
		 -o-transition: all 100ms ease-out;
			transition: all 100ms ease-out;
}
.cx.s1{	
	right:0;	
	width:20px;	
	-webkit-transition: all 100ms ease-out;
	   -moz-transition: all 100ms ease-out;
		-ms-transition: all 100ms ease-out;
		 -o-transition: all 100ms ease-out;
			transition: all 100ms ease-out;
}
.cx.s2{	
	-ms-transform: rotate(140deg); 
	-webkit-transform: rotate(140deg); 
	transform: rotate(140deg);		 
	-webkit-transition: all 100ms ease-out;
	   -moz-transition: all 100ms ease-out;
		-ms-transition: all 100ease-out;
		 -o-transition: all 100ms ease-out;
			transition: all 100ms ease-out;
}
.cx.s3{	
	-ms-transform: rotate(135deg); 
	-webkit-transform: rotate(135deg); 
	transform: rotate(135deg);		 
	-webkit-transition: all 100ease-out;
	   -moz-transition: all 100ms ease-out;
		-ms-transition: all 100ms ease-out;
		 -o-transition: all 100ms ease-out;
			transition: all 100ms ease-out;
}
    .wrap .panel-heading{
           background: #009688;
        color: #fff;
       }
      
.wrap {

  border-radius: 4px;
}
       #demo{ margin:50px auto; width:340px; min-height:200px; background:#CF9}
    .wrap .panel-heading{
    background: #009688;
        color: #fff;
       }
       body{font-size:14px;font-family:"微软雅黑";background:url("http://localhost:8080/img/face/2.jpg")top no-repeat;background-attachment:fixed;z-index:0;background-size:100%;}
       a{  color: black;
         }


</style>
    </head><body>
<!--head-->
   <div class="wrapper">
				<div style="width:100%" >
	<div class="navbar navbar-blue navbar-static-top" style="height:50px">  
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
                             <a href="http://localhost:8080/fasebooke/user/${current_user.fuid}.action">   <c:choose>
                             <c:when test="${!empty current_user.fheadimage}">
                             <img src="http://localhost:8080/img/${current_user.fuid}/${current_user.fheadimage}" style="border: 1px solid rgba(0, 0, 0, .1);width:24px;height:24px"><span>${current_user.fname}</span>
                            </c:when>
                            <c:otherwise>
                             <img src="http://localhost:8080/img/face/head_male_man_user_64px_1578_easyicon.net.png" style="border: 1px solid rgba(0, 0, 0, .1);width:24px;height:24px"><span>${current_user.fname}</span>
                            </c:otherwise>
                            </c:choose><span>${current_user.fname}</span>
                             </a>
                          </li>
							  <li>
								<a href="http://localhost:8080/fasebooke/user/show.action?fuid=${current_user.fuid }">
								<i class="glyphicon glyphicon-home"></i> 首页</a>
							  </li>
							  <li>
								<a href="#postModal" role="button" data-toggle="modal"><i class="glyphicon glyphicon-plus"></i> 好友请求</a>
							  </li>
							  <li>
							    
								<a href="javascript:;" title="消息" onclick="opennotice()" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="fa fa-comments"></span></a>
								<ul class="dropdown-menu" role="menu"> <li><a href="#">签到</a></li><li><a href="#">赞</a></li><li><a href="#">活动</a></li><li class="divider"></li><li><a href="#">更多。。</a></li></ul>
							  </li>
							  <li>
							  <li>
							<a  href="javascript:;" title="通知" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> <span class="glyphicon glyphicon-globe"></span></a>
                          <ul class="dropdown-menu" role="menu"> <li><a href="#">签到</a></li><li><a href="#">赞</a></li><li><a href="#">活动</a></li><li class="divider"></li><li><a href="#">更多。。</a></li></ul> 
							  </li>
				
							  </li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
                          <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="padding-bottom:0">
                            <div style="width:10px;height:30px;">
                            <img src="<%=request.getContextPath()%>/resources/img/secret.png">
                            </div></a>
                            <ul class="dropdown-menu" style="width:380px">
								  <li><a href="#" style="padding:0"><div style="background-color:#3b5998;">
								      <span class="glyphicon glyphicon-eye-close" style="padding-left:10px;padding-right:10px;color:white"></span>
								      <div style="display: inline-block;margin-left:10px">
								          <h5 style="color:white">隐私设置检查</h5>
								      </div>
								      <div style="display: inline-block;margin-left:145px">
								          <img src="<%=request.getContextPath()%>/resources/img/secretcheck.png" style="margin-top:-30px">
								      </div>
								  </div></a></li>
								  <li> <a href="#" style="padding:0"><span class="glyphicon glyphicon-globe" style="padding-left:10px;padding-right:10px">
								  <div style="display:inline-block">
								       <h5>谁能看我的资料？</h5>
								  </div>
								<div style="display: inline-block;margin-left:50%">
								 <span class="caret"></span>
								
								 </div>
								 </a>
								 </li>
								  <li><a href="#"style="padding:0"><span class="fa fa-group" style="padding-left:10px;padding-right:10px"></span>
								   <div style="display:inline-block">
								       <h5>谁能够联系我？</h5>
								  </div>
								   <div style="display:inline-block; margin-left:50%" >
								 <span class="caret"></span>
								 </div>
								  </a></li>
								  <li><a href="#"style="padding:0"><span class="glyphicon glyphicon-minus-sign" style="padding-left:10px;padding-right:10px"></span> <div style="display:inline-block">
								       <h5>如何阻止他人骚扰我？</h5>
								  </div>
								  <div style="display: inline-block;margin-left:43%">
								 <span class="caret"></span>
								
                                      </div></a>
								</ul>
                          </li>
                            
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

<!--  headnext-->
  
 <div class="imagrap" id="imagewrap">
  <script>
 var bk='${current_user.fbackimage}';
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
     <img class="pic" src="http://localhost:8080/img/${current_user.fuid}/${current_user.fheadimage}">
     <span style="color:white;font-size:30px;">${current_user.fname}</span>
 </div>
  <div class="container" style="margin-left:20%;min-height:41px">

  <div class="col-md-12">
<ul class="lead nav nav-pills">
  <li class="active">
  <a href="http://localhost:8080/fasebooke/user/${current_user.fuid}.action">时间线</a></li><li><a href="http://localhost:8080/fasebooke/jian/${current_user.fuid}/firstin.action">简介</a></li><li><a href="http://localhost:8080/fasebooke/friend/${current_user.fuid}/myfreind.action">好友</a></li><li><a href="http://localhost:8080/fasebooke/picture/${current_user.fuid}/fuck.action">照片</a></li> 
   <li><a href="http://localhost:8080/fasebooke/user/${current_user.fuid}/checkin.action">签到</a></li>
   </ul>
  </div>
  </div>


<!--   container-->

 <div class="container">
     <div class="row">
         <div class="panel panel-default">
             <div class="panel-heading">
                 <i class="glyphicon glyphicon-user" style="font-size:30px; color:gray"></i><span style="font-size:30px;color:gray">朋友</span>
                 <div class="btn-group" style="float:right">
              <a href="#" class="btn btn-default"><i class="glyphicon glyphicon-pencil"></i></a>
            </div>
             </div>
             <div class="panel-body">
              <div class="col-md-4 col-sm-6">
                  <div class="panel-group wrap" id="bs-collapse">
                      <div class="panel" style="width:280px">
                          <div class="panel-heading" id="topmenu">
                              <h4 class="panel-title">
			<a data-toggle="collapse" data-parent="#" href="#four">
			<span class="friends"></span>
			</a>
			
		  </h4>
                          </div>
                          <div id="four" class="panel-collapse collapse">
            <c:forEach items="${myfreind}" var="emp" varStatus="vs">
                  <c:forEach items="${emp.flist}" var="uf">
               
               <div class="friend" data="${uf.fuid }" onclick="seeMore(this)">
			     <SCRIPT TYPE="TEXT/JAVASCRIPT">
                 var  user={"fuid":'${uf.fuid}',"fname":'${uf.fname}',"fcount":'${uf.fcount}',"ftel":'${uf.ftel}',"femail":'${uf.femail}',"fliveplace":'${uf.fhome.lprovice}',"fplace":'${uf.fhome.lurl}',"fpersonal":'${uf.fpersonal}',"fbirthday":'${uf.fbirthday}'};
                  window.userarray.push(user);
                  </SCRIPT>
			  <p>
			  
			  	<c:choose>
			<c:when test="${!empty uf.fheadimage}">
		<img src="http://localhost:8080/img/${uf.fuid}/${uf.fheadimage}"  style="border: 1px solid rgba(0, 0, 0, .1);width:24px;height:24px" >
				</c:when>
					<c:otherwise>   
 			  <img src="http://localhost:8080/img/face/head_male_man_user_64px_1578_easyicon.net.png" style="border: 1px solid rgba(0, 0, 0, .1);width:24px;height:24px" data="${uf.fuid }" >
                </c:otherwise> 
				</c:choose>  

			  
			  
			  
			  <strong>${uf.fname }</strong><span>${uf.fcount}</span></p>
			
				
			<c:choose>
			<c:when test="${uf.fstate==1}">
				<div class="status available"></div>
				</c:when>
					<c:otherwise>   
  <div class="status inactive"></div> 
  </c:otherwise> 
			</c:choose>
			<c:forEach items="${heiming}" var="hei">
			<c:if test="${hei.bfuid==uf.fuid}">
			<a href="javascript:;" style="color:gray" data="${uf.fuid}" onclick="yichuhei(this)">移除黑名</a>
			</c:if>
			</c:forEach>
			  </div> 
                  </c:forEach>
			
                  </c:forEach> 
                       
                                                             <div id="search">
    <input type="text" id="searchfield">
</div>
                     </div>
       <!--               资料 -->
   <div  id="chatview" class="p1" >
   <div id="profile" >
   <div id="close">
    <div class="cy s1 s2 s3"></div>
   <div class="cx s1 s2 s3"></div> 
   </div>
<!--  
   <p class="animate">00000000</p>
   <span>8888888</span> -->
   </div>
   <div id="chat-messages" class="animate">
     <label>个人资料</label>
   <div class="message">
   <img src="http://localhost:8080/img/face/facebook.net.ico">
    <a href="" style="top:20px;position:relative;display:block"></a>
   </div>
   <div class="message">
   <img src="http://localhost:8080/img/face/phone_receiver_96px_1205960_easyicon.net.png">
   <div class="bubble">
  
   </div>
   </div>
   <div class="message">
   <img src="http://localhost:8080/img/face/Email_72.730223123732px_1195279_easyicon.net.png">
   <div class="bubble">
 
   </div>
   </div>
   <div class="message">
   <img src="http://localhost:8080/img/face/smiley_pencil_72px_1113041_easyicon.net.png">
   <div class="bubble">
    无
   </div>
   </div>
    <div class="message">
   <img src="http://localhost:8080/img/face/MSN_birthday_64px_546054_easyicon.net.png">
   <div class="bubble">
  
   </div>
   </div>
   <div class="message">
   <img src="http://localhost:8080/img/face/City_Story_48px_537166_easyicon.net.png">
   <div class="bubble">
                       无
   </div>
   </div>
   </div>
   <img src="" class="floatingImg" style="top: 20px; width: 68px; left: 108px;">
    </div>
      <!--               资料 -->
                      </div>
                  </div>
  
              </div>
   
              <div class="col-md-8">
                <div class="sim ">
                  <ul id="otherInfoTab">
                      <li class="active"><a href="#email" data-toggle="tab"><span class="chats "></span></a></li>
                      <li>  <a href="#email2" data-toggle="tab"><span class="history"></span></a></li>
                  </ul>
                   
                 
                </div>
                <div class="tab-content">
                 <div class="tab-pane fade in active" id="email">
                   <form role="form" class="form-horizontal">
                      <div class="form-group"> 
        
                       </div>
                      <div class="form-group"> 
        <label for="lastname" class="col-sm-2 control-label">标题：</label> 
        <div class="col-sm-10">
          <input type="text" class="form-control" id="biaoti">
         </div>
       </div>
                              <div class="form-group"> 
        <label for="lastname" class="col-sm-2 control-label">收件人：</label> 
        <div class="col-sm-10">
          <input type="text" class="form-control" id="recievename" placeholder="fasebooke用户账号">
         </div>
       </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">内容：</label> 
                <div class="col-sm-10">
                    <textarea class="form-control"  rows="8"  id="neirong">
                        
                    </textarea>
     
     
       </div>
           </div> 
           <div class="form-group">
           <button type="button" class="btn btn-primary" onclick="doemail()">  发 送</button>
            <div class="col-sm-10">
	<div id="as" style="margin-left:180px"> 
	</div>  
            </div>
                  </div>
                   </form>
                   </div>
                   <div class="tab-pane fade" id="email2">
                    <div class="_mytakenpicture" style="columns:1;position:relative;left:-150px" >
                   
                     
                       <ul class="list-group" style="min-width:600px">
                  <c:forEach items="${myemail}" var="em">
                  <script>
                  var obj={"eid":'${em.eid}',"fname":'${em.user.fname}',"sendtime":'${em.senttime}',"estate":"${em.estate}"};
                window.email.push(obj);
              
                  </script>
                 
              </c:forEach> 
             <script>
             ini();
             </script>
            </ul>
            
                  </div>
                    <div class="container">
        <div class="row">
          <div class="col-md-12">
            <ul class="pager">
              <li>
                <a href="javascript:;" id="shang" onclick="shangyiye()">←  上一页</a>
              </li>
              <li>
                <a href="javascript:;" id="xia" onclick="xiayiye()">下一页  →</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
                   </div>
                </div>
              </div>
             </div>
           
    </div>
  
</div>
         </div>
 
 
 <!-- endcontainer -->
 <!-- wraper -->
 </div>
</div>
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
         <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/localsearch.js"></script>
        <script type="text/javascript">
     
         
        /*
        * 服务器地址,成功返回,失败返回参数格式依照jquery.ajax习惯;
        * 其他参数同WebUploader
        */


        $('#as').diyUpload({
        	url:'http://localhost:8080/fasebooke/picture/dofile.action',
        	success:function( data ) {
        		$('#as').append('<input type="hidden" value="'+data["filepath"]+'">');
        		console.info( data );
        	},
        	error:function( err ) {
        		console.info( err );	
        	},
        	buttonText : '选择文件',
        	chunked:true,
        	// 分片大小
        	chunkSize:512 * 1024,
        	//最大上传的文件数量, 总文件大小,单个文件大小(单位字节);
        	fileNumLimit:50,
        	fileSizeLimit:500000 * 1024,
        	fileSingleSizeLimit:50000 * 1024,
        	accept: {}
        });
                    $(function() { 
            
                $('#otherInfoTab a:last').tab('show');//初始化显示哪个tab  
           
                $('#otherInfoTab a').click(function(e) {  
                    console.log("dddddddddd");
                    e.preventDefault();//阻止a链接的跳转行为  
                    $(this).tab('show');//显示当前选中的链接及关联的content  
                })  
            })  



 
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