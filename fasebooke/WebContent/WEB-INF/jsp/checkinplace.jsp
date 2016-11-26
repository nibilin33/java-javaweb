<%@ page language="java" import="java.util.*,net.sf.json.*,com.fase.po.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import="org.springframework.web.util.UrlPathHelper" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
      
       <base href="<%=basePath%>">
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"> 
        <meta charset="utf-8">
        <title>fasebooke</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
   <link href="<%=request.getContextPath()%>/resources/css/facebook.css" rel="stylesheet" type="text/css"/>
         <link href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/facebook_128px_1160395_easyicon.net.ico"/>
      <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script> 
        <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=1994ba35a603f806df16000f3799b1da"></script>
   <style>
       body{font-size:14px;font-family:"微软雅黑";background:url("http://localhost:8080/img/face/2.jpg")top no-repeat;background-attachment:fixed;z-index:0;background-size:100%;}
       a{      color: black;
         }
         #box{ margin:50px auto; width:540px; min-height:400px; background:#FF9}
.box1{width:960px;height:auto;min-height: 800px; margin:5px auto;position:relative;z-index:1;background-color:rgba(0,0,0,0.075)}
/*内容发布区域*/
       #weizhi img{
           width: 225px;
           height: 225px;
            margin-left: 30%;
       }
    
        #map
        {
            position: relative;
            top:10px;
            margin: 25px;
            border: 1px solid #080808;
            right: 8px;
            bottom: 0;
        }
    
			input,
			textarea {
				padding: 9px;
				border: solid 1px #E5E5E5;
				outline: 0;
				font: normal 13px/100% Verdana, Tahoma, sans-serif;
				width: 200px;
				background: #FFFFFF url('bg_form.png') left top repeat-x;
				background: -webkit-gradient(linear, left top, left 25, from(#FFFFFF), color-stop(4%, #EEEEEE), to(#FFFFFF));
				background: -moz-linear-gradient(top, #FFFFFF, #EEEEEE 1px, #FFFFFF 25px);
				box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
				-moz-box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
				-webkit-box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
			}
			
			textarea {
				width: 400px;
				max-width: 400px;
				height: 150px;
				line-height: 150%;
			}
			
			input:hover,
			textarea:hover,
			input:focus,
			textarea:focus {
				border-color: #C9C9C9;
				-webkit-box-shadow: rgba(0, 0, 0, 0.15) 0px 0px 8px;
			}
			
			.form {
				margin-bottom: 1em;
			}
			
			.form label {
				margin-left: 10px;
				color: #999999;
			}
			
			.form input[type="button"] {
				margin-left: 4px;
			}
			
			.submit input {
				width: auto;
				padding: 9px 15px;
				background: #617798;
				border: 0;
				font-size: 14px;
				color: #FFFFFF;
				-moz-border-radius: 5px;
				-webkit-border-radius: 5px;
			}
			
			.haha {
				width: auto;
				font-size: 14px;
				background: #617798;
				border: 0;
				color: #FFFFFF;
				-moz-border-radius: 5px;
				-webkit-border-radius: 5px;
			}
   
</style>
    </head><body>
<!--head-->
   <div class="wrapper">
				<div style="width:100%" >
	<div class="navbar navbar-blue navbar-static-top" style="height:50px">  
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
                             <a href="http://localhost:8080/fasebooke/user/${current_user.fuid}.action">   <c:choose>
                             <c:when test="${!empty current_user.fheadimage}">
                             <img src="http://localhost:8080/img/${current_user.fuid}/${current_user.fheadimage}" style="border: 1px solid rgba(0, 0, 0, .1);width:24px;height:24px"><span>${current_user.fname}</span>
                            </c:when>
                            <c:otherwise>
                             <img src="http://localhost:8080/img/face/head_male_man_user_64px_1578_easyicon.net.png" style="border: 1px solid rgba(0, 0, 0, .1);width:24px;height:24px"><span>${current_user.fname}</span>
                            </c:otherwise>
                            </c:choose><span>${current_user.fname}</span>
                             </a>
                          </li>
							  <li>
								<a href="http://localhost:8080/fasebooke/user/show.action?fuid=${current_user.fuid }">
								<i class="glyphicon glyphicon-home"></i> 首页</a>
							  </li>
							  <li>
								<a href="#postModal" role="button" data-toggle="modal"><i class="glyphicon glyphicon-plus"></i> 好友请求</a>
							  </li>
							  <li>
							    
								<a href="javascript:;" title="消息" onclick="opennotice()" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="fa fa-comments"></span></a>
								<ul class="dropdown-menu" role="menu"> <li><a href="#">签到</a></li><li><a href="#">赞</a></li><li><a href="#">活动</a></li><li class="divider"></li><li><a href="#">更多。。</a></li></ul>
							  </li>
							  <li>
							  <li>
							<a  href="javascript:;" title="通知" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> <span class="glyphicon glyphicon-globe"></span></a>
                          <ul class="dropdown-menu" role="menu"> <li><a href="#">签到</a></li><li><a href="#">赞</a></li><li><a href="#">活动</a></li><li class="divider"></li><li><a href="#">更多。。</a></li></ul> 
							  </li>
				
							  </li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
                          <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="padding-bottom:0">
                            <div style="width:10px;height:30px;">
                            <img src="<%=request.getContextPath()%>/resources/img/secret.png">
                            </div></a>
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

<!--  headnext-->
  
 <div class="imagrap">
    <a href="" class="_30x-">
     <div  class="_30x">
         <span class="fa  fa-camera" style="color:white"></span>
         <span>添加封面照片</span>
     </div>
     </a>
     <img class="pic">
     <span style="color:white;font-size:30px;">NIBILIN</span>
 </div>
  <div class="container" style="margin-left:20%;min-height:41px">

  <div class="col-md-12">
<ul class="lead nav nav-pills">
  <li class="active">
  <a href="http://localhost:8080/fasebooke/user/${current_user.fuid}.action">时间线</a></li><li><a href="http://localhost:8080/fasebooke/jian/${current_user.fuid}/firstin.action">简介</a></li><li><a href="http://localhost:8080/fasebooke/friend/${current_user.fuid}/myfreind.action">好友</a></li><li><a href="http://localhost:8080/fasebooke/picture/${current_user.fuid}/fuck.action">照片</a></li> 
   <li><a href="http://localhost:8080/fasebooke/user/${current_user.fuid}/checkin.action">签到</a></li>
   </ul>
 
  </div>
  </div>


<!--   container-->
<div class="container">
     <div class="row">
         <div class="panel panel-default">
             <div class="panel-heading">
               <a href="javascript:;" onclick="showCityInfo()">   <i class="glyphicon glyphicon-map-marker" style="font-size:30px; color:gray"></i><span style="font-size:30px;color:gray">签到</span></a> 
            
             </div>
             <div class="panel-body">
                <form class="form" style="text-align:center">
                    <input type="text" style="width:380px;" id="SearchKey">
                    <div class="submit"  style="float:right;position:relative;right:26%">
                        <input type="button" value="查询" id="btn_Search" onclick="placeSearch()">
                    </div>
                </form>
          
               <div class="map" id="map">
                
                 </div>
                  
             </div>
           
    </div>
  
</div>
         </div>
<!--         模态-->
   	<div id="postModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true" >
		  <div class="modal-dialog">
		
		  <div class="modal-content">
		  <div class="modal-header">
		       <i class="glyphicon glyphicon-map-marker"></i><span>你的位置</span>
		       <label id="weizhi"></label>
		  </div>
			  <div class="modal-body">
	            
	             <div style="text-align:center;" >
	                 <img src="" id="weizhiimg" style="height:190px;width:190px">
	             </div>
			    
				   <form class="form"style="height:40px;text-align:center">
                      <select class="haha input-sm" style="margin-top:10px">
                          <option>公开</option>
                            <option>好友</option>
                              <option>仅自己</option>
                      </select>
				  <button class="btn  haha input-sm" data-dismiss="modal" aria-hidden="true" onclick="fabu()">发&nbsp;布</button>
					 <button class="btn  haha input-sm" data-dismiss="modal" aria-hidden="true">取&nbsp;消</button>
                  </form>
			
		  </div>
		  </div>
		</div>
      </div>
 </div>
 </div>

		
		
		
		
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/localsearch.js"></script> 
        <script type="text/javascript">
        
        var marker;
                  var geolocation;
                  var result;
              var windowsArr;
              var toolBar = null;
              var overView;
              var editorTool;
              var map = new AMap.Map("map", {
                  resizeEnable: true,zoom:12
              });
              map.plugin(["AMap.ToolBar"], function () {
                  toolBar = new AMap.ToolBar();
                  map.addControl(toolBar);
              });
                  console.log(map);
              //在地图中添加鹰眼插件
              map.plugin(["AMap.OverView"], function () {
                  //加载鹰眼
                  //初始化隐藏鹰眼
                  overView = new AMap.OverView({
                      visible: true
                  });
                  map.addControl(overView);
              });
              //添加地图类型切换插件
              map.plugin(["AMap.MapType"], function () {
                  //地图类型切换
                  var mapType = new AMap.MapType({
                      defaultType: 0, //默认显示卫星图
                      showRoad: true //叠加路网图层
                  });
                  map.addControl(mapType);
              });
              //加载比例尺插件
              map.plugin(["AMap.Scale"], function () {
                  scale = new AMap.Scale();
                  map.addControl(scale);
              });
              //基本地图加载
              function placeSearch() {
                  map = new AMap.Map("map", {
                      resizeEnable: true
                  });
                  map.plugin(["AMap.ToolBar"], function () {
                      toolBar = new AMap.ToolBar();
                      map.addControl(toolBar);
                  });
                  //在地图中添加鹰眼插件
                  map.plugin(["AMap.OverView"], function () {
                      //加载鹰眼
                      //初始化隐藏鹰眼
                      overView = new AMap.OverView({
                          visible: true
                      });
                      map.addControl(overView);
                  });
                  //添加地图类型切换插件
                  map.plugin(["AMap.MapType"], function () {
                      //地图类型切换
                      var mapType = new AMap.MapType({
                          defaultType: 0, //默认显示卫星图
                          showRoad: true //叠加路网图层
                      });
                      map.addControl(mapType);
                  });
                  //加载比例尺插件
                  map.plugin(["AMap.Scale"], function () {
                      scale = new AMap.Scale();
                      map.addControl(scale);
                  });
                  //设置多边形的属性
                  var polygonOption = {
                      strokeColor: "#0000ff",
                      strokeOpacity: 1,
                      strokeWeight: 3
                  };
                  var polygonArr;
                  //在地图中添加MouseTool插件
                  map.plugin(["AMap.MouseTool"], function () {
                      var mouseTool = new AMap.MouseTool(map);
                      //使用鼠标工具绘制多边形
                      mouseTool.polygon(polygonOption);
                      AMap.event.addListener(mouseTool, "draw", function (e) {
                          //obj属性就是绘制完成的覆盖物对象
                          var drawObj = e.obj;
                          //获取节点个数
                          var pointsCount = e.obj.getPath().length;
                          polygonArr = new Array(); //构建多边形经纬度坐标数组
                          for (var i = 0; i < pointsCount; i++) {
                              polygonArr.push(new AMap.LngLat(e.obj.getPath()[i].lng, e.obj.getPath()[i].lat));
                          }
                          var polygon = new AMap.Polygon({
                              map: map,
                              path: polygonArr,
                              fillColor: "#f5deb3",
                              fillOpacity: 0.35
                          });
                          //添加编辑控件
                          map.plugin(["AMap.PolyEditor"], function () {
                              editorTool = new AMap.PolyEditor(map, polygon);
                          });
                      });
                  });
                  marker = new Array();
                  windowsArr = new Array();
                  var searchKey = document.getElementById("SearchKey").value;
                  var MSearch;
                  AMap.service(["AMap.PlaceSearch"], function () {
                      MSearch = new AMap.PlaceSearch({ //构造地点查询类
                          pageSize: 10,
                          pageIndex: 1,
                          city: "021" //城市
                      });
                      //关键字查询
                      MSearch.search(searchKey, function (status, result) {
                          if (status === 'complete' && result.info === 'OK') {
                              keywordSearch_CallBack(result);
                          }
                      });
                  });
              }
              function edditpolygon() {
                  editorTool.open();
              }
              function endEddit() {
                  editorTool.close();
              }
              //添加marker&infowindow   
              function addmarker(i, d) {
                  var lngX = d.location.getLng();
                  var latY = d.location.getLat();
                  var markerOption = {
                      map: map,
                      icon: "http://webapi.amap.com/images/" + (i + 1) + ".png",
                      position: new AMap.LngLat(lngX, latY),
                      topWhenMouseOver: true
                  };
                  var mar = new AMap.Marker(markerOption);
                  marker.push(new AMap.LngLat(lngX, latY));
                  var infoWindow = new AMap.InfoWindow({
                      content: "<h3><font color=\"#00a6ac\">  " + (i + 1) + ". " + d.name + "</font></h3>" + TipContents(d.type, d.address, d.tel),
                      size: new AMap.Size(300, 0),
                      autoMove: true,
                      offset: new AMap.Pixel(0, -20)
                  });
                  windowsArr.push(infoWindow);
                  var aa = function (e) { infoWindow.open(map, mar.getPosition()); };
                  AMap.event.addListener(mar, "mouseover", aa);
              }
              //回调函数
              function keywordSearch_CallBack(data) {
                  var resultStr = "";
                  var poiArr = data.poiList.pois;
                  var resultCount = poiArr.length;
                  for (var i = 0; i < resultCount; i++) {
                      resultStr += "<div id='divid" + (i + 1) + "' onmouseover='openMarkerTipById1(" + i + ",this)' onmouseout='onmouseout_MarkerStyle(" + (i + 1) + ",this)' style=\"font-size: 12px;cursor:pointer;padding:0px 0 4px 2px; border-bottom:1px solid #C1FFC1;\"><table><tr><td><img src=\"http://webapi.amap.com/images/" + (i + 1) + ".png\"></td>" + "<td><h3><font color=\"#00a6ac\">名称: " + poiArr[i].name + "</font></h3>";
                      resultStr += TipContents(poiArr[i].type, poiArr[i].address, poiArr[i].tel) + "</td></tr></table></div>";
                      addmarker(i, poiArr[i]);
                  }
                  map.setFitView();
              }
              function TipContents(type, address, tel) {  //窗体内容
                  if (type == "" || type == "undefined" || type == null || type == " undefined" || typeof type == "undefined") {
                      type = "暂无";
                  }
                  if (address == "" || address == "undefined" || address == null || address == " undefined" || typeof address == "undefined") {
                      address = "暂无";
                  }
                  if (tel == "" || tel == "undefined" || tel == null || tel == " undefined" || typeof address == "tel") {
                      tel = "暂无";
                  }
                  var str = "  地址：" + address + "<br />  电话：" + tel + " <br />  类型：" + type;
                  return str;
              }
              function openMarkerTipById1(pointid, thiss) {  //根据id 打开搜索结果点tip
                  thiss.style.background = '#CAE1FF';
                  windowsArr[pointid].open(map, marker[pointid]);
              }
              function onmouseout_MarkerStyle(pointid, thiss) { //鼠标移开后点样式恢复
                  thiss.style.background = "";
              }
          
      function showCityInfo() {  //IP定位
          //加载IP定位插件
          map.plugin(["AMap.CitySearch"], function() {
              //实例化城市查询类
              var citysearch = new AMap.CitySearch();
          
              //自动获取用户IP，返回当前城市
              citysearch.getLocalCity();
            
              AMap.event.addListener(citysearch, "complete", function(result){
                  if(result && result.city && result.bounds) {
                      var cityinfo = result.city;
                      var citybounds = result.bounds;
                   /*  $("#weizhi").append("<img src='assets/img/'"+cityinfo+".jpg'>"); */
                        $("#weizhi").text(cityinfo);
                        var x="http://localhost:8080/img/city/"+cityarray[$('#weizhi').text()];
                        $('#weizhiimg').attr("src",x);	
                     console.log(cityinfo);
                      //地图显示当前城市
                      map.setBounds(citybounds);
                  }
                  else {
                    console.log(result.info);
                  }
              });
              $("#postModal").modal("show");
              AMap.event.addListener(citysearch, "error", function(result){alert(result.info);});
          });
      }
      function onComplete (data) {   //解析定位结果
          console.log(data.position.getLng());
         
      };
      function onError (data) {    //解析定位错误信息ta
          console.log(data.info);
        
      };
        function dimiss(){
            console.log("dddddddd");
          $('.parentFileBox').remove();
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
	  $(".comeon").mouseover(function(){
	        $(this).next().next().css("display","");
	    });
	  $('.collapse.in').prev('.panel-heading').addClass('active');
	  $('#accordion, #bs-collapse')
		.on('show.bs.collapse', function(a) {
		  $(a.target).prev('.panel-heading').addClass('active');
		})
		.on('hide.bs.collapse', function(a) {
		  $(a.target).prev('.panel-heading').removeClass('active');
		});
    	
	}); 
	
    </script>
</body>
</html>