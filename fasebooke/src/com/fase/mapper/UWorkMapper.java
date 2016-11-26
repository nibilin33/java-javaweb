package com.fase.mapper;

import com.fase.po.UWork;

public interface UWorkMapper {
    int deleteByPrimaryKey(String uworkid);

    int insert(UWork record);

    int insertSelective(UWork record);

    UWork selectByPrimaryKey(String uworkid);

    int updateByPrimaryKeySelective(UWork record);

    int updateByPrimaryKey(UWork record);
    UWork selectbyFuid(String fuid);
}