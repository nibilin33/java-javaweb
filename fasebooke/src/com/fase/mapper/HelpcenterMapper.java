package com.fase.mapper;

import java.util.List;

import com.fase.po.Helpcenter;

public interface HelpcenterMapper {
    int deleteByPrimaryKey(String helpid);

    int insert(Helpcenter record);

    int insertSelective(Helpcenter record);

    Helpcenter selectByPrimaryKey(String helpid);

    int updateByPrimaryKeySelective(Helpcenter record);

    int updateByPrimaryKey(Helpcenter record);
    List<Helpcenter> selectBylike(String s);
    List<String> selectByquestion(String s);
}