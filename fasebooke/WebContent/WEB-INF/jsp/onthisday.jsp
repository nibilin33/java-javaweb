<%@ page language="java" import="java.util.*,net.sf.json.*,com.fase.po.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import="org.springframework.web.util.UrlPathHelper" %>
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
    <link href="<%=request.getContextPath()%>/resources/css/stylewall.css" rel="stylesheet" type="text/css"/>
         <link href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/facebook_128px_1160395_easyicon.net.ico"/>
      <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>    
      <script language="javascript" type="text/javascript" src="http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js"></script>
 <script language="javascript" type="text/javascript">
 <% Fuser us =(Fuser)request.getSession().getAttribute("current_user") ;  %>
 var cuserid='<%=us.getFuid()%>';
 var curername='<%=us.getFname()%>';
 var curhead='${current_user.fheadimage}'; 
  if(curhead==''){
	 curhead="http://localhost:8080/img/face/head_male_man_user_64px_1578_easyicon.net.png"; 
 }else
	 {
	 var s="http://localhost:8080/img/"+cuserid+"/"+curhead;
  console.log(s); 
	 curhead=s; 
	 }  
 
  localStorage.setItem("current_id",cuserid); 
  localStorage.setItem("current_name",curername); 
  localStorage.setItem("current_head",curhead);
 window.onload=function(){
   window.p=remote_ip_info.province+remote_ip_info.city;
 }
 
 </script>

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
							<li class="active"><a href="javascript:;"><i class="fa fa-facebook-square"></i> 欢迎来到fasebooke</a></li>
							<li><a href="javascript:;" onclick="openChatService()"><i class="glyphicon glyphicon-list"></i> fasebooke聊天窗</a></li>
							<li><a href="http://localhost:8080/fasebooke/picture/${current_user.fuid}/onthisday.action"><i class="glyphicon glyphicon-picture"></i> 照片墙</a></li>
							<li>
							    <a href="http://localhost:8080/fasebooke/comment/${current_user.fuid}/seenote.action"><i class="fa  fa-history" ></i>留言墙</a>
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
							<form class="navbar-form navbar-left" method="post" action="/fasebooke/user/${current_user.fuid}/plusfd.action">
								<div class="input-group input-group-sm" style="max-width:360px;">
								  <input class="form-control" placeholder="搜好友" name="srch-term" id="srch-term" type="text">
								  <ul name="EngineModel" style="height: auto;width:305px; margin-left: 20px; position: absolute; display: none;background:-webkit-gradient(linear, left top, left 25, from(#FFFFFF), color-stop(4%, #EEEEEE), to(#FFFFFF))"></ul>
								  <div class="input-group-btn">
									<button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
								  </div>
								</div>
							</form>
							<ul class="nav navbar-nav">
                          <li>
                             <a href="http://localhost:8080/fasebooke/user/${current_user.fuid}.action"> 
                             
                             <c:choose>
                             <c:when test="${!empty current_user.fheadimage}">
                             <img src="http://localhost:8080/img/${current_user.fuid}/${current_user.fheadimage}" style="border: 1px solid rgba(0, 0, 0, .1);width:24px;height:24px"><span>${current_user.fname}</span>
                            </c:when>
                            <c:otherwise>
                             <img src="http://localhost:8080/img/face/head_male_man_user_64px_1578_easyicon.net.png" style="border: 1px solid rgba(0, 0, 0, .1);width:24px;height:24px"><span>${current_user.fname}</span>
                            </c:otherwise>
                            </c:choose>
                            
                             </a>
                          </li>
							  <li>
								<a href="http://localhost:8080/fasebooke/user/show.action?fuid=${current_user.fuid }">
								<i class="glyphicon glyphicon-home"></i> 首页</a>
							  </li>
							 
							  <li>
							    
								<a href="javascript:;" title="消息" onclick="opennoticeSou(this)"><span class="fa fa-comments"></span></a>
								<ul class="dropdown-menu" role="menu" ></ul>
							  </li>
							  <li>
							  <li>
							<a  href="javascript:;" onclick="openbroadcast(this)" title="通知" > <span class="glyphicon glyphicon-globe"></span></a>
                          <ul class="dropdown-menu" role="menu"></ul> 
							  </li>
				
							  </li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
				<!-- 			隐私设置块
							 -->
                          <li>
                            <a href="javascript:;" onclick="openL(this)"><div style="width:10px;height:100%"><img src="<%=request.getContextPath()%>/resources/img/secret.png"></div></a>
                          <ul style="width:380px ;display:none;z-index:9999;position:absolute;top:60px;left:-350px;background:#3B5999" >
