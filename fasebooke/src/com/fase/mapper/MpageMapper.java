package com.fase.mapper;

import com.fase.po.Mpage;

public interface MpageMapper {
    int deleteByPrimaryKey(String mpid);

    int insert(Mpage record);

    int insertSelective(Mpage record);

    Mpage selectByPrimaryKey(String mpid);

    int updateByPrimaryKeySelective(Mpage record);

    int updateByPrimaryKey(Mpage record);
}