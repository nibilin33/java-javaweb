package official.entity;

public class Task {
	private int taskID;
	private String taskName;
	private String taskInfo;
	private String getTime;
	private String taskSate;
	private String employeeName;
	public Task() {
		super();
	}
	
	public Task(String taskName, String taskInfo, String getTime,
			String taskSate, String employeeName) {
		super();
		this.taskName = taskName;
		this.taskInfo = taskInfo;
		this.getTime = getTime;
		this.taskSate = taskSate;
		this.employeeName = employeeName;
	}

	public Task(int taskID, String taskName, String taskInfo, String getTime,
			String taskSate, String employeeName) {
		super();
		this.taskID = taskID;
		this.taskName = taskName;
		this.taskInfo = taskInfo;
		this.getTime = getTime;
		this.taskSate = taskSate;
		this.employeeName = employeeName;
	}
	public int getTaskID() {
		return taskID;
	}
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskInfo() {
		return taskInfo;
	}
	public void setTaskInfo(String taskInfo) {
		this.taskInfo = taskInfo;
	}
	public String getGetTime() {
		return getTime;
	}
	public void setGetTime(String getTime) {
		this.getTime = getTime;
	}
	public String getTaskSate() {
		return taskSate;
	}
	public void setTaskSate(String taskSate) {
		this.taskSate = taskSate;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	@Override
	public String toString() {
		return "Task [taskID=" + taskID + ", taskName=" + taskName
				+ ", taskInfo=" + taskInfo + ", getTime=" + getTime
				+ ", taskSate=" + taskSate + ", employeeID=" + employeeName + "]";
	}
	
}
