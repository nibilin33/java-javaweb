package com.fase.service.imp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import util.Pageinfo;

import com.fase.iservice.Idynamicinfo;
import com.fase.mapper.DynamicInfoMapper;
import com.fase.po.DynamicInfo;
@Service
@Transactional
public class Fdynamic implements Idynamicinfo {
	 @Resource
	 private DynamicInfoMapper dydao;
	 private Pageinfo page;
	@Override
	public List<DynamicInfo> querybypage(int start, int max) {
		// TODO 自动生成的方法存根
		int number=dydao.selectcount();
		if(max>number){
			max=number;
		}
		if(start<0){
			start=0;
		}
		page=new Pageinfo(start, max, "dynamicinfo");
		return dydao.selectinfo(page.getSql());
	}
	@Override
	public List<DynamicInfo> selectallowinfo(Map<String, Object> param) {
		// TODO 自动生成的方法存根
		dydao.selectallowinfo(param);
		List<DynamicInfo> info=(List<DynamicInfo>) param.get("result");
		return info;
	}
	@Override
	public int insertIntody(DynamicInfo dy) {
		// TODO 自动生成的方法存根
		return dydao.insertIntoDy(dy);
	}
	@Override
	public List<DynamicInfo> selectdybyid(Map<String, Object> param) {
		// TODO 自动生成的方法存根
		dydao.selectinfobyfuid(param);
		List <DynamicInfo> info=(List<DynamicInfo>) param.get("result");
		return info;
	}
	@Override
	public int selectCount(Map<String, Object> param) {
		// TODO 自动生成的方法存根
		dydao.selectPcount(param);
		int n=(int) param.get("result");
		return n;
	}

}
