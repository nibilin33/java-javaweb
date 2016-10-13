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
		// TODO 自动生成的构造函数存根
	}
	public void savemoney(){
		System.out.println("请输入你的存款金额：");
		double money=0.0;
		money=Tools.inputDouble();
		this.money+=money;
		System.out.println("您本次存入："+money+"元，账户余额是："+this.money+"元");
	}
	public void outmoney()
	{
		System.out.println("请输入你的取款金额：");
		double money=0.0;
		money=Tools.inputDouble();
		if(money>this.money){
			System.out.println("余额不足");
		}
		else
		{
			this.money-=money;
			System.out.println("您本次取款："+money+"元，账户余额是："+this.money+"元");
			
		}
		
	}
	public void showmoney()
	{
		System.out.println("您的账户余额是："+money+"元");
		
	}
	public void modifypassword(){
		String s1=null,s2=null;
		int num=3;
		System.out.println("请输入原密码：");
		while(num-->0){
			if(Tools.inputString().equals(this.password)){
				System.out.println("请输入新的密码：");
				s1=Tools.inputString();
				if(s1.equals(s2)){
					password=s1;
					System.out.println("修改密码成功~");
				}else
				{
					System.out.println("两次输入的密码不一致，密码修改失败！");
				} 
				return;
			}
			else
			{
				if(num==0)
				{
					System.out.println("您已经输错3次密码，本次不再允许修改~");
					break;
				}
				System.out.println("密码不对，请重新输入：");
			}
		}
	
	}

}
