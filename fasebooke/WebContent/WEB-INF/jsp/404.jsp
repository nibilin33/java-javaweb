<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isErrorPage="true"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="<%=basePath%>">
        <meta charset="utf-8">
        <title>fasebooke</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <link href="<%=request.getContextPath()%>/resources/css/normalize.css" rel="stylesheet" type="text/css"/>
      <link href="<%=request.getContextPath()%>/resources/css/help.css" rel="stylesheet" type="text/css"/>
         <link href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet" type="text/css"/>
     <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/facebook_128px_1160395_easyicon.net.ico"/>
  
       
</head>
<body>

<div class="_flex">
    <div class="_h1">
   
    </div>
    <div class="_clearfix">
        <div class="_404b">
           <h1 style="color:#dee9ff;font-size:77px;padding-left:10%">404</h1>
            <img src="<%=request.getContextPath()%>/resources/img/404f.jpg">
        </div>
    </div>
</div>
</body>
</html>