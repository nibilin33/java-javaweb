package com.fase.mapper;

import java.util.List;
import java.util.Map;

import com.fase.po.Blocking;

public interface BlockingMapper {


    int deleteByPrimaryKey(String bid);

    int insert(Blocking record);

    int insertSelective(Blocking record);
 

    Blocking selectByPrimaryKey(String bid);

    int updateByPrimaryKeySelective(Blocking record);

    int updateByPrimaryKey(Blocking record);
    String selectbid(Map<String,Object> param);
    List<Blocking> selectallbyfuid(String fuid);
    int deletebyfb(Map<String,Object>params);
}