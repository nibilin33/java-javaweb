package com.fase.mapper;

import com.fase.po.Mpagedata;

public interface MpagedataMapper {
    int deleteByPrimaryKey(String dataid);

    int insert(Mpagedata record);

    int insertSelective(Mpagedata record);

    Mpagedata selectByPrimaryKey(String dataid);

    int updateByPrimaryKeySelective(Mpagedata record);

    int updateByPrimaryKey(Mpagedata record);
}