package com.fase.iservice;

import java.util.List;

import com.fase.po.College;
import com.fase.po.Helpcenter;
import com.fase.po.Localp;

public interface Ihelpcenter {
  List<Helpcenter> checksmartSearch(String s);
  List<String> checklike(String s);
  List<Localp> checksmartSearchlive(String s);
  List<College> checksmartSearchcolle(String s);
 
}
