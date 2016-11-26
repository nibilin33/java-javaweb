package com.fase.po;

import java.math.BigDecimal;
import java.util.Date;

public class Mpagedata {
    private String dataid;

    private String mpid;

    private String fuid;

    private Date mvitime;

    private BigDecimal iszan;

    private BigDecimal iscollect;

    public String getDataid() {
        return dataid;
    }

    public void setDataid(String dataid) {
        this.dataid = dataid == null ? null : dataid.trim();
    }

    public String getMpid() {
        return mpid;
    }

    public void setMpid(String mpid) {
        this.mpid = mpid == null ? null : mpid.trim();
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid == null ? null : fuid.trim();
    }

    public Date getMvitime() {
        return mvitime;
    }

    public void setMvitime(Date mvitime) {
        this.mvitime = mvitime;
    }

    public BigDecimal getIszan() {
        return iszan;
    }

    public void setIszan(BigDecimal iszan) {
        this.iszan = iszan;
    }

    public BigDecimal getIscollect() {
        return iscollect;
    }

    public void setIscollect(BigDecimal iscollect) {
        this.iscollect = iscollect;
    }
}