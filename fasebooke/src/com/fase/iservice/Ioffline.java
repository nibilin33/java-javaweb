package com.fase.iservice;

import java.util.List;

import com.fase.po.Offlinemssage;

public interface Ioffline {
public List<Offlinemssage> selectunread(String tfuid);
public int inset(Offlinemssage of);
}
