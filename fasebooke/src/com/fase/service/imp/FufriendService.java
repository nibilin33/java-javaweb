package com.fase.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.Iufriend;
import com.fase.mapper.UfreindMapper;
import com.fase.po.Ufreind;
@Service
@Transactional
public class FufriendService implements Iufriend {
    @Resource
    private UfreindMapper ufdao;

	@Override
	public List<Ufreind> selectall(String fuid) {
		// TODO 自动生成的方法存根
		return ufdao.selectallfriend(fuid);
	}
	
}
