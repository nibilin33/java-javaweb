package com.fase.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.Ileave;
import com.fase.mapper.LeavenoteMapper;
import com.fase.po.Leavenote;
@Service
@Transactional
public class LeavenoteService implements Ileave {
    @Resource
    private LeavenoteMapper ldao;
	@Override
	public int insertIleve(Leavenote re) {
		// TODO 自动生成的方法存根
		return ldao.insert(re);
	}

	@Override
	public List<Leavenote> selectbyfuid(String fuid) {
		// TODO 自动生成的方法存根
		return ldao.selectbyfuid(fuid);
	}

}
