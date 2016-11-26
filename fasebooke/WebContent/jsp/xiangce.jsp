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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/diyUpload/css/webuploader.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/diyUpload/css/diyUpload.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/diyUpload/js/webuploader.html5only.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/diyUpload/js/diyUpload.js"></script>
           <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js"></script>
   <style>
       body{font-size:14px;font-family:"微软雅黑";background:url("http://localhost:8080/img/face/2.jpg")top no-repeat;background-attachment:fixed;z-index:0;background-size:100%;}
       a{      color: black;
         }
         #box{ margin:50px auto; width:540px; min-height:400px; background:#FF9}
.box1{width:960px;height:auto;min-height: 800px; margin:5px auto;position:relative;z-index:1;background-color:rgba(0,0,0,0.075)}
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
							<form class="navbar-form navbar-left">
								<div class="input-group input-group-sm" style="max-width:360px;">
								  <input class="form-control" placeholder="Search" name="srch-term" id="srch-term" type="text">
								  <div class="input-group-btn">
									<button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
								  </div>
								</div>
							</form>
							<ul class="nav navbar-nav">
                          <li>
                             <a href="http://localhost:8080/fasebooke/user/${current_user.fuid}.action"> <img src="" style="border: 1px solid rgba(0, 0, 0, .1);width:24px;height:24px"><span>${current_user.fname}</span>
                             </a>
                          </li>
							  <li>
								<a href="http://localhost:8080/fasebooke/user/show.action">
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
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-sort-desc"></i></a>
								<ul class="dropdown-menu">
								  <li ><a href="">创建主页</a></li>
								  <li role="separator" class="divider"></li>
								    <li><a href="">创建小组</a></li>
								  <li ><a href="">查找小组</a></li>
								  <li  role="separator" class="divider"></li>
								  <li><a href="">创建广告</a></li>
								   <li  role="separator" class="divider"></li>
								  <li><a href="">退出</a></li>
								  <li><a href="">设置</a></li>
								   <li  role="separator" class="divider"></li>
								  <li><a href="">帮助中心</a></li>
								</ul>
							  </li>
							</ul>
							</nav>
						</div>

<!--  headnext-->
  
 <div class="imagrap">
    <a href="" class="_30x-">
     <div  class="_30x">
         <span class="fa  fa-camera" style="color:white"></span>
         <span>添加封面照片</span>
     </div>
     </a>
     <img class="pic">
     <span style="color:white;font-size:30px;">NIBILIN</span>
 </div>
  <div class="container" style="margin-left:20%;min-height:41px">

  <div class="col-md-12">
  <ul class="lead nav nav-pills">
  <li >
  <a href="#">时间线</a></li><li><a href="#">简介</a></li><li><a href="#">好友</a></li><li class="active"><a href="#">照片</a></li><li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">更多<i class="fa fa-caret-down"></i></a> <ul class="dropdown-menu" role="menu"> <li><a href="#">签到</a></li><li><a href="#">赞</a></li><li><a href="#">活动</a></li><li class="divider"></li><li><a href="#">管理各项</a></li></ul>
  </div>
  </div>


<!--   container-->
 <div class="container">
     <div class="row">
         <div class="panel panel-default">
             <div class="panel-heading">
                 <i class="glyphicon glyphicon-picture" style="font-size:30px"></i><span style="font-size:30px;color:gray">照片</span>
                 <div class="btn-group" style="float:right">
              <a href="javascript:;" data-target="#postModal2" data-toggle="modal" class="btn btn-default"><i class="glyphicon glyphicon-plus"></i>创建相册</a>
              <a href="javascript:;" data-target="#postModal" data-toggle="modal" class="btn btn-default"><i class="glyphicon glyphicon-pencil"></i>添加照片</a>
         
            </div>
             </div>
             <div class="panel-body">
                <ul id="myTab" class="nav nav-tabs">
	<li class="active">
		<a href="#home" data-toggle="tab">
			相册名
		</a>
	</li>
	<li>
	<a href="javascript:;">返回</a>
	</li>
</ul>
             </div>
             <div id="myTabContent" class="tab-content">
    <div class="tab-pane fade in active" id="home">
     <div class="_mytakenpicture" id="my">
      <div class="pic2">
       
          
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

<!--post modal-->
		<div id="postModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true" >
		  <div class="modal-dialog">
		
		  <div class="modal-content">
			  <div class="modal-body">
	       <div id="box" >
       	   <div id="test">
             
         </div>
     </div>
			  <div class="modal-footer">
				  <div>
				  <button class="btn btn-primary btn-sm" data-dismiss="modal" aria-hidden="true" onclick="dimiss()">关闭</button>
					
				  </div>	
			  </div>
		  </div>
		  </div>
		</div>
      </div>
 <div id="postModal2" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
		  <div class="modal-dialog">
		  <div class="modal-content">
		  <form action="" method="">
			  <div class="modal-header">
       <input type="text" class="form-control" placeholder="相册标题">
			  </div>
			  <div class="modal-body">
				
					<div class="form-group center-block">
					  <textarea class="form-control input-lg" autofocus="" placeholder="你想如何描述相册"></textarea>
					</div>
				  <input type="hidden" name="isopen" id="isopen" value="">
			  </div>
			  </form>
			  <div class="modal-footer">
				  <div>
				  <div class="dropdown">  
        <button class="btn dropdown-toggle pull-left" type="button" id="dropdownMenu1" data-toggle="dropdown">  
           权限设置 
            <span class="caret"></span>  
        </button>  
        <ul class="dropdown-menu" style="margin-top:40px"role="menu" aria-labelledby="dropdownMenu1">  
            <li role="presentation"><a href="#" role="menuitem" tabindex="-1"><span class="glyphicon glyphicon-globe"></span>公开</a></li>  
            <li role="presentation"><a href="#" role="menuitem" tabindex="-1"><span class="fa fa-user"></span>好友</a></li>  
            <li role="presentation"><a href="#" role="menuitem" tabindex="-1"><span class="fa  fa-unlock-alt"></span>仅自己</a></li>  
           
        </ul>  
    </div> 
</div>
				  <button class="btn btn-primary btn-sm" data-dismiss="modal" aria-hidden="true">确定</button>
					
				  </div>	
			  </div>
		  </div>
		  </div>
		</div>
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
        <script type="text/javascript">

        $('#test').diyUpload({
        	url:'http://localhost:8080/fasebooke/picture/dotest.action',
        	success:function( data ) {
        		console.info( data );
        	},
        	error:function( err ) {
        		console.info( err );	
        	}
        });
        function dimiss(){
            console.log("dddddddd");
          $('.parentFileBox').remove();
        }
 
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