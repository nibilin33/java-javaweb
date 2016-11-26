package com.fase.iservice;

import java.util.List;

import com.fase.po.Askpermission;

public interface Iaskpermisson {
   public void insertP(Askpermission ask);
   public void updateP(Askpermission ask);
   public List<Askpermission> selectall(String fuid);
}
