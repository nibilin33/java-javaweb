package com.fase.po;

import java.math.BigDecimal;

public class UEducation {
    private String uedid;

    private String fuid;

    private String uschool;

    private String utime;

    private BigDecimal ubstate;

    private String udescription;

    private String upro;
    private Fuser user;
    private String url;

    public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "UEducation [uedid=" + uedid + ", fuid=" + fuid + ", uschool="
				+ uschool + ", utime=" + utime + ", ubstate=" + ubstate
				+ ", udescription=" + udescription + ", upro=" + upro
				+ ", user=" + user + ", url=" + url + "]";
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Fuser getUser() {
		return user;
	}

	public void setUser(Fuser user) {
		this.user = user;
	}

	public String getUedid() {
        return uedid;
    }

    public void setUedid(String uedid) {
        this.uedid = uedid == null ? null : uedid.trim();
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid == null ? null : fuid.trim();
    }

    public String getUschool() {
        return uschool;
    }

    public void setUschool(String uschool) {
        this.uschool = uschool == null ? null : uschool.trim();
    }

    public String getUtime() {
        return utime;
    }

    public void setUtime(String utime) {
        this.utime = utime == null ? null : utime.trim();
    }

    public BigDecimal getUbstate() {
        return ubstate;
    }

    public void setUbstate(BigDecimal ubstate) {
        this.ubstate = ubstate;
    }

    public String getUdescription() {
        return udescription;
    }

    public void setUdescription(String udescription) {
        this.udescription = udescription == null ? null : udescription.trim();
    }

    public String getUpro() {
        return upro;
    }

    public void setUpro(String upro) {
        this.upro = upro == null ? null : upro.trim();
    }
}