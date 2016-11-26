package com.fase.mapper;

import java.util.List;

import com.fase.po.College;

public interface CollegeMapper {
    int deleteByPrimaryKey(String coid);

    int insert(College record);

    int insertSelective(College record);

    College selectByPrimaryKey(String coid);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);
    List<College> selectBylike(String name);
    String selectforURL(String name);
}