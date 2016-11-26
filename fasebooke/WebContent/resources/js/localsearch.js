var T=(function (){
    var focus = false;
        $('#srch-term').focus(function () {
          console.log("dddddd");
            focus = true;
          /*  $(this).next().css('display', 'block');*/
        }).blur(function () {
            if (focus) {
              /*  $(this).next().css('display', 'none');*/
            }
        }).keyup(function(){
        var q=$(this).val();
       if (q == ''){
    	  /* $(this).next().css('display', 'none');  */ 
       }else{
    	   var ul = $(this).next();
    	   $.ajax({
	            url:"/fasebooke/user/friendsearch.action",
	            type:"post",
	            data:"friend="+q,
	            dataType:"text",
	            success:function(message){
	            	console.log(message);
	            	  //$(this).next().css('display', 'block');
	                ul.empty();
	            	ul.css('display', 'block');
	            	var res = message.split('[')[1].split(']')[0].split('},{');
	                for(var i = 0; i < res.length; i++)
	                	if(res[i] != ""){
	                		if(i > 0)
	                			res[i] = "{" + res[i];
	                		if(i < res.length - 1)
	                			res[i] = res[i] + "}";
	                		res[i] = JSON.parse(res[i]);
	                		if(res[i].fheadimage == "")
	                			res[i].fheadimage = "face/100.png";
	                		else
	                			res[i].fheadimage = res[i].fuid+'/' + res[i].fheadimage;
	                			ul.append('<li style="margin-top:20px;cursor:pointer;color:gray;text-indent:1em;" onclick="selectli(this)"><img src="http://localhost:8080/img/'+res[i].fheadimage+'" style="width:30px;height:30px;float:left;">'+res[i].fname+" "+ res[i].fcount + '</li>');
	                	}
	            }
    	   });
       }
    });
})();
var cityarray={"厦门市":"xiamen.jpg","福州市":"fuzhou.jpg"};
function selectli(e){
	var fcount = e.innerHTML.split('>')[1].split(' ')[1];
	$(e).parent().prev().val(fcount);
	var x = $(e).parent().next().find('button')[0];
	$(x).click();
}
function fabu(){
	var fid=localStorage.getItem("current_id");
var x="http://localhost:8080/img/city/"+cityarray[$('#weizhi').text()];
$.ajax({
    url:"/fasebooke/fdynamiccontrol/"+fid+"/city.action",
    type:"post",
    dataType:"text",
    data:"im="+x,
    success:function(message){
        console.log(message);
    }
});
}