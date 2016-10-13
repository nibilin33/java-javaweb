package official.entity;

public class Filee {
	private int fileID;
	private String fileTime;
	private String fileText;
	private String fileFrom;
	private String fileTo;
	private String fileName;
	public Filee() {
		super();
	}
	
	public Filee(String fileTime, String fileText, String fileFrom, String fileTo,
			String fileName) {
		super();
		this.fileTime = fileTime;
		this.fileText = fileText;
		this.fileFrom = fileFrom;
		this.fileTo = fileTo;
		this.fileName = fileName;
	}

	public Filee(int fileID, String fileTime, String fileText, String fileFrom,
			String fileTo, String fileName) {
		super();
		this.fileID = fileID;
		this.fileTime = fileTime;
		this.fileText = fileText;
		this.fileFrom = fileFrom;
		this.fileTo = fileTo;
		this.fileName = fileName;
	}
	public int getFileID() {
		return fileID;
	}
	public void setFileID(int fileID) {
		this.fileID = fileID;
	}
	public String getFileTime() {
		return fileTime;
	}
	public void setFileTime(String fileTime) {
		this.fileTime = fileTime;
	}
	public String getFileText() {
		return fileText;
	}
	public void setFileText(String fileText) {
		this.fileText = fileText;
	}
	public String getFileFrom() {
		return fileFrom;
	}
	public void setFileFrom(String fileFrom) {
		this.fileFrom = fileFrom;
	}
	public String getFileTo() {
		return fileTo;
	}
	public void setFileTo(String fileTo) {
		this.fileTo = fileTo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "Filee [fileID=" + fileID + ", fileTime=" + fileTime
				+ ", fileText=" + fileText + ", fileFrom=" + fileFrom
				+ ", fileTo=" + fileTo + ", fileName=" + fileName + "]";
	}
	
}
