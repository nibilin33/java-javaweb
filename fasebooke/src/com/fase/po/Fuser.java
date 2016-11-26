package com.fase.po;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Fuser {
    private String fuid;
    @NotEmpty
    @Pattern(regexp="^[a-zA-Z_]\\w{4,19}$",message ="用户名必须以字母下划线开头，可由字母数字下划线组成")
    private String fname;

    private String fcount;

    private BigDecimal fsex;
     
    //生日必须是以前的时间，而不能是未来的时间
    @Past
    private Date fbirthday;
    @Pattern(regexp="^(13|15|18)\\d{9}$",message="{user.tel.error}")
    private String ftel;
    @Email
    private String femail;
    
    @Length(min=5, max=20, message="{user.password.length}")
    @NotEmpty
    private String fpassword;

    private String fliveplace;

    private String fheadimage;

    private String fbackimage;

    private String fhttp;

    private String fsociallink;

    private BigDecimal fsexlike;

    private String fblodtype;

    private String femotion;

    private String fpersonal;

    private String flikeword;

    private BigDecimal fstate;
    private String fhometown;
    private Localp fplace;
 


	public Localp getFplace() {
		return fplace;
	}

	public void setFplace(Localp fplace) {
		this.fplace = fplace;
	}

	public Localp getFhome() {
		return fhome;
	}

	public void setFhome(Localp fhome) {
		this.fhome = fhome;
	}

	private Localp fhome;

    public String getFhometown() {
		return fhometown;
	}

	public void setFhometown(String fhometown) {
		this.fhometown = fhometown;
	}

	public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid == null ? null : fuid.trim();
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public String getFcount() {
        return fcount;
    }

    public void setFcount(String fcount) {
        this.fcount = fcount == null ? null : fcount.trim();
    }

    public BigDecimal getFsex() {
        return fsex;
    }

    public void setFsex(BigDecimal fsex) {
        this.fsex = fsex;
    }

    public Date getFbirthday() {
        return fbirthday;
    }

    public void setFbirthday(Date fbirthday) {
        this.fbirthday = fbirthday;
    }

    public String getFtel() {
        return ftel;
    }

    public void setFtel(String ftel) {
        this.ftel = ftel == null ? null : ftel.trim();
    }

    public String getFemail() {
        return femail;
    }

    public void setFemail(String femail) {
        this.femail = femail == null ? null : femail.trim();
    }

    public String getFpassword() {
        return fpassword;
    }

    public void setFpassword(String fpassword) {
        this.fpassword = fpassword == null ? null : fpassword.trim();
    }

    public String getFliveplace() {
        return fliveplace;
    }

    public void setFliveplace(String fliveplace) {
        this.fliveplace = fliveplace == null ? null : fliveplace.trim();
    }

    public String getFheadimage() {
        return fheadimage;
    }

    public void setFheadimage(String fheadimage) {
        this.fheadimage = fheadimage == null ? null : fheadimage.trim();
    }

    public String getFbackimage() {
        return fbackimage;
    }

    public void setFbackimage(String fbackimage) {
        this.fbackimage = fbackimage == null ? null : fbackimage.trim();
    }

    public String getFhttp() {
        return fhttp;
    }

    public void setFhttp(String fhttp) {
        this.fhttp = fhttp == null ? null : fhttp.trim();
    }

    public String getFsociallink() {
        return fsociallink;
    }

    public void setFsociallink(String fsociallink) {
        this.fsociallink = fsociallink == null ? null : fsociallink.trim();
    }

    public BigDecimal getFsexlike() {
        return fsexlike;
    }

    public void setFsexlike(BigDecimal fsexlike) {
        this.fsexlike = fsexlike;
    }

    public String getFblodtype() {
        return fblodtype;
    }

    public void setFblodtype(String fblodtype) {
        this.fblodtype = fblodtype == null ? null : fblodtype.trim();
    }

    public String getFemotion() {
        return femotion;
    }

    public void setFemotion(String femotion) {
        this.femotion = femotion == null ? null : femotion.trim();
    }

    public String getFpersonal() {
        return fpersonal;
    }

    public void setFpersonal(String fpersonal) {
        this.fpersonal = fpersonal == null ? null : fpersonal.trim();
    }

    public String getFlikeword() {
        return flikeword;
    }

    public void setFlikeword(String flikeword) {
        this.flikeword = flikeword == null ? null : flikeword.trim();
    }

    public BigDecimal getFstate() {
        return fstate;
    }

    public void setFstate(BigDecimal fstate) {
        this.fstate = fstate;
    }
}