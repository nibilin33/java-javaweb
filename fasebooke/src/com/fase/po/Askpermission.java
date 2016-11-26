package com.fase.po;

import java.math.BigDecimal;
import java.util.Date;

public class Askpermission {
    private String asid;

    private String fuid;

    private String ffid;

    private Date asktime;

    private BigDecimal asktype;

    private String groupid;

    private String activityid;

    private BigDecimal msgstage;
    private Fuser fuser;

    public Fuser getFuser() {
		return fuser;
	}

	public void setFuser(Fuser fuser) {
		this.fuser = fuser;
	}

	public String getAsid() {
        return asid;
    }

    public void setAsid(String asid) {
        this.asid = asid == null ? null : asid.trim();
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid == null ? null : fuid.trim();
    }

    public String getFfid() {
        return ffid;
    }

    public void setFfid(String ffid) {
        this.ffid = ffid == null ? null : ffid.trim();
    }

    public Date getAsktime() {
        return asktime;
    }

    public void setAsktime(Date asktime) {
        this.asktime = asktime;
    }

    public BigDecimal getAsktype() {
        return asktype;
    }

    public void setAsktype(BigDecimal asktype) {
        this.asktype = asktype;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }

    public String getActivityid() {
        return activityid;
    }

    public void setActivityid(String activityid) {
        this.activityid = activityid == null ? null : activityid.trim();
    }

    public BigDecimal getMsgstage() {
        return msgstage;
    }

    public void setMsgstage(BigDecimal msgstage) {
        this.msgstage = msgstage;
    }
}