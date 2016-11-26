package com.fase.mapper;

import com.fase.po.Collecturl;

public interface CollecturlMapper {
    int deleteByPrimaryKey(String cuid);

    int insert(Collecturl record);

    int insertSelective(Collecturl record);

    Collecturl selectByPrimaryKey(String cuid);

    int updateByPrimaryKeySelective(Collecturl record);

    int updateByPrimaryKey(Collecturl record);
}