package com.fase.mapper;

import com.fase.po.Sensitive;

public interface SensitiveMapper {
    int deleteByPrimaryKey(String seid);

    int insert(Sensitive record);

    int insertSelective(Sensitive record);

    Sensitive selectByPrimaryKey(String seid);

    int updateByPrimaryKeySelective(Sensitive record);

    int updateByPrimaryKey(Sensitive record);
}