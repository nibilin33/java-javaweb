package com.fase.iservice;

import java.util.List;

import com.fase.po.Leavenote;

public interface Ileave {
public int insertIleve(Leavenote re);
public List<Leavenote> selectbyfuid(String fuid);
}
