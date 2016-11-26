package com.fase.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.Icollege;
import com.fase.mapper.CollegeMapper;
import com.fase.po.College;
@Service
@Transactional
public class Fcollege implements Icollege {
    @Resource
    private CollegeMapper codao;
	@Override
	public String selectURL(String name) {
		// TODO 自动生成的方法存根
		return codao.selectforURL(name);
	}

	@Override
	public List<College> selectSmart(String x) {
		// TODO 自动生成的方法存根
		return codao.selectBylike(x);
	}

}
