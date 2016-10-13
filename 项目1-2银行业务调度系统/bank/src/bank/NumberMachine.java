package bank;

import java.util.Queue;

public class NumberMachine {
  private NumberManger gernel=new NumberManger(CustomerType.GENERAL);
  private NumberManger quik=new NumberManger(CustomerType.QUICK);
  private NumberManger vip=new NumberManger(CustomerType.VIP);
  
  public NumberManger getmanger(CustomerType ss){
	  switch(ss){
	  case GENERAL:
		  return gernel;
	  case QUICK:
		  return quik;
	  case VIP:
		  return vip;
		  
	  }
	 return null; 
  }
  public String generateTicket(CustomerType businessType){
	          switch(businessType){
	         case GENERAL:
	              return gernel.gernenatenumber();
	          case QUICK:
	              return quik.gernenatenumber();
	          case VIP:
	              return vip.gernenatenumber();
	           }
	           return null;
	      }
  private NumberMachine(){}
  private static NumberMachine instant=new NumberMachine();
  public static NumberMachine getinstant()
  {
	  return instant;
  }
  
}
