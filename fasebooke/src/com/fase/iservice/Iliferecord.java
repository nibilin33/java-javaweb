package com.fase.iservice;

import java.util.List;

import com.fase.po.Liferecord;

public interface Iliferecord {
	
  public int addLife(Liferecord l);
  public int deleteLife(String flid);
  public List<Liferecord> selectlife(String fuid);
}
