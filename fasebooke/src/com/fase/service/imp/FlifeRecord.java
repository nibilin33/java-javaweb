package com.fase.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.Iliferecord;
import com.fase.mapper.LiferecordMapper;
import com.fase.po.Liferecord;
@Service
@Transactional
public class FlifeRecord implements Iliferecord {
   @Resource
   private LiferecordMapper lifedao;
	@Override
	public int addLife(Liferecord l) {
		// TODO 自动生成的方法存根
		return lifedao.insertSelective(l);
	}

	@Override
	public int deleteLife(String flid) {
		// TODO 自动生成的方法存根
		return lifedao.deleteByPrimaryKey(flid);
	}

	@Override
	public List<Liferecord> selectlife(String fuid) {
		// TODO 自动生成的方法存根
		return lifedao.selectByfuid(fuid);
	}

}
