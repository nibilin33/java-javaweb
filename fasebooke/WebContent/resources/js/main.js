var fid=localStorage.getItem("current_id");
var headimage= localStorage.getItem("current_head");

$(document).ready(function(){
	
/*	$('.friend').each(function () {
	$(this).click(function () {
		var childOffset = $(this).offset();
		var parentOffset = $(this).parent().parent().offset();
		var childTop = childOffset.top - parentOffset.top;
		var clone = $(this).find('img').eq(0).clone();
		var top = childTop + 12 + 'px';
		$(clone).css({ 'top': top }).addClass('floatingImg').appendTo('#chatbox');
		setTimeout(function () {
			$('#profile p').addClass('animate');
			$('#profile').addClass('animate');
		}, 100);
		setTimeout(function () {
			$('#chat-messages').addClass('animate');
			$('.cx, .cy').addClass('s1');
			setTimeout(function () {
				$('.cx, .cy').addClass('s2');
			}, 100);
			setTimeout(function () {
				$('.cx, .cy').addClass('s3');
			}, 200);
		}, 150);
		$('.floatingImg').animate({
			'width': '68px',
			'left': '108px',
			'top': '20px'
		}, 200);
		var name = $(this).find('p strong').html();
		var email = $(this).find('p span').html();
		$('#profile p').html(name);
		$('#profile span').html(email);
		$('.message').not('.right').find('img').attr('src', $(clone).attr('src'));
		$('#friendslist').fadeOut();
		$('#chatview').fadeIn();
		$('#close').unbind('click').click(function () {
			$('#chat-messages, #profile, #profile p').removeClass('animate');
			$('.cx, .cy').removeClass('s1 s2 s3');
			$('.floatingImg').animate({
				'width': '40px',
				'top': top,
				'left': '12px'
			}, 200, function () {
				$('.floatingImg').remove();
			});
			setTimeout(function () {
				$('#chatview').fadeOut();
				$('#friendslist').fadeIn();
			}, 50);
		});
	});
});*/
	
	$('#timeline').on('click','a',function(){

		var addp=$(this).parent().parent().parent().prev();
		var tale=$(addp).children()[0];
			var cl=$($(this).parent()).attr('class');
	   		
	   		$(tale).attr("class",cl);
	   			var value=$(this).text();
	   			$(tale).text(value);
			var settime={
					"fuid":fid,
					"ftimeline":value
			};
			 $.ajax({
				    url:'/fasebooke/user/upsetting.action',
				    type:'post'	,
				    contentType:"application/json",
				    data:JSON.stringify(settime),
				    success:function(message){
				    	console.log(message);
				    }
				    });
		   
		});
	$('#gallary').on('click','a',function(){

		var addp=$(this).parent().parent().parent().prev();
		var tale=$(addp).children()[0];
			var cl=$($(this).parent()).attr('class');
	   		
	   		$(tale).attr("class",cl);
	   			var value=$(this).text();
	   			$(tale).text(value);
		});
	$('#befriend').on('click','a',function(){

		var addp=$(this).parent().parent().parent().prev();
		var tale=$(addp).children()[0];
			var cl=$($(this).parent()).attr('class');
	   		
	   		$(tale).attr("class",cl);
	   			var value=$(this).text();
	   			$(tale).text(value);
			var settime={
					"fuid":fid,
					"fbefriend":value
			};
			 $.ajax({
				    url:'/fasebooke/user/upsetting.action',
				    type:'post'	,
				    contentType:"application/json",
				    data:JSON.stringify(settime),
				    success:function(message){
				    	console.log(message);
				    }
				    });
		   
		});

	jQuery.extend({

	    createUploadIframe: function(id, uri)
		{
				//create frame
	            var frameId = 'jUploadFrame' + id;
	            
	            if(window.ActiveXObject) {
	                var io = document.createElement('<iframe id="' + frameId + '" name="' + frameId + '" />');
	                if(typeof uri== 'boolean'){
	                    io.src = 'javascript:false';
	                }
	                else if(typeof uri== 'string'){
	                    io.src = uri;
	                }
	            }
	            else {
	                var io = document.createElement('iframe');
	                io.id = frameId;
	                io.name = frameId;
	            }
	            io.style.position = 'absolute';
	            io.style.top = '-1000px';
	            io.style.left = '-1000px';

	            document.body.appendChild(io);

	            return io			
	    },
	    createUploadForm: function(id, fileElementId)
		{
			//create form	
			var formId = 'jUploadForm' + id;
			var fileId = 'jUploadFile' + id;
			var form = $('<form  action="" method="POST" name="' + formId + '" id="' + formId + '" enctype="multipart/form-data"></form>');	
			var oldElement = $('#' + fileElementId);
			var newElement = $(oldElement).clone();
			$(oldElement).attr('id', fileId);
			$(oldElement).before(newElement);
			$(oldElement).appendTo(form);
			//set attributes
			$(form).css('position', 'absolute');
			$(form).css('top', '-1200px');
			$(form).css('left', '-1200px');
			$(form).appendTo('body');		
			return form;
	    },

	    ajaxFileUpload: function(s) {
	        // TODO introduce global settings, allowing the client to modify them for all requests, not only timeout		
	        s = jQuery.extend({}, jQuery.ajaxSettings, s);
	        var id = s.fileElementId;        
			var form = jQuery.createUploadForm(id, s.fileElementId);
			var io = jQuery.createUploadIframe(id, s.secureuri);
			var frameId = 'jUploadFrame' + id;
			var formId = 'jUploadForm' + id;		
	        // Watch for a new set of requests
	        if ( s.global && ! jQuery.active++ )
			{
				jQuery.event.trigger( "ajaxStart" );
			}            
	        var requestDone = false;
	        // Create the request object
	        var xml = {}   
	        if ( s.global )
	            jQuery.event.trigger("ajaxSend", [xml, s]);
	        // Wait for a response to come back
	        var uploadCallback = function(isTimeout)
			{			
				var io = document.getElementById(frameId);
	            try 
				{				
					if(io.contentWindow)
					{
						 xml.responseText = io.contentWindow.document.body?io.contentWindow.document.body.innerHTML:null;
	                	 xml.responseXML = io.contentWindow.document.XMLDocument?io.contentWindow.document.XMLDocument:io.contentWindow.document;
						 
					}else if(io.contentDocument)
					{
						 xml.responseText = io.contentDocument.document.body?io.contentDocument.document.body.innerHTML:null;
	                	xml.responseXML = io.contentDocument.document.XMLDocument?io.contentDocument.document.XMLDocument:io.contentDocument.document;
					}						
	            }catch(e)
				{
					jQuery.handleError(s, xml, null, e);
				}
	            if ( xml || isTimeout == "timeout") 
				{				
	                requestDone = true;
	                var status;
	                try {
	                    status = isTimeout != "timeout" ? "success" : "error";
	                    // Make sure that the request was successful or notmodified
	                    if ( status != "error" )
						{
	                        // process the data (runs the xml through httpData regardless of callback)
	                        var data = jQuery.uploadHttpData( xml, s.dataType );    
	                        // If a local callback was specified, fire it and pass it the data
	                        if ( s.success )
	                            s.success( data, status );
	    
	                        // Fire the global callback
	                        if( s.global )
	                            jQuery.event.trigger( "ajaxSuccess", [xml, s] );
	                    } else
	                        jQuery.handleError(s, xml, status);
	                } catch(e) 
					{
	                    status = "error";
	                    jQuery.handleError(s, xml, status, e);
	                }

	                // The request was completed
	                if( s.global )
	                    jQuery.event.trigger( "ajaxComplete", [xml, s] );

	                // Handle the global AJAX counter
	                if ( s.global && ! --jQuery.active )
	                    jQuery.event.trigger( "ajaxStop" );

	                // Process result
	                if ( s.complete )
	                    s.complete(xml, status);

	                jQuery(io).unbind()

	                setTimeout(function()
										{	try 
											{
												$(io).remove();
												$(form).remove();	
												
											} catch(e) 
											{
												jQuery.handleError(s, xml, null, e);
											}									

										}, 100)

	                xml = null

	            }
	        }
	        // Timeout checker
	        if ( s.timeout > 0 ) 
			{
	            setTimeout(function(){
	                // Check to see if the request is still happening
	                if( !requestDone ) uploadCallback( "timeout" );
	            }, s.timeout);
	        }
	        try 
			{
	           // var io = $('#' + frameId);
				var form = $('#' + formId);
				$(form).attr('action', s.url);
				$(form).attr('method', 'POST');
				$(form).attr('target', frameId);
	            if(form.encoding)
				{
	                form.encoding = 'multipart/form-data';				
	            }
	            else
				{				
	                form.enctype = 'multipart/form-data';
	            }			
	            $(form).submit();

	        } catch(e) 
			{			
	            jQuery.handleError(s, xml, null, e);
	        }
	        if(window.attachEvent){
	            document.getElementById(frameId).attachEvent('onload', uploadCallback);
	        }
	        else{
	            document.getElementById(frameId).addEventListener('load', uploadCallback, false);
	        } 		
	        return {abort: function () {}};	

	    },

	    uploadHttpData: function( r, type ) {
	        var data = !type;
	        data = type == "xml" || data ? r.responseXML : r.responseText;
	        // If the type is "script", eval it in global context
	        if ( type == "script" )
	            jQuery.globalEval( data );
	        // Get the JavaScript object, if JSON is used.
	        if ( type == "json" )
	            eval( "data = " + data );
	        // evaluate scripts within html
	        if ( type == "html" )
	            jQuery("<div>").html(data).evalScripts();
				//alert($('param', data).each(function(){alert($(this).attr('value'));}));
	        return data;
	    }
	});


   $("#ispublic").on("click","a",function(event){
       var ta=event.target;
    var x=document.getElementById("isvisiable");
       x.value=ta.innerHTML;
       var xx=document.getElementById("fuid").value;
    
   		var addp=$(this).parent().parent().parent().prev();
   		var cl=$($(this).parent()).attr('class');
   	
   		var tale=$(addp).children()[0];
   		console.log(tale);
   		$(tale).attr("class",cl);
   			var value=$(this).text();
   			$(tale).text(value);
   			
   });
/*   window.fuid=document.getElementById("fuid").value;*/
  $("#result").on('click',"a",function(event){
	  var ta=event.target;
	  var t=$(ta).attr('data');
	  
	  $.ajax({
		  url:"/fasebooke/fdynamiccontrol/delete.action?fid="+t+"&uid="+fuid,
          type:"get",
          dataType:"text",
          success:function(message){
        	 var x= document.getElementById(t);
        	x.parentNode.removeChild(x);
          }
	  });
  });
  
});
/*遮罩*/   
/*<div class="wrapper">
<div id="mask" class="mask"></div> 
<div class="box">*/
function showMask(){     
    $("#mask").css("height",$(document).height());     
    $("#mask").css("width",$(document).width());     
    $("#mask").show();     
}  
//隐藏遮罩层  
function hideMask(){     
      
    $("#mask").hide();     
} 
var no;
function openbroadcast(e){
	if($(e).parent().attr("class")=="open"){
		$(e).parent().removeClass("open");
		return;
	}
	$(e).parent().addClass("open");
	  $.ajax({
	        url:"/fasebooke/nofican/o.action",
	        type:"POST",
	        data:"fuid="+fid,
	        dataType:"json",
	        success:function(message){
	        	console.log(message);
	     	   no=message["nti"];
	        	ul = $(e).next();
	        	ul.empty();
	        	if(no.length>4){
	        	for(var i = 0; i <4; i++){
	      ul.append('<li fuid="'+no[i].fuid+'" nid="'+no[i].nid+'" style="color:gray;text-align:center;width:200px;cursor:default"><p>'+no[i].note+'</p><button class="btn btn-default" onclick="readNOti(this)"><i class="glyphicon glyphicon-ok-circle" style="color:gray"></i>未读</button></li>');
	              
	        }
	        	
	                 ul.append('<a href="javascript:;" onclick="askmore(this)"><span class="glyphicon glyphicon-hand-down" style="color:gray;font-size:20px;position:relative;left:87px"></span><a>');
	        }else{
	        	for(var i=0;i<no.length;i++){
	        	    ul.append('<li fuid="'+no[i].fuid+'" nid="'+no[i].nid+'" style="color:gray;text-align:center;width:200px;cursor:default"><p>'+no[i].note+'</p><button class="btn btn-default" onclick="readNOti(this)"><i class="glyphicon glyphicon-ok-circle" style="color:gray"></i>未读</button></li>');
	        	}
	        }
	        }
	        });
	
}
function askmore(e){
	$(e).parent().parent().addClass("open");
	for(var i=4;i<no.length;i++){
		console.log(no[i]);
		$(e).parent().append('<li fuid="'+no[i].fuid+'" nid="'+no[i].nid+'" style="color:gray;text-align:center;width:200px;cursor:default"><p>'+no[i].note+'</p><button class="btn btn-default" onclick="readNOti(this)"><i class="glyphicon glyphicon-ok-circle" style="color:gray"></i>未读</button></li>');
	}
}
function readNOti(e){
	var noid=$(e).parent().attr("nid");
	var nofican={"nid":noid,"isread":1};
	$(e).parent().remove();
	$.ajax({
        url:"/fasebooke/nofican/read.action",
        type:"POST",
        contentType:"application/json",
        data:JSON.stringify(nofican),
        dataType:"text",
        success:function(message){
        	console.log(message);
        }
        });
	
}
function addask(e){  
	
    var that=e;
    var sid=$(e).attr("data");
    var fid=localStorage.getItem("current_id");
    var time=new Date().getTime();
   
    var obj={"fuid":fid,"ffid":sid,"asktime":time,"asktype":0};
    $.ajax({
        url:"/fasebooke/aska/aa.action",
        type:"POST",
        contentType:"application/json",
        data:JSON.stringify(obj),
        dataType:"text",
        success:function(message){
                $(that).hide();
        }
        
    });
   
}
function doemail(){
	var da=new Date();
	var  title=$('#biaoti').val();
	var reci=$('#recievename').val();
	var context=$('#neirong').val();
	var file=$('#as input[type=hidden]');
	var contents="";
	if(file!=undefined){
	for(var i=0;i<file.length;i++){
		contents+=$(file[i]).val();
	}
	}
	console.log(contents);
	var email={"fuid":fid,"ffid":reci,"senttime":da,"contenti":context,"plusfile":contents		
	};
	
	$.ajax({
        
        url:"/fasebooke/email/sendEmail.action",
        type:"post",
        contentType:"application/json",
        data:JSON.stringify(email),
        success:function(message){
        	$('#biaoti').val("");
        	$('#recievename').val("");
        	$('#neirong').val("");
        var s=$('#as input[type=hidden]');
         for(var i=0;i<s.length;i++){
        	 console.log(s[i]);
        	 $(s[i]).remove();
         }
        
         $($('#as').next()).remove();
         
        }
    });
}
function dwfile(e){
	var filename=$(e).text();
	var file=filename.split('"').join('');
	console.log(file);
	$.post("/fasebooke/email/download.action?fileName="+"-"+file);
}
function imgChoose(e){
	  var test = /([^\/]*?\.png)/i;
	 var s=e.parentNode;
    var t=s.parentNode;
    var y=t.nextElementSibling;
    var z=y.nextElementSibling;
    var target=z.firstElementChild;
 var sp= $(target).find("span");
    var fid=localStorage.getItem("current_id");
    var b= e.src;
    var name=b.match(test)[0];
  var im=document.createElement("img");
    im.setAttribute("src","http://localhost:8080/img/face/"+name);
  
    $(target).prepend($(im));
    var data=$(e).parent().parent().next().next().next().next();
  
    var tar=data[0];
    var d=$(tar).children();
    var dd=d.children();
   var ddd=dd[2];
    var daid=$(ddd).attr("data-id");
    var comment={"did":daid,"emotion":name,"fname":fid};
    $.ajax({  
        url:"/fasebooke/user/zan.action",
        type:"post",
        contentType:"application/json",
        data:JSON.stringify(comment),
        success:function(message){
       /*    zan总数*/
        	 $(sp).text("共"+message+"人赞了 你");
        	 $(sp).addClass("bounce animated");
        	 setTimeout(function(){
        		 $(sp).removeClass("bounce animated");
        	 }, 1000);
        }
    });
 }
