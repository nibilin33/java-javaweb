package com.fase.po;

import java.util.Date;

public class Offlinemssage {
    private String ofid;

    private String fuid;

    private String tofuid;

    private String msg;

    private Date sendtime;
    private Fuser tof;

    @Override
	public String toString() {
		return "{fuid:" + fuid + ", tofuid:"
				+ tofuid + ", msg:" + msg + ", sendtime:" + sendtime + ", tof:"
				+ tof + "}";
	}

	public Fuser getTof() {
		return tof;
	}

	public void setTof(Fuser tof) {
		this.tof = tof;
	}

	public String getOfid() {
        return ofid;
    }

    public void setOfid(String ofid) {
        this.ofid = ofid == null ? null : ofid.trim();
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid == null ? null : fuid.trim();
    }

    public String getTofuid() {
        return tofuid;
    }

    public void setTofuid(String tofuid) {
        this.tofuid = tofuid == null ? null : tofuid.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }
}