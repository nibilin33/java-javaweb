package com.fase.mapper;

import java.util.List;

import com.fase.po.Leavenote;

public interface LeavenoteMapper {
    int deleteByPrimaryKey(String leid);

    int insert(Leavenote record);

    int insertSelective(Leavenote record);

    Leavenote selectByPrimaryKey(String leid);

    int updateByPrimaryKeySelective(Leavenote record);

    int updateByPrimaryKey(Leavenote record);
    List<Leavenote> selectbyfuid(String fuid);
}