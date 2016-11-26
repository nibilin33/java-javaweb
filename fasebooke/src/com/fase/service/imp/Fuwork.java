package com.fase.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.Iwork;
import com.fase.mapper.UWorkMapper;
import com.fase.po.UWork;
@Service
@Transactional
public class Fuwork implements Iwork {
    @Resource
    private UWorkMapper UWdao;
	@Override
	public int AddWork(UWork uw) {
		// TODO 自动生成的方法存根
		return UWdao.insertSelective(uw);
	}

	@Override
	public int updateWork(UWork uw) {
		// TODO 自动生成的方法存根
		return UWdao.updateByPrimaryKeySelective(uw);
	}

	@Override
	public UWork selectbyFuid(String fuid) {
		// TODO 自动生成的方法存根
		return UWdao.selectbyFuid(fuid);
	}

}
