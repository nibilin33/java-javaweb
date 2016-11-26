package com.fase.iservice;

import java.util.List;

import com.fase.po.Zan;

public interface IZan {
public List<Zan> selectbyFdid(String did);
public void insertZan(Zan fu);
public void updateZan(Zan fu);
public int getcount(String id);
}
