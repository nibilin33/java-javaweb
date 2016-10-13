package myproject.atm;

import java.util.Scanner;

public class Tools {
 public static void show(Card card){
	 System.out.println("���ţ�"+card.getCardNumber());
	 
 }
 public static void show(User user){
	 show(user.getCard());
	 System.out.println("������"+user.getUsername());
	 System.out.println("�Ա�"+user.getSex());
	 System.out.println("���䣺"+user.getAge());
 }
 public static void show(Account account){
	 show(account.getUser());
	 System.out.println("���룺"+account.getPassword());
	 System.out.println("��"+account.getMoney());
	 
 } 
 public static void showATMinfo()
 {
	 System.out.println("ATM��ȡ�����ϵͳ����ѡ����Ĳ�����");
	 System.out.println("------------------------");
	 System.out.println("  1    ��� ");
	 System.out.println("  2    ȡ��");
	 System.out.println("  3    ��ѯ���");
	 System.out.println("  4    �޸�����");
	 System.out.println("  5    ��ʾ�˻���Ϣ");
	 System.out.println("  6    �˳�");
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
 		System.out.println( "�������������������ֵ������");
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
 		System.out.println( "�������������������ֵ������");
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