<li><a href="javascript:;" style="padding:0"><div style="background-color:#3b5998;">
<span class="glyphicon glyphicon-eye-close" style="padding-left:10px;padding-right:10px;color:white"></span>
<div style="display: inline-block;margin-left:10px">
<h5 style="color:white">隐私设置检查</h5>
</div>
<div style="display: inline-block;margin-left:145px">
<img src="<%=request.getContextPath()%>/resources/img/secretcheck.png" style="margin-top:-90px">
</div>
</div></a></li>
<li> <a href="#demo" style="padding:0" data-toggle="collapse"><span class="glyphicon glyphicon-globe" style="padding-left:10px;padding-right:10px"></span>
<div style="display:inline-block">
<h5>谁能看我的资料？</h5>
</div>
<div style="display: inline-block;margin-left:50%">
<span class="caret"></span>

</div>
</a>
<div id="demo" class="collapse">

<ul style="padding:0;margin:0">

<li class="yinsi">
<i class="fa fa-shield"></i> 
<div class="zuobian" >
<p>谁以后可以看见我的帖子</p>
<div class="dropdown pull-left" style="margin-right:2px">
<button class="btn btn-sm dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
<span class="glyphicon glyphicon-globe">公开</span>
<span class="caret"></span>
</button>
<ul class="dropdown-menu" aria-labelledby="dropdownMenu1" id="timeline" style="color:darkgray;text-align:center">
<li><span class="glyphicon glyphicon-globe"><a href="javascript:;">公开</a></span></li>
<li><span class="fa fa-user"><a href="javascript:;">好友</a></span>
</li>
<li><span class="fa  fa-unlock-alt"><a href="javascript:;">仅限自己</a></span></li>
</ul>
</div>
</div>
</li>
<li class="yinsi">
<i class="fa fa-eye"></i>
<div class="zuobian">
<p>其他人在我的时间线上能看见什么？</p>
<a href="http://localhost:8080/fasebooke/user/${current_user.fuid}/${current_user.fuid}.action" style="display:block;margin:10px">访客视图</a>
</div>
</li>

</ul>

</div>

</li>
<li><a href="#demo2"style="padding:0" data-toggle="collapse"><span class="fa fa-group" style="padding-left:10px;padding-right:10px"></span>
<div style="display:inline-block">
<h5>谁能够联系我？</h5>
</div>
<div style="display: inline-block;margin-left:50%">
<span class="caret"></span>

</div>
</a>
<div id="demo2" class="collapse">

<ul style="padding:0;margin:0">

<li class="yinsi">
<i class="fa  fa-plus"></i> 
<div class="zuobian" >
<p>谁可以向我发送加好友请求？</p>
<div class="dropdown pull-left" style="margin-right:2px">
<button class="btn btn-sm dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
<span class="glyphicon glyphicon-globe">公开</span>
<span class="caret"></span>
</button>
<ul class="dropdown-menu" aria-labelledby="dropdownMenu1" id="befriend" style="color:darkgray;text-align:center">
<li>
<span class="glyphicon glyphicon-globe"><a href="javascript:;">公开</a></span></li>
<li>
<span class="fa  fa-users"><a href="javascript:;">好友的好友</a></span></li>
</ul>
</div>
</div>
</li>


</ul>

</div>
</li>

<li><a href="#demo3"style="padding:0" data-toggle="collapse"><span class="glyphicon glyphicon-minus-sign" style="padding-left:10px;padding-right:10px"></span> <div style="display:inline-block">
<h5>如何阻止他人骚扰我？</h5>
</div>
<div style="display: inline-block;margin-left:43%">
<span class="caret"></span>

</div></a>
<div id="demo3" class="collapse" style="margin-bottom:10px">

<ul style="padding:0;margin:0">

<li class="yinsi">
<i class="fa  fa-minus-circle"></i> 
<div class="zuobian" >
<p>你可以拉黑用户，进而解除与对方的好友关系，并阻止其与你沟通、或查看你时间线上的内容</p>
<input type="text" placeholder="输入名字或者邮箱"><button type="button" onclick="lahei(this)">拉黑</button>
</div>
</li>


