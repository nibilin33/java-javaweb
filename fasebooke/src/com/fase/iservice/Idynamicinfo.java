package com.fase.iservice;

import java.util.List;
import java.util.Map;

import com.fase.po.DynamicInfo;
import com.fase.po.Fuser;

public interface Idynamicinfo {
 public List<DynamicInfo> querybypage(int start,int max);
 public List<DynamicInfo> selectallowinfo(Map<String, Object> param);
 public int insertIntody(DynamicInfo dy);
 public List<DynamicInfo> selectdybyid(Map<String, Object> param);
 public int selectCount(Map<String, Object> param);
}
