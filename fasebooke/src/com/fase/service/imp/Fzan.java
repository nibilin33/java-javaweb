package com.fase.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.IZan;
import com.fase.mapper.ZanMapper;
import com.fase.po.Zan;
@Service
@Transactional
public class Fzan implements IZan {
    @Resource
    private ZanMapper zandao;
	@Override
	public List<Zan> selectbyFdid(String did) {
		// TODO 自动生成的方法存根
		return zandao.selectBydid(did);
	}

	@Override
	public void insertZan(Zan fu) {
		// TODO 自动生成的方法存根
         zandao.insert(fu);
	}

	@Override
	public void updateZan(Zan fu) {
		// TODO 自动生成的方法存根
        zandao.updateByPrimaryKeySelective(fu);
	}

	@Override
	public int getcount(String id) {
		// TODO 自动生成的方法存根
		return zandao.selectCount(id);
	}

  



}
