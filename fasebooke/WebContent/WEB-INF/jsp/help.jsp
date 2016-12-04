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
   <link href="<%=request.getContextPath()%>/resources/css/facebook.css" rel="stylesheet" type="text/css"/>
     <link href="<%=request.getContextPath()%>/resources/css/help.css" rel="stylesheet" type="text/css"/>
     
        
         <link href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/facebook_128px_1160395_easyicon.net.ico"/>
      <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script> 
 
      <script language="javascript" type="text/javascript" src="http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js
"></script>

    </head>

    
    <body>
        
       <div class="_flex">
    <div class="_h1">
   <img src="<%=request.getContextPath()%>/resources/img/FF.jpg" style="width:40px;line-height: 44px">
   <span style="font-size: 25px ;line-height: 44px;
    margin-left: 8px;color:white"><a href=""></a>帮助中心</span>
    </div>
    
</div>
<div class="_b">
    <div class="_b1">
        <img src="<%=request.getContextPath()%>/resources/img/helpcenter.png"/>
        
    </div>
    <form >
    <div class="input-group">
      <input type="text" class="form-control" id="question" placeholder="提问" name="ans">
      <span class="input-group-btn">
       <button type="button" class="btn btn-default">
            <i class="fa fa-search" ></i>
       </button>
       
      </span>
    
    </div>
     <div id="search_sugest" >
     <ul id="getsearch">
         
     </ul>
   </div>
    </form>
</div>

<div class="_hover">
      <div class="_hoverb">
       <ul>
       <li>
        <span class="glyphicon glyphicon-home"></span>
        <a href="http://localhost:8080/fasebooke/user/show.action?fuid=${current_user.fuid}" style="color:#4080ff">返回fasebooke</a>
        </li>
        </ul>
        </div>
</div>
<div class="_hoverbl">
  <div class="_146b">
   <div class="_clearfix _146p">
    <div class="blist">
       <span class="_146q">Questions You May Have</span> 
       <ul id="sta">
           <li >
               <a href="javascript:;" class="lii" >如何创建Fasebooke账户</a>
           </li>
           <li>
               <a href="javascript:;" class="lii">我没有收到验证手机号码的验证码</a>
           </li>
           <li>
               <a href="javascript:;" class="lii">我无法使用手机号码注册</a>
           </li>
           <li>
               <a href="javascript:;" class="lii">我找不到自己的 Fasebooke 注册确认电子邮件</a>
           </li>
       </ul>
       
    </div>
    
    <div class="span12" id="change">
   
        
                
    </div>
    </div>
    </div>
</div>
		<!--post modal-->
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/search.js"></script>
       
    <script type="text/javascript">
  
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