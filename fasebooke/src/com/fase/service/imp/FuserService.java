package com.fase.service.imp;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.Ifuser;
import com.fase.mapper.FuserMapper;
import com.fase.po.Fuser;

@Service
@Transactional
public class FuserService implements Ifuser {
   @Resource
   private FuserMapper fuserdao;
 
@Override
public boolean insertFuser(Fuser record) {
	
	// TODO 自动生成的方法存根
	if(record.getFemail()!=null&&this.fuserdao.selectByTel2(record.getFemail())>=1)
			return false;
	else
		if(record.getFtel()!=null&&this.fuserdao.selectByTel(record.getFtel())>=1)
			return false;
		else
		{ 
			this.fuserdao.insertSelective(record);	
	return true;
		}
}

@Override
public void updateFuser(Fuser record) {
	// TODO 自动生成的方法存根
	this.fuserdao.updateByPrimaryKeySelective(record);
}

@Override
public List<Fuser> checkLogin(String count, String password) {
	// TODO 自动生成的方法存根
	List<Fuser> user=null;
   if(count.contains("@")){
    
    	user=this.fuserdao.selectBymap(count,password);
    }else
    {  
        user=this.fuserdao.selectBymap2(count,password);
    }
	return user;
}


@Override
public void checklogOut(String uid) {
	// TODO 自动生成的方法存根
	Fuser us=this.fuserdao.selectByPrimaryKey(uid);
	us.setFstate(new BigDecimal(0));
	this.fuserdao.updateByPrimaryKeySelective(us);
}



@Override
public List<Fuser> findfreinds(Map<String, Object> params) {
	// TODO 自动生成的方法存根
	fuserdao.selectBylocation(params);
	List<Fuser> f=(List<Fuser>)params.get("results");
	return f;
}

@Override
public Fuser selectuser(String us) {
	// TODO 自动生成的方法存根
	Fuser uer;
       if(us.contains("@")){
    	  uer=fuserdao.selectByphoneOrmail(us); 
       }else
    	   uer=fuserdao.selectByCount(us);
       return uer;
}

@Override
public Fuser findlostpass(String ask) {
	// TODO 自动生成的方法存根
	return fuserdao.selectByphoneOrmail(ask);
}

@Override
public Fuser selectbyid(String fuid) {
	// TODO 自动生成的方法存根
	return fuserdao.selectByPrimaryKey(fuid);
}

@Override
public Fuser selectForMail(String fcount) {
	// TODO 自动生成的方法存根
	return fuserdao.selectFormailFid(fcount);
}

@Override
public List<Fuser> selectSmartByname(String fn) {
	// TODO 自动生成的方法存根
	return fuserdao.selectSmartbycount(fn);
}

@Override
public List<Fuser> selectByMulti(Fuser us) {
	// TODO 自动生成的方法存根
	return fuserdao.selectbyMulti(us);
}

@Override
public List<Fuser> selectBYSchool(Map<String, Object> params) {
	// TODO 自动生成的方法存根
	fuserdao.selectbySchool(params);
	List<Fuser> us= (List<Fuser>) params.get("result");
	return us;
}

   
}
