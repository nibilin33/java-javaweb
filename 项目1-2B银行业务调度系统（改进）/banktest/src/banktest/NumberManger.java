package banktest;

import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class NumberManger {
	private int customnumber=1;
	public	CustomerType type;
	public	LinkedList<String> que=new LinkedList<String>();
	private static Lock lock =new ReentrantLock();

   public NumberManger(CustomerType type) {
		super();
		// TODO 自动生成的构造函数存根
		this.type=type;
	}

public synchronized String gernenatenumber() {
	lock.lock();
	   String number=type+"客户"+(customnumber++)+"号";
	   if(que.add(number)){
		   lock.unlock();
		  return number;
	   }
	   else{
		   lock.unlock();
		   return null;
	   }
   }
public synchronized String getcustom(){
	lock.lock();
	if(que.size()>0){
		lock.unlock();
	   return que.remove();
	}
	  else{
		  lock.unlock();
		return null;
	  }
}

}
