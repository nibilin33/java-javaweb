package bank;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class NumberManger {
	private int customnumber=1;
	public CustomerType type;
public	LinkedList<String> que=new LinkedList<String>();

   public NumberManger(CustomerType type) {
		super();
		// TODO �Զ����ɵĹ��캯�����
		this.type=type;
	}

public synchronized String gernenatenumber()
   {   
	   String number=type+"�ͻ�"+(customnumber++)+"��";
	   if(que.add(number))
		  return number;
	   else
		   return null;
   }
public synchronized String getcustom()
{
	if(que.size()>0)
	   return que.remove(0);
	  else
		return null;
}

}
