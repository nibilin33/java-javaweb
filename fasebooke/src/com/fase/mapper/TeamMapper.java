package com.fase.mapper;

import com.fase.po.Team;

public interface TeamMapper {
    int deleteByPrimaryKey(String teamid);

    int insert(Team record);

    int insertSelective(Team record);

    Team selectByPrimaryKey(String teamid);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);
}