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
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js"></script>
   <style>
    .zuobian{
    margin-top: -11px;
    margin-left: 40px;
    color: darkgray;
    }
    input[type=file]{
 padding : 0px ! important;
 }
    
 
			input,
			textarea {
			     padding : 9px;
				border: solid 1px #E5E5E5;
				outline: 0;
				font: normal 13px/100% Verdana, Tahoma, sans-serif;
				width: 200px;
				background: #FFFFFF url('bg_form.png') left top repeat-x;
				background: -webkit-gradient(linear, left top, left 25, from(#FFFFFF), color-stop(4%, #EEEEEE), to(#FFFFFF));
				background: -moz-linear-gradient(top, #FFFFFF, #EEEEEE 1px, #FFFFFF 25px);
				box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
				-moz-box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
				-webkit-box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
			}
			
			textarea {
				width: 400px;
				max-width: 400px;
				height: 150px;
				line-height: 150%;
			}
			
			input:hover,
			textarea:hover,
			input:focus,
			textarea:focus {
				border-color: #C9C9C9;
				-webkit-box-shadow: rgba(0, 0, 0, 0.15) 0px 0px 8px;
			}
			
			.form {
				margin-bottom: 1em;
				
			}
			
			.form label {
				margin-left: 10px;
				color: #999999;
			}
			
			.form input[type="button"] {
				margin-left: 4px;
			}

			.submit input {
				width: auto;
				padding: 9px 15px;
				background: #617798;
				border: 0;
				font-size: 14px;
				color: #FFFFFF;
				-moz-border-radius: 5px;
				-webkit-border-radius: 5px;
			}
			
			.haha {
				width: auto;
				font-size: 14px;
				background: #617798;
				border: 0;
				color: #FFFFFF;
				-moz-border-radius: 5px;
				-webkit-border-radius: 5px;
			}
			/* .squaredFour */
			
			.squaredFour {
				width: 20px;
				position: relative;
				margin: 20px auto;
				margin-top: 30px;
			}
			
			.squaredFour label {
				width: 20px;
				height: 20px;
				cursor: pointer;
				position: absolute;
				top: 0;
				left: 0;
				background: #fcfff4;
				background: -moz-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
				background: -webkit-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
				background: linear-gradient(to bottom, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
				-moz-border-radius: 4px;
				-webkit-border-radius: 4px;
				border-radius: 4px;
				-moz-box-shadow: inset 0px 1px 1px white, 0px 1px 3px rgba(0, 0, 0, 0.5);
				-webkit-box-shadow: inset 0px 1px 1px white, 0px 1px 3px rgba(0, 0, 0, 0.5);
				box-shadow: inset 0px 1px 1px white, 0px 1px 3px rgba(0, 0, 0, 0.5);
			}
			
			.che {
				margin-left: 50px;
				width: 100px;
				height: 100px;
				background: #617798;
				display: inline-block;
				position: relative;
				text-align: center;
				margin-top: 5px;
				border: 1px solid gray;
				-moz-border-radius: 5px;
				-webkit-border-radius: 5px;
				border-radius: 5px;
				-moz-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;
				-webkit-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;
				box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;
			}
			
			.squaredFour label:after {
				content: '';
				width: 9px;
				height: 5px;
				position: absolute;
				top: 8px;
				left: 5px;
				border: 3px solid #333;
				border-top: none;
				border-right: none;
				background: transparent;
				filter: progid: DXImageTransform.Microsoft.Alpha(Opacity=0);
				opacity: 0;
				-moz-transform: rotate(-45deg);
				-ms-transform: rotate(-45deg);
				-webkit-transform: rotate(-45deg);
				transform: rotate(-45deg);
			}
			
			.squaredFour label:hover::after {
				filter: progid: DXImageTransform.Microsoft.Alpha(Opacity=50);
				opacity: 0.5;
			}
			
			.squaredFour input[type=checkbox] {
				visibility: hidden;
			}
			
			.squaredFour input[type=checkbox]:checked+ label:after {
				filter: progid: DXImageTransform.Microsoft.Alpha(enabled=false);
				opacity: 1;
			}
			/* end .squaredFour */
			/*
 * Copyright (c) 2012-2013 Thibaut Courouble
 * http://www.webinterfacelab.com
 *
 * Licensed under the MIT License:
 * http://www.opensource.org/licenses/mit-license.php
 */
			
			.switch {
				position: relative;
				margin-left: 80px;
				height: 26px;
				width: 120px;
				background: rgba(0, 0, 0, 0.25);
				border-radius: 3px;
				-webkit-box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.3), 0 1px rgba(255, 255, 255, 0.1);
				box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.3), 0 1px rgba(255, 255, 255, 0.1);
			}
			
			section {
				margin: 0;
				padding: 0;
				border: 0;
				font-size: 100%;
				font: inherit;
				vertical-align: baseline;
			}
			
			section:after {
				content: attr(title);
				position: absolute;
				width: 100%;
				left: 0;
				bottom: 3px;
				color: #fff;
				font-size: 12px;
				font-weight: 400;
				-webkit-font-smoothing: antialiased;
				text-shadow: 0px 1px black;
			}
			
			.switch-label {
				position: relative;
				z-index: 2;
				float: left;
				width: 58px;
				line-height: 26px;
				font-size: 11px;
				color: rgba(255, 255, 255, 0.35);
				text-align: center;
				text-shadow: 0 1px 1px rgba(0, 0, 0, 0.45);
				cursor: pointer;
			}
			
			.switch-label:active {
				font-weight: bold;
			}
			
			.switch-label-off {
				padding-left: 2px;
			}
			
			.switch-label-on {
				padding-right: 2px;
			}
			/*
 * Note: using adjacent or general sibling selectors combined with
 *       pseudo classes doesn't work in Safari 5.0 and Chrome 12.
 *       See this article for more info and a potential fix:
 *       http://css-tricks.com/webkit-sibling-bug/
 */
			
			.switch-input {
				display: none;
			}
			
			.switch-input:checked+ .switch-label {
				font-weight: bold;
				color: rgba(0, 0, 0, 0.65);
				text-shadow: 0 1px rgba(255, 255, 255, 0.25);
				-webkit-transition: 0.15s ease-out;
				-moz-transition: 0.15s ease-out;
				-o-transition: 0.15s ease-out;
				transition: 0.15s ease-out;
			}
			
			.switch-input:checked+ .switch-label-on~ .switch-selection {
				left: 60px;
				/* Note: left: 50% doesn't transition in WebKit */
			}
			
			.switch-selection {
				display: block;
				position: absolute;
				z-index: 1;
				top: 2px;
				left: 2px;
				width: 58px;
				height: 22px;
				background: #65bd63;
				border-radius: 3px;
				background-image: -webkit-linear-gradient(top, #9dd993, #65bd63);
				background-image: -moz-linear-gradient(top, #9dd993, #65bd63);
				background-image: -o-linear-gradient(top, #9dd993, #65bd63);
				background-image: linear-gradient(to bottom, #9dd993, #65bd63);
				-webkit-box-shadow: inset 0 1px rgba(255, 255, 255, 0.5), 0 0 2px rgba(0, 0, 0, 0.2);
				box-shadow: inset 0 1px rgba(255, 255, 255, 0.5), 0 0 2px rgba(0, 0, 0, 0.2);
				-webkit-transition: left 0.15s ease-out;
				-moz-transition: left 0.15s ease-out;
				-o-transition: left 0.15s ease-out;
				transition: left 0.15s ease-out;
			}
			
			.switch-blue .switch-selection {
				background: #617798;
				background-image: -webkit-linear-gradient(top, #617798, #3aa2d0);
				background-image: -moz-linear-gradient(top, #617798, #3aa2d0);
				background-image: -o-linear-gradient(top, #617798, #3aa2d0);
				background-image: linear-gradient(to bottom, #617798, #617790);
			}
			
			.switch-yellow .switch-selection {
				background: #c4bb61;
				background-image: -webkit-linear-gradient(top, #e0dd94, #c4bb61);
				background-image: -moz-linear-gradient(top, #e0dd94, #c4bb61);
				background-image: -o-linear-gradient(top, #e0dd94, #c4bb61);
				background-image: linear-gradient(to bottom, #e0dd94, #c4bb61);
			}
	
       body{font-size:14px;font-family:"微软雅黑";background:url("http://localhost:8080/img/face/2.jpg")top no-repeat;background-attachment:fixed;z-index:0;background-size:100%;}
       a{      
       color: black;
         }
    
/*内容发布区域*/

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
                             <a href="http://localhost:8080/fasebooke/user/${current_user.fuid}.action">  <c:choose>
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
  <li>
  <a href="http://localhost:8080/fasebooke/user/${current_user.fuid}.action">时间线</a></li><li  class="active"><a href="http://localhost:8080/fasebooke/jian/${current_user.fuid}/firstin.action">简介</a></li><li><a href="http://localhost:8080/fasebooke/friend/${current_user.fuid}/myfreind.action">好友</a></li><li><a href="http://localhost:8080/fasebooke/picture/${current_user.fuid}/fuck.action">照片</a></li> 
   <li><a href="http://localhost:8080/fasebooke/user/${current_user.fuid}/checkin.action">签到</a></li>
   </ul>
  </div>
  </div>


<!--   container-->
<div class="container">
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="glyphicon glyphicon-user" style="font-size:30px"></i><span style="font-size:30px;color:gray">简介</span>
					</div>
					<div class="panel-body">
						<div class="col-md-6" style="height:400px">
							<ul class="nav nav-pills nav-stacked">
								<li>
									<a href="http://localhost:8080/fasebooke/jian/${current_user.fuid}/firstin.action">概览</a>
								</li>
								<li>
									<a href="http://localhost:8080/fasebooke/jian/${current_user.fuid}/education.action">工作与学习</a>
								</li>
								<li>
									<a href="http://localhost:8080/fasebooke/jian/${current_user.fuid}/liveing.action">你生活过的地方</a>
								</li>
								<li class="active">
									<a href="http://localhost:8080/fasebooke/jian/${current_user.fuid}/contactinfo.action">联系方式和基本信息</a>
								</li>
								
								<li>
									<a href="http://localhost:8080/fasebooke/jian/${current_user.fuid}/biomore.action">你的详细资料</a>
								</li>

							</ul>
						</div>
						<div class="col-md-6">
							<ul class="list-group" id="uldy">
								<h4 style="color:#90949c;">联系方式</h4>
								<li class="list-group-item">
									<a href="javascript:;" data="tel"><i class="glyphicon glyphicon-plus"></i>添加新手机号</a>
								</li>
								<h4 style="color:#90949c;">网站和社交链接</h4>
								<li class="list-group-item">
									<a href="javascript:;" data="link"><i class="glyphicon glyphicon-plus" ></i>添加网站</a>
								</li>
								<li class="list-group-item">
									<a href="javascript:;" data="social"><i class="glyphicon glyphicon-plus"></i>添加社交链接</a>
								</li>
						
								<h4 style="color:#90949c;">基本信息</h4>
								<li class="list-group-item">
									<a href="javascript:;" data="born"><i class="glyphicon glyphicon-plus"></i>添加出生年月</a>
								</li>
								<li class="list-group-item">
									<a href="javascript:;" data="sex"><i class="glyphicon glyphicon-plus"></i>添加性别</a>
								</li>
							
								<li class="list-group-item">
									<a href="javascript:;" data="pre"><i class="glyphicon glyphicon-plus"></i>添加性别取向</a>
								</li>
							
								<li class="list-group-item">
									<a href="javascript:;" data="blod"><i class="glyphicon glyphicon-plus"></i>添加血型</a>
			
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
<!-- neirong -->
 </div>
 </div>

		
		
		
		
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jianjie.js"></script>
       <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/localsearch.js"></script>
        <script type="text/javascript">
        function dimiss(){
            console.log("dddddddd");
          $('.parentFileBox').remove();
        }
 
$(document).ready(function() {
	 setCookie("fuid",'${current_user.fuid}');
 	setCookie("ftel",'${current_user.ftel}');
 	setCookie("fhttp",'${current_user.fhttp}');
 	setCookie("fsociallink",'${current_user.fsociallink}');
 	setCookie("fblodtype",'${current_user.fblodtype}');
 	setCookie("fsexlike",'${current_user.fsexlike}');
 	setCookie("fsex",'${current_user.fsex}');
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