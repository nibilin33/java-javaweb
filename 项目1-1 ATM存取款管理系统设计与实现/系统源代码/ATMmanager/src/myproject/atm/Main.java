package myproject.atm;

public class Main {
public static void main(String[] args){
 Card card=new Card("0101");
 User user=new User("��û",'��',20,card);
 Account acount=new Account("1234",1000,user);
 System.out.println("�����뿨�ţ�");
 String cardNumber=Tools.inputString();
 
  while(!cardNumber.equals(acount.getUser().getCard().getCardNumber())){
	  System.out.println("���Ŵ������������룺");
	  cardNumber=Tools.inputString();
	 
	}
  System.out.println("���������룺");
  String password=Tools.inputString();
  while(!password.equals(acount.getPassword())){
	  System.out.println("����������������룺");
	  password=Tools.inputString();
  }
 while(true){
	 Tools.showATMinfo();
	 int i=Tools.inputInt();
	 switch(i){
	 case 1:
		 acount.savemoney();break;
	 case 2:
		 acount.outmoney();break;
	 case 3:
		 acount.showmoney();break;
	 case 4:
		 acount.modifypassword();break;
	 case 5:
		 Tools.show(acount);break;
	 case 6:
		 System.out.println("ϵͳ�Ѿ��˳����ټ�");return;
		 default:
			 Tools.showATMinfo();
	 }
 }
	}
}
