package com.fase.iservice;

import java.util.List;

import com.fase.po.UEducation;

public interface Ieducation {
public int Addeducation(UEducation ue);
public int updateEducation(UEducation ue);
public List<UEducation> selectbyFuid(String fuid);
}
