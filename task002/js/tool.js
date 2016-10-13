var SHIP_SPEED=[80,100];
var POWER_NAME=['邪恶力量','犯罪心理'];
var ENERGY_NAME=['能源一','能源二','能源三','能源四'];
var ENERGY_COST=[5,7];
var POWER_RECOVER=[2,3,4];
var ships = [null, null, null, null, null];
var Ship_Exit=[null,null,null,null,null];
var ships_circle=[0,250,350,450,550];
window.distroyable=0;
 var ship_id=1;
var TOOL={
    gettime:function(){ 
        var date=new Date();
        
    },
    Log:function(text){
    var info=document.getElementById("info");
    var lis=document.createElement("li");
    lis.innerHTML=text;
    info.appendChild(lis);
    },
    getShipPerform:function(type,index){
        var result=0;
        switch(type){
            case "recover":
                result=POWER_RECOVER[index];
                break;
            case "cost":
                result=ENERGY_COST[index];
                break;
            case "speed":
                result=SHIP_SPEED[index];
                break;
        }
        return result;  
    },
    createShip:function(ship_id,road_id,power_type,energy_type){
        var isenable=false;
         if(ships[road_id]!=null){
            TOOL.Log("第"+road_id+"轨道已有飞船，创建失败");
             isenable=false;
             
        }else{
        ships[road_id]=ship_id;
        var title="第"+road_id+"轨道-"+ship_id+"号飞船-"+POWER_NAME[power_type]+"-"+ENERGY_NAME[energy_type];
            TOOL.Log(title);
            TOOL.createControl(title,ship_id);
        var roadid="road"+road_id;
        var parent=document.getElementById(roadid);
        var objid="flight"+ship_id;
        var nodechild=document.createElement("div");
        nodechild.id=objid;
        nodechild.setAttribute("class","flight");
        var img=document.createElement("img");
        img.setAttribute("src","img/flight.png");
        var pp=document.createElement("p");
        pp.innerHTML=ship_id+"号100%";
        parent.appendChild(nodechild);
        nodechild.appendChild(img);
        nodechild.appendChild(pp);
           isenable=true;
           
        }
        Ship_Exit[road_id]=new flight(ship_id,road_id,power_type,energy_type);
        distroyable=0;
        return isenable;
        
    },
    createControl:function(title,ship_id){
        var parent=document.getElementById("ship-list");
        var list=document.createElement("li");
          parent.appendChild(list);
        var  spanlist=document.createElement("span");
        spanlist.innerHTML=title;
         list.appendChild(spanlist);
        var check=document.createElement("input");
        check.setAttribute("type","checkbox");
        check.setAttribute("id","begin"+ship_id);
        check.onclick=this.startship;
        list.appendChild(check);
        var lab=document.createElement("label");
        lab.setAttribute("for","begin"+ship_id);
         list.appendChild(lab);
        var checkend=document.createElement("input");
        checkend.setAttribute("type","checkbox");
        checkend.setAttribute("id","end"+ship_id);
         checkend.onclick=this.destroy;
         list.appendChild(checkend);
      
        var labend=document.createElement("label");
        labend.setAttribute("for","end"+ship_id);
        labend.innerHTML="注 &nbsp; 销"
        list.appendChild(labend);
         
                 },
      destroyControl:function(ship_id){
          var childnode=document.getElementById("begin"+ship_id);
          childnode.parentNode.remove();
          
      },
      Changep:function(ship_id,road_id){
         var ship=document.getElementById("flight"+ship_id);  
         // var childenode=ship.childNodes;
         
          var nodes=ship.childNodes;
         nodes[1].innerHTML=Ship_Exit[road_id].ship_energy+"%";
       // ship.innerHTML=Ship_Exit[road_id].ship_energy;
      //   console.log(Ship_Exit[road_id].ship_energy);
            
     },
    destroy:function(){
       
    var id=this.id;
        TOOL.destroyShip(window.shiparray[id][0],window.shiparray[id][1]);
        ships[window.shiparray[id][0]]=null;
        TOOL.destroyControl(window.shiparray[id][1]);
       distroyable=1;
     },
     destroyShip:function(road_id,ship_id){
         
         var parent=document.getElementById("road"+road_id);
         var childnode=document.getElementById("flight"+ship_id);
         childnode.parentNode.removeChild(childnode);
       
     },
    startship:function(){
        var id=this.id;
    var temp=id.match(/\d/g);
       var shipstart=document.getElementById("flight"+temp);
        var num=ships_circle[temp];
        var begin=document.getElementById(id);
       // console.log(shipstart);
        if(begin.checked){
            if(shipstart.className.match(/stop/)){
                shipstart.className="flight";
            
            }
        shipstart.classList.add("start");
        //shipstart.className="flight start";
            //alert(shipstart.className);
            
             Ship_Exit[window.shiparray["end"+temp][0]].move();
//            console.log(  Ship_Exit[window.shiparray["end"+temp][0]].ship_state);
        }else 
            {   
                shipstart.classList.add("stop");
            
           Ship_Exit[window.shiparray["end"+temp][0]].stop();
//               console.log( "stop"+ Ship_Exit[window.shiparray["end"+temp][0]].ship_state);
                //shipstart.className="flight stop";
               // alert(shipstart.className);
            }
    },
  change:  function (event){
    var road_id=document.getElementById("road_id").selectedIndex;
        var power_id=document.getElementById("power_id").selectedIndex;
        var recover_id=document.getElementById("recover_id").selectedIndex;
     
    if(distroyable==1){
        ship_id--;
    }
    var check= TOOL.createShip(ship_id,road_id,power_id,recover_id); 
   //  var fee=new flight(ship_id,road_id,power_id,recover_id);

    if(check==true)
        {  
  window.shiparray["end"+ship_id]=new Array();
  window.shiparray["end"+ship_id][0]=road_id;
 window.shiparray["end"+ship_id][1]=ship_id;
           // Ship_Exit[road_id].move();
             ship_id++;
            
        }
      
     
}
    
}
