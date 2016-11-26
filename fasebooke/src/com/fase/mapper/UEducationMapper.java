package com.fase.mapper;

import java.util.List;

import com.fase.po.UEducation;

public interface UEducationMapper {
    int deleteByPrimaryKey(String uedid);

    int insert(UEducation record);

    int insertSelective(UEducation record);

    UEducation selectByPrimaryKey(String uedid);

    int updateByPrimaryKeySelective(UEducation record);

    int updateByPrimaryKey(UEducation record);
    List<UEducation> selectbyfuid(String fuid);
}