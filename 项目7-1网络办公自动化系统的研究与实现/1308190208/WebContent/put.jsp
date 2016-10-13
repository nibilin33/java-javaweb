<%@ page language="java" import="java.util.*,java.text.*,official.dao.*,official.entity.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://ckeditor.com" prefix="ck" %>
    <%@ page import="com.ckeditor.*" %>
    <%@ page import="java.util.*" %>
    <%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="ckeditor/contents.css"> 
 <link rel="stylesheet" type="text/css" href="styles.css">  
 <script type="text/javascript" src="ckeditor/ckeditor.js"></script>  
    <script type="text/javascript">  
        window.onload = function() {  
            CKEDITOR.replace("content",{  
                width: 600,  
                height: 400,  
                filebrowserFileUploadUrl : 'servlet/upload?type=file',  
                filebrowserImageUploadUrl : 'servlet/upload?type=image',   
                filebrowserFlashUploadUrl : 'servlet/upload?type=flash'  
            });  
        };  
    </script>  
  
  </head>  
    
  <body>  
 <form action="servlet/upload" method="post" enctype="multipart/form-data">
<textarea class="ckeditor" id="content" ></textarea>  
<input type="submit">
</form>
  </body>  
</html>