package official.entity;

public class Notice {
	private int noteID;
	private String employeeName;
	private String noteName;
	private String noteInfo;
	private String noteTime;
	public Notice() {
		super();
	}
	
	public Notice(String employeeName, String noteName, String noteInfo,
			String noteTime) {
		super();
		this.employeeName = employeeName;
		this.noteName = noteName;
		this.noteInfo = noteInfo;
		this.noteTime = noteTime;
	}

	public Notice(int noteID, String employeeName, String noteName, String noteInfo,
			String noteTime) {
		super();
		this.noteID = noteID;
		this.employeeName = employeeName;
		this.noteName = noteName;
		this.noteInfo = noteInfo;
		this.noteTime = noteTime;
	}
	public int getNoteID() {
		return noteID;
	}
	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	public String getNoteInfo() {
		return noteInfo;
	}
	public void setNoteInfo(String noteInfo) {
		this.noteInfo = noteInfo;
	}
	public String getNoteTime() {
		return noteTime;
	}
	public void setNoteTime(String noteTime) {
		this.noteTime = noteTime;
	}
	@Override
	public String toString() {
		return "Notice [noteID=" + noteID + ", employeeName=" + employeeName
				+ ", noteName=" + noteName + ", noteInfo=" + noteInfo
				+ ", noteTime=" + noteTime + "]";
	}
	
}
