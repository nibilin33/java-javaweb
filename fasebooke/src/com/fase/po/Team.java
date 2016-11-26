package com.fase.po;

import java.util.Date;

public class Team {
    private String teamid;

    private String fuid;

    private Date createtime;

    private Integer membersum;

    private String teamicon;

    private String teamtype;

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid == null ? null : teamid.trim();
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid == null ? null : fuid.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getMembersum() {
        return membersum;
    }

    public void setMembersum(Integer membersum) {
        this.membersum = membersum;
    }

    public String getTeamicon() {
        return teamicon;
    }

    public void setTeamicon(String teamicon) {
        this.teamicon = teamicon == null ? null : teamicon.trim();
    }

    public String getTeamtype() {
        return teamtype;
    }

    public void setTeamtype(String teamtype) {
        this.teamtype = teamtype == null ? null : teamtype.trim();
    }
}