var flight=function(ship_id,road_id,power_type,energy_type){
    this.ship_id=ship_id;
    this.road_id=road_id;
    this.energy_type=energy_type;
    this.recovery=TOOL.getShipPerform("recover",energy_type);
    this.power_type=power_type;
    this.ship_speed=TOOL.getShipPerform("speed",power_type);
    this.cost=TOOL.getShipPerform("cost",power_type);
    this.ship_state=0;
    this.destroy=1;
    this.ship_energy=100;
    this.move=function(){
       if(this.ship_state==0&&this.ship_energy>0){
           this.ship_state=1;
           shipMove(this);
       }
    }
    this.stop=function(){
       this.ship_state=0;
    }
    this.destroy=function(){
       this.destroy=0;
     //   TOOL.destroyShip(road_id,ship_id);
    }
    this.energyRecovery=function(){
        var old=this.ship_energy;
        var newone=old+this.recovery;
          if(newone>=100){
           this.ship_energy=100;
          }else{
            this.ship_energy=newone;
          }
          
    }
    setTimeout(this.energyRecovery,1000);
    this.isLife=function(){
        return destroy==1?true:false;
    }
    
}
shipMove=function(flight){
		if(flight.ship_state == 0){
			return;
        }
        var old=flight.ship_energy;
        flight.ship_energy=old-flight.cost/10;
        console.log(flight.ship_energy);
        if(flight.ship_energy<0){
            flight.ship_state=0;
            flight.ship_energy=0;
        }
		TOOL.Changep(flight.ship_id,flight.road_id);
    setTimeout(function(){return shipMove(flight);},1000);
}
