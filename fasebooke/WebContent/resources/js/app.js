
$("document").ready(function(){
	$("input[name='telemail']").blur(function(){
		 var s=$(this).val().trim();
		    
	     if(s==''||s==null||s==undefined){
	    	 console.log(s+"ddddddd");
	    	 $("#telemail").html("");
	    	 $("#telemail").html("不能为空");
	    	 $("input[name='telemail']").focus();
	     }
	});
		$("input[name='firstname']").blur(function(){
			 var s=$(this).val().trim();
			    
		     if(s==''||s==null||s==undefined){
		    	 console.log(s+"ddddddd");
		    	 $("#iname").html("");
		    	 $("#iname").html("姓名不能为空");
		    	 $("input[name='firstname']").focus();
		     }else {
		    	 $("#iname").html("");
			}
		});
	$("input[name='lastname']").blur(function(){
		 var s=$(this).val().trim();
		    
	     if(s==''||s==null||s==undefined){
	    	 console.log(s+"ddddddd");
	    	 $("#iname").html("");
	    	 $("#iname").html("姓名不能为空");
	    	 $("input[name='lastname']").focus();
	     }else{
	    	 $("#iname").html("");
	     }
	});
	$("input[name='ogame']").blur(function(){
		 var s=$(this).val().trim();
		    
	     if(s==''||s==null||s==undefined){
	    	 console.log(s+"ddddddd");
	    	 $("#ogame").html("");
	    	 $("#ogame").html("密码不能为空");
	    	 $("input[name='ogame']").focus();
	     }
	});
 $("input[name='telemail']").change(function(){   
     var pattern=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
     var pattern2=/^(13|15|18)\d{9}$/;
     var s=$(this).val().trim();
    var l=$("input[name='lastname']").val().trim();
    var t=$("input[name='firstname']").val().trim();
    if(t==''||t==null||t==undefined){
    	 $("#iname").html("");
    	 $("#iname").html("姓名不能为空");
    	 $("input[name='firstname']").focus();
    }
    if(l==''||l==null||l==undefined){
    	 $("#iname").html("");
    	 $("#iname").html("姓名不能为空");
    	 $("input[name='lastname']").focus();
    }
     if(s==''||s==null||s==undefined){
    	 console.log(s+"ddddddd");
    	 $("#telemail").html("");
    	 $("#telemail").html("不能为空");
    	 $("input[name='telemail']").focus();
     }
     if(s.indexOf("@")>0){
       if(!pattern.test(s)){
    $("#telemail").html("请输入正确邮箱格式");
   
    $("input[name='telemail']").focus();
          }else{
               $("#telemail").html("");
          }
     }else{
         if(!pattern2.test(s)){
               $("#telemail").html("请输入正确电话格式");
    $("input[name='telemail']").focus();
         }else
             {
                 $("#telemail").html(""); 
             }
         
     }
});
   $("input[name='ogame']").change(function(){
        var pp=/^[0-9a-zA-Z_]{6,15}$/
       var s=$(this).val().trim();
        if(s == ''){
        	 $("#ogame").html("密码不能为空");
        	 $("input[name='ogame']").focus();
        }
          if(pp.test(s)){
               $("#ogame").html("");
          }else{
              $("#ogame").html("密码格式错误");
          }
   });
      $("input[name='password2']").change(function(){
var ss=$("input[name='ogame']").val().trim(); 
 var ch=$(this).val().trim();
          if(ss===ch){
            $("#pa").html("");  
               
          }else
              {
        	  
               $("#pa").html("密码错误"); 
                   
          }
        
   });
    
    $("#btn2").click(function(){
    	 var kk=$("input[name='telemail']").val();
    	 var l=$("input[name='lastname']").val().trim();
    	    var t=$("input[name='firstname']").val().trim();
    	if(kk==''||kk==undefined||kk==null||t==''||t==null||t==undefined||l==''||l==null||l==undefined){
    		alert("请完整填写信息");
    		return;
    	}
       $.ajax({
           type:"POST",
           url:"/fasebooke/user/register.action",
           contentType: "application/json",
           data: JSON.stringify(GetJsonData(kk)),
           dataType:"text",
           success:function(message){
        	   var dataObj=eval("("+message+")");
        	   
        	    if(dataObj.susucess=="200"){
        	    	alert("注册成功！请登录");
        	    	$("input[type=text]").val("");
        	    	$("input[type=password]").val("");
        	    }else{
        	    	alert("改手机或邮箱已被注册！");
        	    	$("input[type=text]").val("");
        	    	$("input[type=password]").val("");
        	    }
        	    	
        	   console.log(dataObj.susucess);
           },
           error:function(message){
               console.log(message);
           }
           
       }
       );
    });
   function GetJsonData(xx) {
        var json;
        var name=$("input[name='lastname']").val()+$("input[name='firstname']").val();
        console.log($("input[name='ogame']").val());
       if(xx.indexOf("@")>0){
    	  
   json = {
        "fname":name,
        "fsex": $("input[name='sex']:checked").val(),
        "fbirthday": $("input[type='date']").val(),
        "femail": $("input[name='telemail']").val(),
       "fpassword": $("input[name='ogame']").val(),
       "fliveplace":window.p,
                  "fstate":1
    };
       }else
           {
              json = {
        "fname":name,
        "fsex": $("input[name='sex']:checked").val(),
        "fbirthday": $("input[type='date']").val(),
        "ftel": $("input[name='telemail']").val(),
       "fpassword": $("input[name='ogame']").val(),
                  "fliveplace":window.p,
                  "fstate":1
                  
    };  
           }
       console.log(json);
    return json; 
}
});
