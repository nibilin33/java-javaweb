<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.jspsmart.upload.*,org.apache.commons.fileupload.*,java.text.*,java.util.*,official.dao.*,official.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

SmartUpload smart = new SmartUpload();
smart.initialize(pageContext);
SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date time=new Date();
String addtime=matter.format(time);
smart.upload();
com.jspsmart.upload.Request request1=smart.getRequest();
String employeeName =request1.getParameter("employeeName");
String sex =request1.getParameter("sex");
String birthday =request1.getParameter("birthday");
String address =request1.getParameter("address");
String nOcode =request1.getParameter("NOcode");
String learn =request1.getParameter("learn");
String mobile =request1.getParameter("mobile");
String email =request1.getParameter("email");
String jobName =request1.getParameter("jobName");
String deptName =request1.getParameter("deptName");
String workState =request1.getParameter("workState");
String userLevell ="1";
int userLevel = Integer.parseInt(userLevell);
String photo="";
String agreement =request1.getParameter("agreement");
String pwd =request1.getParameter("pwd");
String filename=null;
String fileExt=null;
String realpath="/UserFiles/";
try {
	
	
	int count=smart.getFiles().getCount();
	for(int i=0;i<count;i++){
		com.jspsmart.upload.File file=smart.getFiles().getFile(i);
		if(file.isMissing())continue;
		filename=smart.getFiles().getFile(i).getFileName();
		fileExt=smart.getFiles().getFile(i).getFileExt();
		photo=realpath+filename+"."+fileExt;
		smart.getFiles().getFile(i).saveAs(photo,0);
	}

} catch (SmartUploadException e) {
	// TODO 自动生成的 catch 块
	e.printStackTrace();
}
Employees em =new Employees(employeeName, sex, birthday, address, nOcode, learn, mobile, email, jobName, deptName, workState, photo, agreement, pwd, userLevel, "out");
Dao d = new Dao();
int x = d.addEmployees(em);
if(x==-2){
	//-2已存在
 response.sendRedirect("http://localhost:8080/office/person.jsp?x=-1");
}else if(x==0){
	//0，成功
	response.sendRedirect("http://localhost:8080/office/person.jsp?x=0");
}else{
	//失败
	response.sendRedirect("http://localhost:8080/office/person.jsp?x=1");
}
%>
</body>
</html>