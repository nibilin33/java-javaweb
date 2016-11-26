package com.fase.mapper;

import java.util.List;
import java.util.Map;

import com.fase.po.Emailmessage;

public interface EmailmessageMapper {
    int deleteByPrimaryKey(String eid);

    int insert(Emailmessage record);

    int insertSelective(Emailmessage record);

    Emailmessage selectByPrimaryKey(String eid);

    int updateByPrimaryKeySelective(Emailmessage record);

    int updateByPrimaryKey(Map<Object,String> record);
    List<Emailmessage> selectByffid(String fuid);
}