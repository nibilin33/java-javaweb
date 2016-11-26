<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
        <!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
   <link href="<%=request.getContextPath()%>/resources/css/facebook.css" rel="stylesheet" type="text/css"/>
         <link href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/facebook_128px_1160395_easyicon.net.ico"/>
    
      <style type="text/css">     
    
</style>   
    </head>
    
    
    <body>
       
        <div class="wrapper">
   
			<div class="box">
				<div class="row row-offcanvas row-offcanvas-left">
					
					<!-- sidebar -->
					<div class="column col-sm-2 col-xs-1 sidebar-offcanvas" id="sidebar">
					  
						<ul class="nav">
							<li><a href="#" data-toggle="offcanvas" class="visible-xs text-center"><i class="glyphicon glyphicon-chevron-right"></i></a></li>
						</ul>
					   
						<ul class="nav hidden-xs" id="lg-menu">
							<li class="active"><a href="#featured"><i class="fa fa-facebook-square"></i> 欢迎来到fasebooke</a></li>
							<li><a href="#stories"><i class="fa fa-pencil-square-o"></i>消息</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-list"></i> 好友名单</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-picture"></i> 照片</a></li>
							<li>
							    <a href=""><i class="fa fa-bookmark"></i>收藏夹</a>
							</li>
							<li>
							    <a href=""><i class="fa  fa-calendar" ></i>活动</a>
							</li>
							<li>
							    <a href=""><i class="fa  fa-history" ></i>那年今天</a>
							</li>
						</ul>
						<ul class="list-unstyled hidden-xs" id="sidebar-footer">
							
						</ul>
					  
						<!-- tiny only nav-->
					  <ul class="nav visible-xs" id="xs-menu">
							<li><a href="#featured" class="text-center"><i class="glyphicon glyphicon-list-alt"></i></a></li>
							<li><a href="#stories" class="text-center"><i class="glyphicon glyphicon-list"></i></a></li>
							<li><a href="#" class="text-center"><i class="glyphicon glyphicon-paperclip"></i></a></li>
							<li><a href="#" class="text-center"><i class="glyphicon glyphicon-refresh"></i></a></li>
						</ul>
					  
					</div>
					<!-- /sidebar -->
				  
					<!-- main right col -->
					<div class="column col-sm-10 col-xs-11" id="main">
						
						<!-- top nav -->
						<div class="navbar navbar-blue navbar-static-top">  
							<div class="navbar-header">
							  <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							  </button>
							  <a href="" class="navbar-brand logo">f</a>
							</div>
							<nav class="collapse navbar-collapse" role="navigation">
							<form class="navbar-form navbar-left">
								<div class="input-group input-group-sm" style="max-width:360px;">
								  <input class="form-control" placeholder="Search" name="srch-term" id="srch-term" type="text">
								  <div class="input-group-btn">
									<button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
								  </div>
								</div>
							</form>
							<ul class="nav navbar-nav">
                          <li>
                             <a href=""> <img src="" style="border: 1px solid rgba(0, 0, 0, .1);width:24px;height:24px"><span>Niblin</span>
                             </a>
                          </li>
							  <li>
								<a href="javascript:;" onclick="showMask(this)"><i class="glyphicon glyphicon-home"></i> 首页</a>
							  </li>
							  <li>
								<a href="#postModal" role="button" data-toggle="modal"><i class="glyphicon glyphicon-plus"></i> 好友请求</a>
							  </li>
							  <li>
							    
								<a href="#" title="消息"><span class="fa fa-comments"></span></a>
							  </li>
							  <li>
							<a href="#" title="通知"> <span class="glyphicon glyphicon-globe"></span></a> 
							  </li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
                          <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><div style="width:10px;height:100%"><img src="<%=request.getContextPath()%>/resources/img/secret.png"></div></a>
                            <ul class="dropdown-menu" style="width:380px">
								  <li><a href="#" style="padding:0"><div style="background-color:#3b5998;">
								      <span class="glyphicon glyphicon-eye-close" style="padding-left:10px;padding-right:10px;color:white"></span>
								      <div style="display: inline-block;margin-left:10px">
								          <h5 style="color:white">隐私设置检查</h5>
								      </div>
								      <div style="display: inline-block;margin-left:145px">
								          <img src="<%=request.getContextPath()%>/resources/img/secretcheck.png" style="margin-top:-30px">
								      </div>
								  </div></a></li>
								  <li> <a href="#" style="padding:0"><span class="glyphicon glyphicon-globe" style="padding-left:10px;padding-right:10px">
								  <div style="display:inline-block">
								       <h5>谁能看我的资料？</h5>
								  </div>
								<div style="display: inline-block;margin-left:50%">
								 <span class="caret"></span>
								
								 </div>
								 </a>
								 </li>
								  <li><a href="#"style="padding:0"><span class="fa fa-group" style="padding-left:10px;padding-right:10px"></span>
								   <div style="display:inline-block">
								       <h5>谁能够联系我？</h5>
								  </div>
								   <div style="display:inline-block; margin-left:50%" >
								 <span class="caret"></span>
								 </div>
								  </a></li>
								  <li><a href="#"style="padding:0"><span class="glyphicon glyphicon-minus-sign" style="padding-left:10px;padding-right:10px"></span> <div style="display:inline-block">
								       <h5>如何阻止他人骚扰我？</h5>
								  </div>
								  <div style="display: inline-block;margin-left:43%">
								 <span class="caret"></span>
								
                                      </div></a>
								</ul>
                          </li>
                            
							  <li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-sort-desc"></i></a>
								<ul class="dropdown-menu">
								  <li ><a href="">创建主页</a></li>
								  <li role="separator" class="divider"></li>
								    <li><a href="">创建小组</a></li>
								  <li ><a href="">查找小组</a></li>
								  <li  role="separator" class="divider"></li>
								  <li><a href="">创建广告</a></li>
								   <li  role="separator" class="divider"></li>
								  <li><a href="">退出</a></li>
								  <li><a href="">设置</a></li>
								   <li  role="separator" class="divider"></li>
								  <li><a href="">帮助中心</a></li>
								</ul>
							  </li>
							</ul>
							</nav>
						</div>
						<!-- /top nav -->
					  
						<div class="padding">
							<div class="full col-sm-9">
							  
								<!-- content --> 
								                      
								<div class="row" >
								
								  <div class="col-md-7" style="height:auto;border:0.5px solid #ccc;margin-right:20px;background:#fff">
								 <!-- main col left --> 
						
						    <div id="mask" class="mask"></div>  
             <h4>可能认识的人</h4>
             <ul>
                 <li>
                     <div class="pic2" style="width:80px;height:80px">
                      <img src="" style="width:80px;height:80px">
                     </div>
           <ul style="float:left;position:relative;left:150px;top:20px">
           <li>   <a href=""><i class="glyphicon glyphicon-heart" style="color:red"></i>Sally</a></li>
                             <li>
                                 <i class="fa fa-home"></i>住址
                             </li>
                             <li>
                                 <i class="fa fa-facebook"></i>账号
                             </li>
                         </ul>
                      
                        
                     <div style="float:right;margin-top:40px" >
                         <button type="button" class="btn btn-default"><i class="glyphicon glyphicon-plus"></i><span>加为好友</span></button>
                         <button type="button" class="btn btn-default"> <i class="glyphicon glyphicon-trash"></i>移除</button>
                     </div>
                 </li>
             </ul>
              
       </div>
									 
								   
									

										
								    <div class="col-md-4" style="height:400px;border:0.5px solid #ccc;background:#fff">
                                             <form role="form" style="margin-top:20px">
              <div class="form-group">
              <div style="float:left;font-size:40px;margin-top:-10px">
               <span class="fa fa-home"></span> 
               </div>
                <div class="input-group" >
                <input type="text" class="form-control" placeholder="按地域省市搜索">
          
                </div>
              </div>
               <div class="form-group" style="margin-top:40px">
              <div style="float:left;font-size:40px;margin-top:-10px;margin-left:10px">
               <span class="fa fa-venus"></span> 
               </div>
                <div class="input-group" >
                <input type="text" class="form-control" placeholder="按姓搜索">
                </div>
              </div>
                <div class="form-group" style="margin-top:40px">
              <div style="float:left;font-size:40px;margin-top:-10px;">
               <span class="fa fa-birthday-cake" aria-hidden="true"></span> 
               </div>
                <div class="input-group" >
                <input type="date" class="form-control" style="width:203px;margin-left:3px;margin-top:5px">
                </div>
              </div>
                <div class="form-group" style="margin-top:40px">
              <div style="float:left;font-size:37px;margin-top:-10px;">
               <span class=" fa fa-graduation-cap" aria-hidden="true"></span> 
               </div>
                <div class="input-group" >
                  <input type="text" class="form-control" placeholder="按学校搜索">
                </div>
              </div>
           <div class="form-group" style="margin-top:40px;float:right" >
                <button type="submit" class="btn btn-primary " ><i class="glyphicon glyphicon-search"></i>搜索</button>
           </div>
            </form>
          </div>   
								
								
								  <!-- main col right -->
								
							   </div><!--/row-->
								
							  
							</div><!-- /col-9 -->
						</div><!-- /padding -->
					</div>
					<!-- /main -->
				  
				</div>
			</div>
		</div>


		<!--post modal-->
	
        
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
        <script type="text/javascript"> 
        function showMask(){     
            $("#mask").css("height",$(document).height());     
            $("#mask").css("width",$(document).width());     
            $("#mask").show();     
        } 
        $(document).ready(function() {
			$('[data-toggle=offcanvas]').click(function() {
				$(this).toggleClass('visible-xs text-center');
				$(this).find('i').toggleClass('glyphicon-chevron-right glyphicon-chevron-left');
				$('.row-offcanvas').toggleClass('active');
				$('#lg-menu').toggleClass('hidden-xs').toggleClass('visible-xs');
				$('#xs-menu').toggleClass('visible-xs').toggleClass('hidden-xs');
				$('#btnShow').toggle();
			});
           
        });
      $('#imagefile').change(function(){
            var file=this.files[0];
           var read=new FileReader();
            read.readAsDataURL(file);
            $('#result').innerHTML='<img src="'+this.result+'" alt=""/>';
        });  
          function imgChoose(e){
            var b= e.src;
            var d=document.getElementById("leavemoods");
            var im=document.createElement("img");
              im.setAttribute("src",b);
              d.appendChild(im);
              im.style.width="20px";
              im.style.height="20px";
          }
        
        </script>
</body></html>