function opennotice(e){ /*  打开通知*/
	if($(e).parent().attr("class")=="open"){
		$(e).parent().removeClass("open");
		return;
	}
	
	$(e).parent().addClass("open");
	  var fid=localStorage.getItem("current_id");
	  console.log(fid);
	  $.ajax({
	        url:"/fasebooke/aska/opennotice.action",
	        type:"POST",
	        data:"fuid="+fid,
	        dataType:"json",
	        success:function(message){
	        	var no=message["newnotice"];
	        	console.log(no);
	        	ul = $(e).next();
	        	ul.empty();
	        	for(var i = 0; i < no.length; i++)
	        		ul.append('<li ffid="'+no[i].ffid+'" fuid="'+no[i].fuid+'" asid="'+no[i].asid+'" style="color:gray;text-align:center;width:200px;cursor:default"><p>'+no[i].fuser.fname+'请求好友</p><button class="btn btn-default" onclick="Agree(this)"><i class="glyphicon glyphicon-ok-circle" style="color:white"></i>同意</button><button class="btn btn-default" onclick="Reject(this)"><i class="glyphicon glyphicon-remove-circle" style="color:white"></i>拒绝</button></li>');
	              
	        }
	        
	    });
}
function Agree(e){
	var ffid=$(e).parent().attr("ffid");
	var fuid=$(e).parent().attr("fuid");
	
	var asid=$(e).parent().attr("asid");
	var askp={"asid":asid,"msgstage":1,"ffid":ffid,"fuid":fuid,"asktype":0};
$(e).parent().remove();
	$.ajax({
		  url:"/fasebooke/aska/updatenotice.action",
	        type:"POST",
	        contentType:"application/json",
	        data:JSON.stringify(askp),
	        dataType:"text",
	        success:function(message){
	        	console.log(message);
	        }
	});
	
}
function Reject(e){
	var ffid=$(e).parent().attr("ffid");
	var fuid=$(e).parent().attr("fuid");
	var asid=$(e).parent().attr("asid");
	var askp={"asid":asid,"msgstage":2,"ffid":ffid,"fuid":fuid,"asktype":0};
$(e).parent().remove();
	$.ajax({
		  url:"/fasebooke/aska/updatenotice.action",
	        type:"POST",
	        contentType:"application/json",
	        data:JSON.stringify(askp),
	        dataType:"text",
	        success:function(message){
	        	console.log(message);
	        }
	});
}
var emotionArray=["h.gif","lovea.gif","d.gif","zy.gif","qq.gif","mb.gif","sb.gif","sdz.gif","kl.gif","zan.png","wow.png","haha.png","angr.png","sad.png"];
var emotion=["[zemo笑哭]","[zemo害羞]","[zemo呕吐]","[zemo难受]","[zemo想哭]","[zemo羞羞]","[zemo赞]","[zemo咦]","[zemo微笑]","[zemo花痴]","[zemo尴尬]","[zemo傲娇]","[zemo无语]","[zemo牙齿]","[zemo媚眼]","[zemo打晕]","[zemo哼]","[zemo呀]","[zemo天使]","[zemo啊啊]","[zemo邪恶]","[zemo笑眼]","[zemo吐舌]","[zemo不屑]","[zemo泪奔]","[zemo金星]","[zemo鼓鼓]","[zemo畏汗]","[zemo精神]","[zemo愉快]","[zemo恶汗]","[zemo石化]","[zemo阳光]","[zemo明媚]"];
function jiexi(sendwords,dataid,sendimage){
	
	var s=dataid;
	var temp=sendwords;
/*	console.log(temp);
	var re=/(\[zemo.*\])/g;
    var r = "";   
	while(r = re.exec(temp)) {   
	   console.log(r[0] + "  " + r[1]);   
	} */
 var ta= document.getElementById(s);
		for(var i =0;i< emotion.length; i ++){
			temp = temp.split(emotion[i]);
			temp = temp.join('<img src="http://localhost:8080/img/face/3017/'+i+'.png" width="22" height="22"/>');
		
		}

		$(ta).append(temp);
		
	if(sendimage!=''){
		/* if(sendimage.indexOf("http://localhost:8080/img/city/")==0){
			 sendimage = "http://localhost:8080/" + sendimage.split("http://localhost:8080/")[2];
			 sendimage = sendimage.substr(0,sendimage.length - 1);
			 $(ta).append('<img src="'+sendimage+'">'); 
			 }else{*/
				var imagearray=sendimage.split('|');
				console.log(sendimage);
				for(var i=1;i<imagearray.length;i++)
					$(ta).append('<img src="'+imagearray[i]+'">');
		}
	
		

}
function commentshow(e){
    var parent=e.parentNode.nextElementSibling.nextElementSibling.nextElementSibling;
   
var ta=parent.firstElementChild; 
/*  console.log(parent); */
    ta.style="display:block"; 
 $(parent).css('display','block'); 
   var show=ta.firstElementChild.firstElementChild;
   var commentid=$(e).attr("data");
/*   $.ajax({
	 url:"/fasebooke/comment/dycomment.action",
	 data:"contentid="+commentid+"&fuid="+fid,
   });*/
  
/*  var div=document.createElement('div');
    div.innerHTML="hhhhh";
    show.appendChild(div);*/
  
}
function postcomment(e){
	var ha=document.getElementById("emotions");
	if(ha==undefined){
  $(e.parentElement).append('<div id="emotions" style="margin-left: 66px; margin-top: 18px; display: block;"> <div class="containerT"> </div></div>');
    for(var i = 0;  i < 34; ++i){
				$('#emotions .containerT').append($('<a href="javascript:void(0);"><img src="http://localhost:8080/img/face/3017/'+i+'.png" " width="22" height="22" data="'+i+'" /></a>'));
			}
     $('#emotions .containerT').on("click",function(e){
        var name=$(e.target).attr("src");
        var i=$(e.target).attr("data");
        var sendin=e.target.parentElement.parentElement.parentElement.parentElement.nextElementSibling.firstElementChild;
    var content=emotion[i];

        var test=$(sendin).val();
        $(sendin).val(test+content);
    });
    $('#emotions').mouseleave(function(){
      $(this).remove();
    });
	}else
		$('#emotions').remove();
   
}
function getPbiao(e){
	var ha=document.getElementById("emotions");
	if(ha==undefined){
  $(e.parentElement).append('<div id="emotions" style="margin-left: 66px; margin-top: 18px; display: block;"> <div class="containerT"> </div></div>');
    for(var i = 0;  i < 34; ++i){
				$('#emotions .containerT').append($('<a href="javascript:void(0);"><img src="http://localhost:8080/img/face/3017/'+i+'.png" " width="22" height="22" data="'+i+'" /></a>'));
			}
     $('#emotions .containerT').on("click",function(e){
        var name=$(e.target).attr("src");
        var i=$(e.target).attr("data");
        var sendin=e.target.parentElement.parentElement.parentElement.parentElement.nextElementSibling.firstElementChild;
    var content=emotion[i];
 
    var old=$('textarea[name=sendwords]').val().trim()+content;
	
	$('textarea[name=sendwords]').val(old);
	
    });
    $('#emotions').mouseleave(function(){
      $(this).remove();
    });
	}else
		$('#emotions').remove();
}
function getp(){
	
		var x="我的位置:"+window.p;
	

		var old=$('textarea[name=sendwords]').val().trim()+x;
		console.log(old);
		$('textarea[name=sendwords]').val(old);

	
	
}
function repy(e){
	x = $(e).parent().parent().parent().prev();
    y = x.find("textarea")[0];
    y.value = "";
    y.id = "neirong";
    x = x.prev();
    y = x.find("input")[0];
    y.disabled = "disabled";
    y.id = "biaoti";
    x = x.prev();
    y = x.find("input")[0];
    y.disabled = "disabled";
    y.id = "recievename";
    y = x.find("label")[0];
    y.innerHTML = "收件人";
   	x = x.parent();
   	y = x.parent().next();
   	$(y).remove();
   	$(x).append('<div class="form-group"><div class="col-sm-10"><div id="as" style="margin-left:180px"></div></div></div>');
   	console.log(2);
   	$(e).next().remove();
//   	$(e).click(doemail);
   	$(e).attr("onclick","doemail()");
    $('#as').diyUpload({
    	url:'http://localhost:8080/fasebooke/picture/dofile.action',
    	success:function( data ) {
    		$('#as').append('<input type="hidden" value="'+data["filepath"]+'">');
    		$('.parentFileBox').css("width","1200px");
    	},
    	error:function( err ) {
    		console.info( err );	
    	},
    	buttonText : '选择文件',
    	chunked:true,
    	// 分片大小
    	chunkSize:512 * 1024,
    	//最大上传的文件数量, 总文件大小,单个文件大小(单位字节);
    	fileNumLimit:50,
    	fileSizeLimit:500000 * 1024,
    	fileSingleSizeLimit:50000 * 1024,
    	accept: {}
    });
    
}

