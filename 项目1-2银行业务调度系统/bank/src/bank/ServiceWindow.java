package bank;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceWindow {
	private CustomerType customertype;
	public int winnumber;
	private boolean available=false;
	public String nn="";
	public ServiceWindow(CustomerType customertype, int winnumber) {
		super();
		this.customertype = customertype;
		this.winnumber = winnumber;
	}

	public void start(){
		available=true;
		ExecutorService pool= Executors.newSingleThreadExecutor();
		pool.execute(new Runnable(){

			@Override
			public void run() {
				// TODO �Զ����ɵķ������
				switch(customertype){
				case GENERAL:
					while(available){
						servicegenernal();
					}
				case QUICK:
					while(available){
						servicequick();
					}
				case VIP:
					while(available){
						servicevip();
					}
				}
				
			}
			
		});
	}
	private void servicegenernal()
	{
		NumberManger q=NumberMachine.getinstant().getmanger(CustomerType.GENERAL);
		if(q.que.size()>0){
			 String name =q.getcustom(); 
		   int time = generalCustomerServicing();
		   Main.textArea.setText(name+"������ϣ���ʱ"+time+"��");
		}
		   else{
			            
			              try {
			                   Thread.sleep(1000);
			              } catch (InterruptedException e) {
			             
			                  e.printStackTrace();
			               }
			           }
		}

	private void servicequick()
	{
		NumberManger q1=NumberMachine.getinstant().getmanger(CustomerType.QUICK);
		if(q1.que.size()>0){
			 String name =q1.getcustom();
		   int time = quickCustomerServicing();
		   Main.textArea_1.setText(name+"������ϣ���ʱ"+time+"��");
		  
		}
		   else{
			            
			              try {
			                   Thread.sleep(1000);
			              } catch (InterruptedException e) {
			             
			                  e.printStackTrace();
			               }
			           }
	}
	private void servicevip()
	{
		NumberManger q2=NumberMachine.getinstant().getmanger(CustomerType.VIP);
		if(q2.que.size()>0){
			 String name =q2.getcustom();	 
		   int time = vipCustomerServicing(); 
		   Main.textArea_2.setText(name+"������ϣ���ʱ"+time+"��");
		  
		}
		   else{
			            
			              try {
			                   Thread.sleep(1000);
			              } catch (InterruptedException e) {
			             
			                  e.printStackTrace();
			               }
			           }
	}
	 private int generalCustomerServicing(){
		        int time = new Random().nextInt(
		                 Constants.MAX_SERVICE_TIME-Constants.MIN_SERVICE_TIME)+
		                 Constants.MIN_SERVICE_TIME;
		         try {
		             Thread.sleep(time*1000);
		         } catch (InterruptedException e) {
		            // TODO Auto-generated catch block
		             e.printStackTrace();
		        }
		          return time;
		      }
		 
		     private int quickCustomerServicing(){
		         int time = Constants.MIN_SERVICE_TIME;
		         try {
		             Thread.sleep(time*1000);
		         } catch (InterruptedException e) {
		            // TODO Auto-generated catch block
		             e.printStackTrace();
		          }
		          return time;
		      }
		   
		     private int vipCustomerServicing(){
		         int time = new Random().nextInt(
		                      Constants.MAX_SERVICE_TIME-Constants.MIN_SERVICE_TIME)+
		                      Constants.MIN_SERVICE_TIME;
		       try {
		             Thread.sleep(time*1000);
		        } catch (InterruptedException e) {
		              // TODO Auto-generated catch block
		              e.printStackTrace();
		          }
		         return time;
		     }
		      
		      @Override
		      public String toString() {
		          // TODO Auto-generated method stub
		         return customertype+"����"+winnumber+"��";
		     }

}
