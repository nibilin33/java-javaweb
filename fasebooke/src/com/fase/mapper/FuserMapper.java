package com.fase.mapper;

import java.util.List;
import java.util.Map;

import com.fase.po.Fuser;

public interface FuserMapper {
    int deleteByPrimaryKey(String fuid);
    int insert(Fuser record);
    int insertSelective(Fuser record);
    Fuser selectByPrimaryKey(String fuid);
    Fuser selectByname(Map map);
    void selectBylocation(Map<String, Object> params);
    int selectByTel(String eom);
    int selectByTel2(String eom);
    List<Fuser> selectBymap(String f,String f2);
    List<Fuser> selectBymap2(String f,String f2);
    int updateByPrimaryKeySelective(Fuser record);
    int updateByPrimaryKey(Fuser record);
    Fuser selectByphoneOrmail(String pm);
    Fuser selectByCount(String name);
    Fuser selectFormailFid(String fcount);
    List<Fuser> selectSmartbycount(String f);
    List<Fuser> selectbyMulti(Fuser us);
   void selectbySchool(Map<String, Object> params);
}