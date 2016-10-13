package myproject.atm;

public class Account {
	private String password=null;
	private double money=0.0;
	private User user=new User();
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Account(String password, double money, User user) {
		super();
		this.password = password;
		this.money = money;
		this.user = user;
	}
	public Account() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	public void savemoney(){
		System.out.println("��������Ĵ���");
		double money=0.0;
		money=Tools.inputDouble();
		this.money+=money;
		System.out.println("�����δ��룺"+money+"Ԫ���˻�����ǣ�"+this.money+"Ԫ");
	}
	public void outmoney()
	{
		System.out.println("���������ȡ���");
		double money=0.0;
		money=Tools.inputDouble();
		if(money>this.money){
			System.out.println("����");
		}
		else
		{
			this.money-=money;
			System.out.println("������ȡ�"+money+"Ԫ���˻�����ǣ�"+this.money+"Ԫ");
			
		}
		
	}
	public void showmoney()
	{
		System.out.println("�����˻�����ǣ�"+money+"Ԫ");
		
	}
	public void modifypassword(){
		String s1=null,s2=null;
		int num=3;
		System.out.println("������ԭ���룺");
		while(num-->0){
			if(Tools.inputString().equals(this.password)){
				System.out.println("�������µ����룺");
				s1=Tools.inputString();
				if(s1.equals(s2)){
					password=s1;
					System.out.println("�޸�����ɹ�~");
				}else
				{
					System.out.println("������������벻һ�£������޸�ʧ�ܣ�");
				} 
				return;
			}
			else
			{
				if(num==0)
				{
					System.out.println("���Ѿ����3�����룬���β��������޸�~");
					break;
				}
				System.out.println("���벻�ԣ����������룺");
			}
		}
	
	}

}
