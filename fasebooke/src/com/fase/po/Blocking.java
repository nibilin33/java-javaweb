package com.fase.po;

import java.math.BigDecimal;

public class Blocking {
    private String bid;

    private String fuid;

    private String bfuid;

    private BigDecimal blocktype;

    private BigDecimal isdelete;

    private String fzhuyeid;

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid == null ? null : fuid.trim();
    }

    public String getBfuid() {
        return bfuid;
    }

    public void setBfuid(String bfuid) {
        this.bfuid = bfuid == null ? null : bfuid.trim();
    }

    public BigDecimal getBlocktype() {
        return blocktype;
    }

    public void setBlocktype(BigDecimal blocktype) {
        this.blocktype = blocktype;
    }

    public BigDecimal getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(BigDecimal isdelete) {
        this.isdelete = isdelete;
    }

    public String getFzhuyeid() {
        return fzhuyeid;
    }

    public void setFzhuyeid(String fzhuyeid) {
        this.fzhuyeid = fzhuyeid == null ? null : fzhuyeid.trim();
    }
}