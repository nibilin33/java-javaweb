package com.fase.po;

import java.math.BigDecimal;
import java.util.Date;

public class Picture {
    private String pid;

    private String gpid;

    private String picname;

    private Date ptime;

    private String picdescribe;

    private BigDecimal pusetype;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid == null ? null : gpid.trim();
    }

    public String getPicname() {
        return picname;
    }

    public void setPicname(String picname) {
        this.picname = picname == null ? null : picname.trim();
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public String getPicdescribe() {
        return picdescribe;
    }

    public void setPicdescribe(String picdescribe) {
        this.picdescribe = picdescribe == null ? null : picdescribe.trim();
    }

    public BigDecimal getPusetype() {
        return pusetype;
    }

    public void setPusetype(BigDecimal pusetype) {
        this.pusetype = pusetype;
    }
}