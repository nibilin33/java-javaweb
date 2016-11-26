package com.fase.po;

public class Mpage {
    private String mpid;

    private String fuid;

    private String mtype;

    private String mname;

    private String mdescribe;

    private String mwebsite;

    private String mpicture;

    private String mtarget;

    private String mcover;

    private Long mvisitsum;

    private Long mzansum;

    private Long mcollect;

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

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype == null ? null : mtype.trim();
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }

    public String getMdescribe() {
        return mdescribe;
    }

    public void setMdescribe(String mdescribe) {
        this.mdescribe = mdescribe == null ? null : mdescribe.trim();
    }

    public String getMwebsite() {
        return mwebsite;
    }

    public void setMwebsite(String mwebsite) {
        this.mwebsite = mwebsite == null ? null : mwebsite.trim();
    }

    public String getMpicture() {
        return mpicture;
    }

    public void setMpicture(String mpicture) {
        this.mpicture = mpicture == null ? null : mpicture.trim();
    }

    public String getMtarget() {
        return mtarget;
    }

    public void setMtarget(String mtarget) {
        this.mtarget = mtarget == null ? null : mtarget.trim();
    }

    public String getMcover() {
        return mcover;
    }

    public void setMcover(String mcover) {
        this.mcover = mcover == null ? null : mcover.trim();
    }

    public Long getMvisitsum() {
        return mvisitsum;
    }

    public void setMvisitsum(Long mvisitsum) {
        this.mvisitsum = mvisitsum;
    }

    public Long getMzansum() {
        return mzansum;
    }

    public void setMzansum(Long mzansum) {
        this.mzansum = mzansum;
    }

    public Long getMcollect() {
        return mcollect;
    }

    public void setMcollect(Long mcollect) {
        this.mcollect = mcollect;
    }
}