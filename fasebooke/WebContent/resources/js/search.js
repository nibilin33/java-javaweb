$(document).ready(function(){
    $("#question").keyup(function(){
        var q=$(this).val();
       if (q == ''){
    	   $("#search_sugest").css('display','none');
    	   
       }else{
        $.ajax({
            url:"/fasebooke/help/hahaha.action",
            type:"post",
            data:"query="+q,
            dataType:"text",
            success:function(message){
            	$("#search_sugest").css('display','block');
            	  analay(message);
                
            }
                 
    });}
    });
           $('#sta').on("click","a",function(event){
               var ta=event.target;
               var haha=ta.innerHTML;
               console.log(haha);
               $.ajax({
              url:"/fasebooke/help/help2.action",
              type:"POST",
              data:"query="+ta.innerHTML,
              dataType:"text",
              success:function(message){
              	$("#search_sugest").css('display','none');
              $("#change").html("");
              var obj=eval("("+message+")");
            
              console.log(message);
              $("#change").append(' <h3  class="text-center">'+haha+'</h3>');
              var ret=message.split(":")[1].split('"')[1].split("。");
              for(var i=0;i<ret.length;i++){
              	  console.log(ret[i]);
              		$("#change").append('<blockquote  class="blockquotes"><p>'+ret[i]+'</p></blockquote>');
              
              }
              
              }
               }
                ); 
            });

          $("#getsearch").on("click","a",function(event){
             var ta=event.target;
             var haha=ta.innerHTML;
             $.ajax({
            url:"/fasebooke/help/help2.action",
            type:"POST",
            data:"query="+ta.innerHTML,
            dataType:"text",
            success:function(message){
            	$("#search_sugest").css('display','none');
            $("#change").html("");
            var obj=eval("("+message+")");
            /*var an=obj["hah"];
            console.log(an);*/
            $("#change").append(' <h3  class="text-center">'+haha+'</h3>');
            var ret=message.split(":")[1].split('"')[1].split("。");
            for(var i=0;i<ret.length;i++){
            	
            		$("#change").append('<blockquote  class="blockquotes"><p>'+ret[i]+'</p></blockquote>');
            
            }
            
            }
             }
              ); 
          }); /*$("#getsearch").delegate("a","click",function(event){
            var ta=$(event.target);
                console.log(ta);
             $.ajax({
            url:"/fasebooke/help/help2.action",
            type:"POST",
            data:"query="+ta,
            dataType:"text",
            success:function(message){
            $("#change").html("");
            $("#change").append(message);
                console.log(message);
            }
             }
              );
           
            
   
});*/
});

function analay(message){

    $("#getsearch").html("");
    if(!message==""){
    var obj=eval("("+message+")");
  
    $.each(obj.hah,function(i,item){
    	
        $("#getsearch").append('<li><a>'+item.questions+'</a></li>');
    }); 
    }
    
}

