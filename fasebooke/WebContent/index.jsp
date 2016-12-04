<%@ page language="java" contentType="text/html;charset=utf-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <title></title>
    <meta charset="uft-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/resources/css/normalize.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/resources/css/main.css" rel="stylesheet" type="text/css"/>
     <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
    
     <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/app.js"></script>
     <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/facebook_128px_1160395_easyicon.net.ico"/>
  <script language="javascript" type="text/javascript" src="http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js
"></script>
 <script language="javascript" type="text/javascript">
 window.onload=function(){
	 window.p=remote_ip_info.province+remote_ip_info.city;
 }
 
 </script>

</head>
<body>

<div class="fb-container">
  <div class="fb_headcontainer">
   <div class="fb_loghead">
     <div class="fb_left">
     <h1>
      <a href="index.jsp"> 
          <i>
          <u>
           fasebooke
              </u>
          </i>
          </a>
     </h1>
       </div>
       <div class="fb_logright">
       <div class="fb_logmain">
         <form method="post" action="/fasebooke/user/login.action">
          <table>
             <tbody>
              <tr>
                  <td><label for="email" style="color:white" >邮箱/手机</label></td>
                  <td><label for="password" style="color:white" >密码</label></td>
                  <td>
      
                  </td>
              </tr>
              <tr>
                  <td>
                  
                    <input type="text" id="email" name="username">  
                  </td>
                  <td>
                      <input type="password" style="margin-left:10px" id="password" name="password">
                  </td>
                  <td >
                      <button type="submit" class="btn-default btn-info" style="margin-left:10px">登录</button>
                  </td>
              </tr>
              <tr>
                  <td>
                      
                  </td>
                  <td>
                      <a href="<%=request.getContextPath()%>/jsp/login.jsp" style="color:#9cb4d8">忘记密码？</a>
                  </td>
                
              </tr>
              </tbody>
          </table> 
          </form>
       </div>
       </div>
   </div>  
   </div>
  
   <div class="fb_left">
       <h1 style="color:black;font-size:22px;margin-left:20px;margin-top:20px">联系你我，分享生活，尽在 Fasebooke</h1>
       <img src="<%=request.getContextPath()%>/resources/img/facebooklogin.png">
   </div>
   <div class="fb_logright">
     <div class="_5c">
      <h1>注册</h1>
      <h4>永久免费使用</h4>
    <form >
        <div class="form-inline">
       <div class="form-group ">
    
        <input type="text" class="form-control" placeholder="名" name="firstname">
       </div>
       <div class="form-group">
        <input type="text" class="form-control" placeholder="姓" name="lastname">
       </div>
       </div><p id="iname" style="color:red"></p>
       <br>
       <div class="form-group">
            <input type="text" class="form-control" placeholder="手机或邮箱"
                   name="telemail" ><p id="telemail" style="color:red"></p>
       </div>
       <div class="form-group">
            <input type="password" class="form-control" placeholder="密码长度在5-10" name="ogame"><p id="ogame" style="color:red"></p>
       </div>
       <div class="form-group">
            <input type="password" class="form-control" placeholder="确认密码" name="password2"><p id="pa" style="color:red"></p>
       </div>
       <h4>生日</h4>
       <input type="date" value="1990-01-01" class="_5b" name="fbirthday"/>
       <div class="form-group" style="margin-top:20px">
       <input type="radio" value="0" name="sex"/><label class="_5mt">女</label>
       <input type="radio" value="1" name="sex"/><label class="_5mt">男</label>
       <br>
       <br>
       <input type="button" class="btn-default btn-success btn-lg" value="         注册         " id="btn2">
       </div>
       </div>
       </form>
   </div>
</div>
</body>
</html>