function huifu(e){
	var parentid=$(e).attr("data");
	var comtid=$(e).attr("parent-data");
	var y=$(e).position().top;
	var x=$(e).position().left-470;
	var newone=$('<div class="input-group" style="position:absolute;width:500px;" ><div class="input-group-btn"><a href="javascript:;" onclick="postcomment(this)" class="btn btn-default" ><span class="fa fa-smile-o"></span></a></div><div> <input class="form-control" style=""placeholder="Add a comment.." type="text"> <a  href="javascript:;" class="btn btn-default" style="display:inline;float:right;position: relative;margin-top:-34px;" onclick="rsend(this)" data="'+parentid+'" parent-data="'+comtid+'"><i class="glyphicon glyphicon-share"></i></a></div></div>').css("top",y).css("left",x);
	$(e).parent().append(newone);
}
function rsend(e){  /* 发送回复*/
	var parent = $(e).parent().parent().parent();
	var mubiao = "回复"+$(parent).html().split(">")[1].split(":")[0].split("回复")[0];
	console.log(mubiao);
	 var content=e.parentElement.firstElementChild;
	var neirong=$(content).val().trim();
	var dis=$(e).parent().parent();
	
	if(neirong!=''){
		var parentid=$(e).attr("data");
		var comid=$(e).attr("parent-data");
		var timeY=new Date().getFullYear()+"/"+new Date().getMonth()+"/"+new Date().getDate();
		var fuid=localStorage.getItem("current_id");
		var head=localStorage.getItem("current_head");
		var fname=localStorage.getItem("current_name");
		/*var commentfuid=$($(document.getElementById("pinlun"+parentid)).children()[0]).attr("data");
		console.log(commentfuid);*/
		var timeZ=new Date().getHours()+":"+new Date().getMinutes()+":"+new Date().getSeconds();
		
		var huip=$(e).parent().parent().parent();
		var comment={"customerId":fuid,"parentCommentId":parentid,"contentId":comid,"type":0,"content":neirong,"commetDate":timeY,"commetTime":timeZ}; 
		var target=$(e).parent().parent().prev().children(1).children(1);
		for(var i =0;i< emotion.length; i ++){
			neirong = neirong.split(emotion[i]);
			neirong = neirong.join('<img src="http://localhost:8080/img/face/3017/'+i+'.png" width="22" height="22"/>');
		}
	/*	$(huip).append('<div class="overcom" id="pinlun'+3+'"><img src="http://localhost:8080/img/'+fuid+'/'+head+'" style="border: 1px solidrgba(0,0,0,.1);width:24px;height:24px">'+fname+':'+neirong+timeZ+'<a href="javascript:;" style="float:right" onclick="huifu(this)" data="'+3+'">回复</a></div>');*/
		var ok = false;
		$.ajax({
		    url:"/fasebooke/comment/reply.action",
		    type:"post",
		    contentType:"application/json",
		    data:JSON.stringify(comment),
		    success:function(message){
		  /*     返回一个t_comment的id，将t_comment生成一条回复*/
		    	$(content).val("");
		    	  var s=$(e).parent().parent().prev();
		    	  $(s).css("display","block");
		    	/*  console.log(headimage);*/
		/*    	  $(huip).append('<div class="overcom"><img src=""style="border: 1px solidrgba(0,0,0,.1);width:24px;height:24px"><a href="javascript:;" style="float:right" onclick="huifu(this)">回复</a></div>');*/
		    	  $(huip).append('<div class="overcom" id="pinlun'+message+'"><img id="linshizhanyong" src="'+head+'" style="border: 1px solidrgba(0,0,0,.1);width:24px;height:24px">'+fname+mubiao+':'+neirong+" "+timeZ+'<a href="javascript:;" style="float:right" onclick="huifu(this)" data="'+message+'" parent-data="'+parentid+'">回复</a></div>');
		        console.log(message);
		      /*  console.log(head);
		        ok = true;*/
		    }
		});
//		setTimeout(function(){
//			console.log("ok:"+ok);
//			if(ok){
//				$("#linshizhanyong").attr("src",head);
//			}
//			else
//				setTimeout(this, 500);
//		}, 1000);
	}
	dis.remove();
}
function openL(e){  /*打开评论*/
    var lip=$(e).parent()[0];
    if($(lip).hasClass("open")){
       $(e).next().css("display","none"); 
         $(lip).removeClass("open");
    }else
       {$(e).next().css("display","block");
           $(lip).addClass("open");
       }
}
function realsend(e){
	
   var content=e.parentElement.firstElementChild;
   var neirong=$(content).val().trim();
  
   if(neirong!=' '){
    var parentid=$(e).attr("data-id");
   
    var fuid=localStorage.getItem("current_id");
    var head=localStorage.getItem("current_head");
    var fname=localStorage.getItem("current_name");
   var timeY=new Date().getFullYear()+"/"+new Date().getMonth()+"/"+new Date().getDate();

   var timeZ=new Date().getHours()+":"+new Date().getMinutes()+":"+new Date().getSeconds();
  
    var comment={"customerId":fuid,"contentId":parentid,"type":0,"content":neirong,"commetDate":timeY,"commetTime":timeZ     
    }; 
    var target=$(e).parent().parent().prev().children(1).children(1);
	for(var i =0;i< emotion.length; i ++){
		neirong = neirong.split(emotion[i]);
		neirong = neirong.join('<img src="http://localhost:8080/img/face/3017/'+i+'.png" width="22" height="22"/>');
	
	}
  
    $.ajax({
         
        url:"/fasebooke/comment/reply.action",
        type:"post",
        contentType:"application/json",
        data:JSON.stringify(comment),
        success:function(message){
       /*    返回一个t_comment的id，将t_comment生成一条回复*/
        	
        	$(content).val("");
        	  var s=$(e).parent().parent().prev();
        	  $(s).css("display","block");
      $(target[0]).append('<div class="overcom" id="pinlun'+message+'"><img src="'+head+'" style="border: 1px solidrgba(0,0,0,.1);width:24px;height:24px">'+fname+':'+neirong+timeZ+'<a href="javascript:;" style="float:right" onclick="huifu(this)" data="'+message+'">回复</a></div>');
            console.log(message);
        }
    });
   }else {
	   var s=$(e).parent().parent().prev();
 	  $(s).css("display","block");
}
}
//写cookies 

