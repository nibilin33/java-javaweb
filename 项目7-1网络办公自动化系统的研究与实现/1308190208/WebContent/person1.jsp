<%@ page language="java" import="java.util.*,java.text.*,official.dao.*,official.entity.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <jsp:setProperty property="*" name="user"/> --%>
    <%@ taglib uri="http://ckeditor.com" prefix="ck" %>
    <%@ page import="com.ckeditor.*" %>
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
                    <a href="dashboard.html">
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
                    <a href="upgrade.html">
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
                              <a href="addactive.jsp"  class="dropdown-toggle" >
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
<%
  String s=request.getParameter("x");

	if ("1".equals(s))
	{
		%>
		<script type="text/javascript">
		alert("添加失败");
		</script>
		<% 
	}
		else
		{
			if("-1".equals(s)){
				%>
				<script type="text/javascript">
				alert("已存在");
				</script>
				<% 
				}else 
				{
					if ("0".equals(s)){
						%>
						<script type="text/javascript">
						alert("添加成功");
						</script>
						<% 
					}
				}
			
			
		}
%>
<script> 
function setImagePreview() { 
var docObj=document.getElementById("doc"); 
var imgObjPreview=document.getElementById("preview"); 
if(docObj.files && docObj.files[0]){ 
//火狐下，直接设img属性 
imgObjPreview.style.display = 'block'; 
imgObjPreview.style.width = '300px'; 
imgObjPreview.style.height = '120px'; 
//imgObjPreview.src = docObj.files[0].getAsDataURL(); 
//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式 
imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]); 
}else{ 
//IE下，使用滤镜 
docObj.select(); 
var imgSrc = document.selection.createRange().text; 
var localImagId = document.getElementById("localImag"); 
//必须设置初始大小 
localImagId.style.width = "250px"; 
localImagId.style.height = "200px"; 
//图片异常的捕捉，防止用户修改后缀来伪造图片 
try{ 
localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)"; 
localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc; 
}catch(e){ 
alert("您上传的图片格式不正确，请重新选择!"); 
return false; 
} 
imgObjPreview.style.display = 'none'; 
document.selection.empty(); 
} 
return true; 
} 
</script> 
<%
  Employees em=(Employees)session.getAttribute("emp");
%>

                         <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">个人信息</h4>
                            </div>
                            <div class="content">
                                <form method="post" action="servlet/UpdateEmloyees" enctype="multipart/form-data">
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label>姓名：</label>
                                                <input type="text" class="form-control"  placeholder="username" name="employeeName" value="<%=em.getEmployeeName()%>">
                                                <input type="hidden" name="employeeID" value="<%=em.getEmployeeID()%>">
                                                <input type="hidden" name="pwd" value="<%=em.getPwd() %>">
</div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>性别</label>
                                                <select class="form-control" name="sex" id="sex">
                                                <option value="男" >男</option>
                                                   <option value="女" >女</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">邮箱：</label>
                                                <input type="email" class="form-control" placeholder="Email" name="email" value="<%=em.getEmail()%>" >
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>出生日期</label>
                                                <input type="text" class="form-control" placeholder="birthdate" name="birthday" value="<%=em.getEmail()%>">(例如：YYYY-YY-YY)
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>身份证</label>
                                                <input type="text" class="form-control" name="NOcode" value="<%=em.getNOcode()%>" >
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>现在住址</label>
                                                <input type="text" class="form-control" placeholder="Home Adress" name="address" value="<%=em.getAddress()%>" >
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>手机：</label>
                                                <input type="text" class="form-control" placeholder="Telephone" name="mobile" value="<%=em.getMobile()%>">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>部门</label>
                                                <select class="form-control" name="deptName">
                                    
                                                <option value="开发" id="开发">开发</option>
                                                   <option value="销售" id="销售">销售</option>
                                                </select>
                                            </div>
                                        </div>
                                     
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>职称</label>
                                               <select class="form-control" >
                                                <option value="员工">员工</option>
                                                   <option value="高级">高级</option>
                                                </select>
                                            </div>
                                        </div>
                                            <div class="col-md-4">
                                            <div class="form-group">
                                                <label>状态</label>
                                                <select class="form-control" name="workState">
                                                <option value="在校" id="在校">在校</option>
                                                   <option value="工作" id="工作">工作</option>
                                                </select>
                                            </div>
                                        </div>
                                            <div class="col-md-4">
                                            <div class="form-group">
                                                <label>系统用户级别</label>
                                                <select class="form-control" name="userLevel">
                                                <option value="0">高层级别</option>
                                                   <option value="1">普通级别</option>
                                                </select>
                                            </div>
                                        </div>
                                            <div class="col-md-4">
                                            <div class="form-group">
                                                <label>学历</label>
                                                <select class="form-control" name="learn">
                                                <option value="本科">本科</option>
                                                   <option value="高中">高中</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                         <div class="form-group">
                                                <label>上传图像</label>
                                                <input  type="file"  name="doc" id="doc" onchange="javascript:setImagePreview();" class="form-control" >
                                            </div>
                                            <div class="form-group">
                                                                  <label>就职协议</label> 
                             <textarea rows="10" cols="10" id="my_txt" name="agreement"></textarea>
 <ck:replace replace="my_txt" basePath="ckeditor"></ck:replace> 
                                            </div>
                                             
                                        </div>
                                    </div>
                                  <table align="center">
                                  <tr>
                                  <td>  <button type="submit" class="btn btn-info btn-fill pull-right">确认保存</button></td>
                                  <td>  &nbsp &nbsp &nbsp &nbsp &nbsp<td>
                                
                                  <td>  <button type="reset" class="btn btn-info btn-fill pull-right">取 &nbsp &nbsp &nbsp &nbsp &nbsp消</button></td>
                                    </tr>
                                    </table>
                                  
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
                               <div class="author"  id="localImag" >
                                     <a href="#">
                                     <%System.out.print(em.getPhoto()); %>
                                    <img class="avatar border-gray" id="preview" src="<%=em.getPhoto()%>"  />

                                
                                    </a>
                                </div>






       
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
                    &copy; 2016 <a href="http://www.creative-tim.com">智能办公</a>
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

</html>
