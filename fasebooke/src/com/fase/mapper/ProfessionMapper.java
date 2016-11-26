package com.fase.mapper;

import com.fase.po.Profession;

public interface ProfessionMapper {
    int deleteByPrimaryKey(String pid);

    int insert(Profession record);

    int insertSelective(Profession record);

    Profession selectByPrimaryKey(String pid);

    int updateByPrimaryKeySelective(Profession record);

    int updateByPrimaryKey(Profession record);
}