package com.fase.po;

import java.math.BigDecimal;

public class Liferecord {
    private String lfid;

    private String fuid;

    private String ltitle;

    private String ltype;

    public String getLfid() {
        return lfid;
    }

    public void setLfid(String lfid) {
        this.lfid = lfid == null ? null : lfid.trim();
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid == null ? null : fuid.trim();
    }

    public String getLtitle() {
        return ltitle;
    }

    public void setLtitle(String ltitle) {
        this.ltitle = ltitle == null ? null : ltitle.trim();
    }

    public String getLtype() {
        return ltype;
    }

    public void setLtype(String ltype) {
        this.ltype = ltype;
    }
}