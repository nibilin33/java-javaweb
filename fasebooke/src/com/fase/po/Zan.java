package com.fase.po;

import java.math.BigDecimal;

public class Zan {
    private String zid;

    private String did;

    private String emotion;

    private BigDecimal counter;

    private String fname;

    public String getZid() {
        return zid;
    }

    public void setZid(String zid) {
        this.zid = zid == null ? null : zid.trim();
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did == null ? null : did.trim();
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion == null ? null : emotion.trim();
    }

    public BigDecimal getCounter() {
        return counter;
    }

    public void setCounter(BigDecimal counter) {
        this.counter = counter;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }
}