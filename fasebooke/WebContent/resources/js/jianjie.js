//写cookies 
$("#uldy a").click(function() {
	newTel(this);
});
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
function createList(x,y){
	
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

function search(sheet){
	console.log(sheet);
    var focus = false;
        $('input[name=text]').focusin(function () {
          
            focus = true;
            $(this).next().css('display', 'block');
        }).keyup(function(){
        var q=$(this).val();
        console.log(q);
       if (q == ''){
    	   $(this).next().css('display', 'none');   
       }else{
    	   var ul = $(this).next();
	     $.ajax({
	            url:"/fasebooke/help/"+sheet,
	            type:"post",
	            data:"college="+q,
	            dataType:"text",
	            success:function(message){
	            	if("wrong"!=message){
	            	ul.empty();
	            	ul.css('display', 'block');
	            	var res = message.split('[')[1].split(']')[0].split('},');
	                for(var i = 0; i < res.length; i++)
	                	if(res[i] != ""){
	                		if(i < res.length - 1)
	                		res[i] = res[i] + "}";
	                		res[i] = JSON.parse(res[i]);
	                		if(res[i].curl == undefined)
	                			ul.append('<li style="margin-top:20px;cursor:pointer;" onclick="selectcity(this)"><img src="http://localhost:8080/img/city/'+res[i].lurl+'" style="width:30px;height:30px;float:left;">'+res[i].lprovice+ '</li>');
	                		else 
	                			ul.append('<li style="margin-top:20px;cursor:pointer;" onclick="selectdaxue(this)"><img src="'+res[i].curl+'" style="width:30px;height:30px;float:left;">'+res[i].cname+ '</li>');
	                	}
	            	}
	            }
	     	});
     
       }
    });
    
};
function selectcity(e){
	var html = e.innerHTML;
	var value = html.split('>')[1];
	var src = html.split('"')[1];


	if("其他住地："==$($(e).parent().parent().children()[0]).text()){
		setCookie("ltitle", value);
	setCookie("ltype",src);
	}
	else {
		setCookie("fhometown", value);
		setCookie("fhome", src);
	}
	$(e).parent().prev().val(value);
	$(e).parent().prev().prev().attr("src",src);
	$(e).parent().css('display', 'none');
}

function selectdaxue(e){
	var html = e.innerHTML;
	var value = html.split('>')[1];
	var src = html.split('"')[1];
	setCookie("fliveplace", value);
	setCookie("fplace", src);
	$(e).parent().prev().val(value);
	$(e).parent().prev().prev().attr("src",src);
	$(e).parent().css('display', 'none');
}

/*还需--------------------------	  获取userjson 对上面变量进行封装-------------------------*/
function newTel(e) {
	var mv = $(e).parent();
	if($(e).attr("data") == "tel") {
		var tel = {
				"fuid":getCookie("fuid"),
				"ftel":getCookie("ftel") 
			};
		console.log(tel);
		$(e).remove();
		mv.append('<div class="form"><label>手机号：</label><input type="tel"><div class="submit" style="float:right;margin:5px"><select class="input-sm haha"> <option>公开</option><option>好友</option><option>仅自己</option></select><input type="button" value="保存"><input type="button" value="取消"> </div></div>');
		$("#uldy input[type='button']").on("click", function() {
			$suibian = $(this).parent().parent().parent();
			var length = tel["ftel"].length;
			var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
			var tels = /^\d{3,4}-?\d{7,9}$/;
			if($(this).attr("value") == '保存') {
				tel["ftel"] = $(this).parent().prev().val();
                 setCookie("ftel", tel["ftel"]);
				if(!(tels.test(tel["ftel"]) || mobile.test(tel["ftel"]))) {
					return;
				}
				$(this).parent().parent().remove();
				if(tel["ftel"] != "") {
					$suibian.append('<div class="form"><label>手机号：</label><label>' + tel["ftel"] + '</label></div><a href="javascript:;" data="tel"><i class="glyphicon glyphicon-plus" ></i>编辑手机号</a>');
					$('#uldy a[data="tel"]').click(function() {
						$(this).prev().remove();
						newTel(this);
					});
				} else
					$suibian.append('<a href="javascript:;" data="tel"><i class="glyphicon glyphicon-plus" ></i>添加新手机号</a>');
				$('#uldy a[data="tel"]').click(function() {
					newTel(this);
				});

				$.ajax({
					url: "/fasebooke/user/update.action",
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify(tel),
					dataType: "text",
					success: function(message) {
						console.log(message);
					}
				});
			} else {

				$(this).parent().parent().remove();
				if(tel["ftel"] == "") {
					$suibian.append('<a href="javascript:;" data="tel"><i class="glyphicon glyphicon-plus" ></i>添加新手机号</a>');
					$('#uldy a[data="tel"]').click(function() {
						newTel(this);
					});
				} else {
					$suibian.append('<div class="form"><label>手机号：</label><label>' + tel["ftel"] + '</label></div><a href="javascript:;" data="tel"><i class="glyphicon glyphicon-plus" ></i>编辑手机号</a>');
					$('#uldy a[data="tel"]').click(function() {
						$(this).prev().remove();
						newTel(this);
					});
				}
			}
		});
	}
	if($(e).attr("data") == "link") {
		var link = {
				"fuid": getCookie("fuid"),
				"fhttp":getCookie("fhttp")
			};
		$(e).remove();
		mv.append('<form class="form"> <label style="margin-left:-10px">网站链接：</label><input type="text"> <div class="submit" style="float:right;margin:5px"><select class="input-sm haha"><option>公开</option><option>好友</option><option>仅自己</option></select> <input type="button" value="保存"><input type="button" value="取消"></div></form>');
		$("#uldy input[type='button']").on("click", function() {
			$suibian = $(this).parent().parent().parent();
			regExp = /^((https?|ftp|news|http):\/\/)?([a-z]([a-z0-9\-]*[\.。])+([a-z]{2}|aero|arpa|biz|com|coop|edu|gov|info|int|jobs|mil|museum|name|nato|net|org|pro|travel)|(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]))(\/[a-z0-9_\-\.~]+)*(\/([a-z0-9_\-\.]*)(\?[a-z0-9+_\-\.%=&]*)?)?(#[a-z][a-z0-9_]*)?$/
			if($(this).attr("value") == '保存') {
				link["fhttp"] = $(this).parent().prev().val();
                setCookie("fhttp", link["fhttp"]);
				if(!(regExp.test(link["fhttp"]))) {
					return;
				}
				$(this).parent().parent().remove();
				if(link["fhttp"] != "") {
					$suibian.append('<div class="form"><label  style="margin-left:-10px">网址链接：</label><a href="' + link["fhttp"] + '">' + link["fhttp"] + '"</a></div><a href="javascript:;" data="link"><i class="glyphicon glyphicon-plus" ></i>编辑网址</a>');
					$('#uldy a[data="link"]').click(function() {
						$(this).prev().remove();
						newTel(this);
					});
				} else
					$suibian.append('<a href="javascript:;" data="link"><i class="glyphicon glyphicon-plus" ></i>添加网站链接</a>');
				$('#uldy a[data="link"]').click(function() {
					newTel(this);
				});

				$.ajax({
					url: "/fasebooke/user/update.action",
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify(social),
					dataType: "text",
					success: function(message) {
						console.log(message);
					}
				});
			} else {

				$(this).parent().parent().remove();
				if(link["fhttp"] == "") {
					$suibian.append('<a href="javascript:;" data="link"><i class="glyphicon glyphicon-plus" ></i>添加新网址</a>');
					$('#uldy a[data="link"]').click(function() {
						newTel(this);
					});
				} else {
					$suibian.append('<div class="form"><label>网址链接：</label><a href=' + link["fhttp"] + '>' + link["fhttp"] + '</a></div><a href="javascript:;" data="link"><i class="glyphicon glyphicon-plus" ></i>编辑网址</a>');
					$('#uldy a[data="link"]').click(function() {
						$(this).prev().remove();
						newTel(this);
					});
				}
			}
		});
	}
	if($(e).attr("data") == "social") {
		var social = {
				"fuid":getCookie("fuid"),
				"fsociallink": getCookie("fsociallink")
				
			};
		$(e).remove();
		mv.append('<form class="form"><label style="margin-left:-10px">社交链接：</label><input type="text"><div class="submit" style="float:right;margin:5px"><select class="input-sm haha"><option>QQ</option><option>微信</option><option>github</option></select><input type="button" value="保存"><input type="button" value="取消"></div></form>');
		$("#uldy input[type='button']").on("click", function() {
			$suibian = $(this).parent().parent().parent();

			if($(this).attr("value") == '保存') {
				social["fsociallink"] = $(this).parent().prev().val();
                   setCookie("fsociallink", social["fsociallink"]);
				$(this).parent().parent().remove();
				if(link["fsociallink"] != "") {
					$suibian.append('<div class="form"><label  style="margin-left:-10px">社交链接：</label><label>' + social["fsociallink"] + '</label></div><a href="javascript:;" data="social"><i class="glyphicon glyphicon-plus" ></i>编辑网址</a>');
					$('#uldy a[data="social"]').click(function() {
						$(this).prev().remove();
						newTel(this);
					});
				} else
					$suibian.append('<a href="javascript:;" data="social"><i class="glyphicon glyphicon-plus" ></i>添加社交链接</a>');
				$('#uldy a[data="social"]').click(function() {
					newTel(this);
				});

				$.ajax({
					url: "/fasebooke/user/update.action",
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify(link),
					dataType: "text",
					success: function(message) {
						console.log(message);
					}
				});
			} else {

				$(this).parent().parent().remove();
				if(social["fsociallink"] == "") {
					$suibian.append('<a href="javascript:;" data="social"><i class="glyphicon glyphicon-plus" ></i>编辑社交链接</a>');
					$('#uldy a[data="social"]').click(function() {
						newTel(this);
					});
				} else {
					$suibian.append('<div class="form"><label style="margin-left:-10px">社交链接：</label><label>' + social["fsociallink"] + '</label></div><a href="javascript:;" data="social"><i class="glyphicon glyphicon-plus" ></i>编辑社交链接</a>');
					$('#uldy a[data="social"]').click(function() {
						$(this).prev().remove();
						newTel(this);
					});
				}
			}
		});
	}
	if($(e).attr("data") == "born") {
		var born = {
				"fuid": getCookie("fuid"),
				"fbirthday": getCookie("fbirthday")
			};
		$(e).remove();
		mv.append(' <form class="form" style="height:40px;min-width:656px;"> <div class="submit" style="float:left;margin:10px"><label>出生年月：</label> <input type="date" style="margin-right: 4px;"><select class="input-sm haha"><option>公开</option><option>好友</option><option>仅自己</option></select><input type="button" value="保存"><input type="button" value="取消"></div></form>');
		$("#uldy input[type='button']").on("click", function() {
			$suibian = $(this).parent().parent().parent();

			if($(this).attr("value") == '保存') {
				var t = $(this).parent().children()[1];

				born["fbirthday"] = $(t).val();
                setCookie("fbirthday", born["fbirthday"]);
				$(this).parent().parent().remove();
				if(born["fbirthday"] != "") {
					$suibian.append('<div class="form" style="height:40px;min-width:656px;"><div class="submit" style="float:left;margin:10px"><label>出生年月：</label> <label>' + born["fbirthday"] + '</label></div></div><a href="javascript:;" data="born"><i class="glyphicon glyphicon-plus" ></i>编辑生日</a>');
					$('#uldy a[data="born"]').click(function() {
						$(this).prev().remove();
						newTel(this);
					});
				} else
					$suibian.append('<a href="javascript:;" data="born"><i class="glyphicon glyphicon-plus" ></i>添加出生年月</a>');
				$("#uldy a").click(function() {
					newTel(this);
				});

				$.ajax({
					url: "/fasebooke/user/update.action",
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify(born),
					dataType: "text",
					success: function(message) {
						console.log(message);
					}
				});
			} else {

				$(this).parent().parent().remove();
				if(born["fbirthday"] == "") {
					$suibian.append('<a href="javascript:;" data="born"><i class="glyphicon glyphicon-plus" ></i>编辑出生年月</a>');
					$("#uldy a").click(function() {
						newTel(this);
					});
				} else {
					$suibian.append('<div class="form"><label style="margin-left:-10px">出生年月：</label><label>' + born["fbirthday"] + '</label></div><a href="javascript:;" data="born"><i class="glyphicon glyphicon-plus" ></i>编辑年月</a>');

					$('#uldy a[data="born"]').click(function() {
						$(this).prev().remove();
						newTel(this);
					});
				}
			}
		});
	}

	if($(e).attr("data") == "sex") {
		var sex = {
				"fuid": getCookie("fuid"),
				"fsex": getCookie("fsex")
			};
		$(e).remove();
		mv.append(' <div class="form" style="margin-left:20px;float:left"><label> 性 别： </label></div><div class="switch switch-blue"><input type="radio" class="switch-input" name="sex" value="0" id="boy" checked><label for="boy" class="switch-label switch-label-off">男</label><input type="radio" class="switch-input" name="sex" value="1" id="girl"><label for="girl" class="switch-label switch-label-on">女</label><span class="switch-selection"></span></div>');
		$("#uldy input[type='radio']").on("click", function() {

			sex["fsex"] = $(this).val();
			setCookie("fsex", sex["fsex"]);
			$.ajax({
				url: "/fasebooke/user/update.action",
				type: "POST",
				contentType: "application/json",
				data: JSON.stringify(sex),
				dataType: "text",
				success: function(message) {
					console.log(message);
				}
			});

		});
	}
	if($(e).attr("data") == "pre") {
		var pre = {
				"fuid": getCookie("fuid"),
				"fsexlike": getCookie("fsexlike")
			};
		$(e).remove();
		mv.append('<div class="form" style="text-align:center"><label>性别喜好：</label></div><section title="男" class="che"><div class="squaredFour"><input type="checkbox" value="0" name="check" id="se"><label for="se"></label></div></section><section title="女" class="che"><div class="squaredFour"><input type="checkbox" value="1" name="check" id="se1"><label for="se1"></label></div></section><section class="che" title="其他"><div class="squaredFour"><input type="checkbox" value="2" name="check" id="se2"> <label for="se2"></label></div></section>');

	}
	$(function() {
		
		var allBox = $(":checkbox");
		allBox.click(function() {
			if(this.checked || this.checked == 'checked') {
				allBox.removeAttr("checked");
				//这里需注意jquery1.6以后必须用prop()方法
				//$(this).attr("checked",true);
				$(this).prop("checked", true);
				pre["fsexlike"] = this.value;
				console.log(pre["fsexlike"]);
                 setCookie("fsexlike", pre["fsexlike"]);
			}

			$.ajax({
				url: "/fasebooke/user/update.action",
				type: "POST",
				contentType: "application/json",
				data: JSON.stringify(pre),
				dataType: "text",
				success: function(message) {
					console.log(message);
				}
			});
		});
	});

	if($(e).attr("data") == "blod") {
		var blod = {
				"fuid": getCookie("fuid"),
				"fblodtype": getCookie("fblodtype")
			};
		$(e).remove();
		mv.append('<form class="form"style="height:40px"><label>你的血型：</label><select class="haha input-sm" style="margin-top:10px"><option>A型</option><option>B型</option><option>AB型</option><option>O型</option></select><div class="submit" style="float:right;margin:10px"><select class="input-sm haha" style="margin-right:3px"><option>公开</option><option>好友</option><option>仅自己</option></select><input type="button" value="保存"> <input type="button" value="取消"></div></form>');
		$("#uldy input[type='button']").on(	"click", function() {
			$suibian = $(this).parent().parent().parent();
			if($(this).attr("value") == '保存') {

				blod["fblodtype"] = $(this).parent().prev().val();
                setCookie("fblodtype", blod["fblodtype"] );
				$(this).parent().parent().remove();
				if(blod["fblodtype"] != "") {
					$suibian.append('<div class="form" style="height:40px;"><div class="submit" style="float:left;margin:10px"><label>你的血型：</label> <label>' + blod["fblodtype"] + '</label></div></div><a href="javascript:;" data="blod"><i class="glyphicon glyphicon-plus" ></i>编辑血型</a>');
					$("#uldy a").click(function() {
						$(this).prev().remove();
						newTel(this);
					});
				} else
					$suibian.append('<a href="javascript:;" data="blod"><i class="glyphicon glyphicon-plus" ></i>添加血型</a>');

					$('#uldy a[data="blod"]').click(function() {
						newTel(this);
					});

				$.ajax({
					url: "/fasebooke/user/update.action",
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify(blod),
					dataType: "text",
					success: function(message) {
						console.log(message);
					}
				});
			} else {
				$(this).parent().parent().remove();
				if(blod["fblodtype"] == undefined) {
					$suibian.append('<a href="javascript:;" data="blod"><i class="glyphicon glyphicon-plus" ></i>编辑血型</a>');
					var y = $suibian.find("a");
					y = y[y.length - 1];
					$(y).click(function() {
						newTel(this);
					});
				} else {
					$suibian.append('<div class="form"><label style="margin-left:-10px">你的血型：</label><label>' + blod["fblodtype"] + '</label></div><a href="javascript:;" data="blod"><i class="glyphicon glyphicon-plus" ></i>编辑血型</a>');

					$('#uldy a[data="blod"]').click(function() {
						$(this).prev().remove();
						newTel(this);
					});
				}
			}
		});
	}
	if($(e).attr("data") == "fliveplace") {
		var fliveplace = {
				"fuid": getCookie("fuid"),
				"fhometown": getCookie("fhometown")
			};
		console.log(fliveplace);
		$yy = $(e).parent();
		var mediabody = $yy.children()[2];
		mediabody.firstElementChild.remove();
		$(mediabody).append('<div class="form"><div style="text-align:center"><label>故乡：</label><img src="" style="height:40px;width:40px;border:1px dashed #4080ff;"><input name="text" ><ul name="EngineModel" style="height: auto;width:202px; margin-left: 272px; position: absolute; display: none;background:-webkit-gradient(linear, left top, left 25, from(#FFFFFF), color-stop(4%, #EEEEEE), to(#FFFFFF))"></ul></div><div class="submit" style="text-align:center;margin-top:20px;margin-left:60px"><input type="button" value="保存"><input type="button" value="取消"></div></div>');
         search("local.action");
		$(e).remove();

		$("#uldy input[type='button']").on("click", function() {
			$suibian = $(this).parent().parent().parent();

			if($(this).attr("value") == '保存') {

				var ss = $suibian.children()[0];
				console.log(ss);
				var z = $($(ss).children()[0]);
				fliveplace["fhometown"]=getCookie("fhometown");
				$(this).parent().parent().remove();
				$suibian.parent().append('<a class="pull-left" href="javascript:;" data="fliveplace" ><div style="height:64px;width:64px;border:1px dashed #4080ff;"><img src="'+getCookie("fhome")+'" style="width:62px;height:62px;"></img> </div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">' + getCookie('fliveplace') + '</h4> </div>');
				$suibian.parent().children()[1].remove();
				$('#uldy a[data="fliveplace"]').click(function() {
					newTel(this);
				});
				$.ajax({
					url: "/fasebooke/user/update.action",
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify(fliveplace),
					dataType: "text",
					success: function(message) {
						console.log(message);
					}
				});
			} else {
				$(this).parent().parent().remove();
				if(fliveplace["fhometown"] == "") {
					$suibian.parent().append(' <a class="pull-left" href="javascript:;" data="fliveplace"><div style="height:64px;width:64px;border:1px dashed #4080ff;"><i class="glyphicon glyphicon-plus" style="line-height:60px;margin-left:22px"></i></div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">添加故乡</h4></div>');
				} else {
					$suibian.parent().append('<a class="pull-left" href="javascript:;" data="fliveplace" ><div style="height:64px;width:64px;border:1px dashed #4080ff;"><img src="'+getCookie("fhome")+'" style="width:62px;height:62px;"></img> </div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">' + fliveplace["fhometown"] + '</h4> </div>');
				}
				$suibian.parent().children()[1].remove();
				$('#uldy a[data="fliveplace"]').click(function() {
					newTel(this);
				});
			}
		});

	}
 
	if($(e).attr("data") == "other") {

			var other = {
		"fuid": getCookie("fuid"),
		"ltype": "",
		"ltitle":""
	};
		$yy = $(e).parent();
		var mediabody = $yy.children()[1];
		
		$yy.before('<div class="form"><div style="text-align:center"><label>其他住地：</label><img src="" style="height:40px;width:40px;border:1px dashed #4080ff;"><input name="text"><ul name="EngineModel" style="height: auto;width:202px; margin-left: 272px; position: absolute; display: none;background:-webkit-gradient(linear, left top, left 25, from(#FFFFFF), color-stop(4%, #EEEEEE), to(#FFFFFF))"></ul></div><div class="submit" style="text-align:center;margin-top:20px;margin-left:60px"><input type="button" value="保存"><input type="button" value="取消"></div></div>');
		   search("local.action");
	    
		var isexit = $(mediabody.firstElementChild).text();
		if(isexit == other["ltitle"]) {
			$yy.remove();
		}
		
		$("#uldy input[type='button']").on("click", function(e) {
			
			$suibian = $(e.target).parent().parent();
			if($(this).attr("value") == '保存') {
				var ss = $suibian.children()[0];
				var z = $(ss).children()[2];
				$charu = $suibian.next();
			
				$suibian.remove();
				other["ltitle"] = $(z).val();
				other["ltype"]=getCookie("ltype");
				$.ajax({
					url: "/fasebooke/jian/addlife.action",
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify(other),
					dataType: "text",
					success: function(message) {
						$charu.before('<div class="b"><a class="pull-left" href="javascript:;" ><div style="height:64px;width:64px;border:1px dashed #4080ff;"><img src="'+getCookie("ltype")+'" style="width:62px;height:62px;"></img> </div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">' + $(z).val() + '</h4> </div><span lfid="'+message+'" class="glyphicon glyphicon-trash" style="float:right;margin-top:-60px;color:#E5E5E5;font-size:30px" onclick="del(this)" onmouseover="show(this)" onmouseout="showoff(this)"></span></div>');
					}
				});
			} else {
				$suibian.remove();
			}
		});

	}

	if($(e).attr("data") == "personal") {
		var personal = {
				"fuid": getCookie("fuid"),
				"fpersonal":getCookie("fpersonal")
			};
		$yy = $(e).parent();
		var mediabody = $yy.children()[2];
		mediabody.firstElementChild.remove();
		$(mediabody).append('<div class="form"><label>自我描述：</label><textarea></textarea></div><div class="submit" style="text-align:center;margin:5px"><select class="input-sm haha" style="margin-right:4px"><option>公开</option><option>好友</option><option>仅自己</option></select><input type="button" value="保存"><input type="button" value="取消"></div>');

		$(e).remove();

		$("#uldy input[type='button']").on("click", function() {
			$suibian = $(this).parent().parent().parent();
			console.log($suibian);
			if($(this).attr("value") == '保存') {

				var ss = $suibian.children()[1];
				console.log(ss);
				var z = $($(ss).children()[0]).children()[1];
				personal["fpersonal"] = $(z).val();
				$(ss).remove();
				$suibian.append('<a class="pull-left" href="javascript:;" data="personal" ><div style="height:64px;width:64px;border:1px dashed #4080ff;"><img src="" style="width:62px;height:62px;"></img> </div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">' + $(z).val() + '</h4> </div>');
				/*	    $suibian.parent().children()[1].remove();*/
				$('#uldy a[data="personal"]').click(function() {
					newTel(this);
				});
				$.ajax({
					url: "/fasebooke/user/update.action",
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify(personal),
					dataType: "text",
					success: function(message) {
						console.log(message);
					}
				});
			} else {

				$($suibian.children()[1]).remove();
				if(personal["fpersonal"] == "") {
					$suibian.append(' <a class="pull-left" href="javascript:;" data="personal"><div style="height:64px;width:64px;border:1px dashed #4080ff;"><i class="glyphicon glyphicon-plus" style="line-height:60px;margin-left:22px"></i></div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">编辑自我描述</h4></div>');
				} else {
					$suibian.append('<a class="pull-left" href="javascript:;" data="personal" ><div style="height:64px;width:64px;border:1px dashed #4080ff;"><img src="http://localhost:8080/img/face/Text_Pirate_72px_1082461_easyicon.net.png" style="width:62px;height:62px;"></img> </div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">' + personal["fpersonal"] + '</h4> </div>');
				}
				/*	  $suibian.parent().children()[1].remove();*/
				$('#uldy a[data="personal"]').click(function() {
					newTel(this);
				});
			}
		});

		
	}
	if($(e).attr("data") == "likeword") {
		var likeword = {
				"fuid": getCookie("fuid"),
				"flikeword": getCookie("flikeword")
			};
		$yy = $(e).parent();
		var mediabody = $yy.children()[2];
		mediabody.firstElementChild.remove();
		$(mediabody).append('<div class="form"> <label>喜爱的名言：</label><input type="text"> <div class="submit" style="float:right;margin:5px"><select class="input-sm haha"style="margin-right:4px" ><option>公开</option><option>好友</option><option>仅自己</option></select><input type="button" value="保存"><input type="button" value="取消"></div></div>');

		$(e).remove();

		$("#uldy input[type='button']").on("click", function() {
			$suibian = $(this).parent().parent();
			if($(this).attr("value") == '保存') {

				var z = $suibian.children()[1];
				likeword["flikeword"] = $(z).val();

				$suibian.parent().append('<span></span><a class="pull-left" href="javascript:;" data="likeword" ><div style="height:64px;width:64px;border:1px dashed #4080ff;"><img src="" style="width:62px;height:62px;"></img> </div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">' + $(z).val() + '</h4> </div>');
				$suibian.remove();
				/*	    $suibian.parent().children()[1].remove();*/
				$('#uldy a[data="likeword"]').click(function() {
					newTel(this);
				});
				$.ajax({
					url: "/fasebooke/user/update.action",
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify(likeword),
					dataType: "text",
					success: function(message) {
						console.log(message);
					}
				});
			} else {

				$($suibian.children()[1]).remove();
			

				if(likeword["flikeword"] == "") {
					$suibian.parent().append(' <span></span><a class="pull-left" href="javascript:;" data="likeword"><div style="height:64px;width:64px;border:1px dashed #4080ff;"><i class="glyphicon glyphicon-plus" style="line-height:60px;margin-left:22px"></i></div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">编辑最喜爱的名言</h4></div>');
				} else {
					$suibian.parent().append('<span></span><a class="pull-left" href="javascript:;" data="likeword" ><div style="height:64px;width:64px;border:1px dashed #4080ff;"><img src="http://localhost:8080/img/face/LIKE_100.09756097561px_1179710_easyicon.net.png" style="width:62px;height:62px;"></img> </div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">' + likeword["flikeword"] + '</h4> </div>');
				}

				$suibian.remove();
				$('#uldy a[data="likeword"]').click(function() {
					newTel(this);
				});
			}
		});

	}

	if($(e).attr("data") == "uwork") {
		var uwork = {
				"fuid": getCookie("fuid"),
				"ucompanyname": getCookie("ucompanyname"),
				"uzhiwei": getCookie("uzhiwei"),
				"ulocation": getCookie("ulocation"),
				"udescription": getCookie("udescription"),
				"uworkid":getCookie("uworkid")
			};
		$yy = $(e).parent();
		console.log($yy);
		var mediabody = $yy.children()[2];
		mediabody.firstElementChild.remove();
		$(mediabody).append('<div class="b"><div class="form"><label>公司：</label><input style="text"></div><div class="form"><label>职位：</label><input style="text"></div><div class="form"><label>市/县：</label><input style="text"></div><div class="form"><label>说明：</label><textarea ></textarea></div><div class="submit" style="text-align:center;margin:5px"><select class="input-sm haha"><option>公开</option><option>好友</option><option>仅自己</option></select><input type="button" value="保存"><input type="button" value="取消"></div></div>');

		$(e).remove();

		$("#uldy input[type='button']").on("click", function() {
			var neirong = [];
			$suibian = $(this).parent().parent().parent(); /* mediabody*/

			var inpu = $suibian.children().children();
			for(var i = 0; i < 4; i++) {

				if($($(inpu[i]).children()[1]).val() != '') {
					neirong[i] = $($(inpu[i]).children()[1]).val();

				}

			}

			var z = "";
			if($(this).attr("value") == '保存') {
				console.log(neirong.length);
				if(neirong.length > 0) {

					for(var i = 0; i < neirong.length; i++) {
						z += neirong[i];
					}
					uwork["ucompanyname"] = neirong[0];
					uwork["uzhiwei"] = neirong[1];
					uwork["ulocation"] = neirong[2];
					uwork["udescription"] = neirong[3];

					$suibian.parent().append('<a class="pull-left" href="javascript:;" data="uwork" ><div style="height:64px;width:64px;border:1px dashed #4080ff;"><img src="" style="width:62px;height:62px;"></img> </div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">' + z + '</h4> </div>');

				} else {
					console.log(uwork["ucompanyname"] + uwork["uzhiwei"] + uwork["ulocation"] + uwork["udescription"]);
					if(uwork["ucompanyname"] + uwork["uzhiwei"] + uwork["ulocation"] + uwork["udescription"] == '') {

						$suibian.parent().append(' <a class="pull-left" href="javascript:;" data="uwork"><div style="height:64px;width:64px;border:1px dashed #4080ff;"><i class="glyphicon glyphicon-plus" style="line-height:60px;margin-left:22px"></i></div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">添加工作</h4></div>');
					} else {

						$suibian.parent().append('<a class="pull-left" href="javascript:;" data="uwork" ><div style="height:64px;width:64px;border:1px dashed #4080ff;"><img src="http://localhost:8080/img/face/company_72px_564445_easyicon.net.png" style="width:62px;height:62px;"></img> </div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">' + uwork["ucompanyname"] + uwork["uzhiwei"] + uwork["ulocation"] + '</h4> </div>');
					}
				}
				$suibian.remove();
				$('#uldy a[data="uwork"]').click(function() {
					newTel(this);
				});
				$.ajax({
					url: "/fasebooke/jian/'"+getCookie("fuid")+"'/updateW.action",
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify(uwork),
					dataType: "text",
					success: function(message) {
						console.log(message);
					}
				});
			} else {
				$($suibian.children()[1]).remove();
				console.log($suibian);

				if(uwork["ucompanyname"] + uwork["uzhiwei"] + uwork["ulocation"] + uwork["udescription"] == '') {
					$suibian.parent().append(' <a class="pull-left" href="javascript:;" data="uwork"><div style="height:64px;width:64px;border:1px dashed #4080ff;"><i class="glyphicon glyphicon-plus" style="line-height:60px;margin-left:22px"></i></div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">添加工作</h4></div>');
				} else {
					$suibian.parent().append('<a class="pull-left" href="javascript:;" data="uwork" ><div style="height:64px;width:64px;border:1px dashed #4080ff;"><img src="http://localhost:8080/img/face/company_72px_564445_easyicon.net.png" style="width:62px;height:62px;"></img> </div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">' + uwork["ucompanyname"] + uwork["uzhiwei"] + uwork["ulocation"] + '</h4> </div>');
				}

				$suibian.remove();
				$('#uldy a[data="uwork"]').click(function() {
					newTel(this);
				});
			}
		});

	}

	if($(e).attr("data") == "Deducation") {
		var Deducation = {
				"fuid": getCookie("fuid"),
				"uschool": getCookie("Duschool"),
				"utime": getCookie("Dutime"),
				"ubstate":getCookie("Dubstate"),
				"udescription": getCookie("Dudescription"),
				"upro": getCookie("Dupro"),
				"uedid":getCookie("Duedid")
			};
		$yy = $(e).parent();

		var mediabody = $yy.children()[2];
		mediabody.firstElementChild.remove();
		$(mediabody).append('<div class="b"><div class="form"><label>大学：</label><input name="text"><ul name="EngineModel" style="height: auto;width:202px; margin-left: 272px; position: absolute; display: none;background:-webkit-gradient(linear, left top, left 25, from(#FFFFFF), color-stop(4%, #EEEEEE), to(#FFFFFF))"></ul></div><div class="form"><label>专业：</label><input style="text"></div><div class="form"><label style="margin-right:30px;">从</label><input type="date"></div><div class="form"><label style="margin-right:30px;">至 </label><input type="date"></div><div class="form"><label>已毕业：</label><input type="checkbox"></div><div class="form"><label>说明：</label><textarea ></textarea></div><div class="submit" style="text-align:center;margin:5px"><select class="input-sm haha"><option>公开</option><option>好友</option><option>仅自己</option></select><input type="button" value="保存"><input type="button" value="取消"></div></div>');
         search("college.action");
		$(e).remove();

		$("#uldy input[type='button']").on("click", function() {
			var neirong = [];
			$suibian = $(this).parent().parent().parent(); /* mediabody*/

			var inpu = $suibian.children().children();

		
				
			var z = "";
			if($(this).attr("value") == '保存') {
				console.log(getCookie('fplace'));
				Deducation["utime"] = $($(inpu[2]).children()[1]).val() + $($(inpu[3]).children()[1]).val();
				Deducation["ubstate"] = $($(inpu[4]).children()[1]).is(":checked");
				if(Deducation["ubstate"]==true){
					Deducation["ubstate"]=1;
				}else {
					Deducation["ubstate"]=0;
				}
				Deducation["udescription"] = $($(inpu[5]).children()[1]).val();
				Deducation["upro"] = $($(inpu[1]).children()[1]).val();
			     Deducation["uschool"]= $($(inpu[0]).children()[1]).val();
          
if(Deducation["uschool"] + Deducation["udescription"] + Deducation["upro"] + Deducation["utime"]== '') {
	
						$suibian.parent().append(' <a class="pull-left" href="javascript:;" data="Deducation"><div style="height:64px;width:64px;border:1px dashed #4080ff;"><i class="glyphicon glyphicon-plus" style="line-height:60px;margin-left:22px"></i></div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">添加大学</h4></div>');
					} else {
                        if(Deducation["upro"]== ''){
                        	Deducation["upro"]="未知";
                        }
						$suibian.parent().append('<a class="pull-left" href="javascript:;" data="Deducation" ><div style="height:64px;width:64px;border:1px dashed #4080ff;"><img src="'+getCookie('fplace')+'" style="width:62px;height:62px;"></img> </div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">' + Deducation["uschool"] + Deducation["upro"] + '</h4> </div>');
					}
			
				$suibian.remove();
				$('#uldy a[data="Deducation"]').click(function() {
					newTel(this);
				});
				
				$.ajax({
					url: "/fasebooke/jian/"+getCookie("fuid")+"/updateE.action",
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify(Deducation),
					dataType: "text",
					success: function(message) {
						console.log(message);
					}
				});
			} else {
				console.log(getCookie('fplace'));
				$($suibian.children()[1]).remove();
				console.log($suibian);
				if(Deducation["uschool"] + Deducation["udescription"] + Deducation["upro"] + Deducation["utime"] == '') {
					$suibian.parent().append(' <a class="pull-left" href="javascript:;" data="Deducation"><div style="height:64px;width:64px;border:1px dashed #4080ff;"><i class="glyphicon glyphicon-plus" style="line-height:60px;margin-left:22px"></i></div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">添加大学</h4></div>');
				} else {
					$suibian.parent().append('<a class="pull-left" href="javascript:;" data="Deducation" ><div style="height:64px;width:64px;border:1px dashed #4080ff;"><img src="'+getCookie('fplace')+'" style="width:62px;height:62px;"></img> </div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">' + Deducation["utime"]+Deducation["uschool"] + Deducation["upro"] + '</h4> </div>');
				}

				$suibian.remove();
				$('#uldy a[data="Deducation"]').click(function() {
					newTel(this);
				});
			}
		});

	}
	if($(e).attr("data") == "Geducation") {
		var Geducation = {
				"fuid": getCookie("fuid"),
				"uschool": getCookie("Guschool"),
				"utime": getCookie("Gutime"),
				"ubstate":getCookie("Gubstate"),
				"udescription": getCookie("Gudescription"),
				"upro": getCookie("Gupro"),
				"uedid":getCookie("Guedid")
			};
		$yy = $(e).parent();
		console.log($yy);
		var mediabody = $yy.children()[2];
		mediabody.firstElementChild.remove();
		$(mediabody).append('<div class="b"><div class="form"><label>高中：</label><input name="text" ></div><div class="form"><label style="margin-right:30px;">从</label><input type="date"></div><div class="form"><label style="margin-right:30px;">至</label><input type="date"></div><div class="form"><label>已毕业：</label><input type="checkbox"></div><div class="form"><label>说明：</label><textarea ></textarea></div><div class="submit" style="text-align:center;margin:5px"><select class="input-sm haha"><option>公开</option><option>好友</option><option>仅自己</option></select><input type="button" value="保存"><input type="button" value="取消"></div></div>');
          search("college.action");
		$(e).remove();

		$("#uldy input[type='button']").on("click", function() {
			$suibian = $(this).parent().parent().parent(); /* mediabody*/

			var inpu = $suibian.children().children();

			var z = "";
			if($(this).attr("value") == '保存') {
				
				Geducation["utime"] = $($(inpu[1]).children()[1]).val() + $($(inpu[2]).children()[1]).val();
				Geducation["ubstate"] = $($(inpu[3]).children()[1]).is(":checked");
				if(Geducation["ubstate"]==true){
					Geducation["ubstate"]=1;
				}else {
					Geducation["ubstate"]=0;
				}
				Geducation["udescription"] = $($(inpu[4]).children()[1]).val();
				Geducation["uschool"]= $($(inpu[0]).children()[1]).val();
               
if(Geducation["uschool"] + Geducation["udescription"] + Geducation["utime"]== '') {

						$suibian.parent().append(' <a class="pull-left" href="javascript:;" data="Geducation"><div style="height:64px;width:64px;border:1px dashed #4080ff;"><i class="glyphicon glyphicon-plus" style="line-height:60px;margin-left:22px"></i></div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">添加高中</h4></div>');
					} else {

						$suibian.parent().append('<a class="pull-left" href="javascript:;" data="Geducation" ><div style="height:64px;width:64px;border:1px dashed #4080ff;"><img src="http://localhost:8080/img/face/school_266px_1150096_easyicon.net.png" style="width:62px;height:62px;"></img> </div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">' + Geducation["uschool"] + Geducation["utime"] + '</h4> </div>');
					}
			
				$suibian.remove();
				$('#uldy a[data="Geducation"]').click(function() {
					newTel(this);
				});
				console.log(getCookie("Gubstate"));
				$.ajax({
					url: "/fasebooke/jian/"+getCookie("fuid")+"/updateE.action",
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify(Geducation),
					dataType: "text",
					success: function(message) {
						console.log(message);
					}
				});
			} else {
				$($suibian.children()[1]).remove();
				console.log($suibian);
				if(Geducation["uschool"] + Geducation["udescription"] + Geducation["utime"] == '') {
					$suibian.parent().append(' <a class="pull-left" href="javascript:;" data="Geducation"><div style="height:64px;width:64px;border:1px dashed #4080ff;"><i class="glyphicon glyphicon-plus" style="line-height:60px;margin-left:22px"></i></div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">添加高中</h4></div>');
				} else {
					$suibian.parent().append('<a class="pull-left" href="javascript:;" data="Geducation"><div style="height:64px;width:64px;border:1px dashed #4080ff;"><img src="http://localhost:8080/img/face/school_266px_1150096_easyicon.net.png" style="width:62px;height:62px;"></img> </div></a><div class="media-body"><h4 class="media-heading" style="line-height:60px">' + Geducation["uschool"] + Geducation["utime"] + '</h4> </div>');
				}

				$suibian.remove();
				$('#uldy a[data="Geducation"]').click(function() {
					newTel(this);
				});
			}
		});

	}

}

function show(e) {
	$(e).css("color", "gray");
}

function showoff(e) {
	$(e).css("color", "#E5E5E5");
}

function del(e) {
	var life=$(e).attr("lfid");
	$($(e).parent()[0]).remove();
	$.ajax({
		  url:"/fasebooke/jian/"+life+"/del.action",
	        type:"post",
	        data:"",
	        dataType:"text",
	        success:function(message){
	       /*    返回一个t_comment的id，将t_comment生成一条回复*/
	            console.log(message);
	        }
	});
	
}
