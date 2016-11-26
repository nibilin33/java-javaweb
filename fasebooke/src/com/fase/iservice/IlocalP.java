package com.fase.iservice;

import java.util.List;

import com.fase.po.Localp;

public interface IlocalP {
 public Localp selectURL(String fro);/*查url*/
 public List<Localp> selectSmart(String x);
}
