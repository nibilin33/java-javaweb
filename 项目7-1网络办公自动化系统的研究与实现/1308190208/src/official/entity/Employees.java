package official.entity;

public class Employees {
	private int employeeID;
	private String employeeName;
	private String sex;
	private String birthday;
	private String address;
	private String NOcode;
	private String learn;
	private String mobile;
	private String email;
	private String jobName;
	private String deptName;
	private String workState;
	private String photo;
	private String agreement;
	private String pwd;
	private int userLevel;
	private String onLine;
	public Employees() {
		super();
	}
	
	public Employees(String employeeName, String sex, String birthday,
			String address, String nOcode, String learn, String mobile,
			String email, String jobName, String deptName, String workState,
			String photo, String agreement, String pwd, int userLevel,
			String onLine) {
		super();
		this.employeeName = employeeName;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		NOcode = nOcode;
		this.learn = learn;
		this.mobile = mobile;
		this.email = email;
		this.jobName = jobName;
		this.deptName = deptName;
		this.workState = workState;
		this.photo = photo;
		this.agreement = agreement;
		this.pwd = pwd;
		this.userLevel = userLevel;
		this.onLine = onLine;
	}

	public Employees(int employeeID, String employeeName, String sex,
			String birthday, String address, String nOcode, String learn,
			String mobile, String email, String jobName, String deptName,
			String workState, String photo, String agreement, String pwd,
			int userLevel, String onLine) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		NOcode = nOcode;
		this.learn = learn;
		this.mobile = mobile;
		this.email = email;
		this.jobName = jobName;
		this.deptName = deptName;
		this.workState = workState;
		this.photo = photo;
		this.agreement = agreement;
		this.pwd = pwd;
		this.userLevel = userLevel;
		this.onLine = onLine;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNOcode() {
		return NOcode;
	}
	public void setNOcode(String nOcode) {
		NOcode = nOcode;
	}
	public String getLearn() {
		return learn;
	}
	public void setLearn(String learn) {
		this.learn = learn;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getWorkState() {
		return workState;
	}
	public void setWorkState(String workState) {
		this.workState = workState;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAgreement() {
		return agreement;
	}
	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
	public String getOnLine() {
		return onLine;
	}
	public void setOnLine(String onLine) {
		this.onLine = onLine;
	}
	@Override
	public String toString() {
		return "Employees [employeeID=" + employeeID + ", employeeName="
				+ employeeName + ", sex=" + sex + ", birthday=" + birthday
				+ ", address=" + address + ", NOcode=" + NOcode + ", learn="
				+ learn + ", mobile=" + mobile + ", email=" + email
				+ ", jobName=" + jobName + ", deptName=" + deptName
				+ ", workState=" + workState + ", photo=" + photo
				+ ", agreement=" + agreement + ", pwd=" + pwd + ", userLevel="
				+ userLevel + ", onLine=" + onLine + "]";
	}
	
}
