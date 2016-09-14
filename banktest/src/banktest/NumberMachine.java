package banktest;

public class NumberMachine extends Thread {
	private static NumberManger gernel = new NumberManger(CustomerType.GENERAL);
	private static NumberManger quick = new NumberManger(CustomerType.QUICK);
	private static NumberManger vip = new NumberManger(CustomerType.VIP);

	public NumberManger getmanger(CustomerType ss) {
		switch (ss) {
		case GENERAL:
			return gernel;
		case QUICK:
			return quick;
		case VIP:
			return vip;
		}
		return null;
	}

	public void run() {
		while (true) {
			int x = (int) (Math.random() * 10);
			String newGerNo;
			if (x < 2) {
				newGerNo = vip.gernenatenumber();
				if (newGerNo != null)
					Main.textArea.append(newGerNo+"\n");
			} else if (x < 7) {
				newGerNo = gernel.gernenatenumber();
				if (newGerNo != null)
					Main.textArea.append(newGerNo+"\n");
			} else {
				newGerNo = quick.gernenatenumber();
				if (newGerNo != null)
					Main.textArea.append(newGerNo+"\n");
			}
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
