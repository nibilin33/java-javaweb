package com.fase.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.Ipictureservice;
import com.fase.mapper.PictureMapper;
import com.fase.po.Picture;
@Service
@Transactional
public class Fpic implements Ipictureservice {
     @Resource
     private PictureMapper picdao;
	@Override
	public void deletebypid(String pid) {
		// TODO 自动生成的方法存根
       picdao.deleteByPrimaryKey(pid);
	}

	@Override
	public int insertpic(Picture p) {
		// TODO 自动生成的方法存根
		return picdao.insertSelective(p);
	}

}
