package com.fase.mapper;

import java.util.List;

import com.fase.po.Notification;

public interface NotificationMapper {
    int deleteByPrimaryKey(String nid);

    int insert(Notification record);

    int insertSelective(Notification record);

    Notification selectByPrimaryKey(String nid);

    int updateByPrimaryKeySelective(Notification record);

    int updateByPrimaryKey(Notification record);
    List<Notification> selectByfuid(String fuid);
}