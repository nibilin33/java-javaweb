package com.fase.po;

public class College {
    private String coid;

    private String cname;

    private String curl;

    private String clocation;

    public String getCoid() {
        return coid;
    }

    public void setCoid(String coid) {
        this.coid = coid == null ? null : coid.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl == null ? null : curl.trim();
    }

    public String getClocation() {
        return clocation;
    }

    public void setClocation(String clocation) {
        this.clocation = clocation == null ? null : clocation.trim();
    }
}