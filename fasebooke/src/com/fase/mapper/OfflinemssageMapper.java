package com.fase.mapper;

import java.util.List;

import com.fase.po.Offlinemssage;

public interface OfflinemssageMapper {
    int deleteByPrimaryKey(String ofid);

    int insert(Offlinemssage record);

    int insertSelective(Offlinemssage record);

    List<Offlinemssage> selectByPrimaryKey(String ofid);

    int updateByPrimaryKeySelective(Offlinemssage record);

    int updateByPrimaryKey(Offlinemssage record);
}