package com.fase.mapper;

import com.fase.po.Activity;

public interface ActivityMapper {
    int deleteByPrimaryKey(String acid);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(String acid);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
}