package com.fase.po;

public class Settime {
    private String seid;

    private String fuid;

    private String fbefriend;

    private String ftimeline;

    public String getSeid() {
        return seid;
    }

    public void setSeid(String seid) {
        this.seid = seid == null ? null : seid.trim();
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid == null ? null : fuid.trim();
    }

    public String getFbefriend() {
        return fbefriend;
    }

    public void setFbefriend(String fbefriend) {
        this.fbefriend = fbefriend == null ? null : fbefriend.trim();
    }

    public String getFtimeline() {
        return ftimeline;
    }

    public void setFtimeline(String ftimeline) {
        this.ftimeline = ftimeline == null ? null : ftimeline.trim();
    }
}