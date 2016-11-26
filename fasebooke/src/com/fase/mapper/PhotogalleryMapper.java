package com.fase.mapper;

import java.util.List;
import java.util.Map;

import com.fase.po.Photogallery;

public interface PhotogalleryMapper {
    int deleteByPrimaryKey(String gpid);

    int insertT(Photogallery record);

    int insertSelective(Photogallery record);

    Photogallery selectByPrimaryKey(String gpid);

    int updateByPrimaryKeySelective(Photogallery record);

    int updateByPrimaryKey(Photogallery record);
    void insertP(Map<String ,Object> parma);
    List<Photogallery> selectall(String fuid);
  Photogallery selectbygname(String gname);
}