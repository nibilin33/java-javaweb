package com.fase.po;

import java.math.BigDecimal;
import java.util.Date;

public class Notification {
    private String nid;

    private String fuid;

    private String note;

    private BigDecimal isread;
    private Date asktime;

    public Date getAsktime() {
		return asktime;
	}

	public void setAsktime(Date asktime) {
		this.asktime = asktime;
	}

	public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid == null ? null : nid.trim();
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid == null ? null : fuid.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public BigDecimal getIsread() {
        return isread;
    }

    public void setIsread(BigDecimal isread) {
        this.isread = isread;
    }
}