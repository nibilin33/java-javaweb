package com.fase.po;

import java.math.BigDecimal;
import java.util.List;

public class Ufreind {
    private String ufid;

    private String fuid;

    private String ffid;

    private BigDecimal fftype;

    private BigDecimal isnotice;
    private List<Fuser> flist;

    public List<Fuser> getFlist() {
		return flist;
	}

	public void setFlist(List<Fuser> flist) {
		this.flist = flist;
	}

	public String getUfid() {
        return ufid;
    }

    public void setUfid(String ufid) {
        this.ufid = ufid == null ? null : ufid.trim();
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

    public BigDecimal getFftype() {
        return fftype;
    }

    public void setFftype(BigDecimal fftype) {
        this.fftype = fftype;
    }

    public BigDecimal getIsnotice() {
        return isnotice;
    }

    public void setIsnotice(BigDecimal isnotice) {
        this.isnotice = isnotice;
    }
}