package banktest;


import java.util.Random;

public class newRandom {
	private int servetime;
	public newRandom() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	public void setRandom(int min,int max){
		try {
			servetime=new Random().nextInt(max-min)+min;
			//System.out.println(servetime);
		}
		catch(IllegalArgumentException e)
		{}
	}
	public int getServetime() {
		return servetime;
	}
	public void setServetime(int servetime) {
		this.servetime = servetime;
	}

}
