package com.fase.mapper;

import java.util.List;

import com.fase.po.Liferecord;

public interface LiferecordMapper {
    int deleteByPrimaryKey(String lfid);

    int insert(Liferecord record);

    int insertSelective(Liferecord record);

    Liferecord selectByPrimaryKey(String lfid);

    int updateByPrimaryKeySelective(Liferecord record);
 
    int updateByPrimaryKey(Liferecord record);
    List<Liferecord> selectByfuid(String fuid);
}