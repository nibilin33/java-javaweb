package com.fase.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.Ihelpcenter;
import com.fase.mapper.CollegeMapper;
import com.fase.mapper.FuserMapper;
import com.fase.mapper.HelpcenterMapper;
import com.fase.mapper.LocalpMapper;
import com.fase.po.College;
import com.fase.po.Helpcenter;
import com.fase.po.Localp;
@Service
@Transactional
public class Fhelpcenter implements Ihelpcenter {
	   @Resource
	   private HelpcenterMapper fuserdao;
	   @Resource
	   private LocalpMapper localdao;
	   @Resource
	   private CollegeMapper collegedao;
	@Override
	public List<Helpcenter> checksmartSearch(String s) {
		// TODO 自动生成的方法存根
		return fuserdao.selectBylike(s);
	}
	@Override
	public List<String> checklike(String s) {
		// TODO 自动生成的方法存根
		
		return fuserdao.selectByquestion(s);
	}
	@Override
	public List<Localp> checksmartSearchlive(String s) {
		// TODO 自动生成的方法存根
		return localdao.selectBylike(s);
	}
	@Override
	public List<College> checksmartSearchcolle(String s) {
		// TODO 自动生成的方法存根
		return collegedao.selectBylike(s);
	}

}
