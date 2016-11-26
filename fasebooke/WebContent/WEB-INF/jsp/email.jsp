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

   <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/diyUpload/css/webuploader.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/diyUpload/css/diyUpload.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/diyUpload/js/webuploader.html5only.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/diyUpload/js/diyUpload.js"></script>
           <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js"></script>
                   <link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
   <link href="<%=request.getContextPath()%>/resources/css/facebook.css" rel="stylesheet" type="text/css"/>
         <link href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/facebook_128px_1160395_easyicon.net.ico"/>
   <style>
   .parentFileBox{
   width:1200px !important;
   }
       body{font-size:14px;font-family:"微软雅黑";background:url("http://localhost:8080/img/face/2.jpg")top no-repeat;background-attachment:fixed;z-index:0;background-size:100%;}
       a{      color: black;
         }
         #box{ margin:50px auto; width:540px; min-height:400px; background:#FF9}
.box1{width:960px;height:auto;min-height: 800px; margin:5px auto;position:relative;z-index:1;background-color:rgba(0,0,0,0.075)}
/*内容发布区域*/

</style>
    </head><body>
<!--head-->
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
				  <button class="btn btn-primary btn-sm" data-dismiss="modal" aria-hidden="true" onclick="dimiss()">完成</button>
					
				  </div>	
			  </div>
		  </div>
		  </div>
		</div>
      </div>
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
                 <i class="glyphicon glyphicon-envelope" style="font-size:30px"></i><span style="font-size:30px;color:gray">邮箱</span>
              
             </div>
             <div class="panel-body">
               
                 <div class="col-md-12">
            <form class="form-horizontal" role="form">
              <div class="form-group has-error">
                <div class="col-sm-2">
                  <label for="inputEmail3" class="control-label">发件人：</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="fajian" value="${email.user.fcount}">
                </div>
              </div>
              <div class="form-group has-success">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">标题：</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="biaoti" value="${email.senttime}">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">内容：</label>
                </div>
                <div class="col-sm-10">
                  <textarea class="form-control" rows="6" id="neirong">
                     ${email.contenti}
                  </textarea>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-10 col-sm-offset-2 text-right">
                  <div class="btn-group">
                    <a href="javascript:;" onclick="repy(this)" class="btn btn-lg btn-primary">回复</a>
                    <a href="javascript:;" onclick="demail(this)" class="btn btn-lg btn-primary">删除</a>
                    <a href="http://localhost:8080/fasebooke/friend/${current_user.fuid }/myfreind.action" class="btn btn-lg btn-primary">返回</a>
                  </div>
                </div>
              </div>
            </form>
          </div>
          <div class="section">
          
      <div class="container">
        <div class="row" style="columns:4" id="psfile">
        <c:if test="${! empty email.plusfile}">
       
                   </c:if>    
                
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
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
       <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/localsearch.js"></script>
        <script type="text/javascript">
        var pfile='${email.plusfile}';
        var arr=pfile.split('-');
        for(var i=0;i<arr.length;i++)
       	 if(arr[i]!=''){
       		 var file=arr[i].split('"').join('');
         $('#psfile').append(' <div style="float:left"><i class="glyphicon glyphicon-file" style="font-size:100px"></i><a href="http://localhost:8080/fasebooke/email/download.action?fileName=-'+file+'" onclick="dwfile(this)"><span class="glyphicon glyphicon-floppy-save"></span>"'+arr[i]+'"</a></div>');
       	 }
        function demail(e){ /* 删除邮件*/
    		$.ajax({
    		        url:"/fasebooke/email/"+'${email.eid}'+"/demail.action",
    		        success:function(message){
    		        	$('#fajian').val("");
    		        	$('#biaoti').val("");
    		        	$('#neirong').text("");
    		        	console.log(message);
    		        }
    		    });
    			
    		}
        function fuifu(e){
        	
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