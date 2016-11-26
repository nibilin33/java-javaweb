package com.fase.mapper;

import java.util.List;

import com.fase.po.Askpermission;

public interface AskpermissionMapper {
    int deleteByPrimaryKey(String asid);

    int insert(Askpermission record);

    int insertSelective(Askpermission record);

    Askpermission selectByPrimaryKey(String asid);
    List<Askpermission> selectall(String fuid);
    int updateByPrimaryKeySelective(Askpermission record);

    int updateByPrimaryKey(Askpermission record);
}