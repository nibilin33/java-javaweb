package com.fase.iservice;

import java.util.List;
import java.util.Map;

import com.fase.po.Blocking;
import com.fase.po.Settime;

public interface IBlock {
public void updateBlock(Blocking b);
public int insertBlock(Blocking b);
public int deleteBlock(Map<String,Object> params);
public List<Blocking> selectall(String fuid);
public void updatesetting(Settime s);
public Settime selectsetting(String fuid);
}
