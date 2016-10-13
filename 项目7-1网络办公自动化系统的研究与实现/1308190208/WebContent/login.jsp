<%@ page language="java" import="java.util.*,java.text.*,official.dao.*,official.entity.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="assets/css/light-bootstrap-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
</head>
<body>
<%
String username=request.getParameter("username");
String pass=request.getParameter("pwd");
Dao dao=new Dao();
if(username!=null&&pass!=null){
Employees a=dao.Login(username, pass);
if (a!=null){
	session.setAttribute("id", username);
	session.setAttribute("emp", a);
	response.sendRedirect("main.jsp");
}else {
	
		%>
		<script type="text/javascript">
		alert("用户名或密码错误");
		</script>
		<% 
	}
}
%>
   <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">登录</h4>
                            </div>
                            <div class="content">
                                <form method="post" action="login.jsp">
                                    <div class="row">
                   
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>用户 </label>
                                                <input type="text" class="form-control" placeholder="Username" name="username" value="1">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                          
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>密码</label>
                                                <input type="password" class="form-control" placeholder="ID number" name="pwd" value="1">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                          请使用火狐或者360浏览器看，否则界面会有问题=-=然后工程可能会加载非常慢，不清楚为什么，大概是因为使用了富文本编辑器。。请耐心看完。。
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                       
                                        <div class="col-md-4">
                                            <div class="form-group">
                                            
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                            
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                           
                                            </div>
                                        </div>
                                    </div>

                                    <button type="submit" class="btn btn-info btn-fill pull-right">登录</button>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card card-user">
                            <div class="image">
                                <img src="https://ununsplash.imgix.net/photo-1431578500526-4d9613015464?fit=crop&fm=jpg&h=300&q=75&w=400" alt="..."/>
                            </div>
                            <div class="content">
                                <div class="author">
                                     <a href="#">
                                    <img class="avatar border-gray" src="img/smart.jpg" alt="..."/>

                                      <h4 class="title">智能办公系统<br />
                                         <small>office intelligentization</small>
                                      </h4>
                                    </a>
                                </div>
                                <p class="description text-center"> "欢迎使用智能办公系统" <br>
                             
                                </p>
                            </div>
                            <hr>
                            <div class="text-center">
                                <button href="#" class="btn btn-simple"><i class="fa fa-facebook-square"></i></button>
                                <button href="#" class="btn btn-simple"><i class="fa fa-twitter"></i></button>
                                <button href="#" class="btn btn-simple"><i class="fa fa-google-plus-square"></i></button>

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

</body>
</html>