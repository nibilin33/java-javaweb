package com.fase.mapper;

import java.util.List;

import com.fase.po.Zan;

public interface ZanMapper {
    int deleteByPrimaryKey(String zid);

    int insert(Zan record);

    int insertSelective(Zan record);

    Zan selectByPrimaryKey(String zid);

    int updateByPrimaryKeySelective(Zan record);

    int updateByPrimaryKey(Zan record);
    List<Zan> selectBydid(String did);
    int selectCount(String did);
}