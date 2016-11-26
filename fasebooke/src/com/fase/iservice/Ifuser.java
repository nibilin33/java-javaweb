package com.fase.iservice;

import java.util.List;
import java.util.Map;

import com.fase.po.Fuser;

public interface Ifuser {
	 public boolean insertFuser(Fuser record);
	 public void updateFuser(Fuser record);
	 public List<Fuser> checkLogin(String count,String password);
	 public List<Fuser> findfreinds(Map<String,Object> params);
	 public void checklogOut(String uid);
	 public Fuser selectuser(String us);
	 public Fuser findlostpass(String ask);
	 public Fuser selectbyid(String fuid);
	 public Fuser selectForMail(String fcount);
	 public List<Fuser> selectSmartByname(String fn);
	 public List<Fuser> selectByMulti(Fuser us);
	 public List<Fuser> selectBYSchool(Map<String,Object> params);

}
