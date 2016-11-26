package com.fase.po;

import java.math.BigDecimal;
import java.util.Date;

public class Activity {
    private String acid;

    private String fuid;

    private Date createitme;

    private Date endtime;

    private String mainidea;

    private String acimage;

    private String acdiscribe;

    private BigDecimal puorper;

    private String cmguest;

    public String getAcid() {
        return acid;
    }

    public void setAcid(String acid) {
        this.acid = acid == null ? null : acid.trim();
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid == null ? null : fuid.trim();
    }

    public Date getCreateitme() {
        return createitme;
    }

    public void setCreateitme(Date createitme) {
        this.createitme = createitme;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getMainidea() {
        return mainidea;
    }

    public void setMainidea(String mainidea) {
        this.mainidea = mainidea == null ? null : mainidea.trim();
    }

    public String getAcimage() {
        return acimage;
    }

    public void setAcimage(String acimage) {
        this.acimage = acimage == null ? null : acimage.trim();
    }

    public String getAcdiscribe() {
        return acdiscribe;
    }

    public void setAcdiscribe(String acdiscribe) {
        this.acdiscribe = acdiscribe == null ? null : acdiscribe.trim();
    }

    public BigDecimal getPuorper() {
        return puorper;
    }

    public void setPuorper(BigDecimal puorper) {
        this.puorper = puorper;
    }

    public String getCmguest() {
        return cmguest;
    }

    public void setCmguest(String cmguest) {
        this.cmguest = cmguest == null ? null : cmguest.trim();
    }
}