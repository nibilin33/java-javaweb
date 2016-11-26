package com.fase.iservice;

import java.util.List;

import com.fase.po.College;

public interface Icollege {
public String selectURL(String name);
public List<College> selectSmart(String x);
}
