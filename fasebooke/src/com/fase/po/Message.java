package com.fase.po;

import java.util.Date;

public class Message {
private String fuid;
private String tfuid;
private String msg;
private Date sendtime;
public String getFuid() {
	return fuid;
}
public void setFuid(String fuid) {
	this.fuid = fuid;
}
public String getTfuid() {
	return tfuid;
}
public void setTfuid(String tfuid) {
	this.tfuid = tfuid;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public Date getSendtime() {
	return sendtime;
}
public void setSendtime(Date sendtime) {
	this.sendtime = sendtime;
}
}
