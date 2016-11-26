package com.fase.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.Ieducation;
import com.fase.mapper.UEducationMapper;
import com.fase.po.UEducation;
@Service
@Transactional
public class Feducation implements Ieducation {
     @Resource
     private UEducationMapper UEdao;
	@Override
	public int Addeducation(UEducation ue) {
		// TODO 自动生成的方法存根
		return UEdao.insertSelective(ue);
	}

	@Override
	public int updateEducation(UEducation ue) {
		// TODO 自动生成的方法存根
		return UEdao.updateByPrimaryKeySelective(ue);
	}

	@Override
	public List<UEducation> selectbyFuid(String fuid) {
		// TODO 自动生成的方法存根
		return UEdao.selectbyfuid(fuid);
	}

}
