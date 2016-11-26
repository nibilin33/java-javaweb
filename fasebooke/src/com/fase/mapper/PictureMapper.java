package com.fase.mapper;

import com.fase.po.Picture;

public interface PictureMapper {
    int deleteByPrimaryKey(String pid);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(String pid);
    
    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}