<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
 <base href="<%=basePath%>">
    <title></title>
    <meta charset="uft-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/resources/css/normalize.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/resources/css/main.css" rel="stylesheet" type="text/css"/>
     <link rel="shortcut icon" href="https://www.facebook.com/rsrc.php/yl/r/H3nktOa7ZMg.ico"/>
 <script type="text/javascript">
 <%
 request.setAttribute("curent_user", "uuuu");
 %>
 var cuser='${curent_user}';
 localStorage.setItem("current_user",JSON.stringify(cuser));
          var timer=6;
        function countdown(){
          
    var jump=document.getElementById("timer");
         
            timer--;
              jump.innerHTML=timer;
            if(timer==0) 
          {    
         window.location.href= "<%=request.getContextPath()%>/jsp/facebook.jsp "; 
         } 
       setTimeout("countdown()",1000);
        }
    </script>
</head>
<body onload= "countdown();">
<div class="fb-container">
  <div class="fb_headcontainer">
   <div class="fb_loghead">
     <div class="fb_left">
     <h1>
      <a href="<%=request.getContextPath()%>/index.jsp"> 
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
         <form>
          <table>
             <tbody>
              <tr>
                  <td><label for="email" style="color:white">邮箱/手机</label></td>
                  <td><label for="password" style="color:white">密码</label></td>
              </tr>
              <tr>
                  <td>
                    <input type="text" id="email">  
                  </td>
                  <td>
                      <input type="password" style="margin-left:10px" id="password">
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
   <div style="background-color:#e9ebee;padding:80px 0">
      <div style="display:block;height:340px">
         <div style="text-align:center">
           <label data-brackets-id="92" style="color:black">  注册成功，再过<span id="timer" style="color:red">5</span>秒跳转</label>
         </div>
      </div>
       
   </div>
    </div>
</body>
</html>