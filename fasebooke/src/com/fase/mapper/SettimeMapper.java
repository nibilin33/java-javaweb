package com.fase.mapper;

import com.fase.po.Settime;

public interface SettimeMapper {
    int deleteByPrimaryKey(String seid);

    int insert(Settime record);

    int insertSelective(Settime record);

    Settime selectByPrimaryKey(String seid);

    int updateByPrimaryKeySelective(Settime record);

    int updateByPrimaryKey(Settime record);
}