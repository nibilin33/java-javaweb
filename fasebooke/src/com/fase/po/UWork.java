package com.fase.po;

public class UWork {
    private String uworkid;

    private String fuid;

    private String ucompanyname;

    private String uzhiwei;

    private String ulocation;

    private String udescription;

    private String usegtime;

    private String uskill;
    private Fuser user;

    public Fuser getUser() {
		return user;
	}

	public void setUser(Fuser user) {
		this.user = user;
	}

	public String getUworkid() {
        return uworkid;
    }

    public void setUworkid(String uworkid) {
        this.uworkid = uworkid == null ? null : uworkid.trim();
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid == null ? null : fuid.trim();
    }

    public String getUcompanyname() {
        return ucompanyname;
    }

    public void setUcompanyname(String ucompanyname) {
        this.ucompanyname = ucompanyname == null ? null : ucompanyname.trim();
    }

    public String getUzhiwei() {
        return uzhiwei;
    }

    public void setUzhiwei(String uzhiwei) {
        this.uzhiwei = uzhiwei == null ? null : uzhiwei.trim();
    }

    public String getUlocation() {
        return ulocation;
    }

    public void setUlocation(String ulocation) {
        this.ulocation = ulocation == null ? null : ulocation.trim();
    }

    public String getUdescription() {
        return udescription;
    }

    public void setUdescription(String udescription) {
        this.udescription = udescription == null ? null : udescription.trim();
    }

    public String getUsegtime() {
        return usegtime;
    }

    public void setUsegtime(String usegtime) {
        this.usegtime = usegtime == null ? null : usegtime.trim();
    }

    public String getUskill() {
        return uskill;
    }

    public void setUskill(String uskill) {
        this.uskill = uskill == null ? null : uskill.trim();
    }
}