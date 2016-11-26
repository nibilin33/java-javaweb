package com.fase.po;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Photogallery {
    private String gpid;

    private String fuid;

    private String gicname;

    private Date gtime;

    private String gicdescribe;

    private BigDecimal gacesstype;
    private List<Picture> pictures;

    public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid == null ? null : gpid.trim();
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid == null ? null : fuid.trim();
    }

    public String getGicname() {
        return gicname;
    }

    public void setGicname(String gicname) {
        this.gicname = gicname == null ? null : gicname.trim();
    }

    public Date getGtime() {
        return gtime;
    }

    public void setGtime(Date gtime) {
        this.gtime = gtime;
    }

    public String getGicdescribe() {
        return gicdescribe;
    }

    public void setGicdescribe(String gicdescribe) {
        this.gicdescribe = gicdescribe == null ? null : gicdescribe.trim();
    }

    public BigDecimal getGacesstype() {
        return gacesstype;
    }

    public void setGacesstype(BigDecimal gacesstype) {
        this.gacesstype = gacesstype;
    }
}