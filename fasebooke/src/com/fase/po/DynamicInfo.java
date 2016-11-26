package com.fase.po;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class DynamicInfo {
	private String Did ;
	private String fuid ;
@DateTimeFormat(pattern = "yyyy-MM-dd")  
  private Date	sendtime ;
  private String 	sendwords ;
	private String sendimage;
	private BigDecimal isvisiable;
	private List<Zan> dianzan;
	private  String imagehead;
	private String fname;
	private int dinazansize;
	private List<TComment> tcomment;
	public List<TComment> getTcomment() {
		return tcomment;
	}
	public void setTcomment(List<TComment> tcomment) {
		this.tcomment = tcomment;
	}
	public int getDinazansize() {
		return dinazansize;
	}
	public void setDinazansize(int dinazansize) {
		this.dinazansize = dinazansize;
	}
	public String getImagehead() {
		return imagehead;
	}
	public void setImagehead(String imagehead) {
		this.imagehead =imagehead;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public List<Zan> getDianzan() {
		return dianzan;
	}
	public void setDianzan(List<Zan> dianzan) {
		this.dianzan = dianzan;
	}
	public static String imagebase="http://localhost:8080/img/";
	public String getDid() {
		return Did;
	}
	public void setDid(String did) {
		Did = did;
	}
	public String getFuid() {
		return fuid;
	}
	public void setFuid(String fuid) {
		this.fuid = fuid;
	}
	public Date getSendtime() {
		return sendtime;
	}
	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
	public String getSendwords() {
		return sendwords;
	}
	public void setSendwords(String sendwords) {
		this.sendwords = sendwords;
	}
	public String getSendimage() {
		return sendimage;
	}
	public void setSendimage(String sendimage) {
		this.sendimage = sendimage;
	}
	public BigDecimal getIsvisiable() {
		return isvisiable;
	}
	public void setIsvisiable(BigDecimal isvisiable) {
		this.isvisiable = isvisiable;
	}
}
