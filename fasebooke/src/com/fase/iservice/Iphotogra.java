package com.fase.iservice;

import java.util.List;
import java.util.Map;

import com.fase.po.Photogallery;

public interface Iphotogra {
	public int isenableinsert(String gname);
	public int insert(Photogallery params);
public Integer insertito(Map<String,Object>params);
public List<Photogallery> selectall(String fuid);
public Photogallery selectone(String gid);
public void deletebygid(String gid);
}