function setCookie(name,value) 
{ 
    var Days = 30; 
    var exp = new Date(); 
    exp.setTime(exp.getTime() + Days*24*60*60*1000); 
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString(); 
} 

//读取cookies 
function getCookie(name) 
{ 
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
 
    if(arr=document.cookie.match(reg))
 
        return unescape(arr[2]); 
    else 
        return null; 
} 

//删除cookies 
function delCookie(name) 
{ 
    var exp = new Date(); 
    exp.setTime(exp.getTime() - 1); 
    var cval=getCookie(name); 
    if(cval!=null) 
        document.cookie= name + "="+cval+";expires="+exp.toGMTString(); 
} 
function comf(){     
	var overcome=$('#result a');
   var p=[];
   var x= $('#sendwords');
  console.log(x.val());
   if($('#sendwords').val().trim()==''){
		alert("内容不能为空");
		return  false;
	}
  for(var i=0;i<overcome.length;i++)
	  p[i]=$(overcome[i]).attr("data");
  for(var j=0;j<p.length;j++){
     var s=p.join('-');
     console.log(s);
  $('#zz').append(" <input type='hidden' value='"+s+"'name='bigimage' >");
  }
 
	return true;	
}
function deleteOnePig(e){  /*删除照片*/
	var pid=$(e).attr("data");
	$(e).parent().remove();
	$.ajax({
		 url:"/fasebooke/picture/deleteone.action",
	        type:"post",
	        dataType:"text",
	        data:"fuid="+fid+"&pid="+pid,
	        success:function(message){
	       /*    返回一个t_comment的id，将t_comment生成一条回复*/
	            console.log(message);
	        }
	});
}
function deleteG(e){    /* 删除相册*/
	var gid=$(e).attr("data");
	
	$(e).prev().remove();
	$(e).remove();
     $(e).parent().remove();
      $.ajax({
 		 url:"/fasebooke/picture/delete.action",
 	        type:"post",
 	        dataType:"text",
 	        data:"fuid="+fid+"&gid="+gid,
 	        success:function(message){
 	      
 	            console.log(message);
 	        }
 	});
}
function backimage(obj){    /*换空间背景*/
/*	imagrap2*/
	var back=$(obj).parent().parent().parent();
	var fuid=localStorage.getItem("current_id");
	jQuery.ajaxFileUpload({  
	    url: '/fasebooke/user/upbackground.action?uid='+fuid,//用于文件上传的服务器端请求地址  
	    secureuri : false,//一般设置为false  
	    fileElementId : 'imagefile2',//文件上传控件的id属性   
	    dataType : 'json',
	    success : function(data) {
	    	console.log(data);
	    	   var message = data['message'];
	        $(back).removeClass("imagrap").addClass("imagrap2");
	        $(back).css("background",'url("'+message+'") no-repeat 0px 55px');
	       $(back).css("background-size","cover");
	    }
	});
	
}
function preview(obj){  /*发布动态时间的图片上传预览*/
	var fuid=localStorage.getItem("current_id");
jQuery.ajaxFileUpload({  
    url: '/fasebooke/fdynamiccontrol/file1.action?uid='+fuid,//用于文件上传的服务器端请求地址  
    secureuri : false,//一般设置为false  
    fileElementId : 'imagefile',//文件上传控件的id属性  
    dataType : 'json',//返回值类型 一般设置为json  
    success : function(data, status) {
            var message = data['message'];
            var code = data['code'];
            if (code==200) {
            	var file=obj.files;
            	console.log(file);
            	var read=new FileReader();
            	read.onload =function(evt){
            	for(var i=0;i<file.length;i++){
            	 document.getElementById("result").innerHTML+=' <div style="height:250px;width:100px" id="'+message+'" > <img src="'+evt.target.result+'"   style="width:225px;height:225px"/>  <a href="javascript:;" data="'+message+'" class="glyphicon glyphicon-remove" style="margin-top:-220px;position:relative;display:block"></a></div>';
            	}	 
            	}
            	for(var i=0;i<file.length;i++)
            	read.readAsDataURL(file[i]);
          
            }else{
                alert("处理异常！");
            }
        }
     
   
});
}
function zhaohuil(e){    /*找回密码*/
	var name=$("#zhaohui").val();
	console.log(name);
	  var y=$(e).position().top-50;
	    var x=$(e).position().left+50;
	    var newone= $('<div id="talkbubble" title="你的密码已发往您的邮箱或者手机请查看"></div>').css("top",y).css("left",x);
	    $.ajax({
	    url:'/fasebooke/user/findpass.action',
	    type:'post'	,
	    data:'findit='+name,
	    success:function(message){
	    
	    	  $(e).parent().append(newone);
	    	  $("#zhaohui").val("");
	    	  setTimeout(function(){
	    	        $(newone).remove();
	    	    },3000);
	    }
	    });
}
/*window.onbeforeunload = function() {   
    var n = window.event.screenX - window.screenLeft;   
    var b = n > document.documentElement.scrollWidth-20;   
            if(b && window.event.clientY < 0 || window.event.altKey){   
                alert("这是一个关闭操作而非刷新");   
                window.event.returnValue = ""; //此处放你想要操作的代码 
            }else{
                alert("这是一个刷新操作而非关闭");   
            }
        } */
