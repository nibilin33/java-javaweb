package myproject.atm;

import java.util.Scanner;

public class Tools {
 public static void show(Card card){
	 System.out.println("卡号："+card.getCardNumber());
	 
 }
 public static void show(User user){
	 show(user.getCard());
	 System.out.println("姓名："+user.getUsername());
	 System.out.println("性别："+user.getSex());
	 System.out.println("年龄："+user.getAge());
 }
 public static void show(Account account){
	 show(account.getUser());
	 System.out.println("密码："+account.getPassword());
	 System.out.println("余额："+account.getMoney());
	 
 } 
 public static void showATMinfo()
 {
	 System.out.println("ATM存取款管理系统，请选择你的操作：");
	 System.out.println("------------------------");
	 System.out.println("  1    存款 ");
	 System.out.println("  2    取款");
	 System.out.println("  3    查询余额");
	 System.out.println("  4    修改密码");
	 System.out.println("  5    显示账户信息");
	 System.out.println("  6    退出");
	 System.out.println("------------------------");
 }
 public static int inputInt()
 {
 	int i=0;
 	Scanner in=null;
 	try{
 	 in=new Scanner(System.in);
 	 i=in.nextInt();
 	}catch(Exception e){
 		System.out.println( "数据输入错误，请输入数值型数据");
 		inputString();
 		
 	}
 	return i;
 }
 public static double inputDouble()
 {
 	double s=0.0;
 	Scanner in=null;
 	try{
 		 in=new Scanner(System.in);
 		 s=in.nextDouble();
 	}catch(Exception e){
 		System.out.println( "数据输入错误，请输入数值型数据");
 		inputString();
 	}
 		
 	return s;
 }
 	public static String inputString()
 	{
 		String s=null;
 		Scanner in=null;
 		try{
 			 in=new Scanner(System.in);
 			 s=in.nextLine();
 		}catch(Exception e){
 			System.out.println( "exception when read");
 			inputString();
 		}
 			
 		return s.trim();
 	}
}
