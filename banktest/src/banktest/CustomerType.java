package banktest;

public enum CustomerType {
	GENERAL,
	QUICK,
	 VIP;
	public String toString() {
	           switch(this){
	           case GENERAL:
	               return "ÆÕÍ¨";
	           case QUICK:
	               return "¿ìËÙ";
	           case VIP:
	               return "VIP";
	          }
	           return null;
	        }
}
