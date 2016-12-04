package com.fase.mapper;

import java.util.List;
import java.util.Map;

import com.fase.po.Ufreind;

public interface UfreindMapper {
    int deleteByPrimaryKey(String ufid);

    int insert(Ufreind record);

    int insertSelective(Ufreind record);

    Ufreind selectByPrimaryKey(String ufid);

    int updateByPrimaryKeySelective(Ufreind record);

    int updateByPrimaryKey(Ufreind record);
    List<Ufreind> selectallfriend(String fuid);
    int selectisbefirend(Map<String ,Object>params);
}