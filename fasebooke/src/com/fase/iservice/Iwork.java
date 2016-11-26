package com.fase.iservice;

import com.fase.po.UWork;

public interface Iwork {
public int AddWork(UWork uw);
public int updateWork(UWork uw);
public UWork selectbyFuid(String fuid);
}
