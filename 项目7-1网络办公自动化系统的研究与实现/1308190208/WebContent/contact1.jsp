<%@ page language="java"  import="java.util.*,java.text.*,official.dao.*,official.entity.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>智能办公</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


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

<div class="wrapper">
    <div class="sidebar" data-color="purple" data-image="assets/img/sidebar-5.jpg">

    <!--

        Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
        Tip 2: you can also add an image using data-image tag

    -->

    	<div class="sidebar-wrapper">
            <div class="logo">
                  个人管理
            </div>

            <ul class="nav">
                <li class="active">
                    <a href="">
                        <i class="pe-7s-graph"></i>
                        <p>系统信息</p>
                    </a>
                </li>
                <li>
                   <a href="task.jsp">
                        <i class="pe-7s-user"></i>
                        <p>任务计划</p>
                    </a>
                </li>
                <li>
                    <a href="person1.jsp">
                        <i class="pe-7s-note2"></i>
                        <p>信息管理</p>
                    </a>
                </li>
                <li>
                    <a href="password.jsp">
                        <i class="pe-7s-news-paper"></i>
                        <p>密码管理</p>
                    </a>
                </li>
                <li>
                    <a href="loginout.jsp">
                        <i class="pe-7s-science"></i>
                        <p>注销用户</p>
                    </a>
                </li>
             <%--   <li>
                    <a href="maps.html">
                        <i class="pe-7s-map-marker"></i>
                        <p></p>
                    </a>
                </li>
                <li>
                    <a href="notifications.html">
                        <i class="pe-7s-bell"></i>
                        <p></p>
                    </a>
                </li>
               
             --%> 
              
				<li class="active-pro">
                    <a href="">
                        <i class="pe-7s-rocket"></i>
                        <p>查看联系方式</p>
                    </a>
                </li>
            </ul>
    	</div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="active.jsp">活动目录</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                            <a href="publicinfo.jsp" class="dropdown-toggle" >
                                <i class="fa fa-dashboard"></i>公共信息
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-globe"></i>
                                    <b class="caret"></b>
                                    <span class="notification">2</span>
                                                    员工管理
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="worker.jsp">查找员工信息</a></li>
                                <li><a href="person.jsp">添加员工信息</a></li>
                      
                              </ul>
                        </li>
                        <li>
                          <a href="contact.jsp">
                                <i class="fa fa-search"></i>
                                                     通讯录
                            </a>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                         <li class="dropdown">
                              <a href="addactive.jsp" class="dropdown-toggle" >
                                                                                       系统管理
                                    <b class="caret"></b>
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="#">查看用户信息</a></li>
                                <li><a href="#">查看在线用户</a></li>
               
                              </ul>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                                                       部门管理
                                    <b class="caret"></b>
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="department.jsp">查看部门信息</a></li>
                                <li><a href="editjob.jsp">编辑职位信息</a></li>
                                <li><a href="adddepartment.jsp">新建部门</a></li>
                              </ul>
                        </li>
                        
                    </ul>
                </div>
            </div>
        </nav>
        <h4 class="title">
        <form method="post" action="contact1.jsp">
  请输入姓名<input type="text" name="pname">
   <input type="submit" value="search">
                           <i class="fa fa-search"></i>
                         </h4>
                            </form>
         <div class="row">
     <div class="col-md-8">
                        <div class="card ">
                            <div class="header">
                                <h4 class="title">公司</h4>
                                <p class="category"></p>
                            </div>
                            <div class="content">
                                <div id="chartHours" class="ct-chart">
                                 <table class="table">
                                   <tr><td>部门</td> <td>电话</td>  </tr>
                                   <tr><td>开发</td><td>456789</td></tr>
                                   <tr><td>销售</td><td>4256789</td></tr>
                                   <tr><td>财务</td><td>1456789</td></tr>
                                   <tr><td>行政</td><td>4566789</td></tr>
                                   </table>
                                </div>

                                <div class="footer">
                                    <div class="legend">
                                        <i class="fa fa-circle text-info"></i> 
                                        <i class="fa fa-circle text-danger"></i> 
                                    </div>
                                    <hr>
                                    
                                </div>
                            </div>
                        </div>
                       
 </div>
   <div class="col-md-4">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">私人</h4>
                                <p class="category"></p>
                            </div>
                            <div class="content">
                                <div id="chartHours" class="ct-chart">
                                <table class="table">
                                <tr>
                                <td>姓名</td>
                                <td>电话</td>
                                </tr>
                                   <%
                                   Dao dao=new Dao();
                                 
                                   int currentPage=1; //默认显示第一页
                                   int totalpage=dao.getTotalPage("employees");
                                   String strPage=request.getParameter("page");
                                   if(strPage==null){
                                 	  currentPage=1;
                                   }else
                                   {
                                 	 currentPage=Integer.parseInt(strPage);
                                   }
                                   
                                   if(currentPage>totalpage){
                                 	  currentPage=totalpage;
                                   }else
                                 	  if(currentPage<=0){
                                 		  currentPage=1;
                                   }
                                   List<Employees> de=dao.queryEmployeesByPage(currentPage);
                                   for (int i=0;i<de.size();i++){
                                    String s1=de.get(i).getEmployeeName();
                                     String s2= de.get(i).getMobile();
                                    
                                   %>
                                   <tr>
                                   <td><%=s1 %></td>
                                   <td><%=s2 %></td>
                                   </tr>
                                   <%} %>
                                </table>
                                
                                </div>
                                <div class="footer">
                                    <div class="legend">
                                        <i class="fa fa-circle text-info"></i>
                                        <i class="fa fa-circle text-danger"></i> 
                                        <i class="fa fa-circle text-warning"></i> 
                                    </div>
                                    <hr>
                                  
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


              
               
             


 &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp  共有<%=totalpage%>页  &nbsp &nbsp &nbsp   当前第<%=currentPage%>页 &nbsp &nbsp &nbsp   <a href="contact.jsp?page=1">第一页</a> &nbsp &nbsp &nbsp <a href="contact.jsp?page=<%=currentPage-1%>">上一页</a>  &nbsp &nbsp &nbsp 
    
           <a href="contact.jsp?page=<%=currentPage+1%>">下一页</a>
           &nbsp &nbsp &nbsp   <a href="contact.jsp?page=<%=totalpage%>">最后一页</a>   











       
                                <div class="footer">
                                    <hr>
                                    <div class="stats">
                                       
                                    </div>
                                </div>
                            </div>
                        </div>
                
         

        <footer class="footer">
            <div class="container-fluid">
              
                <p class="copyright pull-right">
                    &copy; 2016 <a href="http://www.creative-tim.com">智能办公</a>, made with love for a better web
                </p>
            </div>
        </footer>

    </div>
</div>


</body>

    <!--   Core JS Files   -->
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="assets/js/bootstrap-checkbox-radio-switch.js"></script>

	<!--  Charts Plugin -->
	<script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="assets/js/light-bootstrap-dashboard.js"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="assets/js/demo.js"></script>


</html>
