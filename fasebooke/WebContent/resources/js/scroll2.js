var fuid=localStorage.getItem("current_id"); 
$(function(){
	var post = false;
	var totalheight = 0;
	$(window).scroll(function(){
		console.log($(window).scrollTop());
		console.log(document.body.scrollHeight);
		console.log(document.body.offsetHeight);
   if($(window).scrollTop() + document.body.offsetHeight >= document.body.scrollHeight){
	    	if(post)
	    		return;
	    	post = true;
	    	var page = $('#main');
	    	console.log($(".panel .panel-default").length);
	    	console.log("载入新内容");
	    	var l=$(".panel .panel-default").length;
	 
	    		$.ajax({
		    		 url:"/fasebooke/user/"+fuid+"/lineadd.action",
		    	        type:"POST",
		    	        data:"offset="+l,
		    	        dataType:"json",
		    	        success:function(message){
		    	        	var neirong=message["dinfo"];
		    	           for(var i=0;i<neirong.length;i++){
		    	        	   console.log(neirong[i]);
		    	        	   $(page).append('<div class="b"></div>');
			    	           	var main = document.createElement("div");
			    	           	main.className = "panel panel-default";
			    	           	$(page).append($(main));
			    	        	if(neirong[i].imagehead == "")
			    	        		neirong[i].imagehead = "http://localhost:8080/img/face/head_male_man_user_64px_1578_easyicon.net.png";
			    	           	$(main).append('<div class="panel-heading"><div class="_commentimg"><img src="'+neirong[i].imagehead+'" style="height:50px;width:50px;border:1px solid #eee"></div><div class="_commentnav"><h5>'+neirong[i].fname+'</h5><span>'+(1900+neirong[i].sendtime.year)+'-'+neirong[i].sendtime.month+'-'+neirong[i].sendtime.date+'</span></div></div>');
			    	           	var dongtai = document.createElement("div");
			    	        	dongtai.id="pane"+neirong[i].did;
			    	        	dongtai.className = "panel-body";
			    	        	$(main).append($(dongtai));
			    	        	$(dongtai).append('<script>var sendwords="'+neirong[i].sendwords+'";var sendimage="";var dataid="pane'+neirong[i].did+'";jiexi(sendwords,dataid,sendimage);</script>');
			    	        	$(dongtai).append('<div class="clearfix"></div><hr><div style="display:inline-flex"><a href="javascript:;" style="font-size:26px;" class="comeon"><span class="glyphicon glyphicon-thumbs-up" style="font-size:26px;padding-left:10px;padding-right:30px"></span>赞</a><a href="javascript:;" onclick="commentshow(this)" data="121" style="font-size:26px;"><span class="glyphicon glyphicon-comment" style="font-size:26px;padding-left:10px;padding-right:30px"></span>评论</a><div class="_dianzan" style="margin-left: 2px; display: none;" id="wobujianle" onmouseover="'+"this.style.display=''"+'" onmouseout="'+"this.style.display='none'"+'"><img src="/fasebooke/resources/img/haha.png" onclick="imgChoose(this)"><img src="/fasebooke/resources/img/angr.png" onclick="imgChoose(this)"><img src="/fasebooke/resources/img/love.png" onclick="imgChoose(this)"><img src="/fasebooke/resources/img/sad.png" onclick="imgChoose(this)"><img src="/fasebooke/resources/img/wow.png" onclick="imgChoose(this)"><img src="/fasebooke/resources/img/zan.png" onclick="imgChoose(this)"></div></div><hr><div class="_sb"><div class="_leavemood overcom" id="linshizhanyong"></div></div>');
			    				$(".comeon").mouseover(function(){
			    					$(this).next().next().css("display",""); });
			    	        	for(var j = 0; j < neirong[i].dianzan.length && j < 3; j++)
			    	        		$('#linshizhanyong').append('<img src="http://localhost:8080/img/face/'+neirong[i].dianzan[j].emotion+'">');
			    	        	$('#linshizhanyong').append('<span style="display: block">共'+neirong[i].dianzan.length+'人赞了你</span>');
			    	        	$('#linshizhanyong').attr('id','leavemoods');
			    	        	$(dongtai).append('<div style="display: none;"><div class="panel panel-default" style="display: block;"><div class="panel-body" id="linshizhanyong"><div class="clearfix"></div></div><div class="panel-footer" style="text-align:center"><a href="javascript:;" onclick="commenthide(this)"><i class="glyphicon glyphicon-chevron-up"></i></a></div></div></div>');
			    	        	$(dongtai).append('<div class="input-group"><div class="input-group-btn"><a href="javascript:;" onclick="postcomment(this)" class="btn btn-default"><span class="fa fa-smile-o"></span></a></div><div><input class="form-control" style="display:inline;" placeholder="Add a comment.." type="text"><a href="javascript:;" class="btn btn-default" style="display:inline;float:right;position: relative;margin-top:-34px;" onclick="realsend(this)" data-id="'+neirong[i].did+'"><i class="glyphicon glyphicon-share"></i></a></div></div>');
			    	        		scrollpinglun($("#linshizhanyong"),neirong[i].tcomment);
			    	        	$("#linshizhanyong").removeAttr('id');
		    	           }
		    	        	post=false;
		    	        }
		    	});
	      
	    }
	});
});
function scrollpinglun(e,p){
	if(p == undefined)
		return;
	console.log(e.attr('id'));
	for(var i = 0; i < p.length; i++){
		if(e.attr('id') != 'linshizhanyong')
			var huifu = p[i].replyCustomer.fname+'回复'+p[i].customer.fname+':';
		else
			var huifu = p[i].customer.fname+':';
			
		e.append('<div class="overcom" id="linshiID"><img src="'+p[i].customer.fheadimage+'" data="'+p[i].customer.fuid+'" style="border: 1px solidrgba(0,0,0,.1);width:24px;height:24px">'+huifu+'<script>var sendwords="'+p[i].content+'";var dataid="pinlun'+p[i].id+'";jiexi(sendwords,dataid,"");</script><span style="font-size:2px;">'+p[i].commetTime+'</span><a href="javascript:;" style="float:right" onclick="huifu(this)" data="'+p[i].id+'" parent-data="'+p[i].fuid+'">回复</a></div>');
		if(e.attr('id') == 'linshizhanyong')
			scrollpinglun($('#linshiID'), p.tcomment);
		else
			scrollpinglun(e, p.tcomment);
		$('#linshiID').attr('id','pinlun'+p[i].id);
	}
	console.log(e);
	console.log(p);
}