package com.fase.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.Ioffline;
import com.fase.mapper.OfflinemssageMapper;
import com.fase.po.Offlinemssage;
@Service
@Transactional
public class Foffline implements Ioffline {
    @Resource
    private OfflinemssageMapper om;
	@Override
	public List<Offlinemssage> selectunread(String tfuid) {
		// TODO 自动生成的方法存根
		return om.selectByPrimaryKey(tfuid);
	}

	@Override
	public int inset(Offlinemssage of) {
		// TODO 自动生成的方法存根
		return om.insertSelective(of);
	}

}
