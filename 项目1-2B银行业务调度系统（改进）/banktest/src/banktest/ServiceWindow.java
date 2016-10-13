package banktest;

import javax.swing.JTextArea;

public class ServiceWindow extends Thread {
	public JTextArea t;
	public CustomerType customerType;
	private NumberManger cust;
	public static int Max, Min;
	public String windowNo;

	ServiceWindow(JTextArea t, CustomerType customerType, int No, int Max,
			int Min) {
		super();
		this.t = t;
		if (Min > Max) {
			Min += Max;
			Max = Min - Max;
			Min -= Max;
		}
		this.customerType = customerType;
		this.windowNo=""+customerType+"窗口"+No+"号";
		this.Max = Max;
		this.Min = Min;
	}
   public static void set(int min,int max){
		if (min > max) {
			min += max;
			max = min - max;
			min -= max;
		}
	    Min=min;
	     Max=max;
    }
	public void run() {
		switch (customerType) {
		case GENERAL:
			while (true) {
				cust = Main.NumMachine.getmanger(customerType);
				String custNo = cust.getcustom();
				if (custNo != null) {
					int time = (int) (Math.random()* (Max - Min) + Min);
					try {
						this.sleep(time*1000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					t.append(windowNo+"完成"+custNo+time+"秒\n");
				} else {
					t.append(windowNo+"等待服务ing...\n");
					try {
						this.sleep(2000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
		case QUICK:
			while(true){
				cust = Main.NumMachine.getmanger(customerType);
				String custNo = cust.getcustom();
				if(custNo==null){
					cust = Main.NumMachine.getmanger(CustomerType.GENERAL);
					custNo = cust.getcustom();
				}
				if (custNo != null) {
					try {
						this.sleep(Min*1000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					t.append(windowNo+"完成"+custNo+Min+"秒\n");
				} else {
					t.append(windowNo+"等待服务ing...\n");
					try {
						this.sleep(2000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
		case VIP:
			while(true){
				cust = Main.NumMachine.getmanger(customerType);
				String custNo = cust.getcustom();
				if(custNo==null){
					cust = Main.NumMachine.getmanger(CustomerType.GENERAL);
					custNo = cust.getcustom();
				}
				if (custNo != null) {
					int time = (int) (Math.random() * (Max - Min) + Min);
					try {
						this.sleep(time*1000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					t.append(windowNo+"完成"+custNo+time+"秒\n");
				} else {
					t.append(windowNo+"等待服务ing...\n");
					try {
						this.sleep(2000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
		}
	}

}