package com.fase.mapper;

import com.fase.po.Teamgroup;

public interface TeamgroupMapper {
    int deleteByPrimaryKey(String groupid);

    int insert(Teamgroup record);

    int insertSelective(Teamgroup record);

    Teamgroup selectByPrimaryKey(String groupid);

    int updateByPrimaryKeySelective(Teamgroup record);

    int updateByPrimaryKey(Teamgroup record);
}