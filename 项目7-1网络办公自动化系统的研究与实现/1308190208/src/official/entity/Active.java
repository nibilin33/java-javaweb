package official.entity;

public class Active {
	private int activeID;
	private String activeName;
	private String activeInfo;
    
	private int activeAgreeNum;
	private String employeeName;
	private int activeNoAgreeNum;
	
	public Active() {
		super();
	}
	
	public Active(String activeName, String activeInfo, int activeAgreeNum,String employeeName,int activeNoAgreeNum) {
		super();
		this.activeName = activeName;
		this.activeInfo = activeInfo;
		this.activeAgreeNum = activeAgreeNum;
		this.employeeName = employeeName;
		this.activeNoAgreeNum = activeNoAgreeNum;
	}

	public Active(int activeID, String activeName, String activeInfo,
			int activeAgreeNum,String employeeName,int activeNoAgreeNum) {
		super();
		this.activeID = activeID;
		this.activeName = activeName;
		this.activeInfo = activeInfo;
		this.activeAgreeNum = activeAgreeNum;
		this.employeeName = employeeName;
		this.activeNoAgreeNum = activeNoAgreeNum;
	}

	public int getActiveID() {
		return activeID;
	}

	public void setActiveID(int activeID) {
		this.activeID = activeID;
	}

	public String getActiveName() {
		return activeName;
	}

	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}

	public String getActiveInfo() {
		return activeInfo;
	}

	public void setActiveInfo(String activeInfo) {
		this.activeInfo = activeInfo;
	}

	public int getActiveAgreeNum() {
		return activeAgreeNum;
	}

	public void setActiveAgreeNum(int activeAgreeNum) {
		this.activeAgreeNum = activeAgreeNum;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getActiveNoAgreeNum() {
		return activeNoAgreeNum;
	}

	public void setActiveNoAgreeNum(int activeNoAgreeNum) {
		this.activeNoAgreeNum = activeNoAgreeNum;
	}

	@Override
	public String toString() {
		return "Active [activeID=" + activeID + ", activeName=" + activeName
				+ ", activeInfo=" + activeInfo + ", activeAgreeNum="
				+ activeAgreeNum + ", employeeName=" + employeeName
				+ ", activeNoAgreeNum=" + activeNoAgreeNum + "]";
	}

	
	
}
