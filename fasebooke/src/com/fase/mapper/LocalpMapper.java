package com.fase.mapper;

import java.util.List;

import com.fase.po.Localp;

public interface LocalpMapper {
    int deleteByPrimaryKey(String lid);

    int insert(Localp record);

    int insertSelective(Localp record);

    Localp selectByPrimaryKey(String lid);

    int updateByPrimaryKeySelective(Localp record);

    int updateByPrimaryKey(Localp record);
    List<Localp> selectBylike(String smart);
    Localp selectforURL(String name);
}