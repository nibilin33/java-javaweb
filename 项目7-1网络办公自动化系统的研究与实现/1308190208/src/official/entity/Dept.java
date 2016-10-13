package official.entity;

public class Dept {
	private int deptID;
	private String deptName;
	private String deptText;
	public Dept() {
		super();
	}
	
	public Dept(String deptName, String deptText) {
		super();
		this.deptName = deptName;
		this.deptText = deptText;
	}

	public Dept(int deptID, String deptName, String deptText) {
		super();
		this.deptID = deptID;
		this.deptName = deptName;
		this.deptText = deptText;
	}
	public int getDeptID() {
		return deptID;
	}
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptText() {
		return deptText;
	}
	public void setDeptText(String deptText) {
		this.deptText = deptText;
	}
	@Override
	public String toString() {
		return "Dept [deptID=" + deptID + ", deptName=" + deptName
				+ ", deptText=" + deptText + "]";
	}
	
}
