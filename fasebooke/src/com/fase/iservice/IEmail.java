package com.fase.iservice;

import java.util.List;
import java.util.Map;

import com.fase.po.Emailmessage;

public interface IEmail {
public int insertImail(Emailmessage m);
public int deleteImail(String eid);
public List<Emailmessage> selectfuidmail(String fuid);
public Emailmessage selectbymailid(String eid);
public int updateEmail(Map<Object,String> eid);
}