</ul>

</div>

</li>
</ul>
                          </li>
                          
             <!-- 			隐私设置块
							                                    -->               
							  <li class="dropdown">
								<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-sort-desc"></i></a>
								<ul class="dropdown-menu">
			
								   <li  role="separator" class="divider"></li>
								  <li><a href="/fasebooke/user/out/${current_user.fuid}.action">退出</a></li>
								   <li  role="separator" class="divider"></li>
								  <li><a href="http://localhost:8080/fasebooke/user/helpcenter.action?fuid=${current_user.fuid}">帮助中心</a></li>
								</ul>
							  </li>
							</ul>
							</nav>
						</div>
						<!-- /top nav -->
					  <div class="full col-sm-12">
					  <div class="onthisday">
                     <div class="clearfix">
                      <div style="postion:relative;margin-left:-700px;margin-top:20px">
					      <div style="color: #000; -webkit-font-smoothing: antialiased; text-align: center;" id="m">
					           
					                                             
					      </div>
					      <div style="color: #ec4c60;font-size: 33px;text-align: center;" id="r">
                                                      
                                                              </div>
                                                               <script type="text/javascript">
					            var time = new Date( ); //获得当前时间
					      
					            var month = time.getMonth( )+1;
					            var day = time.getDate( ); 
					            $('#m').text(month+"月");
					            $('#r').text(day+"日");
					            console.log(month);
					            </script>
                                                              </div>
                                                              </div>
					  </div>
				</div>
			 <div class="col-sm-12">
			 <div class="content">
				  <div class="iw_wrapper">
				<ul class="iw_thumbs" id="iw_thumbs"> 
				<c:forEach items="${gaypic}" var="emp" varStatus="vs">
				<c:if test="${! empty emp.pictures }">
				<c:forEach items="${emp.pictures}" var="pic" varStatus="vs">
				<c:if test="${! empty pic.picdescribe}">
				<li><img src="${pic.picdescribe }" data-img="${pic.picdescribe }" alt="${pic.pid}"/><div></div></li>
			</c:if>
			</c:forEach>
			</c:if>
				</c:forEach>
				</ul>
				</div> 
				<div id="iw_ribbon" class="iw_ribbon">
				<span class="iw_close"></span>
				<span class="iw_zoom">Click thumb to zoom</span>
			</div>
					</div>
					</div>
					<!-- /main -->
				  
				</div>
			</div>
		</div>


		<!--post modal-->
		<div id="postModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
		  <div class="modal-dialog">
		  <div class="modal-content">
			  <div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
					Update Status
			  </div>
			  <div class="modal-body">
				  <form class="form center-block">
					<div class="form-group">
					  <textarea class="form-control input-lg" autofocus="" placeholder="What do you want to share?"></textarea>
					</div>
				  </form>
			  </div>
			  <div class="modal-footer">
				  <div>
				  <button class="btn btn-primary btn-sm" data-dismiss="modal" aria-hidden="true">Post</button>
					<ul class="pull-left list-inline"><li><a href=""><i class="glyphicon glyphicon-upload"></i></a></li><li><a href=""><i class="glyphicon glyphicon-camera"></i></a></li><li><a href=""><i class="glyphicon glyphicon-map-marker"></i></a></li></ul>
				  </div>	
			  </div>
		  </div>
		  </div>
		</div>
        

        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/localsearch.js"></script>
           <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script> 
          <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.easing.1.3.js"></script> 
            <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.masonry.min.js"></script>
     <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js"></script>  
    <script type="text/javascript">
	$(window).load(function(){
		var $iw_thumbs			= $('#iw_thumbs'),
			$iw_ribbon			= $('#iw_ribbon'),
			$iw_ribbon_close	= $iw_ribbon.children('span.iw_close'),
			$iw_ribbon_zoom		= $iw_ribbon.children('span.iw_zoom');
			
			ImageWall	= (function() {
					// window width and height
				var w_dim,
				    // index of current image
					current				= -1,
					isRibbonShown		= false,
					isFullMode			= false,
					// ribbon / images animation settings
					ribbonAnim			= {speed : 500, easing : 'easeOutExpo'},
					imgAnim				= {speed : 400, easing : 'jswing'},
					// init function : call masonry, calculate window dimentions, initialize some events
					init				= function() {
						$iw_thumbs.imagesLoaded(function(){
							$iw_thumbs.masonry({
								isAnimated	: true
							});
						});
						getWindowsDim();
						initEventsHandler();
					},
					// calculate window dimentions
					getWindowsDim		= function() {
						w_dim = {
							width	: $(window).width(),
							height	: $(window).height()
						};
					},
					// initialize some events
					initEventsHandler	= function() {
						
						// click on a image
						$iw_thumbs.delegate('li', 'click', function() {
							if($iw_ribbon.is(':animated')) return false;
							
							var $el = $(this);
							
							if($el.data('ribbon')) {
								showFullImage($el);
							}
							else if(!isRibbonShown) {
								isRibbonShown = true;
								
								$el.data('ribbon',true);
								
								// set the current
								current = $el.index();
							
								showRibbon($el);
							}
						});
						
						// click ribbon close
						$iw_ribbon_close.bind('click', closeRibbon);
						
						// on window resize we need to recalculate the window dimentions
						$(window).bind('resize', function() {
									getWindowsDim();
									if($iw_ribbon.is(':animated'))
										return false;
									closeRibbon();
								 })
						         .bind('scroll', function() {
									if($iw_ribbon.is(':animated'))
										return false;
									closeRibbon();
								 });
						
					},
					showRibbon			= function($el) {
						var	$img	= $el.children('img'),
							$descrp	= $img.next();
						
						// fadeOut all the other images
						$iw_thumbs.children('li').not($el).animate({opacity : 0.2}, imgAnim.speed);
						
						// increase the image z-index, and set the height to 100px (default height)
						$img.css('z-index', 100)
							.data('originalHeight',$img.height())
							.stop()
							.animate({
								height 		: '100px'
							}, imgAnim.speed, imgAnim.easing);
						
						// the ribbon will animate from the left or right
						// depending on the position of the image
						var ribbonCssParam 		= {
								top	: $el.offset().top - $(window).scrollTop() - 6 + 'px'
							},
							descriptionCssParam,
							dir;
						
						if( $el.offset().left < (w_dim.width / 2) ) {
							dir = 'left';
							ribbonCssParam.left 	= 0;
							ribbonCssParam.right 	= 'auto';
						}
						else {
							dir = 'right';
							ribbonCssParam.right 	= 0;
							ribbonCssParam.left 	= 'auto';
						}
						
						$iw_ribbon.css(ribbonCssParam)
						          .show()
								  .stop()
								  .animate({width : '100%'}, ribbonAnim.speed, ribbonAnim.easing, function() {
										switch(dir) {
											case 'left' :
												descriptionCssParam		= {
													'left' 			: $img.outerWidth(true) + 'px',
													'text-align' 	: 'left'
												};
												break;
											case 'right' :	
												descriptionCssParam		= {
													'left' 			: '-200px',
													'text-align' 	: 'right'
												};
												break;
										};
										$descrp.css(descriptionCssParam).fadeIn();
										// show close button and zoom
										$iw_ribbon_close.show();
										$iw_ribbon_zoom.show();
								  });
						
					},
					// close the ribbon
					// when in full mode slides in the middle of the page
					// when not slides left
					closeRibbon			= function() {
						isRibbonShown 	= false
						
						$iw_ribbon_close.hide();
						$iw_ribbon_zoom.hide();
						
						if(!isFullMode) {
						
							// current wall image
							var $el	 		= $iw_thumbs.children('li').eq(current);
							
							resetWall($el);
							
							// slide out ribbon
							$iw_ribbon.stop()
									  .animate({width : '0%'}, ribbonAnim.speed, ribbonAnim.easing); 
								  
						}
						else {
							$iw_ribbon.stop().animate({
								opacity		: 0.8,
								height 		: '0px',
								marginTop	: w_dim.height/2 + 'px' // half of window height
							}, ribbonAnim.speed, function() {
								$iw_ribbon.css({
									'width'		: '0%',
									'height'	: '126px',
									'margin-top': '0px'
								}).children('img').remove();
							});
							
							isFullMode	= false;
						}
					},
					resetWall			= function($el) {
						var $img		= $el.children('img'),
							$descrp		= $img.next();
							
						$el.data('ribbon',false);
						
						// reset the image z-index and height
						$img.css('z-index',1).stop().animate({
							height 		: $img.data('originalHeight')
						}, imgAnim.speed,imgAnim.easing);
						
						// fadeOut the description
						$descrp.fadeOut();

						// fadeIn all the other images
						$iw_thumbs.children('li').not($el).animate({opacity : 1}, imgAnim.speed);								
					},
					showFullImage		= function($el) {
						isFullMode	= true;
						
						$iw_ribbon_close.hide();
						
						var	$img	= $el.children('img'),
							large	= $img.data('img'),
						
							// add a loading image on top of the image
							$loading = $('<span class="iw_loading"></span>');
						
						$el.append($loading);
						
						// preload large image
						$('<img/>').load(function() {
							var $largeImage	= $(this);
							
							$loading.remove();
							
							$iw_ribbon_zoom.hide();
							
							resizeImage($largeImage);
							
							// reset the current image in the wall
							resetWall($el);
							
							// animate ribbon in and out
							$iw_ribbon.stop().animate({
								opacity		: 1,
								height 		: '0px',
								marginTop	: '63px' // half of ribbons height
							}, ribbonAnim.speed, function() {
								// add the large image to the DOM
								$iw_ribbon.prepend($largeImage);
								
								$iw_ribbon_close.show();
								
								$iw_ribbon.animate({
									height 		: '100%',
									marginTop	: '0px',
									top			: '0px'
								}, ribbonAnim.speed);
							});
						}).attr('src',large);
							
					},
					resizeImage			= function($image) {
						var widthMargin		= 100,
							heightMargin 	= 100,
						
							windowH      	= w_dim.height - heightMargin,
							windowW      	= w_dim.width - widthMargin,
							theImage     	= new Image();
							
						theImage.src     	= $image.attr("src");
						
						var imgwidth     	= theImage.width,
							imgheight    	= theImage.height;
						console.log(imgwidth);
						console.log(imgheight);
						console.log(w_dim.height);
						console.log(w_dim.width);
						console.log(windowW);
						if((imgwidth > windowW) || (imgheight > windowH)) {
							if(imgwidth > imgheight) {
								var newwidth 	= windowW,
									ratio 		= imgwidth / windowW,
									newheight 	= imgheight / ratio;
									
								theImage.height = newheight;
								theImage.width	= newwidth;
								
								if(newheight > windowH) {
									var newnewheight 	= windowH,
										newratio 		= newheight/windowH,
										newnewwidth 	= newwidth/newratio;
								
									theImage.width 		= newnewwidth;
									theImage.height		= newnewheight;
								}
							}
							else {
								var newheight 	= windowH,
									ratio 		= imgheight / windowH,
									newwidth 	= imgwidth / ratio;
								
								theImage.height = newheight;
								theImage.width	= newwidth;
								
								if(newwidth > windowW) {
									var newnewwidth 	= windowW,
									    newratio 		= newwidth/windowW,
										newnewheight 	= newheight/newratio;
							
									theImage.height 	= newnewheight;
									theImage.width		= newnewwidth;
								}
							}
						}
							
						$image.css({
							'width'			: theImage.width + 'px',
							'height'		: theImage.height + 'px',
							'margin-left'	: -theImage.width / 2 + 'px',
							'margin-top'	: -theImage.height / 2 + 'px'
						});							
					};
					
				return {init : init};	
			})();
		
		ImageWall.init();
	});
        $(document).ready(function() {
			$('[data-toggle=offcanvas]').click(function() {
				$(this).toggleClass('visible-xs text-center');
				$(this).find('i').toggleClass('glyphicon-chevron-right glyphicon-chevron-left');
				$('.row-offcanvas').toggleClass('active');
				$('#lg-menu').toggleClass('hidden-xs').toggleClass('visible-xs');
				$('#xs-menu').toggleClass('visible-xs').toggleClass('hidden-xs');
				$('#btnShow').toggle();
			});
			  $(".comeon").mouseover(function(){
			        $(this).next().next().css("display",""); });});
        function commenthide(e){
            var parent=e.parentNode.parentNode.parentNode;
            parent.style="display:none";
                }
    

      </script>  
</body></html>