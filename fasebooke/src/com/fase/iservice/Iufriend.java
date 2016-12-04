package com.fase.iservice;

import java.util.List;
import java.util.Map;

import com.fase.po.Ufreind;

public interface Iufriend {
   public List<Ufreind> selectall(String fuid);
   public boolean isinfriendfriend(Map<String ,Object>params);
}
