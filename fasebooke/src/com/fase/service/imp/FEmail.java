package com.fase.service.imp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.IEmail;
import com.fase.mapper.EmailmessageMapper;
import com.fase.po.Emailmessage;
@Service
@Transactional
public class FEmail implements IEmail {
    @Resource
    private EmailmessageMapper emaildao;
	@Override
	public int insertImail(Emailmessage m) {
		// TODO 自动生成的方法存根
      return  emaildao.insertSelective(m);
	}

	@Override
	public int deleteImail(String eid) {
		// TODO 自动生成的方法存根
     return   emaildao.deleteByPrimaryKey(eid);
	}

	@Override
	public List<Emailmessage> selectfuidmail(String fuid) {
		// TODO 自动生成的方法存根
		return emaildao.selectByffid(fuid);
	}

	@Override
	public Emailmessage selectbymailid(String eid) {
		// TODO 自动生成的方法存根
		return emaildao.selectByPrimaryKey(eid);
	}

	@Override
	public int updateEmail(Map<Object,String> eid) {
		// TODO 自动生成的方法存根
		return emaildao.updateByPrimaryKey(eid);
	}

}
