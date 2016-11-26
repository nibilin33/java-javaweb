package com.fase.mapper;

import java.util.List;
import java.util.Map;

import com.fase.po.DynamicInfo;

public interface DynamicInfoMapper {
  List<DynamicInfo> selectinfo(String sql);
  void selectallowinfo(Map<String, Object> param);
  int selectcount();
  int insertIntoDy(DynamicInfo dynamic);
  void selectinfobyfuid(Map<String, Object> param);
  void selectPcount(Map<String, Object> param);
}
