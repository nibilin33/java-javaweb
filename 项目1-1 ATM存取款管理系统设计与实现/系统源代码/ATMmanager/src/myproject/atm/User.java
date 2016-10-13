package myproject.atm;

public class User {
	private String username=null;
	private char sex='男';
    private int age=0;
	private Card card=new Card();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public User(String username, char sex, int age, Card card) {
		super();
		this.username = username;
		this.sex = sex;
		this.age = age;
		this.card = card;
	}
	public User() {
		super();
		// TODO 自动生成的构造函数存根
	}
	

}
