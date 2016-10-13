package myproject.atm;

public class Main {
public static void main(String[] args){
 Card card=new Card("0101");
 User user=new User("你没",'男',20,card);
 Account acount=new Account("1234",1000,user);
 System.out.println("请输入卡号：");
 String cardNumber=Tools.inputString();
 
  while(!cardNumber.equals(acount.getUser().getCard().getCardNumber())){
	  System.out.println("卡号错误，请重新输入：");
	  cardNumber=Tools.inputString();
	 
	}
  System.out.println("请输入密码：");
  String password=Tools.inputString();
  while(!password.equals(acount.getPassword())){
	  System.out.println("密码错误，请重新输入：");
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
		 System.out.println("系统已经退出，再见");return;
		 default:
			 Tools.showATMinfo();
	 }
 }
	}
}
