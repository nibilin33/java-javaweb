package com.fase.iservice;

import java.util.List;

import com.fase.po.Notification;

public interface Inotification {
public List<Notification> selectbyfuid(String fuid);
public void updatenotice(Notification uid);
}
