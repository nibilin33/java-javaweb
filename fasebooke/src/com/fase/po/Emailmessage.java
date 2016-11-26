package com.fase.po;

import java.math.BigDecimal;
import java.util.Date;

public class Emailmessage {
    private String eid;

    private String fuid;

    private String ffid;

    private Date senttime;

    private String contenti;

    private String plusfile;

    private BigDecimal estate;
    private Fuser user;
    public Fuser getUser() {
		return user;
	}

	public void setUser(Fuser user) {
		this.user = user;
	}

	public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid == null ? null : eid.trim();
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

    public Date getSenttime() {
        return senttime;
    }

    public void setSenttime(Date senttime) {
        this.senttime = senttime;
    }

    public String getContenti() {
        return contenti;
    }

    public void setContenti(String contenti) {
        this.contenti = contenti == null ? null : contenti.trim();
    }

    public String getPlusfile() {
        return plusfile;
    }

    public void setPlusfile(String plusfile) {
        this.plusfile = plusfile == null ? null : plusfile.trim();
    }

    public BigDecimal getEstate() {
        return estate;
    }

    public void setEstate(BigDecimal estate) {
        this.estate = estate;
    }
}