function dimiss(){
    
    $('.parentFileBox').remove();

  }
function yichuhei(e){   /*从黑名单中移除*/
    var name=$(e).attr("data");
	 $.ajax({
		    url:'/fasebooke/user/'+fid+'/yichuhei.action',
		    type:'post'	,
		    data:'bfuid='+name,
		    success:function(message){
		    	if(message=="success")
		           $(e).remove();
	               else {
					$(e).val("服务错误");
				}
		    	console.log("一黑"+message);
		    }
		    });
}
function seeMore(e){  /*查看好友详细资料*/
	var child=$(e).children()[1];
    var da=$(e).attr("data");
    var target;
    for(var i=0;i<userarray.length;i++){
    	if(da==userarray[i].fuid)
    		target=userarray[i];
    	console.log(userarray[i]);
    }
    console.log(child);
    $('#profile').append($(child).clone());
 var s=   $($(child).children()[0]).attr("src");
 $($('.floatingImg')[0]).attr("src",s);
   new Date("yyyy/mm/dd");
var link="http://localhost:8080/fasebooke/user/"+target.fuid+"/"+fid+".action";
console.log(link);
$($($('#chat-messages .message')[0]).children()[1]).attr("href",link);
$($($('#chat-messages .message')[0]).children()[1]).text("http://www.fasebook.com/"+target.fname);
$($($('#chat-messages .message')[1]).children()[1]).text(target.ftel);
$($($('#chat-messages .message')[2]).children()[1]).text(target.femail);
if(target.fpersonal!=''){
$($($('#chat-messages .message')[3]).children()[1]).text(target.fpersonal);
}
var date = new Date(target.fbirthday);
$($($('#chat-messages .message')[4]).children()[1]).text((date.getYear()+1900)+"-"+date.getMonth()+"-"+date.getDay());
if(target.fliveplace!=''){
$($($('#chat-messages .message')[5]).children()[1]).text(target.fliveplace);
$($($('#chat-messages .message')[5]).children()[0]).attr("src",target.fplace);
}

	setTimeout(function () {
		$('#profile p').addClass('animate');
		$('#profile').addClass('animate');
	}, 100);
	setTimeout(function () {
		$('#chat-messages').addClass('animate');
		$('.cx, .cy').addClass('s1');
		setTimeout(function () {
			$('.cx, .cy').addClass('s2');
		}, 100);
		setTimeout(function () {
			$('.cx, .cy').addClass('s3');
		}, 200);
	}, 150);
	$('#chatview').fadeIn();
	$('#close').unbind('click').click(function () {
		$( $('#profile').children()[1]).remove();
		$('#chat-messages, #profile, #profile p').removeClass('animate');
		$('.cx, .cy').removeClass('s1 s2 s3');
		setTimeout(function () {
			$('#chatview').fadeOut();
		}, 50);
	});
}
function createG(e){
	var dateDom = new Date();
/*	//获取本地时间，年月日时分
	var year = dateDom.getFullYear();
	var month = dateDom.getMonth()+1;
	var day = dateDom.getDate();
	var hour = dateDom.getHours();
	var min = dateDom.getMinutes();*/
	var gname=$('#biao').val();
	var gdis=$('#nei').val();
	var gtype=$($('#gallary').prev().children()[0]).text();
	console.log(gname+gdis);
	console.log(gtype);
	var i;
	    switch(gtype){
	    case'公开':i=0;break;
	    case'好友':i=1;break;
	    case'仅限自己':i=2;break;
	    }
	    
	var Ga={"fuid":fid,"gicname":gname,"gtime":dateDom,"gicdescribe":gdis,"gacesstype":i};
	console.log($('#ios').children()[0]);
	
   $.ajax({
    url:'/fasebooke/picture/CreatePbefore.action',
    type:'post',
    contentType:"application/json",
    data:JSON.stringify(Ga),
    success:function(message){
         if(message=='wrong'){
        	 alert("相册已存在");
         }else {
        	$( $('#ios').children()[0]).append('<a href="javascript:;" data="'+message+'" onclick="deleteG(this)" style="color:gray;position:relative;margin-left:10px;top:-126px"><i class="glyphicon glyphicon-remove"></i></a> <div class="pic3" title="'+dateDom+'"><a href="http://localhost:8080/fasebooke/picture/'+message+'/ingay.action?fuid='+fid+'><i class=" fa fa-folder-open" style="font-size:170px;" ></i><p class="pic4">'+gname+'</p></a><p class="gicd">'+gdis+'</p></div>');
		}
    	
    }
    });
}
function delEmail(e){
	var eid=$(e).attr("data");
	$(e).parent().parent().remove();
	$.ajax({
         
        url:"/fasebooke/email/"+eid+"/demail.action",
        type:"post",
        data:"",
        dataType:"text",
        success:function(message){
            console.log(message);
        }
    });
}
function ini(){
	var tie=$($('#email2').children()[0]).children()[0];
	$(tie).empty();
	if(email.length>4){
	for(var i=0;i<4;i++)
    {
/*	email[i].eid+"  "+email[i].fname+"   "+email[i].sendtime*/
	$(tie).append(' <li class="list-group-item"><a href="http://localhost:8080/fasebooke/email/'+email[i].eid+'/'+fid+'/checkemail.action"><i class="glyphicon glyphicon-envelope"></i>"'+email[i].fname+"  "+email[i].sendtime+'"</a>');
	var sssss=$(tie).children().last();

	if(email[i].estate==1){
	 
    	 $(sssss).append('<div style="float:right"><span class="glyphicon glyphicon-star"></span> <span data="'+email[i].eid+'"class="glyphicon glyphicon-trash" onclick="delEmail(this)"></span></div>');
     }else {
    	 
		$(sssss).append('<div style="float:right"><span class="glyphicon glyphicon-star-empty"></span> <span data="'+email[i].eid+'"class="glyphicon glyphicon-trash" onclick="delEmail(this)"></span></div>');
	}
    }
	}else {
		for(var i=0;i<email.length;i++)
	    {
	/*	email[i].eid+"  "+email[i].fname+"   "+email[i].sendtime*/
		$(tie).append(' <li class="list-group-item"><a href="http://localhost:8080/fasebooke/email/'+email[i].eid+'/'+fid+'/checkemail.action"><i class="glyphicon glyphicon-envelope"></i>"'+email[i].fname+"  "+email[i].sendtime+'"</a>');
		var sssss=$(tie).children().last();

		if(email[i].estate==1){
		 
	    	 $(sssss).append('<div style="float:right"><span class="glyphicon glyphicon-star"></span> <span data="'+email[i].eid+'"class="glyphicon glyphicon-trash" onclick="delEmail(this)"></span></div>');
	     }else {
	    	 
			$(sssss).append('<div style="float:right"><span class="glyphicon glyphicon-star-empty"></span> <span data="'+email[i].eid+'"class="glyphicon glyphicon-trash" onclick="delEmail(this)"></span></div>');
		}
	    }
	}
}
function shangyiye(){

/*	console.log("shangyiye"+yeshu);
console.log(	$($('#email2').children()[0]).children()[0]);
	console.log(email.length);*/

	var tie=$($('#email2').children()[0]).children()[0];
	if(email.length>4){
		$(tie).empty();
	if(yeshu>1){
	var end=yeshu*4;
	var begin=(yeshu-1)*4;
	console.log(begin+"iiiiiiiiiiiiiiiiiiiii"+end);
	
	for(var i=begin;i<end;i++)
    {
		$(tie).append(' <li class="list-group-item"><a href="http://localhost:8080/fasebooke/email/'+email[i].eid+'/'+fid+'/checkemail.action"><i class="glyphicon glyphicon-envelope"></i>"'+email[i].fname+"  "+email[i].sendtime+'"</a>');
		var sssss=$(tie).children().last();

		if(email[i].estate==1){
		 
	    	 $(sssss).append('<div style="float:right"><span class="glyphicon glyphicon-star"></span> <span data="'+email[i].eid+'"class="glyphicon glyphicon-trash" onclick="delEmail(this)"></span></div>');
	     }else {
	    	 
			$(sssss).append('<div style="float:right"><span class="glyphicon glyphicon-star-empty"></span> <span data="'+email[i].eid+'"class="glyphicon glyphicon-trash" onclick="delEmail(this)"></span></div>');
		}
	}
	 yeshu=yeshu-1;
	}else{
		ini();
	}
	}
	else {
		ini();
		/*console.log("yyyyyyyyyyy");
		for(var i=0;i<email.length;i++)
	    {
			$(tie).append(' <li class="list-group-item"><a href="http://localhost:8080/fasebooke/email/"'+email[i].eid+'"/"'+fid+'"/checkemail.action"><i class="glyphicon glyphicon-envelope"></i>"'+email[i].fname+"  "+email[i].sendtime+'"</a>');
			var sssss=$(tie).children().last();

			if(email[i].estate==1){
			 
		    	 $(sssss).append('<div style="float:right"><span class="glyphicon glyphicon-star"></span> <span data="'+email[i].eid+'"class="glyphicon glyphicon-trash" onclick="delEmail(this)"></span></div>');
		     }else {
		    	 
				$(sssss).append('<div style="float:right"><span class="glyphicon glyphicon-star-empty"></span> <span data="'+email[i].eid+'"class="glyphicon glyphicon-trash" onclick="delEmail(this)"></span></div>');
			}
		}*/
	}
}
function xiayiye(){
	var tie=$($('#email2').children()[0]).children()[0];
	$(tie).empty();
	if(((yeshu+1)*4)<email.length){
	var begin=yeshu*4;
	var end=(yeshu+1)*4;
	console.log(begin+"iiiiiiiiiiiiiiiiiiiii"+end);

	for(var i=begin;i<end;i++){
		$(tie).append(' <li class="list-group-item"><a href="http://localhost:8080/fasebooke/email/'+email[i].eid+'/'+fid+'/checkemail.action"><i class="glyphicon glyphicon-envelope"></i>"'+email[i].fname+"  "+email[i].sendtime+'"</a>');
	var sssss=$(tie).children().last();

	if(email[i].estate==1){
    	 $(sssss).append('<div style="float:right"><span class="glyphicon glyphicon-star"></span> <span data="'+email[i].eid+'"class="glyphicon glyphicon-trash" onclick="delEmail(this)"></span></div>');
     }else {
    	 
		$(sssss).append('<div style="float:right"><span class="glyphicon glyphicon-star-empty"></span> <span data="'+email[i].eid+'"class="glyphicon glyphicon-trash" onclick="delEmail(this)"></span></div>');
	}
	}
	yeshu=yeshu+1;
	}else
		{
		  for(var i=yeshu*4;i<email.length;i++){
			  $(tie).append(' <li class="list-group-item"><a href="http://localhost:8080/fasebooke/email/'+email[i].eid+'/'+fid+'/checkemail.action"><i class="glyphicon glyphicon-envelope"></i>"'+email[i].fname+"  "+email[i].sendtime+'"</a>');
			var sssss=$(tie).children().last();
			if(email[i].estate==1){
		    	 $(sssss).append('<div style="float:right"><span class="glyphicon glyphicon-star"></span> <span data="'+email[i].eid+'"class="glyphicon glyphicon-trash" onclick="delEmail(this)"></span></div>');
		     }else {
		    	 
				$(sssss).append('<div style="float:right"><span class="glyphicon glyphicon-star-empty"></span> <span data="'+email[i].eid+'"class="glyphicon glyphicon-trash" onclick="delEmail(this)"></span></div>');
			}
		  }
		}
	
}
function lahei(e){

	var name=$(e).prev().val();
	
    var y=$(e).position().top-50;
    var x=$(e).position().left+50;

    var newone= $('<div id="talkbubble" title=""></div>').css("top",y).css("left",x);
  
    $.ajax({
    url:'/fasebooke/user/addblock.action?',
    type:'post'	,
    data:'fuid='+fid+'&target='+name,
    success:function(message){

    	$(newone).attr("title",message);
    	  $(e).parent().append(newone);
    	  $(e).prev().val("");
    	  setTimeout(function(){
    	        $(newone).remove();
    	    },3000);
    }
    });
 
  
}


