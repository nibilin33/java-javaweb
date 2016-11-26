package com.fase.po;

import java.math.BigDecimal;
import java.util.Date;

public class Comments {
    private String cid;

    private String fuid;

    private String targetid;

    private Date ctime;

    private String ccontent;

    private BigDecimal isshare;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid == null ? null : fuid.trim();
    }

    public String getTargetid() {
        return targetid;
    }

    public void setTargetid(String targetid) {
        this.targetid = targetid == null ? null : targetid.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent == null ? null : ccontent.trim();
    }

    public BigDecimal getIsshare() {
        return isshare;
    }

    public void setIsshare(BigDecimal isshare) {
        this.isshare = isshare;
    }
}