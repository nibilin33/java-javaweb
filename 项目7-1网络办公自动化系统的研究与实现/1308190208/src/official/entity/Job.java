package official.entity;

public class Job {
	private int jobID;
	private String deptName;
	private String jobName;
	private String jobText;
	public Job() {
		super();
	}
	
	public Job(String deptName, String jobName, String jobText) {
		super();
		this.deptName = deptName;
		this.jobName = jobName;
		this.jobText = jobText;
	}

	public Job(int jobID, String deptName, String jobName, String jobText) {
		super();
		this.jobID = jobID;
		this.deptName = deptName;
		this.jobName = jobName;
		this.jobText = jobText;
	}
	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptID) {
		this.deptName = deptID;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobText() {
		return jobText;
	}
	public void setJobText(String jobText) {
		this.jobText = jobText;
	}
	@Override
	public String toString() {
		return "Job [jobID=" + jobID + ", deptID=" + deptName + ", jobName="
				+ jobName + ", jobText=" + jobText + "]";
	}
	
}
