package com.fase.po;

public class Sensitive {
    private String seid;

    private String swords;

    public String getSeid() {
        return seid;
    }

    public void setSeid(String seid) {
        this.seid = seid == null ? null : seid.trim();
    }

    public String getSwords() {
        return swords;
    }

    public void setSwords(String swords) {
        this.swords = swords == null ? null : swords.trim();
    }
}