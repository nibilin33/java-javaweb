package banktest;

public enum CustomerType {
	GENERAL,
	QUICK,
	 VIP;
	public String toString() {
	           switch(this){
	           case GENERAL:
	               return "��ͨ";
	           case QUICK:
	               return "����";
	           case VIP:
	               return "VIP";
	          }
	           return null;
	        }
}
