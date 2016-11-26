package com.fase.po;

public class Localp {
    private String lid;

    private String lprovice;

    private String lcity;

    private String lurl;

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid == null ? null : lid.trim();
    }

    public String getLprovice() {
        return lprovice;
    }

    public void setLprovice(String lprovice) {
        this.lprovice = lprovice == null ? null : lprovice.trim();
    }

    public String getLcity() {
        return lcity;
    }

    public void setLcity(String lcity) {
        this.lcity = lcity == null ? null : lcity.trim();
    }

    public String getLurl() {
        return lurl;
    }

    public void setLurl(String lurl) {
        this.lurl = lurl == null ? null : lurl.trim();
    }
}