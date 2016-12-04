package com.fase.po;

import java.util.Date;

public class Leavenote {
    private String leid;

    private String fuid;

    private String lfuid;

    private String leavenote;
    private Date leavedate;
    private String fcount;
    public String getFcount() {
		return fcount;
	}

	public void setFcount(String fcount) {
		this.fcount = fcount;
	}

	public Date getLeavedate() {
		return leavedate;
	}

	public void setLeavedate(Date leavedate) {
		this.leavedate = leavedate;
	}

	public String getLeid() {
        return leid;
    }

    public void setLeid(String leid) {
        this.leid = leid == null ? null : leid.trim();
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid == null ? null : fuid.trim();
    }

    public String getLfuid() {
        return lfuid;
    }

    public void setLfuid(String lfuid) {
        this.lfuid = lfuid == null ? null : lfuid.trim();
    }

    public String getLeavenote() {
        return leavenote;
    }

    public void setLeavenote(String leavenote) {
        this.leavenote = leavenote == null ? null : leavenote.trim();
    }
}