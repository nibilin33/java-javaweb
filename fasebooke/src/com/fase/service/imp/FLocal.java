package com.fase.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.IlocalP;
import com.fase.mapper.LocalpMapper;
import com.fase.po.Localp;
@Service
@Transactional
public class FLocal implements IlocalP {
    @Resource
    private LocalpMapper localdao;
	@Override
	public Localp selectURL(String fro) {
		// TODO 自动生成的方法存根
		Localp s=localdao.selectforURL(fro);
		s.setLurl("http://localhost:8080/img/city/"+s.getLurl());
		return s;
	}

	@Override
	public List<Localp> selectSmart(String x) {
		// TODO 自动生成的方法存根
		return localdao.selectBylike(x);
	}

}
