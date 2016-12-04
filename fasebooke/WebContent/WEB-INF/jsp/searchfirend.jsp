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
        <link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
   <link href="<%=request.getContextPath()%>/resources/css/facebook.css" rel="stylesheet" type="text/css"/>
         <link href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/facebook_128px_1160395_easyicon.net.ico"/>
      <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script> 
         <script  type="text/javascript" src="<%=request.getContextPath()%>/resources/js/ajaxfileupload.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js"></script>    
      <script language="javascript" type="text/javascript" src="http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js
"></script>
 <script language="javascript" type="text/javascript">
 window.onload=function(){
	 window.p=remote_ip_info.province+remote_ip_info.city;
 }
 
 </script>
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
							  <a href="javascript:;" class="navbar-brand logo">f</a>
							</div>
							<nav class="collapse navbar-collapse" role="navigation">
							<form class="navbar-form navbar-left" method="post" action="/fasebooke/user/${current_user.fuid}/plusfd.action">
								<div class="input-group input-group-sm" style="max-width:360px;">
								  <input class="form-control" placeholder="搜好友" name="srch-term" id="srch-term" type="text">
								   <ul name="EngineModel" style="height: auto;width:305px; margin-left: 0; position: absolute; display: none;background:-webkit-gradient(linear, left top, left 25, from(#FFFFFF), color-stop(4%, #EEEEEE), to(#FFFFFF))"></ul>
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
							    
								<a href="javascript:;" title="消息" onclick="opennotice(this)" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="fa fa-comments"></span></a>
								<ul class="dropdown-menu" role="menu"> </ul>
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
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-sort-desc"></i></a>
								<ul class="dropdown-menu">
								
								   <li  role="separator" class="divider"></li>
								  <li><a href="/fasebooke/user/out/${current_user.fuid}.action">退出</a></li>
								 
								   <li  role="separator" class="divider"></li>
								  <li><a href="http://localhost:8080/fasebooke/help.jsp">帮助中心</a></li>
								</ul>
							  </li>
							</ul>
							</nav>
						</div>
						<!-- /top nav -->
					  
						<div class="padding">
							<div class="full col-sm-9">
							  
								<!-- content -->                      
								<div class="row" >
								  <div class="col-md-7" style="height:auto;border:0.5px solid #ccc;margin-right:20px;background:#fff">
								 <!-- main col left --> 
						
						
             <h4>可能认识的人</h4>
             <ul>
             <c:forEach var="fd" items="${pr}">
                 <li>
                     <div class="pic2" style="width:80px;height:80px;position:relative;left:-100px">
                     <c:choose>
                     <c:when test="${! empty fd.fheadimage}">
                      <img src="http://localhost:8080/img/${fd.fuid }/${fd.fheadimage}" style="width:80px;height:80px">
                      </c:when>
                      <c:otherwise>
                       <img src="http://localhost:8080/img/face/head_male_man_user_64px_1578_easyicon.net.png" style="width:80px;height:80px">
                      </c:otherwise>
                      </c:choose>
                     </div>
           <ul style="float:left;position:relative;left:150px;top:20px">
           <li>   <a href="http://localhost:8080/fasebooke/user/${fd.fuid}/${current_user.fuid}.action"><i class="glyphicon glyphicon-heart" style="color:red"></i>${fd.fname}</a></li>
                             <li>
                                 <i class="fa fa-home"></i>住址:${fd.fliveplace}
                             </li>
                             <li>
                                 <i class="fa fa-facebook"></i>账号:${fd.fcount}
                             </li>
                         </ul>
                     <div style="float:right;margin-top:40px" >
                         <button type="button" class="btn btn-default" onclick="addask(this)" data="${fd.fuid}"><i class="glyphicon glyphicon-plus"></i><span>加为好友</span></button>
                     </div>
                 </li>
                 </c:forEach>
             </ul>
              
       </div>
									 
								   
									

										
				<div class="col-md-4" style="height:400px;border:0.5px solid #ccc;background:#fff">
              <form role="form" style="margin-top:20px" method="post" action="/fasebooke/friend/${current_user.fuid}/much.action">
              <div class="form-group">
              <div style="float:left;font-size:40px;margin-top:-10px">
               <span class="fa fa-home"></span> 
               </div>
                <div class="input-group" >
                <input type="text" class="form-control" name="fliveplace" placeholder="按地域省市搜索">
                </div>
              </div>
               <div class="form-group" style="margin-top:40px">
              <div style="float:left;font-size:40px;margin-top:-10px;margin-left:10px">
               <span class="fa fa-venus"></span> 
               </div>
                <div class="input-group" >
                <input type="text" class="form-control" name="fname" placeholder="按姓名搜索">
                </div>
              </div>
                <div class="form-group" style="margin-top:40px">
              <div style="float:left;font-size:40px;margin-top:-10px;">
               <span class="fa fa-birthday-cake" aria-hidden="true"></span> 
               </div>
                <div class="input-group" >
                <input type="date" class="form-control" name="fbirthday" style="width:203px;margin-left:3px;margin-top:5px">
                </div>
              </div>
                <div class="form-group" style="margin-top:40px">
              <div style="float:left;font-size:37px;margin-top:-10px;">
               <span class=" fa fa-graduation-cap" aria-hidden="true"></span> 
               </div>
                <div class="input-group" >
                  <input type="text" class="form-control" name="uschool" placeholder="按学校搜索">
                </div>
              </div>
           <div class="form-group" style="margin-top:40px;float:right" >
                <button type="submit" class="btn btn-primary " ><i class="glyphicon glyphicon-search"></i>搜索</button>
           </div>
            </form>
          </div>   
								
								
								  <!-- main col right -->
								
							   </div><!--/row-->
								
							  
							</div><!-- /col-9 -->
						</div><!-- /padding -->
					</div>
					<!-- /main -->
				  
				</div>
			</div>
		</div>


		
        

        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/localsearch.js"></script>
    <script type="text/javascript">
    <% Fuser us =(Fuser)request.getSession().getAttribute("current_user") ;  %>
     var cuserid='<%=us.getFuid()%>';
     var curername='<%=us.getFname()%>';
     var curhead='${current_user.fheadimage}';
      localStorage.setItem("current_id",cuserid); 
      localStorage.setItem("current_name",curername); 
      localStorage.setItem("current_head",curhead);
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